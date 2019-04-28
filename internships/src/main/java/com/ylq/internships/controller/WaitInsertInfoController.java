package com.ylq.internships.controller;

import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.WaitInsertInfo;
import com.ylq.internships.service.WaitInsertInfoService;
import com.ylq.internships.utils.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/waitInsertInfo")
public class WaitInsertInfoController {

    @Autowired
    private WaitInsertInfoService waitInsertInfoService;
    Logger logger= LoggerFactory.getLogger(getClass());


    @RequestMapping("/get_student_all")
    public String getStudentAll(int page,int limit,String unitName,String pStatus){
        logger.info("WaitInsertInfoController的getStudentAll方法执行==="+page+"==="+limit+"==="+unitName+"==="+pStatus);
        PageInfo<WaitInsertInfo> pageInfo = waitInsertInfoService.findStudentAll(page, limit, unitName, pStatus);
        return PageUtil.getWaitInsertInfoJson(pageInfo.getList(),pageInfo.getTotal());
    }
}
