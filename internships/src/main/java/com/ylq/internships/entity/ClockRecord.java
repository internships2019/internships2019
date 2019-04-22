package com.ylq.internships.entity;

import java.util.Date;

/**
 * 打卡记录实体
 */
public class ClockRecord {
    //打卡记录编号，自增长
    private Integer clockId;
    //学生微信号
    private String wxNo;
    //打卡记录生成时间
    private Date clockTime;
    //打卡详细地址
    private String clockLocation;
    //打卡经度
    private Double clockLongtitude;
    //打卡纬度
    private Double clockLatitude;
    //打卡记录类型
    private String clockType;
    //打卡记录状态(正常，异常)
    private String clockStatus;
    //扣分分值
    private Double deductScore;
    //带队老师微信号
    private String scTeaWx;
    //扣分项实体
    private DeductStandard deductStandard;

    public ClockRecord() {
    }

    public ClockRecord(Integer clockId,String wxNo, Date clockTime, String clockLocation, Double clockLongtitude, Double clockLatitude, String clockType, String clockStatus, Double deductScore,String scTeaWx) {
        this.clockId = clockId;
        this.wxNo = wxNo;
        this.clockTime = clockTime;
        this.clockLocation = clockLocation;
        this.clockLongtitude = clockLongtitude;
        this.clockLatitude = clockLatitude;
        this.clockType = clockType;
        this.clockStatus = clockStatus;
        this.deductScore = deductScore;
        this.scTeaWx=scTeaWx;
    }

    public Integer getClockId() {
        return clockId;
    }

    public void setClockId(Integer clockId) {
        this.clockId = clockId;
    }

    public String getWxNo() {
        return wxNo;
    }

    public void setWxNo(String wxNo) {
        this.wxNo = wxNo;
    }

    public Date getClockTime() {
        return clockTime;
    }

    public void setClockTime(Date clockTime) {
        this.clockTime = clockTime;
    }

    public String getClockLocation() {
        return clockLocation;
    }

    public void setClockLocation(String clockLocation) {
        this.clockLocation = clockLocation;
    }

    public Double getClockLongtitude() {
        return clockLongtitude;
    }

    public void setClockLongtitude(Double clockLongtitude) {
        this.clockLongtitude = clockLongtitude;
    }

    public Double getClockLatitude() {
        return clockLatitude;
    }

    public void setClockLatitude(Double clockLatitude) {
        this.clockLatitude = clockLatitude;
    }

    public String getClockType() {
        return clockType;
    }

    public void setClockType(String clockType) {
        this.clockType = clockType;
    }

    public String getClockStatus() {
        return clockStatus;
    }

    public void setClockStatus(String clockStatus) {
        this.clockStatus = clockStatus;
    }

    public Double getDeductScore() {
        return deductScore;
    }

    public void setDeductScore(Double deductScore) {
        this.deductScore = deductScore;
    }

    public String getScTeaWx() {
        return scTeaWx;
    }

    public void setScTeaWx(String scTeaWx) {
        this.scTeaWx = scTeaWx;
    }

    public DeductStandard getDeductStandard() {
        return deductStandard;
    }

    public void setDeductStandard(DeductStandard deductStandard) {
        this.deductStandard = deductStandard;
    }
}
