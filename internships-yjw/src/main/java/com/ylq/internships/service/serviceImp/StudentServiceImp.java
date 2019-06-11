package com.ylq.internships.service.serviceImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Student;
import com.ylq.internships.mapper.StudentMapper;
import com.ylq.internships.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    Logger logger=LoggerFactory.getLogger(getClass());

    //查询学生列表
    @Override
    public PageInfo<Student> fingStudentList(int page,int limit,String sScName, String sState) {
        logger.info("StudentServiceImp的fingStudentList方法执行了");
        PageHelper.startPage(page,limit);
        List<Student> list = studentMapper.getStudentList(sScName, sState);
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //查询待学生详细信息
    @Override
    public Student findStudnetInformation(String wxNo) {
        return studentMapper.getStudnetInformation(wxNo);
    }

    //通过姓名查询学生
    @Override
    public PageInfo<Student> fingStudentByName(int page, int limit, String sScName, String sState, String sName) {
        logger.info("StudentServiceImp的fingStudentByName方法执行了");
        PageHelper.startPage(page,limit);
        List<Student> list = studentMapper.getStudentByName(sScName, sState,sName);
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //删除学生信息
    @Transactional
    @Override
    public void removeStudent(String wxNo) {
        logger.info("StudentServiceImp的removeStudent方法执行了==="+wxNo);
        studentMapper.deleteStudent1(wxNo);
    }
}
