package com.ylq.internships.service;


import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Company;

public interface CompanyService {

    PageInfo<Company> findAll(int page,int limit);
    Company findCompanyByComName(String comName);
    void addCompany(Company company);
    void edtiComapny(Company company);
    void removeComapny(String conName);
}
