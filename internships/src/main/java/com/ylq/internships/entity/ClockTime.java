package com.ylq.internships.entity;

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
    private Date startTime;
    //截止时间
    private Date endTime;
    //打卡类型
    private String clockType;
    //带队老师微信号
    private String scTeaWx;

    public ClockTime() {
    }

    public ClockTime(Integer id, String wxNo, Date startTime, Date endTime, String clockType, String scTeaWx) {
        this.id = id;
        this.wxNo = wxNo;
        this.startTime = startTime;
        this.endTime = endTime;
        this.clockType = clockType;
        this.scTeaWx = scTeaWx;
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

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
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
}
