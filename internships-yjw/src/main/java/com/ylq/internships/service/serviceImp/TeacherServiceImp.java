package com.ylq.internships.service.serviceImp;

import com.ylq.internships.entity.Teacher;
import com.ylq.internships.mapper.TeacherMapper;
import com.ylq.internships.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImp  implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public Teacher getTeaById(String opdenid) {
        return teacherMapper.selectTeaById(opdenid);
    }
}
