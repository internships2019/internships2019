package com.ylq.internships.mapper;

import com.ylq.internships.entity.ClockRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 打卡记录持久层接口
 */
@Mapper
public interface ClockRecordMapper {

    ClockRecord latestRecord(String type,String openid);
    void insertRecord(ClockRecord clockRecord);
    List<ClockRecord> getRecords(String openid);
}
