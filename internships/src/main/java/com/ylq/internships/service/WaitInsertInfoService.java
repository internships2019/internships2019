package com.ylq.internships.service;


import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.WaitInsertInfo;

public interface WaitInsertInfoService {
    //获取已录学生列表
    PageInfo<WaitInsertInfo> findStudentAll(int page,int limit,String unitName,String pStatus);
}
