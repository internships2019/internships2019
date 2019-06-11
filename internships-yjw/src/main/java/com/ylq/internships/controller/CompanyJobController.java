package com.ylq.internships.controller;

import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.CompanyJob;
import com.ylq.internships.service.CompanyJobService;
import com.ylq.internships.utils.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Arrays;

@RestController
@RequestMapping("/companyJob")
public class CompanyJobController {

    @Autowired
    private CompanyJobService companyJobService;

    private Logger logger= LoggerFactory.getLogger(getClass());


    //查询实习岗位列表接口
    @RequestMapping("/find_list")
    public String findCompanyJobList(int page,int limit,String sScName){
        logger.info("CompanyJobController的findCompanyJobList执行了");
        PageInfo<CompanyJob> pageInfo = companyJobService.findCompanyList(page, limit, sScName);
        return PageUtil.getCompanyJobJson(pageInfo.getList(),pageInfo.getTotal());
    }

    //查询历史岗位列表接口
    @RequestMapping("/find_history_list")
    public String findHistoryCompanyJobList(int page,int limit,String sScName){
        logger.info("CompanyJobController的findHistoryCompanyJobList执行了");
        PageInfo<CompanyJob> pageInfo = companyJobService.findHistoryCompanyJobList(page, limit, sScName);
        return PageUtil.getCompanyJobJson(pageInfo.getList(),pageInfo.getTotal());
    }

    //查询实习岗位列表接口
    @RequestMapping("/find_companyJob_byName")
    public String findCompanyJobByName(int page,int limit,String sScName,String jobName){
        logger.info("CompanyJobController的findCompanyJobByName执行了");
        PageInfo<CompanyJob> pageInfo = companyJobService.findCompanyName(page, limit, sScName,jobName);
        return PageUtil.getCompanyJobJson(pageInfo.getList(),pageInfo.getTotal());
    }

    //新增实习岗位接口
    @RequestMapping("/add_company_job")
    public void addCompanyJob(@RequestBody CompanyJob companyJob){
        logger.info("CompanyJobController的addCompanyJob执行了===="+companyJob.toString());
        companyJobService.addCompanyJob(companyJob);
    }

    //修改实习岗位接口
    @RequestMapping("/edit_company_job")
    public void editCompanyJob(@RequestBody CompanyJob companyJob){
        logger.info("CompanyJobController的addCompanyJob执行了===="+companyJob.toString());
        companyJobService.editCompany(companyJob);
    }

    //修改实习岗位接口
    @RequestMapping("/edit_adState")
    public void editAdState(@RequestBody Integer jobId){
        logger.info("CompanyJobController的addCompanyJob执行了===="+jobId);
        companyJobService.editAdState(jobId);
    }

    //删除实习岗位接口
    @RequestMapping("/remove_company_job")
    public void removeCompanyJob(@RequestBody Integer jobId){
        logger.info("CompanyJobController的removeCompanyJob执行了===="+jobId);
        companyJobService.removeCompanyJob(jobId);
    }

    //批删除实习岗位接口
    @RequestMapping("/batch_remove_companyJob")
    public void batchRemoveCompanyJob(@RequestBody Integer[] arr){
        logger.info("CompanyJobController的batchRemoveCompanyJob执行了===="+ Arrays.toString(arr));
        companyJobService.batchRemoveCompanyJob(arr);
    }
}
