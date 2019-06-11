package com.ylq.internships.service;

import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.CompanyJob;


public interface CompanyJobService {

    PageInfo<CompanyJob> findCompanyList(int page,int limit,String sScName);
    PageInfo<CompanyJob> findCompanyName(int page,int limit,String sScName,String jobName);
    PageInfo<CompanyJob> findHistoryCompanyJobList(int page,int limit,String sScName);
    void addCompanyJob(CompanyJob companyJob);
    void editCompany(CompanyJob companyJob);
    void editAdState(Integer jobId);
    void removeCompanyJob(Integer jobId);
    void batchRemoveCompanyJob(Integer[] arr);
}
