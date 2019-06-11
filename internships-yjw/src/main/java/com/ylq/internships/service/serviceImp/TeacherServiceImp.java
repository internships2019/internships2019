package com.ylq.internships.service.serviceImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Teacher;
import com.ylq.internships.mapper.TeacherMapper;
import com.ylq.internships.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImp  implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;
    Logger logger= LoggerFactory.getLogger(getClass());

    //获取老师列表
    @Override
    public PageInfo<Teacher> findTeacherList(int page, int limit, String unitName, String pStatus) {
        logger.info("TeacherServiceImp的findTeacherList执行了");
        PageHelper.startPage(page,limit);
        List<Teacher> list = teacherMapper.getTeacherList(unitName, pStatus);
        PageInfo<Teacher> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
