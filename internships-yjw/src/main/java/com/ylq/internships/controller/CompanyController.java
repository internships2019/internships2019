package com.ylq.internships.controller;

import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Company;
import com.ylq.internships.service.CompanyService;
import com.ylq.internships.utils.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    private Logger logger= LoggerFactory.getLogger(getClass());

    @ResponseBody
    @RequestMapping("/find_all")
    public String findAll(int page,int limit){
        logger.info("CompanyController的findAll方法执行了");
        PageInfo<Company> pageInfo = companyService.findAll(page, limit);
        return PageUtil.getCompanyJson(pageInfo.getList(),pageInfo.getTotal());
    }

    @RequestMapping("/getAllCompany.wx")
    public List<String> getAllCompany(){
        logger.info("CompanyController的getAllCompany.wx执行===");
        logger.info(companyService.getAllCompany().toString());
        return companyService.getAllCompany();
    }

    //添加企业
    @RequestMapping("/add_company")
    public String addCompany(@RequestBody Company company){
        logger.info("CompanyController的addCompany方法执行了");
        if (companyService.findCompanyByComName(company.getComName())==null){
            companyService.addCompany(company);
            return "1";
        }
        return "2";
    }

    //修改企业
    @RequestMapping("/update_company")
    public void updateCompany(@RequestBody Company company){
        logger.info("CompanyController的updateCompany方法执行了");
        companyService.edtiComapny(company);
    }

    //删除企业
    @RequestMapping("/remove_company")
    public void removeCompany(@RequestBody String comName){
        logger.info("CompanyController的updateCompany方法执行了");
        companyService.removeComapny(comName);
    }
}
