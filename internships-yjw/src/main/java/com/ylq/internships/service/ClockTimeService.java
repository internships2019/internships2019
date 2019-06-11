package com.ylq.internships.service;


import com.ylq.internships.entity.ClockTime;

import java.util.List;

public interface ClockTimeService {
    List<ClockTime> findClockTimeByWxNo(String wxNo);
    String addClockTime(ClockTime clockTime);
    String editClockTime(ClockTime clockTime);
    void removeClockTime(Integer id);
}
