package com.ylq.internships.mapper;

import com.ylq.internships.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学生持久化接口
 */
@Mapper
public interface StudentMapper {
    List<Student> getStudentList(@Param("sScName") String sScName,@Param("sState") String sState);
    List<Student> getStudentByName(@Param("sScName") String sScName,@Param("sState") String sState,@Param("sName") String sName);
    Student getStudnetInformation(String wxNo);
    void deleteStudent1(@Param("wxNo") String wxNo);
}
