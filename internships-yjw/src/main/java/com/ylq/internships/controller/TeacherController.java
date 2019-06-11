package com.ylq.internships.controller;

import com.ylq.internships.entity.Teacher;
import com.ylq.internships.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping("/getTeaById.wx")
    public Teacher getTeaByIdWx(String openid){
        return teacherService.getTeaById(openid);
    }
}
