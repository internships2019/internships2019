package com.ylq.internships.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Information;
import com.ylq.internships.service.InformationService;
import com.ylq.internships.utils.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/information")
public class InformationController {

    @Autowired
    InformationService informationService;
    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 获取学校通知了列表（分页）
     * @param page  页数
     * @param limit 一页中显示的记录数量
     * @return
     */
    @RequestMapping("/getInfoListWx.wx")
    public String getInfoListWx(String school_name,int page,int limit){

        logger.info("InformationServiceImp的getInfos执行===page>>>"+page+"===limit>>>"+limit);
        JSON json = new JSONObject();
        PageInfo<Information> pageInfo = informationService.getInfos(school_name,page,limit);
        ((JSONObject) json).put("data",pageInfo.getList());
        ((JSONObject) json).put("isLast",pageInfo.isIsLastPage());
        return json.toJSONString();
    }

    /**
     * 获取一条最新通知
     * @return
     */
    @RequestMapping("/getLatestWx.wx")
    public Information getLatest(){
        logger.info("InformationServiceImp的getLatest执行>>>>>>>>>");
        return informationService.getLatest();
    }

    /**
     * 以id查找通知
     * @param id
     * @return
     */
    @RequestMapping("/getByIdWx.wx")
    public Information getByIdWx(String id){
        return informationService.getById(id);
    }
}
