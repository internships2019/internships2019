package com.ylq.internships.mapper;

import com.ylq.internships.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 老师持久化接口
 */
@Mapper
public interface TeacherMapper {
    Teacher getTeacherByNo(@Param("unitNo") String unitNo,@Param("unitName") String unitName);
    String getTeacherTel(String wxNo);
    List<Teacher> getTeacherList(@Param("unitName") String unitName,@Param("pStatus") String pStatus);
}
