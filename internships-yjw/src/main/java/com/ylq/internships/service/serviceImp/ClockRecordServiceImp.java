package com.ylq.internships.service.serviceImp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.*;
import com.ylq.internships.mapper.*;
import com.ylq.internships.service.ClockRecordService;
import com.ylq.internships.utils.ClockUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.geom.Point2D;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.ylq.internships.utils.Contant.*;

@Service
public class ClockRecordServiceImp implements ClockRecordService {

    @Autowired
    CompanyMapper companyMapper;
    @Autowired
    StudentApartmentMapper studentApartmentMapper;
    @Autowired
    StuAllotMapper stuAllotMapper;
    @Autowired
    ClockTimeMapper clockTimeMapper;
    @Autowired
    ClockRecordMapper clockRecordMapper;
    @Autowired
    ScoreMapper scoreMapper;
    @Autowired
    ScoreStandardMapper scoreStandardMapper;

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 打卡
     *
     * @param openid
     * @param Longitude
     * @param Latitude
     * @return
     */
    @Override
    public String clock(String openid, String Longitude, String Latitude, String location) {

        logger.info("ClockRecordServiceImp的clock执行>>>>>>>>>");

        String STATE = "state";
        JSON json = new JSONObject();
        Calendar now = Calendar.getInstance();

//        SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");
//        //现在的时间
//        Date currentTime = null;
//        try {
//            currentTime = sf.parse(sf.format(new Date()));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        //获取学生当前的经纬度
        Point2D stuLocation = new Point2D.Double(Double.parseDouble(Longitude), Double.parseDouble(Latitude));

        StuAllot stuAllot = null;
        stuAllot = stuAllotMapper.selectByStuId(openid);   //获取项目表的学生信息，查看是否有该学生信息，在实习状态下才能进行打卡
        logger.info("stuAllot>>>>>>" + stuAllot.toString());

        if (stuAllot == null) { //如果没有岗位实习
            ((JSONObject) json).put(STATE, NOINTERNDHIPS);
        } else {
            String comName = stuAllot.getComName(); //获取学生的实习公司名称
            String state = stuAllot.getState(); //获取学生的状态

            if (state.equals(INTENSHIPING)) {    //如果状态为实习中

                ClockUtil clockUtil = new ClockUtil();

                List<ClockTime> clockTimeList = clockTimeMapper.getClockTime(openid);   //获取该学生打卡时间段列表
                logger.info("clockTimeList>>>>>>>>>" + clockTimeList);

                if (clockTimeList == null) {    //如果没有查询到打卡时间要求
                    ((JSONObject) json).put(STATE, NOCLOCKTIME);
                } else {
                    ClockTime clockTime = null;
                    clockTime = validClockTime(clockTimeList, now.getTimeInMillis());    //获取打卡类型
                    logger.info("clocktype>>>>>>>>>" + clockTime.toString());
                    if (clockTime == null) { //不属于任何类型的打卡，即超时打卡
                        ((JSONObject) json).put(STATE, TIME_UNUSUAL);
                    } else {
                        String type = clockTime.getClockType();
                        ClockRecord past = clockRecordMapper.latestRecord(type, openid);
                        if (isInDate(past.getClockTime().getTime(), clockTime.getStartTime().toString(), clockTime.getEndTime().toString())) {//当天已打过卡(这个方法只是获取了此类型的最新一条数据，不是当天最新数据，需更改)

                            ((JSONObject) json).put(STATE, REPEATED);
                        } else {
                            Point2D clockLocation;
                            if (type.equals(APARTMENT)) {
                                StudentApartment studentApartment = studentApartmentMapper.getLocation(openid); //以学生openid查找该学生住宿位置
                                //获取住宿经纬度
                                clockLocation = new Point2D.Double(studentApartment.getLiveLongtitude(), studentApartment.getLiveLatitude());
                            } else {
                                Company company = companyMapper.getCompanyByConName(comName);   //以学生实习公司名查找该公司信息
                                //获取公司经纬度
                                clockLocation = new Point2D.Double(company.getComLongtitude(), company.getComLatitude());
                            }
                            logger.info("location>>>>>>>>>" + clockLocation.toString());
                            Date current = new Date();  //当前时间
                            if (clockUtil.isValidate(stuLocation, clockLocation, type)) { //如果在合理范围内

                                //插入一条打卡记录
                                ClockRecord clockRecord = new ClockRecord(openid, current, location, ((Point2D.Double) stuLocation).x, ((Point2D.Double) stuLocation).y, type, SUCCEED, 0.0, stuAllot.getScTeaWx());
                                clockRecordMapper.insertRecord(clockRecord);
                                ((JSONObject) json).put(STATE, SUCCEED);
                            } else {

                                //插入一条打卡记录（不在指定地方打卡，需扣分）
                                ClockRecord clockRecord = new ClockRecord(openid, current, location, ((Point2D.Double) stuLocation).x, ((Point2D.Double) stuLocation).y, type, SCOPE_UNUSUAL, clockTime.getDeductScore(), stuAllot.getScTeaWx());
                                clockRecordMapper.insertRecord(clockRecord);
                                deductScore(openid, clockTime.getDeductScore(), stuAllot.getsScName());
                                ((JSONObject) json).put(STATE, SCOPE_UNUSUAL);
                            }
                        }

                    }

                }
            } else if (state.equals(WAIT_INTENSHIP)) {
                ((JSONObject) json).put(STATE, WAIT_INTENSHIP);
            } else {
                ((JSONObject) json).put(STATE, WAITCOMFIRM);
            }
        }
        return json.toJSONString();
    }

    /**
     * 获取打卡记录
     *
     * @param openid
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageInfo<ClockRecord> getRecords(String openid, int page, int limit) {
        logger.info("ClockRecordServiceImp的getRecords执行===" + page + "===");
        PageHelper.startPage(page, limit);
        List<ClockRecord> list = clockRecordMapper.getRecords(openid);
        PageInfo<ClockRecord> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    void deductScore(String openid, Double deduct_score, String sc_name) {
        Score score = scoreMapper.getScore(openid);
        Double attan_score = score.getAttanScore() - deduct_score;
        if (score.getIntagrateScore() != null) {
            ScoreStandard standard = scoreStandardMapper.getStandard(sc_name);
            Double appr_score = score.getApprScore();
            Double inta_score = attan_score * standard.getAttanPecent() + appr_score * standard.getApprPecent();
            scoreMapper.updateScore(openid, attan_score, inta_score);
        } else {
            scoreMapper.updateAttanScore(openid, attan_score);
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
    public ClockTime validClockTime(List<ClockTime> clockTimeList, long currentTime) {

        for (ClockTime clockTime : clockTimeList) {

            if (isInDate(currentTime, clockTime.getStartTime().toString(), clockTime.getEndTime().toString())) {
                return clockTime;
            }
        }
        return null;
    }

    /**
     * 判断时间是否在时间段内
     *
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
}
