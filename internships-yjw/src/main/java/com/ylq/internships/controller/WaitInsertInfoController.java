package com.ylq.internships.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.WaitInsertInfo;
import com.ylq.internships.service.WaitInsertInfoService;
import com.ylq.internships.utils.PageUtil;
import com.ylq.internships.utils.QiNiuYunUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/waitInsertInfo")
public class WaitInsertInfoController {

    @Autowired
    private WaitInsertInfoService waitInsertInfoService;
    Logger logger= LoggerFactory.getLogger(getClass());



    //获取已录人员列表
    @RequestMapping("/get_student_all")
    public String getStudentAll(int page,int limit,String unitName,String pStatus){
        logger.info("WaitInsertInfoController的getStudentAll方法执行==="+page+"==="+limit+"==="+unitName+"==="+pStatus);
        PageInfo<WaitInsertInfo> pageInfo = waitInsertInfoService.findStudentAll(page, limit, unitName, pStatus);
        return PageUtil.getWaitInsertInfoJson(pageInfo.getList(),pageInfo.getTotal());
    }

    //添加人员基本信息
    @RequestMapping("/add_waitInsertInfo")
    public String addWaitInsertInfo(@RequestBody WaitInsertInfo waitInsertInfo){
        logger.info("WaitInsertInfoController的getStudentAll方法执行==="+waitInsertInfo.toString());
        return waitInsertInfoService.addWaitInsertInfo(waitInsertInfo);
    }

    //根据姓名搜索
    @RequestMapping("/find_waitInfo_byName")
    public String findWaitInsertInfoByName(int page,int limit,String pStatus,String pName,String unitName){
        logger.info("WaitInsertInfoController的findWaitInsertInfoByName方法执行==="+pStatus+"==="+pName+"==="+unitName);
        PageInfo<WaitInsertInfo> pageInfo = waitInsertInfoService.findWaitInsertInfoByName(page, limit, unitName, pStatus, pName);
        return PageUtil.getWaitInsertInfoJson(pageInfo.getList(),pageInfo.getTotal());
    }

    //上传照片
    @RequestMapping("/upload_image")
    public String uploadImage(@RequestParam("file") MultipartFile file,String id)  {
        logger.info("WaitInsertInfoController的upload_image方法执行==="+id);
        try {
            String imgPath = QiNiuYunUtil.upLoadImage(file);
            logger.info(imgPath);
            waitInsertInfoService.editImg(id,imgPath);
            JSONObject object=new JSONObject();
            object.put("code",1);
            object.put("data",imgPath);
            return object.toJSONString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //查询教师信息
    @RequestMapping("/get_waitInsert_img")
    public WaitInsertInfo findWaitInsertInfImg(String id){
        logger.info("WaitInsertInfoController的findWaitInsertInfImg方法执行==="+id);
        return waitInsertInfoService.findTeacherById(Integer.parseInt(id));
    }

    //修改教师基本信息
    @RequestMapping("/edit_teacher")
    public void editTeacher(@RequestBody WaitInsertInfo waitInsertInfo){
        logger.info("WaitInsertInfoController的findWaitInsertInfImg方法执行==="+waitInsertInfo.toString());
        waitInsertInfoService.editTeacher(waitInsertInfo);
    }


    //修改教师基本信息
    @RequestMapping("/edit_student")
    public void editStudent(@RequestBody WaitInsertInfo waitInsertInfo){
        logger.info("WaitInsertInfoController的findWaitInsertInfImg方法执行==="+waitInsertInfo.toString());
        waitInsertInfoService.editStudent(waitInsertInfo);
    }

    //批导入人员信息
    @RequestMapping("/batch_add_waitInsertInfo")
    public String batchAddWaitInsertInfo(@RequestParam("file") MultipartFile file,String schoolName,String pStatus) throws IOException {
        logger.info("WaitInsertInfoController的getStudentAll方法执行==="+schoolName+"===="+pStatus);
        return waitInsertInfoService.batchAddWaitInsertInfo(file,schoolName,pStatus);
    }

    //查询已录人员详细信息
    @RequestMapping("/find_waitInfo_information")
    public WaitInsertInfo findWaitInsertInfoInformation(String id){
        WaitInsertInfo waitInsertInfoById = waitInsertInfoService.findWaitInsertInfoById(Integer.parseInt(id));
        System.out.println(waitInsertInfoById.toString());
        return waitInsertInfoById;
    }

    //批删除人员基本信息
    @RequestMapping("/batch_remove_waitInsertInfo")
    public void batchRemoveWaitInsertInfo(@RequestBody String[] arr){
        logger.info("WaitInsertInfoController的getStudentAll方法执行==="+ Arrays.toString(arr));
        waitInsertInfoService.batchDeleteWaitInsertInfo(arr);
    }

    //删除人员基本信息
    @RequestMapping("/remove_waitInsertInfo")
    public void RemoveWaitInsertInfo(@RequestBody String id){
        logger.info("WaitInsertInfoController的getStudentAll方法执行==="+id);
        waitInsertInfoService.removeWaitInsertInfo(Integer.parseInt(id));
    }
}
