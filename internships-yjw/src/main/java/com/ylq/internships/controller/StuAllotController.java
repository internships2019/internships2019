package com.ylq.internships.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qiniu.util.Json;
import com.ylq.internships.entity.StuAllot;
import com.ylq.internships.entity.Teacher;
import com.ylq.internships.service.StuAllotService;
import com.ylq.internships.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stuAllot")
public class StuAllotController {

    @Autowired
    StuAllotService stuAllotService;
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    TeacherService teacherService;

    /**
     * 插入申请岗位的学生信息
     * @param open_id
     * @param job_id
     * @param school_name
     * @return
     */
    @RequestMapping("/insertStuWx.wx")
    public String insertStuWx(String open_id,String job_id,String school_name){
        logger.info("StuAllotController的insertStuWx执行===" + open_id + "==="+job_id);
        return stuAllotService.insertStu(open_id,job_id,school_name);
    }

    /**
     * 获取学生的带队老师和企业指导老师信息
     * @param openid
     * @return
     */
    @RequestMapping("/getTeasInfoWx.wx")
    public String getTeasInfoWx(String openid){
        StuAllot stu = stuAllotService.selectStu(openid);
        JSON json = new JSONObject();
        logger.info("stu>>>>>>>>>"+stu.toString());
        Teacher com_tea = teacherService.getTeaById(stu.getComTeaWx());
        Teacher sc_tea = teacherService.getTeaById(stu.getScTeaWx());

        ((JSONObject) json).put("com_tea",com_tea);
        ((JSONObject) json).put("sc_tea",sc_tea);
        return json.toJSONString();
    }

    /**
     * 获取学生的申请岗位记录
     * @param openid
     * @return
     */
    @RequestMapping("getApplicationWx.wx")
    public List<StuAllot> getApplicationWx(String openid){
        return stuAllotService.getApplications(openid);

    }
}
