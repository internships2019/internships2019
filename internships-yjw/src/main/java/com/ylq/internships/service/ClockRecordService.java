package com.ylq.internships.service;


import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.ClockRecord;

public interface ClockRecordService {

    String clock(String openid,String Longitude,String Latitude,String location);
    PageInfo<ClockRecord> getRecords(String openid,int page,int limit);
}
