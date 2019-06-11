package com.ylq.internships.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.ClockRecord;
import com.ylq.internships.service.ClockRecordService;
import com.ylq.internships.service.serviceImp.ClockRecordServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clockRecord")
public class ClockRecordController {

    @Autowired
    ClockRecordService clockRecordService;
    private Logger logger= LoggerFactory.getLogger(getClass());

    /**
     * 打卡
     * @param openid
     * @param longitude
     * @param latitude
     * @param location
     * @return
     */
    @RequestMapping("clockWx.wx")
    public String clockWx(String openid, String longitude, String latitude,String location){
        logger.info("ClockRecordController的clockWx执行>>>>>>>>>"+longitude+","+latitude);
        return clockRecordService.clock(openid, longitude, latitude,location);
    }

    @RequestMapping("getRecordsWx.wx")
    public String getRecords(String openid,int page,int limit){
        logger.info("ClockRecordController的getRecords执行>>>>>>>>>"+page);
        JSON json = new JSONObject();
        PageInfo<ClockRecord> pageInfo = clockRecordService.getRecords(openid,page,limit);
        ((JSONObject) json).put("data",pageInfo.getList());
        ((JSONObject) json).put("isLast",pageInfo.isIsLastPage());
        return json.toJSONString();
    }

}
