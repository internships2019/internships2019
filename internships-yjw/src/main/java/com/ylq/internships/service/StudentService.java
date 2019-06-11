package com.ylq.internships.service;


import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Student;

public interface StudentService {
    PageInfo<Student> fingStudentList(int page,int limit,String sScName,String sState);
    PageInfo<Student> fingStudentByName(int page,int limit,String sScName,String sState,String sName);
    Student findStudnetInformation(String wxNo);
    void removeStudent(String wxNo);
}
