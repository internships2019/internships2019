package com.ylq.internships.mapper;


import com.ylq.internships.entity.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 企业持久层接口
 */
@Mapper
public interface CompanyMapper {
    //获取企业列表
    List<Company> getAll();

    String[] getAllNames();

    //通过企业名获取企业
    Company getCompanyByConName(String conName);
    //添加企业
    void insertComapny(Company company);
    //更新企业
    void updateComapny(Company company);
    //删除企业
    void deleteComapny(String companyName);
}
