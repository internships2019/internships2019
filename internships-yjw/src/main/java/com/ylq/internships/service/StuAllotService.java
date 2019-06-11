package com.ylq.internships.service;


import com.ylq.internships.entity.StuAllot;

import java.util.List;

public interface StuAllotService {
    String insertStu(String stu_wxNo,String job_id,String school_name);
    StuAllot selectStu(String openid);
    List<StuAllot> getApplications(String openid);
}
