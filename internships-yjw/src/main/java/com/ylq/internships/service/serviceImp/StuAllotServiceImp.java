package com.ylq.internships.service.serviceImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylq.internships.dto.StudentInformation;
import com.ylq.internships.entity.Score;
import com.ylq.internships.entity.StuAllot;
import com.ylq.internships.entity.Teacher;
import com.ylq.internships.mapper.*;
import com.ylq.internships.service.StuAllotService;
import com.ylq.internships.utils.Contant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class StuAllotServiceImp implements StuAllotService {

    @Autowired
    private StuAllotMapper stuAllotMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private StudentApartmentMapper studentApartmentMapper;
    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private ClockTimeMapper clockTimeMapper;
    Logger logger=LoggerFactory.getLogger(getClass());

    //获取学生项目列表
    @Override
    public PageInfo<StuAllot> findStuAllotList(int page, int limit, String sScName,String state) {
        if (Contant.AUDITED.equals(state)||Contant.INTENSHIPING.equals(state)){
            logger.info("StuAllotServiceImp的findStuAllotList方法的if执行了===="+state);
            PageHelper.startPage(page,limit);
            List<StuAllot> list = stuAllotMapper.getCompanyStuAllotList(sScName, state);
            PageInfo<StuAllot> pageInfo = new PageInfo<>(list);
            return pageInfo;
        } else {
            logger.info("StuAllotServiceImp的findStuAllotList方法的else执行了===="+state);
            PageHelper.startPage(page,limit);
            List<StuAllot> list = stuAllotMapper.getStuAllotList(sScName, state);
            PageInfo<StuAllot> pageInfo = new PageInfo<>(list);
            return pageInfo;
        }
    }

    //获取学校实习中学生
    @Override
    public PageInfo<StuAllot> findSchoolStuAllotList(int page, int limit, String sScName) {
        PageHelper.startPage(page,limit);
        List<StuAllot> list = stuAllotMapper.getStuAllotList(sScName, Contant.INTENSHIPING);
        PageInfo<StuAllot> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //企业获取实习中学生详细信息
    @Override
    public StudentInformation findStudentInformation(Integer id) {
        StudentInformation studentInformation=new StudentInformation();
        StuAllot stuAllot = stuAllotMapper.getById(id);
        studentInformation.setStuAllot(stuAllot);
        studentInformation.setScTel(teacherMapper.getTeacherTel(stuAllot.getScTeaWx()));
        studentInformation.setComTel(teacherMapper.getTeacherTel(stuAllot.getComTeaWx()));
        studentInformation.setDisplineName(classMapper.getDiscipline(stuAllot.getsScName(), stuAllot.getStudent().getClassName()));
        studentInformation.setLiveLocation(studentApartmentMapper.getAddress(stuAllot.getsWxNo()));
        return studentInformation;
    }

    //通过学生名查询学生项目
    @Override
    public PageInfo<StuAllot> findStuAllotListByStuName(int page, int limit, String sScName, String state, String stuName) {
        logger.info("StuAllotServiceImp的findStuAllotListByStuName方法执行了");
        PageHelper.startPage(page,limit);
        List<StuAllot> list = stuAllotMapper.getByStuName(sScName,state,stuName);
        PageInfo<StuAllot> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //学校通过学生名查询正在实习的学生
    public PageInfo<StuAllot> findSchoolStuAllotListByStuName(int page, int limit, String sScName, String state, String stuName) {
        logger.info("StuAllotServiceImp的findSchoolStuAllotListByStuName方法执行了");
        PageHelper.startPage(page,limit);
        List<StuAllot> list = stuAllotMapper.getSchoolStudnetByStuName(sScName,state,stuName);
        PageInfo<StuAllot> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //给审核项目添加带队老师
    @Transactional
    @Override
    public String editLeadTeacher(String unitNo, String unitName, String id) {
        logger.info("StuAllotServiceImp的editLeadTeacher方法执行了");
        Teacher teacher=teacherMapper.getTeacherByNo(unitNo, unitName);
        if (teacher!=null){
            stuAllotMapper.updateLeadTeacher(teacher.getWxNo(),teacher.getpName(),id);
            return "1";
        }
        return "2";
    }

    //带队老师查询所带学生信息(带队老师端)
    @Override
    public PageInfo<StuAllot> findStudentToSchoolTeacher(int page, int limit, String scTeaWx) {
        PageHelper.startPage(page,limit);
        List<StuAllot> list = stuAllotMapper.getStudentToSchoolTeacher(scTeaWx);
        PageInfo<StuAllot> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //给审核项目添加指导老师老师
    @Transactional
    @Override
    public String editCompanyTeacher(String unitNo, String unitName, String id) {
        logger.info("StuAllotServiceImp的editCompanyTeacher方法执行了");
        Teacher teacher=teacherMapper.getTeacherByNo(unitNo, unitName);
        if (teacher!=null){
            try {
                stuAllotMapper.updateCompanyTeacher(teacher.getWxNo(),teacher.getpName(),id);
                StuAllot studAllot = stuAllotMapper.getStudAllotById(id);
                Score score = new Score();
                score.setAttanScore(100.0);
                score.setWxNo(studAllot.getsWxNo());
                score.setScName(studAllot.getsScName());
                scoreMapper.insertScore(score);
                return teacher.getpName();
            } catch (Exception e) {
                e.printStackTrace();
                return "2";
            }
        }
        return "3";//教师工号不存在
    }

    //驳回待审核项目
    @Transactional
    @Override
    public void removeStuAllot(String id) {
        logger.info("StuAllotServiceImp的removeStuAllot方法执行了");
        stuAllotMapper.deleteStuAllot(id);
    }

    //批添加带队老师
    @Transactional
    @Override
    public String batachEditLeadTeacher(String[] ids, String unitNo, String unitName) {
        logger.info("StuAllotServiceImp的batachEditLeadTeacher方法执行了");
        Teacher teacher=teacherMapper.getTeacherByNo(unitNo, unitName);
        if (teacher!=null){
           stuAllotMapper.batachAddLeadTeacher(ids,teacher.getWxNo(),teacher.getpName());
            return "1";
        }
        return "2";
    }

    //批添加企业指导老师
    @Transactional
    @Override
    public String batachEditCompanyTeacher(String[] ids, String unitNo, String unitName) {
        logger.info("StuAllotServiceImp的batachEditCompanyTeacher方法执行了");
        Teacher teacher=teacherMapper.getTeacherByNo(unitNo, unitName);
        if (teacher!=null){
            try {
                stuAllotMapper.batachAddCompanyTeacher(ids,teacher.getWxNo(),teacher.getpName());
                return "1";
            } catch (Exception e) {
                e.printStackTrace();
                return "2";
            }
        }
        return "3";
    }

    //学生实习结束
    @Transactional
    @Override
    public void editState(String wxNo) {
        clockTimeMapper.deleteClockTime(wxNo);
        stuAllotMapper.updateState(wxNo);
    }

    //批删除学生项目
    @Transactional
    @Override
    public String batchRemoveStuAllot(String[] ids) {
        logger.info("StuAllotServiceImp的batchRemoveStuAllot方法执行了");
        try {
            stuAllotMapper.batachDeleteStuAllot(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return "2";
        }
        return "1";
    }
}
