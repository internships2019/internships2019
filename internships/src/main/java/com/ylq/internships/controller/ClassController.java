package com.ylq.internships.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Class;
import com.ylq.internships.service.ClassService;
import com.ylq.internships.utils.ExcelUtil;
import com.ylq.internships.utils.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService classService;
    Logger logger= LoggerFactory.getLogger(getClass());

    //查询班级列表
    @RequestMapping("/find_all")
    public String findAll(int page,int limit,String sScName){
        logger.info("ClassController的findAll执行");
        PageInfo<Class> info = classService.findClassAll(page, limit, sScName);
        return PageUtil.getClassJson(info.getList(),info.getTotal());
    }

    @RequestMapping("/find_class")
    public String findClassByName(String sScName,String className){
        logger.info("ClassController的findAll执行==="+sScName+"==="+className);
        List<Class> list = classService.findByNames(sScName, className);
        JSONObject obj = PageUtil.getCode(list.size());
        obj.put("data",list);
        return JSONObject.toJSONString(obj);
    }

    //添加班级
    @RequestMapping("/add_class")
    public String addClass(@RequestBody  Class aclass){
        logger.info("ClassController的addClass执行");
        if (classService.findByNames(aclass.getsScName(),aclass.getClassName())==null){
            classService.addClass(aclass);
            return "1";
        }
        return "2";
    }

    @RequestMapping("/add_batch_class")
    public String addBatchClass(@RequestParam("file") MultipartFile file,@RequestParam("schoolName") String schoolName) throws IOException {
        logger.info("ClassController的addClass执行===="+schoolName);
        List<Class> list = ExcelUtil.getClassListByExcel(file);
        if (list!=null){
            for (int i=0;i<list.size();i++){
                list.get(i).setsScName(schoolName);
                System.out.println(list.get(i).toString());
            }
            classService.addBatchClass(list);
            return "1";
        }
        System.out.println("excel表格式异常！");
        return "2";
    }
}
