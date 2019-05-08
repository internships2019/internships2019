package com.ylq.internships.service;


import com.ylq.internships.entity.Student;
import com.ylq.internships.entity.WaitInsertInfo;

public interface WaitInsertInfoService {

    public String pInsert(String opid,WaitInsertInfo waitInsertInfo);
}
