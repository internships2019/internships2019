package com.ylq.internships.mapper;

import com.ylq.internships.entity.School;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 学校持久化接口
 */
@Mapper
public interface SchoolMapper {
    List<School> getAll();
    List<String> getAllName();
    School getSchoolByName(String schoolName);
    void insertSchool(School school);
    void updateSchool(School school);
    void deleteSchool(String scName);
}
