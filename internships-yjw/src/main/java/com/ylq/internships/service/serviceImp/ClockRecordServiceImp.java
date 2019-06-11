package com.ylq.internships.service.serviceImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.ClockRecord;
import com.ylq.internships.entity.ClockTime;
import com.ylq.internships.entity.Score;
import com.ylq.internships.entity.ScoreStandard;
import com.ylq.internships.mapper.ClockRecordMapper;
import com.ylq.internships.mapper.ClockTimeMapper;
import com.ylq.internships.mapper.ScoreMapper;
import com.ylq.internships.mapper.ScoreStandardMapper;
import com.ylq.internships.service.ClockRecordService;
import com.ylq.internships.utils.Contant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ClockRecordServiceImp implements ClockRecordService {

    @Autowired
    private ClockRecordMapper clockRecordMapper;
    @Autowired
    private ClockTimeMapper clockTimeMapper;
    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private ScoreStandardMapper scoreStandardMapper;
    private Logger logger= LoggerFactory.getLogger(getClass());

    @Override
    public PageInfo<ClockRecord> findStudentClockRecord(int page,int limit,String wxNo) {
        logger.info("ClockRecordServiceImp的findStudentClockRecord方法执行了");
        PageHelper.startPage(page,limit);
        List<ClockRecord> studnetClockRecord =clockRecordMapper.getStudnetClockRecord(wxNo);
        PageInfo<ClockRecord> pageInfo = new PageInfo<>(studnetClockRecord);
        return pageInfo;
    }

    @Override
    @Transactional
    @Scheduled(cron = "0 0 * * * MON-SAT")
    public void timingClockRecord() {
        logger.info("定时任务执行!");
        Calendar calendar=new GregorianCalendar();
        SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar.set(Calendar.MINUTE,0);//设置分为0
        calendar.set(Calendar.SECOND,0);//设置秒为0
        Date nowTime = calendar.getTime();
        calendar.add(Calendar.HOUR,-1);//时间减一小时
        Date oldTime=calendar.getTime();
        System.out.println(sf.format(nowTime));
        System.out.println(sf.format(oldTime));
        List<ClockTime> clokTimes = clockTimeMapper.getClokTimeTiming(sf.format(oldTime), sf.format(nowTime));
        if (clokTimes.size()!=0){
            List<ClockRecord> list=new ArrayList<>();
            for (ClockTime c:clokTimes){
                Calendar cg=new GregorianCalendar();
                cg.setTime(c.getStartTime());
                cg.set(Calendar.YEAR,calendar.get(Calendar.YEAR));
                cg.set(Calendar.MONTH,calendar.get(Calendar.MONTH));
                cg.set(Calendar.DATE,calendar.get(Calendar.DATE));
                Date startTime = cg.getTime();//打卡记录开始时间
                System.out.println(cg.getTime());
                cg.setTime(c.getEndTime());
                cg.set(Calendar.YEAR,calendar.get(Calendar.YEAR));
                cg.set(Calendar.MONTH,calendar.get(Calendar.MONTH));
                cg.set(Calendar.DATE,calendar.get(Calendar.DATE));
                System.out.println(cg.getTime());
                Date endTime = cg.getTime();//打卡记录结束时间
                ClockRecord clockRecord1 = clockRecordMapper.getClockRecord(sf2.format(startTime), sf2.format(endTime), c.getWxNo());
                if (clockRecord1==null){//在规定时间段内打卡记录不存在则生成超时打卡记录
                    Calendar gregorianCalendar = new GregorianCalendar();//获取打卡结束时间并设置结束时间前1分钟为异常时间打卡记录的时间
                    gregorianCalendar.setTime(endTime);
                    gregorianCalendar.add(Calendar.MINUTE,-1);
                    ClockRecord clockRecord = new ClockRecord();//生成打卡记录对象，并提添加到集合中
                    clockRecord.setClockLocation("无");
                    clockRecord.setClockLongtitude(-1.0);
                    clockRecord.setClockLatitude(-1.0);
                    clockRecord.setClockTime(gregorianCalendar.getTime());
                    clockRecord.setClockStatus(Contant.TIME_UNUSUAL);
                    clockRecord.setWxNo(c.getWxNo());
                    clockRecord.setClockType(c.getClockType());
                    clockRecord.setDeductScore(c.getDeductScore());
                    clockRecord.setScTeaWx(c.getScTeaWx());
                    System.out.println(clockRecord.toString());
                    list.add(clockRecord);
                    Score score = scoreMapper.getScoreByWxNo(c.getWxNo());
                    if (score.getAttanScore()-c.getDeductScore()>0){//考勤成绩扣除这次扣分项后大于0
                        score.setAttanScore(score.getAttanScore()-c.getDeductScore());
                    }else {//考勤成绩扣除这次扣分项后小于0，设置考勤成绩为0
                        score.setAttanScore(0.0);
                    }
                    if (score.getIntagrateScore()!=null){//综合成绩存在，综合成绩进行修改
                        ScoreStandard scoreStadard = scoreStandardMapper.getScoreStadard(score.getScName());
                        score.setIntagrateScore(score.getAttanScore()*scoreStadard.getAttanPecent()+score.getApprScore()*scoreStadard.getApprPecent());
                    }
                    scoreMapper.updateAttanScore(score);
                }
            }
            if(list.size()!=0){
                clockRecordMapper.batchInsertClockRecord(list);
            }
        }
    }
}
