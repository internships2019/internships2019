package com.ylq.internships.service.serviceImp;

import com.ylq.internships.entity.Student;
import com.ylq.internships.mapper.StudentMapper;
import com.ylq.internships.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student getStuById(String openid) {
        return studentMapper.selectStuByIdWx(openid);
    }
}
