package com.ylq.internships.mapper;

import com.ylq.internships.entity.Class;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 班级持久层接口
 */
@Mapper
public interface ClassMapper {
    List<Class> getAll(String sScName);
    List<Class> getByClassName(@Param("sScName") String sScName,@Param("className") String className);
    Class getByNames(@Param("sScName") String sScName,@Param("className")  String className);
    void insertClass(Class aclass);
    void insertBatchClass(@Param("list") List<Class> list);
}
