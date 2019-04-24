package com.ylq.internships.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.School;
import com.ylq.internships.service.SchoolService;
import com.ylq.internships.utils.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;
    Logger logger= LoggerFactory.getLogger(getClass());

    //获取学校列表
    @RequestMapping("/get_list")
    public String getList(int page,int limit){
        logger.info("SchoolController的getList执行==="+page+"==="+limit);
        PageInfo<School> pageInfo = schoolService.getAll(page, limit);
        return PageUtil.getSchoolJson(pageInfo.getList(),pageInfo.getTotal());
    }

    //添加学校
    @RequestMapping("/add_school")
    public String addSchool(@RequestBody School school){
        logger.info("SchoolController的addSchool执行==="+school.toString());
        if (schoolService.getSchoolByName(school.getScName())==null){
            schoolService.addSchool(school);
            return "1";
        }
        return "2";
    }

    //修改学校
    @RequestMapping("/edit_school")
    public String editSchool(@RequestBody School school){
        logger.info("SchoolController的editSchool执行==="+school.toString());
        schoolService.editSchol(school);
        return "1";
    }

    //删除学校
    @RequestMapping("/remove_school")
    public String removeSchool(@RequestBody String scName){
        logger.info("SchoolController的editSchool执行==="+scName);
        schoolService.removeSchool(scName);
        return "1";
    }

    //获取所有学校名称
    @RequestMapping("/get_school_name")
    public List<String> getSchoolName(){
        return schoolService.getAllName();
    }

}
