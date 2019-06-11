package com.ylq.internships.service;


import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.CompanyJob;

import java.util.List;

public interface CompanyJobService {
    /**
     * lwq
     * @param page
     * @param limit
     * @return
     */
    PageInfo<CompanyJob> getAll(int page, int limit,String sc_name);
    PageInfo<CompanyJob> getAllDesc(int page,int limit,String sc_name);
    PageInfo<CompanyJob> searchByComName(int page,int limit,String com_name,String sc_name);
    CompanyJob searchById(String job_id);
    String checkNowNum(String job_id);
}
