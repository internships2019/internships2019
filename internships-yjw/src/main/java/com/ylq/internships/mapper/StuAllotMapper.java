package com.ylq.internships.mapper;

import com.ylq.internships.entity.StuAllot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 动态项目持久化接口
 */
@Mapper
public interface StuAllotMapper {
    /**
     * lwq
     * @param stuAllot
     */
    void insertStu(StuAllot stuAllot);
    StuAllot selectByStuId(String openid);
    List<StuAllot> getApplications(String openid);
}
