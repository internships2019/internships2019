package com.ylq.internships.service.serviceImp;

import com.ylq.internships.entity.StudentApartment;
import com.ylq.internships.mapper.StudentApartmentMapper;
import com.ylq.internships.service.StudentApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentApartmentServiceImp implements StudentApartmentService {
    @Autowired
    private StudentApartmentMapper studentApartmentMapper;

    //带队老师设置学生住宿地址
    @Transactional
    @Override
    public void addStudentApartment(StudentApartment studentApartment) {
        studentApartmentMapper.insertAddress(studentApartment);
    }

    //带队老师修改学生住宿地址
    @Transactional
    @Override
    public void editSAtudentApartment(StudentApartment studentApartment) {
        studentApartmentMapper.updateAddress(studentApartment);
    }
}
