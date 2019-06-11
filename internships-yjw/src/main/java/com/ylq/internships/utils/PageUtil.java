package com.ylq.internships.utils;

import com.alibaba.fastjson.JSONObject;
import com.ylq.internships.entity.*;
import com.ylq.internships.entity.Class;

import java.util.List;

public class PageUtil {

    //设置学校列表返回格式
    public static String getSchoolJson(List<School> list, long count){
        JSONObject obj=new JSONObject();
        obj.put("code",0);
        obj.put("msg","");
        obj.put("count",count);
        obj.put("data",list);
        System.out.println(obj.toJSONString());
        return obj.toJSONString();
    }

    //设置管理员列表返回格式
    public static String getManagerJson(List<Manager> list, long count){
        JSONObject obj = PageUtil.toCode(count);
        obj.put("data",list);
        System.out.println(obj.toJSONString());
        return obj.toJSONString();
    }

    //设置企业列表返回格式
    public static String getCompanyJson(List<Company> list, long count){
        JSONObject obj = PageUtil.toCode(count);
        obj.put("data",list);
        System.out.println(obj.toJSONString());
        return obj.toJSONString();
    }

    //设置录入人员信息列表返回格式
    public static String getWaitInsertInfoJson(List<WaitInsertInfo> list, long count){
        JSONObject obj = PageUtil.toCode(count);
        obj.put("data",list);
        System.out.println(obj.toJSONString());
        return obj.toJSONString();
    }

    //设置班级信息列表返回格式
    public static String getClassJson(List<Class> list, long count){
        JSONObject obj = PageUtil.toCode(count);
        obj.put("data",list);
        System.out.println(obj.toJSONString());
        return obj.toJSONString();
    }

    //设置实习岗位信息列表返回格式
    public static String getCompanyJobJson(List<CompanyJob> list, long count){
        JSONObject obj = PageUtil.toCode(count);
        obj.put("data",list);
        System.out.println(obj.toJSONString());
        return obj.toJSONString();
    }

    //设置实习岗位信息列表返回格式
    public static String getStudentJson(List<Student> list, long count){
        JSONObject obj = PageUtil.toCode(count);
        obj.put("data",list);
        System.out.println(obj.toJSONString());
        return obj.toJSONString();
    }

    //设置学生项目信息列表返回格式
    public static String getStuAllotJson(List<StuAllot> list, long count){
        JSONObject obj = PageUtil.toCode(count);
        obj.put("data",list);
        System.out.println(obj.toJSONString());
        return obj.toJSONString();
    }

    //设置老师信息列表返回格式
    public static String getTeacherJson(List<Teacher> list, long count){
        JSONObject obj = PageUtil.toCode(count);
        obj.put("data",list);
        System.out.println(obj.toJSONString());
        return obj.toJSONString();
    }

    //设置学生打卡信息列表返回格式
    public static String getClockRecordJson(List<ClockRecord> list, long count){
        JSONObject obj = PageUtil.toCode(count);
        obj.put("data",list);
        System.out.println(obj.toJSONString());
        return obj.toJSONString();
    }

    //设置通知信息列表返回格式
    public static String getInformationJson(List<Information> list, long count){
        JSONObject obj = PageUtil.toCode(count);
        obj.put("data",list);
        System.out.println(obj.toJSONString());
        return obj.toJSONString();
    }

    //设置成绩信息列表返回格式
    public static String getScoreJson(List<Score> list, long count){
        JSONObject obj = PageUtil.toCode(count);
        obj.put("data",list);
        System.out.println(obj.toJSONString());
        return obj.toJSONString();
    }

    public static JSONObject getCode(long count){
        JSONObject obj=new JSONObject();
        obj.put("code",0);
        obj.put("msg","");
        obj.put("count",count);
        return obj;
    }

    private static JSONObject toCode(long count){
        JSONObject obj=new JSONObject();
        obj.put("code",0);
        obj.put("msg","");
        obj.put("count",count);
        return obj;
    }
}
