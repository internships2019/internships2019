package com.ylq.internships.service.serviceImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.CompanyJob;
import com.ylq.internships.mapper.CompanyJobMapper;
import com.ylq.internships.service.CompanyJobService;
import com.ylq.internships.utils.Contant;
import com.ylq.internships.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class CompanyJobServiceImp implements CompanyJobService {

    @Autowired
    private CompanyJobMapper companyJobMapper;
    private Logger logger= LoggerFactory.getLogger(getClass());

    //查询岗位列表
    @Override
    public PageInfo<CompanyJob> findCompanyList(int page,int limit,String sScName){
        logger.info("CompanyJobServiceImp的findCompanyList执行了");
        PageHelper.startPage(page,limit);
        List<CompanyJob> list = companyJobMapper.getCompanyJobList(sScName);
        PageInfo<CompanyJob> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //通过岗位名查询
    @Override
    public PageInfo<CompanyJob> findCompanyName(int page, int limit, String sScName, String jobName) {
        logger.info("CompanyJobServiceImp的findCompanyName执行了");
        PageHelper.startPage(page,limit);
        List<CompanyJob> list = companyJobMapper.getCompanyJobByName(sScName, jobName);
        PageInfo<CompanyJob> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


    //查询历史岗位信息
    @Override
    public PageInfo<CompanyJob> findHistoryCompanyJobList(int page, int limit, String sScName) {
        logger.info("CompanyJobServiceImp的findHistoryCompanyJobList执行了");
        PageHelper.startPage(page,limit);
        List<CompanyJob> list = companyJobMapper.getHistoryCompanyJobList(sScName);
        PageInfo<CompanyJob> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //新增实习岗位信息
    @Transactional
    @Override
    public void addCompanyJob(CompanyJob companyJob) {
        logger.info("CompanyJobServiceImp的addCompanyJob执行了");
        companyJob.setPostTime(new Date());
        companyJob.setAdState(Contant.APPLY_FOR);
        companyJob.setNowNum(0);
        companyJobMapper.insertCompanyJob(companyJob);
    }

    //修改岗位信息
    @Transactional
    @Override
    public void editCompany(CompanyJob companyJob) {
        logger.info("CompanyJobServiceImp的editCompany执行了");
        companyJobMapper.updateCompanyJob(companyJob);
    }

    //岗位结束招聘
    @Override
    public void editAdState(Integer jobId) {
        logger.info("CompanyJobServiceImp的editAdState执行了");
        companyJobMapper.updateState(jobId);
    }

    //删除实习岗位
    @Transactional
    @Override
    public void removeCompanyJob(Integer jobId) {
        logger.info("CompanyJobServiceImp的remove执行了");
        companyJobMapper.deleteCompanyJob(jobId);
    }

    //批量删除岗位信息
    @Transactional
    @Override
    public void batchRemoveCompanyJob(Integer[] arr) {
        logger.info("CompanyJobServiceImp的batchRemoveCompanyJob执行了");
        companyJobMapper.batchDeleteCompanyJob(arr);
    }
}
