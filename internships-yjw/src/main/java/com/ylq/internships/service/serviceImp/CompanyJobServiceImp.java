package com.ylq.internships.service.serviceImp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.CompanyJob;
import com.ylq.internships.entity.School;
import com.ylq.internships.mapper.CompanyJobMapper;
import com.ylq.internships.service.CompanyJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyJobServiceImp implements CompanyJobService {

    @Autowired
    CompanyJobMapper companyJobMapper;
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public PageInfo<CompanyJob> getAll(int page, int limit,String sc_name) {
        logger.info("CompanyJobServiceImp的getAll执行===" + page + "===");
        PageHelper.startPage(page, limit);
        List<CompanyJob> list = compareTime(companyJobMapper.getAll(sc_name));
        PageInfo<CompanyJob> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<CompanyJob> getAllDesc(int page, int limit,String sc_name) {
        logger.info("CompanyJobServiceImp的getAllDesc执行===" + page + "===");
        PageHelper.startPage(page, limit);
        List<CompanyJob> list = compareTime(companyJobMapper.getAllDesc(sc_name));
        PageInfo<CompanyJob> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<CompanyJob> searchByComName(int page, int limit, String com_name,String sc_name) {
        logger.info("CompanyJobServiceImp的searchByComName执行===" + page + "===");
        PageHelper.startPage(page, limit);
        String name = "%" + com_name + "%";
        List<CompanyJob> list = compareTime(companyJobMapper.searchByComName(name,sc_name));
        PageInfo<CompanyJob> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public CompanyJob searchById(String job_id) {
        logger.info("CompanyJobServiceImp的searchById执行===" + job_id + "===");
        return companyJobMapper.searchById(job_id);
    }

    /**
     * 查看当前已招人数
     * @param job_id
     * @return
     */
    @Override
    public String checkNowNum(String job_id) {
        return companyJobMapper.checkNowNum(job_id);
    }

    /**
     * 比较结束时间和当前时间大小
     * @param list
     * @return
     */
    public List<CompanyJob> compareTime(List<CompanyJob> list) {
        long time = System.currentTimeMillis();
        for (CompanyJob companyJob : list) {
            long end_time = companyJob.getEndTime().getTime();
            if (end_time < time) {
                list.remove(companyJob);
            }
        }
        return list;
    }

}
