package com.ylq.internships.service.serviceImp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import com.qiniu.util.Json;
import com.ylq.internships.entity.Student;
import com.ylq.internships.entity.Teacher;
import com.ylq.internships.entity.WaitInsertInfo;
import com.ylq.internships.mapper.ClassMapper;
import com.ylq.internships.mapper.StudentMapper;
import com.ylq.internships.mapper.TeacherMapper;
import com.ylq.internships.mapper.WaitInsertInfoMapper;
import com.ylq.internships.service.ClassService;
import com.ylq.internships.service.WaitInsertInfoService;
import com.ylq.internships.utils.Contant;
import com.ylq.internships.utils.ExcelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.ylq.internships.utils.Contant.STUDENT;

@Service
public class WaitInsertInfoServiceImp implements WaitInsertInfoService {

    @Autowired
    private WaitInsertInfoMapper waitInsertInfoMapper;
    @Autowired
    private ClassMapper classMapper;
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    //获取已录人员信息列表
    @Override
    public PageInfo<WaitInsertInfo> findStudentAll(int page, int limit, String unitName, String pStatus) {
        logger.info("WaitInsertInfoServiceImp的findStudentAll执行了");
        PageHelper.startPage(page, limit);
        List<WaitInsertInfo> list = waitInsertInfoMapper.getStudentAll(unitName, pStatus);
        PageInfo<WaitInsertInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //通过编号获取录入人员信息
    public WaitInsertInfo findWaitInsertInfoByPno(String unitName, String pNo) {
        logger.info("WaitInsertInfoServiceImp的findWaitInsertInfoByPno执行了");
        return waitInsertInfoMapper.getWaitInsertInfoByPNo(pNo, unitName);
    }

    //获取WaitInsertInfo详细信息
    @Override
    public WaitInsertInfo findWaitInsertInfoById(int id) {
        return waitInsertInfoMapper.getWaitInsertInfoById(id);
    }

    //通过人员姓名获取人员信息
    @Override
    public PageInfo<WaitInsertInfo> findWaitInsertInfoByName(int page, int limit, String unitName, String pStatus, String pName) {
        logger.info("WaitInsertInfoServiceImp的findStudentByName执行了" + pStatus + "===" + pName + "===" + unitName);
        PageHelper.startPage(page, limit);
        List<WaitInsertInfo> list = waitInsertInfoMapper.getWaitInsertInfoByName(unitName, pStatus, pName);
        PageInfo<WaitInsertInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //获取人员照片路径
    @Override
    public WaitInsertInfo findTeacherById(int id) {
        logger.info("WaitInsertInfoServiceImp的findStudentByName执行了" + id);
        return waitInsertInfoMapper.getTeacherById(id);
    }

    //添加待录人员信息
    @Transactional
    @Override
    public String addWaitInsertInfo(WaitInsertInfo waitInsertInfo) {
        logger.info("WaitInsertInfoServiceImp的addWaitInsertInfo执行了");
        if (findWaitInsertInfoByPno(waitInsertInfo.getUnitName(), waitInsertInfo.getpNo()) == null) {
            waitInsertInfoMapper.insert(waitInsertInfo);
            return "1";
        }
        return "2";
    }

    //更换照片
    @Transactional
    @Override
    public void editImg(String id, String path) {
        waitInsertInfoMapper.updateImg(id, path);
    }

    //批插入待录人员信息
    @Transactional
    @Override
    public String batchAddWaitInsertInfo(MultipartFile file, String schoolName, String pStatus) throws IOException {
        if (pStatus.equals(STUDENT)) {//学生待录
            List<String> classs = classMapper.getNames(schoolName);//获取学校班级列表
            List<WaitInsertInfo> list = ExcelUtil.getStudentListByExcel(file, classs);
            for (String c : classs) {
                System.out.println(c);
            }
            if (list == null) {//list为null表明excel1格式有误
                return null;
            }
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setUnitName(schoolName);
                list.get(i).setpStatus(STUDENT);
                System.out.println(list.get(i).toString());
            }
            waitInsertInfoMapper.batchInsert(list);
            return "1";
        } else {
            List<WaitInsertInfo> list = ExcelUtil.getTeacherListByExcel(file);
            if (list == null) {
                return null;
            }
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setUnitName(schoolName);
                list.get(i).setpStatus(Contant.TEACHER_SCHOOL);
                System.out.println(list.get(i).toString());
            }
            waitInsertInfoMapper.batchInsertTeacher(list);
            return "1";
        }
    }


    //批删除人员信息
    @Transactional
    @Override
    public void batchDeleteWaitInsertInfo(String[] arr) {
        logger.info("WaitInsertInfoServiceImp的batchDeleteWaitInsertInfo执行了");
        waitInsertInfoMapper.batchDelete(arr);
    }

    @Override
    public String pInsert(String opid, WaitInsertInfo p) {
        logger.info("WaitInsertInfoServiceImp>>>>>>>>>stuInsert");
        WaitInsertInfo waitInsertInfo = waitInsertInfoMapper.selectPerson(p);
        logger.info("身份》》》》》》" + waitInsertInfo.getpStatus());
        logger.info("wx>>>>>>" + p.toString());
        JSON json = new JSONObject();
        if (waitInsertInfo != null) {
            String user_type = waitInsertInfo.getpStatus();
            if (user_type.equals(STUDENT)) {
                Student stuExist = studentMapper.selectStuByIdWx(opid); //检查学生表内是否有此用户
                if (stuExist == null) {
                    logger.info("waitInsertInfo>>>>>>>>>" + waitInsertInfo.toString());
                    Student student = new Student().initStu(opid, waitInsertInfo);
                    logger.info("stu>>>>>>>>>>>>>>>>>>>" + student.toString());
                    studentMapper.insertStu(student);
                    ((JSONObject) json).put("valid_state", "ok");
                    ((JSONObject) json).put("data", student);
                    return json.toJSONString();
                } else {

                    ((JSONObject) json).put("valid_state", "exist");//学生表已存在此用户
                    return json.toJSONString();
                }
            } else {
                Teacher existTea = teacherMapper.selectTeaById(opid);
                if (existTea == null) {
                    Teacher teacher = new Teacher().initTeacher(opid, waitInsertInfo);
                    teacherMapper.insertTea(teacher);
                    ((JSONObject) json).put("valid_state", "ok");
                    ((JSONObject) json).put("data", teacher);
                    return json.toJSONString();
                } else {
                    ((JSONObject) json).put("valid_state", "exist");//老师表已存在此用户
                    return json.toJSONString();
                }
            }
        }

        ((JSONObject) json).put("valid_state", "invalid");//表示带录入表内不存在此用户信息
        return json.toJSONString();

    }

}
