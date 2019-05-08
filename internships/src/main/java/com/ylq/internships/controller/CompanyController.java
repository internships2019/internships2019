package com.ylq.internships.controller;

import com.ylq.internships.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;
    Logger logger= LoggerFactory.getLogger(getClass());

    @ResponseBody
    @RequestMapping("/getAllCompany.wx")
    public List<String> getAllCompany(){
        logger.info("CompanyController的getAllCompany.wx执行===");
        return companyService.getAllCompany();
    }
}
