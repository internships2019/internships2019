package com.ylq.internships.mapper;

import com.ylq.internships.entity.WaitInsertInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 待录人员信息持久化接口
 */
@Mapper
public interface WaitInsertInfoMapper {
    List<WaitInsertInfo> getStudentAll(@Param("unitName") String unitName,@Param("pStatus") String pStatus);
    List<WaitInsertInfo> getWaitInsertInfoByName(@Param("unitName") String unitName,@Param("pStatus") String pStatus,@Param("pName") String pName);
    WaitInsertInfo getWaitInsertInfoByPNo(@Param("pNo") String pNo,@Param("unitName") String unitName);
    WaitInsertInfo getWaitInsertInfoById(int id);
    WaitInsertInfo getTeacherById(int id);
    void insert(WaitInsertInfo waitInsertInfo);
    void updateImg(@Param("id") String id,@Param("path") String path);
    void updateTeacher(WaitInsertInfo waitInsertInfo);
    void updateStudent(WaitInsertInfo waitInsertInfo);
    void deleteWaitInsertInfo(int id);
    void batchInsert(@Param("list") List<WaitInsertInfo> list);
    void batchInsertTeacher(@Param("list") List<WaitInsertInfo> list);
    void batchDelete(@Param("arr") String[] arr);
}
