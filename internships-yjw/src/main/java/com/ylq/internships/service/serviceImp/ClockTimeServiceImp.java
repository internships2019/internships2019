package com.ylq.internships.service.serviceImp;

import com.ylq.internships.entity.ClockTime;
import com.ylq.internships.mapper.ClockTimeMapper;
import com.ylq.internships.service.ClockTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ClockTimeServiceImp implements ClockTimeService {
    @Autowired
    private ClockTimeMapper clockTimeMapper;

    //带队老师查看某个学生打卡时间段信息
    @Override
    public List<ClockTime> findClockTimeByWxNo(String wxNo) {
        return clockTimeMapper.getClockTimeList(wxNo);
    }

    //带队老师添加学生打卡时间段
    @Transactional
    @Override
    public String addClockTime(ClockTime clockTime) {
        List<ClockTime> list = clockTimeMapper.getClockTimeList(clockTime.getWxNo());
        boolean flag=judge(clockTime.getStartTime(),clockTime.getEndTime(),list);
        if (flag){
            clockTimeMapper.insertClcokTime(clockTime);
            return "1";
        }
        return "2";
    }

    //带队老师修改学生打卡时间段
    @Transactional
    @Override
    public String editClockTime(ClockTime clockTime) {
        List<ClockTime> list = clockTimeMapper.getClockTimeList(clockTime.getWxNo());
        boolean flag=judge(clockTime.getStartTime(),clockTime.getEndTime(),list);
        if (flag){
            clockTimeMapper.updateClcokTime(clockTime);
            return "1";
        }
        return "2";
    }

    //带队老师删除学生打卡时间段
    @Transactional
    @Override
    public void removeClockTime(Integer id) {
        clockTimeMapper.deleteClockTimeById(id);
    }

    boolean judge(Date startTime, Date endTime, List<ClockTime> list){//新的打卡时间段在以往打卡时间段范围内返回false，反之返回true
        boolean flag=true;
        for(ClockTime c: list ){
            if (startTime.compareTo(c.getStartTime())<0&&endTime.compareTo(c.getEndTime())>0){//开始时间小于时间段开始时间,结束时间大于时间段结束时间
                flag=false;
                break;
            }else if (startTime.compareTo(c.getStartTime())<0&&endTime.compareTo(c.getStartTime())>0&&endTime.compareTo(c.getEndTime())<0){//开始时间小于时间段开始时间,结束时间大于时间段开始时间,结束时间小于时间段结束时间
                flag=false;
                break;
            }else if (startTime.compareTo(c.getStartTime())>0&&endTime.compareTo(c.getEndTime())<0){//开始时间大于时间段开始时间,结束时间小于时间段结束时间
                flag=false;
                break;
            }else if (startTime.compareTo(c.getStartTime())>0&&startTime.compareTo(c.getEndTime())<0&&endTime.compareTo(c.getEndTime())>0){//开始时间大于时间段开始时间，开始时间小于时间段结束时间，结束时间大于时间段结束时间
                flag=false;
                break;
            }
        }
        return flag;
    }
}
