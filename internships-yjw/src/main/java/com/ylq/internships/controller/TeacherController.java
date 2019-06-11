package com.ylq.internships.controller;

import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Teacher;
import com.ylq.internships.service.TeacherService;
import com.ylq.internships.utils.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    Logger logger= LoggerFactory.getLogger(getClass());

    //获取老师列表
    @RequestMapping("/find_teacher_list")
    public String findTeacherList(int page,int limit,String unitName,String pStatus){
        logger.info("TeacherController的findTeacherList执行了==="+unitName+"====="+pStatus);
        PageInfo<Teacher> pageInfo = teacherService.findTeacherList(page, limit, unitName, pStatus);
        return PageUtil.getTeacherJson(pageInfo.getList(),pageInfo.getTotal());
    }
}
