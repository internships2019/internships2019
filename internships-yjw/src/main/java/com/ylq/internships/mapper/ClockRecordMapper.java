package com.ylq.internships.mapper;

import com.ylq.internships.entity.ClockRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 打卡记录持久层接口
 */
@Mapper
public interface ClockRecordMapper {
    List<ClockRecord> getStudnetClockRecord(String wxNo);
    //带队老师获取打卡记录
    List<ClockRecord> getClockRecordByScTeaWx(String scTeaWx);
    ClockRecord getClockRecord(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("wxNo") String wxNo);
    void batchInsertClockRecord(@Param("clockRecords") List<ClockRecord> clockRecords);
}
