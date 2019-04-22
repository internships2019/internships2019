package com.ylq.internships.entity;

import java.util.Date;

/**
 * 学校通知实体
 */
public class Information {
    //通知编号
    private Integer infoId;
    //通知所属学校名称
    private String sScName;
    //通知标题
    private String infoTitle;
    //通知详细内容
    private String infoContent;
    //通知发布日期
    private Date infoTime;

    public Information() {
    }

    public Information(Integer infoId, String sScName, String infoTitle, String infoContent, Date infoTime) {
        this.infoId = infoId;
        this.sScName = sScName;
        this.infoTitle = infoTitle;
        this.infoContent = infoContent;
        this.infoTime = infoTime;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public String getsScName() {
        return sScName;
    }

    public void setsScName(String sScName) {
        this.sScName = sScName;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    public Date getInfoTime() {
        return infoTime;
    }

    public void setInfoTime(Date infoTime) {
        this.infoTime = infoTime;
    }
}
