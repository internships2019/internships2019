package com.ylq.internships.controller;

import com.github.pagehelper.PageInfo;
import com.ylq.internships.dto.StudentInformation;
import com.ylq.internships.entity.StuAllot;
import com.ylq.internships.service.StuAllotService;
import com.ylq.internships.utils.PageUtil;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/stuAllot")
public class StuAllotController {

    @Autowired
    private StuAllotService stuAllotService;
    Logger logger= LoggerFactory.getLogger(getClass());

    //查询项目列表后台接口
    @RequestMapping("/find_stuAllot_list")
    public String fingStuAllotList(int page,int limit,String sScName,String state){
        logger.info("StuAllotController的fingStuAllotList执行了==="+sScName+"===="+state);
        PageInfo<StuAllot> pageInfo = stuAllotService.findStuAllotList(page, limit, sScName, state);
        return PageUtil.getStuAllotJson(pageInfo.getList(),pageInfo.getTotal());
    }

    //通过学生名查询项目列表后台接口
    @RequestMapping("/find_stuAllot_byStuName")
    public String fingStuAllotListByStuName(int page,int limit,String sScName,String state,String stuName){
        logger.info("StuAllotController的fingStuAllotListByStuName执行了==="+sScName+"===="+state+"===="+stuName);
        PageInfo<StuAllot> pageInfo = stuAllotService.findStuAllotListByStuName(page, limit, sScName, state,stuName);
        return PageUtil.getStuAllotJson(pageInfo.getList(),pageInfo.getTotal());
    }

    //学校通过学生名查询实习中学生后台接口
    @RequestMapping("/find_school_student_byStuName")
    public String fingSchoolStuAllotListByStuName(int page,int limit,String sScName,String state,String stuName){
        logger.info("StuAllotController的fingStuAllotListByStuName==="+sScName+"===="+state+"===="+stuName);
        PageInfo<StuAllot> pageInfo = stuAllotService.findSchoolStuAllotListByStuName(page, limit, sScName, state,stuName);
        return PageUtil.getStuAllotJson(pageInfo.getList(),pageInfo.getTotal());
    }


    //学校查询实习中学生后台接口
    @RequestMapping("/find_internship_student_list")
    public String fingSchoolStuAllotList(int page,int limit,String sScName){
        logger.info("StuAllotController的fingStuAllotList执行了==="+sScName);
        PageInfo<StuAllot> pageInfo = stuAllotService.findSchoolStuAllotList(page, limit, sScName);
        return PageUtil.getStuAllotJson(pageInfo.getList(),pageInfo.getTotal());
    }

    //查询实习中学生详细信息后台接口
    @RequestMapping("/find_student_information")
    public StudentInformation fingStudentInformation(Integer id){
        logger.info("StuAllotController的fingStuAllotList执行了==="+id);
        return stuAllotService.findStudentInformation(id);
    }

    //添加带队老师后台接口
    @RequestMapping("/add_leadTeacher")
    public String addLeadTeacher(String unitNo,String unitName,String id){
        logger.info("StuAllotController的fingStuAllotList执行了==="+unitNo+"===="+unitName+"===="+id);
        return stuAllotService.editLeadTeacher(unitNo, unitName, id);
    }

    //添加指导老师后台接口
    @RequestMapping("/add_companyTeacher")
    public String addCompanyTeacher(String unitNo,String unitName,String id){
        logger.info("StuAllotController的fingStuAllotList执行了==="+unitNo+"===="+unitName+"===="+id);
        return stuAllotService.editCompanyTeacher(unitNo, unitName, id);
    }


    //驳回待审核项目后台接口
    @RequestMapping("/remove_stuAllot")
    public void removeStuAllot(@RequestBody String id){
        logger.info("StuAllotController的fingStuAllotList执行了====="+id);
        stuAllotService.removeStuAllot(id);
    }

    //批添加带队老师后台接口
    @RequestMapping("/batch_add_leadTeacher")
    public String batchAddLeadTeacher(String[] ids, String unitNo, String unitName){
        logger.info("StuAllotController的batchAddLeadTeacher==="+unitNo+"===="+unitName+"===="+Arrays.toString(ids));
        return stuAllotService.batachEditLeadTeacher(ids,unitNo,unitName);
    }

    //批添加指导老师后台接口
    @RequestMapping("/batch_add_companyTeacher")
    public String batchAddCompanyTeacher(String[] ids, String unitNo, String unitName){
        logger.info("StuAllotController的batchAddCompanyTeacher==="+unitNo+"===="+unitName+"===="+Arrays.toString(ids));
        return stuAllotService.batachEditCompanyTeacher(ids,unitNo,unitName);
    }

    //学生实习结束功能后台接口
    @PostMapping("/edit_state")
    public void editState(String wxNo){
        logger.info("stuAllot的editState方法执行力===="+wxNo);
        stuAllotService.editState(wxNo);
    }

    //批移除学生项目后台接口
    @RequestMapping("/batch_delete_leadTeacher")
    public String batchRemoveLeadTeacher(String[] ids){
        logger.info("StuAllotController的batchAddLeadTeacher==="+Arrays.toString(ids));
        return stuAllotService.batchRemoveStuAllot(ids);
    }
}
