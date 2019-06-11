package com.ylq.internships;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.ylq.internships.entity.ClockRecord;
import com.ylq.internships.entity.ClockTime;
import com.ylq.internships.mapper.ClockRecordMapper;
import com.ylq.internships.mapper.ClockTimeMapper;
import com.ylq.internships.utils.ClockUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.geom.Point2D;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.ylq.internships.utils.Contant.APARTMENT;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InternshipsApplicationTests {

    @Autowired
    ClockTimeMapper clockTimeMapper;
    @Autowired
    ClockRecordMapper clockRecordMapper;
    private static final double EARTH_RADIUS = 6371393;

    @Test
    public void contextLoads() {
//        SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");
//
//        //现在的时间
//        Date currentTime = null;
//        try {
//            currentTime = sf.parse(sf.format(new Date()));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        List<ClockTime> clockTimeList = clockTimeMapper.getClockTime("oIdLM4jC-Sqs9RrtzpxSBEEELPP0");   //获取该学生打卡时间段列表
//        ClockTime clockTime = null;
//        clockTime = validClockTime(clockTimeList, currentTime);    //获取打卡类型
//        System.out.println(isClocked(clockTime, "住宿", "oIdLM4jC-Sqs9RrtzpxSBEEELPP0"));
//        Date latest = new Date(2019, 6, 5);
//        Date now;
//        Calendar c = Calendar.getInstance();
//        now = new Date(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DAY_OF_MONTH));
//        System.out.println("latest>>>>>>>>>" + latest.toString());
//        System.out.println("now>>>>>>>>>>>>" + now.toString());
//        System.out.println(">>>>>>>>>>>>>" + now.after(latest));
    }

    public Boolean isClocked(ClockTime clockTime, String type, String openid) {
        ClockRecord latest = clockRecordMapper.latestRecord(type, openid);
        Date latest_time = latest.getClockTime();
        Calendar c = Calendar.getInstance();

        System.out.println("clocktime>>>>>>>"+clockTime.getStartTime().toString());
        System.out.println("latest_time>>>>>>>>"+c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH) + 1)+"-"+c.get(Calendar.DAY_OF_MONTH));
        Calendar c1 = Calendar.getInstance();
        System.out.println("c1>>>>>>>>>>>>>>>"+c1.get(Calendar.YEAR)+"-"+(c1.get(Calendar.MONTH)+1)+"-"+c1.get(Calendar.DAY_OF_MONTH));
        if (c.get(Calendar.YEAR) == c1.get(Calendar.YEAR) && (c.get(Calendar.MONTH) + 1) == (c1.get(Calendar.MONTH) + 1) && c.get(Calendar.DAY_OF_MONTH) == c1.get(Calendar.DAY_OF_MONTH)) {
            System.out.println("11111111");
            return isInDate(c.getTimeInMillis(),clockTime.getStartTime().toString(),clockTime.getEndTime().toString());
        }
        System.out.println("22222222");
        return false;
    }
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        System.out.println("date>>>>>>>>>>"+date);
        System.out.println("begin>>>>>>>>>>"+begin.toString());
        System.out.println("end>>>>>>>>>>"+end.toString());
        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isInDate(long time, String strDateBegin, String strDateEnd) {
        Calendar calendar = Calendar.getInstance();
        // 处理开始时间
        String[] startTime = strDateBegin.split(":");
        calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(startTime[0]));
        calendar.set(Calendar.MINUTE, Integer.valueOf(startTime[1]));
        calendar.set(Calendar.SECOND, Integer.valueOf(startTime[2]));
        calendar.set(Calendar.MILLISECOND, 0);
        long startTimeL = calendar.getTimeInMillis();
        // 处理结束时间
        String[] endTime = strDateEnd.split(":");
        calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(endTime[0]));
        calendar.set(Calendar.MINUTE, Integer.valueOf(endTime[1]));
        calendar.set(Calendar.SECOND, Integer.valueOf(endTime[2]));
        calendar.set(Calendar.MILLISECOND, 0);
        long endTimeL = calendar.getTimeInMillis();
        return time >= startTimeL && time <= endTimeL;
    }

    /**
     * 判断打卡类型
     *
     * @param clockTimeList
     * @param currentTime
     * @return
     */
    public ClockTime validClockTime(List<ClockTime> clockTimeList, Date currentTime) {

        for (ClockTime clockTime : clockTimeList) {

            if (belongCalendar(currentTime, clockTime.getStartTime(), clockTime.getEndTime())) {
                return clockTime;
            }
        }
        return null;
    }

}
