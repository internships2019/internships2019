package com.ylq.internships.service;


import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Teacher;

public interface TeacherService {
    PageInfo<Teacher> findTeacherList(int page,int limit,String unitName,String pStatus);
}
