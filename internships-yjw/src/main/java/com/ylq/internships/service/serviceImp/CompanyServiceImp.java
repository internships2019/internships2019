package com.ylq.internships.service.serviceImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Company;
import com.ylq.internships.mapper.CompanyMapper;
import com.ylq.internships.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyServiceImp implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;
    Logger logger= LoggerFactory.getLogger(getClass());

    //获取企业列表
    @Override
    public PageInfo<Company> findAll(int page,int limit) {
        logger.info("CompanyServiceImp的findAll执行了");
        PageHelper.startPage(page,limit);
        List<Company> list= companyMapper.getAll();
        PageInfo<Company> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //获取所有企业


    @Override
    public String[] findAllCompany() {
        return companyMapper.getAllNames();
    }

    //通过企业名获取企业信息
    @Override
    public Company findCompanyByComName(String comName) {
        return companyMapper.getCompanyByConName(comName);
    }

    //添加企业
    @Transactional
    @Override
    public void addCompany(Company company) {
        logger.info("CompanyServiceImp的addCompany执行了");
        companyMapper.insertComapny(company);
    }

    //修改企业
    @Transactional
    @Override
    public void edtiComapny(Company company) {
        logger.info("CompanyServiceImp的edtiComapny执行了");
        companyMapper.updateComapny(company);
    }

    //删除企业
    @Transactional
    @Override
    public void removeComapny(String conName) {
        logger.info("CompanyServiceImp的removeComapny执行了");
        companyMapper.deleteComapny(conName);
    }
}
