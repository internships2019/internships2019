package com.ylq.internships.mapper;


import com.ylq.internships.entity.CompanyJob;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 动态项目持久层接口
 */
@Mapper
public interface CompanyJobMapper {

    List<CompanyJob> getCompanyJobList(String sScName);
    List<CompanyJob> getHistoryCompanyJobList(String sScName);
    List<CompanyJob> getCompanyJobByName(@Param("sScName") String sScName,@Param("jobName") String jobName);
    void insertCompanyJob(CompanyJob companyJob);
    void updateCompanyJob(CompanyJob companyJob);
    void updateState(Integer jobId);
    void deleteCompanyJob(Integer jobId);
    void batchDeleteCompanyJob(@Param("arr") Integer[] arr);
}
