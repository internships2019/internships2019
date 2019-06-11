package com.ylq.internships;

import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.*;
import com.ylq.internships.mapper.ClockRecordMapper;
import com.ylq.internships.mapper.ClockTimeMapper;
import com.ylq.internships.mapper.ScoreMapper;
import com.ylq.internships.mapper.ScoreStandardMapper;
import com.ylq.internships.service.ClockTimeService;
import com.ylq.internships.service.StuAllotService;
import com.ylq.internships.utils.Contant;
import com.ylq.internships.utils.MathUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InternshipsApplicationTests {

    @Autowired
    private StuAllotService stuAllotService;
    @Autowired
    private ClockTimeService clockTimeService;
    @Autowired
    private ClockTimeMapper clockTimeMapper;
    @Autowired
    private ClockRecordMapper clockRecordMapper;

    @Test
    public void contextLoads() {
        List<ClockRecord> list = clockRecordMapper.getClockRecordByScTeaWx("13665");
        for (ClockRecord c:list){
            System.out.println(c.toString());
        }
    }

    private void testAddClockTime() {//测试添加时间段
        Time startTime=new Time(10,0,0);
        Time entTime=new Time(11,0,0);
        ClockTime clockTime=new ClockTime();
        clockTime.setWxNo("436589235");
        clockTime.setStartTime(startTime);
        clockTime.setEndTime(entTime);
        clockTime.setClockType("上班打卡");
        clockTime.setScTeaWx("13665");
        clockTime.setDeductScore(1.0);
        System.out.println(clockTime.toString());
        List<ClockTime> list = clockTimeMapper.getClockTimeList("436589235");
        String s = clockTimeService.addClockTime(clockTime);
        System.out.println(s);
    }

}
