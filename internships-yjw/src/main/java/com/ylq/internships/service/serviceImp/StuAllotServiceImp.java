package com.ylq.internships.service.serviceImp;

import com.ylq.internships.entity.Company;
import com.ylq.internships.entity.CompanyJob;
import com.ylq.internships.entity.StuAllot;
import com.ylq.internships.entity.Student;
import com.ylq.internships.mapper.CompanyJobMapper;
import com.ylq.internships.mapper.StuAllotMapper;
import com.ylq.internships.service.CompanyJobService;
import com.ylq.internships.service.CompanyService;
import com.ylq.internships.service.StuAllotService;
import com.ylq.internships.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

import static com.ylq.internships.utils.Contant.WAITCOMFIRM;

@Service
public class StuAllotServiceImp implements StuAllotService {

    @Autowired
    CompanyJobService companyJobService;
    @Autowired
    CompanyService companyService;
    @Autowired
    StuAllotMapper stuAllotMapper;
    @Autowired
    CompanyJobMapper companyJobMapper;

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 检查此学生是否已经申请过岗位
     * 检查岗位是否可申请
     * 检查人数是否已达上限
     * @param openid
     * @param job_id
     * @return
     */
    @Override
    public String insertStu(String openid, String job_id, String school_name) {

        logger.info("StuAllotServiceImp的insertStu执行===" + openid + "===" + job_id);

        //查询此招聘信息
        CompanyJob companyJob = companyJobService.searchById(job_id);
        //查询公司
        Company company = companyService.findCompanyByComName(companyJob.getConName());
        //判断申请时间

        int p_num = companyJob.getRecruitNum() - companyJob.getNowNum();
        long time = System.currentTimeMillis();
        long end_time = companyJob.getEndTime().getTime();

        if (p_num > 0) {
            if (end_time < time) {
                return "overdue";
            } else {
                StuAllot stuAllot = stuAllotMapper.selectByStuId(openid);
                if (stuAllot == null) {
                    StuAllot insert = new StuAllot();
                    insert.setsWxNo(openid.trim());
                    insert.setState(WAITCOMFIRM);
                    insert.setComLocation(companyJob.getWorkPlace());
                    insert.setComName(companyJob.getConName());
                    insert.setComTel(company.getComTel());
                    insert.setJobId(Integer.parseInt(job_id));
                    insert.setJobName(companyJob.getJobName());
                    insert.setsScName(school_name);
                    logger.info("insert>>>>>>>>>>>>>" + insert.toString());
                    try {
                        stuAllotMapper.insertStu(insert);
                        companyJobMapper.addNowNum(job_id);   //招聘广告已招人数加一
                        return "ok";
                    } catch (Exception e) {
                        e.printStackTrace();
                        return "error";
                    }

                }
                return "exist";
            }
        }
        return "full";
    }

    @Override
    public StuAllot selectStu(String openid) {
        return stuAllotMapper.selectByStuId(openid);
    }

    @Override
    public List<StuAllot> getApplications(String openid) {
        return stuAllotMapper.getApplications(openid);
    }
}
