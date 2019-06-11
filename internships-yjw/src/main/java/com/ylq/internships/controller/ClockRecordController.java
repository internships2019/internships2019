package com.ylq.internships.controller;

import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.ClockRecord;
import com.ylq.internships.service.ClockRecordService;
import com.ylq.internships.utils.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clockRecord")
public class ClockRecordController {
    @Autowired
    private ClockRecordService clockRecordService;
    private Logger logger= LoggerFactory.getLogger(getClass());

    @RequestMapping("/find_student_clockRecord")
    public String findStudentClockRecord(int page,int limit,String wxNo){
        logger.info("ClockRecordController的findStudentClockRecord方法执行了");
        PageInfo<ClockRecord> pageInfo = clockRecordService.findStudentClockRecord(page, limit, wxNo);
        return PageUtil.getClockRecordJson(pageInfo.getList(),pageInfo.getTotal());
    }
}
