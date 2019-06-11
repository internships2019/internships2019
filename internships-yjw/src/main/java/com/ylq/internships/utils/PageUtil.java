package com.ylq.internships.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
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

    //设置学校通知信息列表返回格式
    public static String getInformationJson(List<Information> list,long count){
        JSONObject object = PageUtil.toCode(count);
        object.put("data",list);
        System.out.println(object.toJSONString());
        return object.toJSONString();
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
