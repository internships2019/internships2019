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
}
