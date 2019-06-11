package com.ylq.internships.mapper;

import com.ylq.internships.entity.StuAllot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 动态项目持久化接口
 */
@Mapper
public interface StuAllotMapper {
    List<StuAllot> getStuAllotList(@Param("sScName") String sScName,@Param("state") String state);
    List<StuAllot> getCompanyStuAllotList(@Param("sScName") String sScName,@Param("state") String state);
    List<StuAllot> getByStuName(@Param("sScName") String sScName,@Param("state") String state,@Param("stuName") String stuName);
    List<StuAllot> getSchoolStudnetByStuName(@Param("sScName") String sScName,@Param("state") String state,@Param("stuName") String stuName);
    //带队老师获取所带学生信息(带队老师端)
    List<StuAllot> getStudentToSchoolTeacher(String scTeaWx);

    StuAllot getById(Integer id);
    StuAllot getStudAllotById(String id);
    void updateLeadTeacher(@Param("scTeaWx") String scTeaWx,@Param("scTeaName") String scTeaName,@Param("id") String id);
    void updateCompanyTeacher(@Param("comTeaWx") String comTeaWx,@Param("comTeaName") String comTeaName,@Param("id") String id);
    void updateState(@Param("wxNo") String wxNo);
    void deleteStuAllot(String id);
    void batachAddLeadTeacher(@Param("ids")String[] ids,@Param("scTeaWx") String scTeaWx,@Param("scTeaName") String scTeaName);
    void batachAddCompanyTeacher(@Param("ids")String[] ids,@Param("comTeaWx") String scTeaWx,@Param("comTeaName") String scTeaName);
    void batachDeleteStuAllot(@Param("ids")String[] ids);
}
