package com.ylq.internships.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.qiniu.util.Json;
import com.ylq.internships.entity.CompanyJob;
import com.ylq.internships.service.CompanyJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companyJob")
public class CompanyJobController {

    @Autowired
    CompanyJobService companyJobService;

    /**
     * 按时间升序获取招聘广告
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/getJobsWx.wx")
    public String getJobsWx(int page, int limit,String sc_name) {
        JSON json = new JSONObject();
        PageInfo<CompanyJob> companyJobPageInfo = companyJobService.getAll(page, limit,sc_name);
        ((JSONObject) json).put("data", companyJobPageInfo.getList());
        ((JSONObject) json).put("isLast", companyJobPageInfo.isIsLastPage());
        return json.toJSONString();
    }

    /**
     * 按时间降序获取招聘广告
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/getAllDescWx.wx")
    public String getAllDescWx(int page, int limit,String sc_name) {
        JSON json = new JSONObject();
        PageInfo<CompanyJob> companyJobPageInfo = companyJobService.getAllDesc(page, limit,sc_name);
        ((JSONObject) json).put("data", companyJobPageInfo.getList());
        ((JSONObject) json).put("isLast", companyJobPageInfo.isIsLastPage());
        return json.toJSONString();
    }

    /**
     * 按公司名字进行模糊查询
     *
     * @param page
     * @param limit
     * @param com_name
     * @return
     */
    @RequestMapping("/searchByComNameWx.wx")
    public String searchByComName(int page, int limit, String com_name,String sc_name) {
        JSON json = new JSONObject();
        PageInfo<CompanyJob> companyJobPageInfo = companyJobService.searchByComName(page, limit, com_name,sc_name);
        ((JSONObject) json).put("data", companyJobPageInfo.getList());
        ((JSONObject) json).put("isLast", companyJobPageInfo.isIsLastPage());
        return json.toJSONString();
    }

    @RequestMapping("/searchByIdWx.wx")
    public CompanyJob searchById(String job_id) {
        return companyJobService.searchById(job_id);
    }

    @RequestMapping("/checkNowNumWx.wx")
    public String checkNowNumWx(String job_id) {
        return companyJobService.checkNowNum(job_id);
    }
}
