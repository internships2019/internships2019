package com.ylq.internships.controller;

import com.ylq.internships.entity.Student;
import com.ylq.internships.mapper.StudentMapper;
import com.ylq.internships.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/getStuById.wx")
    public Student getStuByIdWx(String openid){
        return studentService.getStuById(openid);
    }
}
