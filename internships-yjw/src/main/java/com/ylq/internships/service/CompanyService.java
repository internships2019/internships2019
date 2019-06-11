package com.ylq.internships.service;


import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Company;

import java.util.List;

public interface CompanyService {

    PageInfo<Company> findAll(int page,int limit);
    String[] findAllCompany();
    Company findCompanyByComName(String comName);
    void addCompany(Company company);
    void edtiComapny(Company company);
    void removeComapny(String conName);
}
