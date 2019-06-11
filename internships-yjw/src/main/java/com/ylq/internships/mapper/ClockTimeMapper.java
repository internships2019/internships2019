package com.ylq.internships.mapper;


import com.ylq.internships.entity.ClockTime;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Time;
import java.util.List;

/**
 * 打卡时间持久层接口
 */
@Mapper
public interface ClockTimeMapper {

    /**
     * 获取打卡时间段
     * @param openid
     * @return
     */
    List<ClockTime> getClockTime(String openid);

}
