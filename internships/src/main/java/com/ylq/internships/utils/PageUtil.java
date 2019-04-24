package com.ylq.internships.utils;

import com.alibaba.fastjson.JSONObject;
import com.ylq.internships.entity.Manager;
import com.ylq.internships.entity.School;

import java.util.List;

public class PageUtil {

    public static String getSchoolJson(List<School> list, long count){
        JSONObject obj=new JSONObject();
        obj.put("code",0);
        obj.put("msg","");
        obj.put("count",count);
        obj.put("data",list);
        System.out.println(obj.toJSONString());
        return obj.toJSONString();
    }

    public static String getManagerJson(List<Manager> list, long count){
        JSONObject obj = PageUtil.toCode(count);
        obj.put("data",list);
        System.out.println(obj.toJSONString());
        return obj.toJSONString();
    }

    private static JSONObject toCode(long count){
        JSONObject obj=new JSONObject();
        obj.put("code",0);
        obj.put("msg","");
        obj.put("count",count);
        return obj;
    }
}
