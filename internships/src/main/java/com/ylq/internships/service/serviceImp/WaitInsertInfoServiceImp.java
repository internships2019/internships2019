package com.ylq.internships.service.serviceImp;

import com.ylq.internships.entity.Student;
import com.ylq.internships.entity.Teacher;
import com.ylq.internships.entity.WaitInsertInfo;
import com.ylq.internships.mapper.StudentMapper;
import com.ylq.internships.mapper.TeacherMapper;
import com.ylq.internships.mapper.WaitInsertInfoMapper;
import com.ylq.internships.service.WaitInsertInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaitInsertInfoServiceImp implements WaitInsertInfoService {

    @Autowired
    private WaitInsertInfoMapper waitInsertInfoMapper;
    Logger logger= LoggerFactory.getLogger(getClass());
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public String pInsert(String opid,WaitInsertInfo p) {
        logger.info("WaitInsertInfoServiceImp>>>>>>>>>stuInsert");
        WaitInsertInfo waitInsertInfo = waitInsertInfoMapper.selectPerson(p);
        logger.info("身份》》》》》》"+waitInsertInfo.getpStatus());
        logger.info("1wx>>>>>>"+p.toString());
        if (waitInsertInfo != null) {
            String user_type = waitInsertInfo.getpStatus();
            if (user_type.equals("学生")) {
                logger.info("waitInsertInfo>>>>>>>>>"+waitInsertInfo.toString());
                Student student = new Student().initStu(opid, waitInsertInfo);
                logger.info("stu>>>>>>>>>>>>>>>>>>>"+student.toString());
                studentMapper.insertStu(student);
            }else {
                Teacher teacher = new Teacher().initTeacher(opid,waitInsertInfo);
                teacherMapper.insertTea(teacher);
            }
            return "valid";
        }else {
            return "invalid";
        }
    }

}
