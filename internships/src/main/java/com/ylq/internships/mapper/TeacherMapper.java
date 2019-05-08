package com.ylq.internships.mapper;

import com.ylq.internships.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

/**
 * 老师持久化接口
 */
@Mapper
public interface TeacherMapper {
    public void insertTea(Teacher teacher);
}
