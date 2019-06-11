package com.ylq.internships.mapper;

import com.ylq.internships.entity.Information;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 通知持久化接口
 */
@Mapper
public interface InformationMapper {
    List<Information> getAllInfo(String school_name);
    Information getLatest();
    Information getById(String id);
}
