package com.ylq.internships.mapper;

import com.ylq.internships.entity.Information;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 通知持久化接口
 */
@Mapper
public interface InformationMapper {
    List<Information> getInformationList(String sScName);
    void insertInformation(Information information);
    void updateInformation(Information information);
    void deleteInformation(Integer infoId);
    void batchDeleteInformation(@Param("infoIds") Integer[] infoIds);
}
