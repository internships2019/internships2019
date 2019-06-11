package com.ylq.internships.mapper;


import com.ylq.internships.entity.ClockTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 打卡时间持久层接口
 */
@Mapper
public interface ClockTimeMapper {
    List<ClockTime> getClokTimeTiming(@Param("oldTime") String oldTime,@Param("nowTime") String nowTime);
    List<ClockTime> getClockTimeList(String wxNo);
    void deleteClockTime(String wxNo);
    void deleteClockTimeById(Integer id);
    void insertClcokTime(ClockTime clockTime);
    void updateClcokTime(ClockTime clockTime);
}
