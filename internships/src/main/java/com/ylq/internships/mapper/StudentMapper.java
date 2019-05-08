package com.ylq.internships.mapper;

import com.ylq.internships.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生持久化接口
 */
@Mapper
public interface StudentMapper {

    public void insertStu(Student student);
//    public Student selectStu(String sc_name,String sno,String p_id);
}
