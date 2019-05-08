package com.ylq.internships.mapper;

import com.ylq.internships.entity.WaitInsertInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 待录人员信息持久化接口
 */
@Mapper
public interface WaitInsertInfoMapper {
    public WaitInsertInfo selectPerson(WaitInsertInfo waitInsertInfo);

    }
