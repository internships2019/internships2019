package com.ylq.internships.entity;

import java.sql.Time;
import java.util.Date;

/**
 * 打卡时间段实体
 */
public class ClockTime {
    //打卡时间段编号
    private Integer id;
    //学生微信号
    private String wxNo;
    //开始时间
    private Time startTime;
    //截止时间
    private Time endTime;
    //打卡类型
    private String clockType;
    //带队老师微信号
    private String scTeaWx;
    //此时间段内异常打卡扣分值
    private Double deductScore;

    public ClockTime() {
    }

    public ClockTime(Integer id, String wxNo, Time startTime, Time endTime, String clockType, String scTeaWx,Double deductScore) {
        this.id = id;
        this.wxNo = wxNo;
        this.startTime = startTime;
        this.endTime = endTime;
        this.clockType = clockType;
        this.scTeaWx = scTeaWx;
        this.deductScore=deductScore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWxNo() {
        return wxNo;
    }

    public void setWxNo(String wxNo) {
        this.wxNo = wxNo;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getClockType() {
        return clockType;
    }

    public void setClockType(String clockType) {
        this.clockType = clockType;
    }

    public String getScTeaWx() {
        return scTeaWx;
    }

    public void setScTeaWx(String scTeaWx) {
        this.scTeaWx = scTeaWx;
    }

    public Double getDeductScore() {
        return deductScore;
    }

    public void setDeductScore(Double deductScore) {
        this.deductScore = deductScore;
    }

    @Override
    public String toString() {
        return "ClockTime{" +
                "id=" + id +
                ", wxNo='" + wxNo + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", clockType='" + clockType + '\'' +
                ", scTeaWx='" + scTeaWx + '\'' +
                ", deductScore=" + deductScore +
                '}';
    }
}
