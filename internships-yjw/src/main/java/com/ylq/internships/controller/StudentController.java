package com.ylq.internships.controller;

import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Student;
import com.ylq.internships.service.StudentService;
import com.ylq.internships.utils.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    Logger logger= LoggerFactory.getLogger(getClass());

    //查询待实习学生列表后台接口
    @RequestMapping("/find_student_list")
    public String fingStudentList(int page,int limit,String sScName,String sState){
        logger.info("StudentController的fingStudentList执行了");
        PageInfo<Student> pageInfo = studentService.fingStudentList(page, limit, sScName, sState);
        return PageUtil.getStudentJson(pageInfo.getList(),pageInfo.getTotal());
    }

    //通过姓名查询实习学生后台接口
    @RequestMapping("/find_student_name")
    public String fingStudentByName(int page,int limit,String sScName,String sState,String sName){
        logger.info("StudentController的fingStudentByName执行了");
        PageInfo<Student> pageInfo = studentService.fingStudentByName(page, limit, sScName, sState,sName);
        return PageUtil.getStudentJson(pageInfo.getList(),pageInfo.getTotal());
    }

    //查询待实习学生详细信息后台接口
    @RequestMapping("/find_student_information")
    public Student fingStudenInformation(String wxNo){
        logger.info("StudentController的fingStudenInformation执行了==="+wxNo);
        return studentService.findStudnetInformation(wxNo);
    }

    //删除待实习学生详细信息后台接口
    @RequestMapping("/remove_student")
    public void removeStudent(@RequestBody String wxNo){
        logger.info("StudentController的removeStudent执行了==="+wxNo);
        studentService.removeStudent(wxNo);
    }
}
