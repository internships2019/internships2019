package com.ylq.internships.service;


import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.ClockRecord;

public interface ClockRecordService {
    PageInfo<ClockRecord> findStudentClockRecord(int page,int limit,String wxNo);
    void timingClockRecord();
}
