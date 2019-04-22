package com.ylq.internships.entity;

/**
 * 学校实体
 */
public class School {
    //学校名称
    private String scName;
    //学校地址
    private String scLocation;
    //学院联系电话
    private String scTel;
    //学校邮箱
    private String scEmail;
    //学校简介
    private String scInfo;

    public School() {
    }

    public School(String scName, String scLocation, String scTel, String scEmail, String scInfo) {
        this.scName = scName;
        this.scLocation = scLocation;
        this.scTel = scTel;
        this.scEmail = scEmail;
        this.scInfo = scInfo;
    }

    public String getScName() {
        return scName;
    }

    public void setScName(String scName) {
        this.scName = scName;
    }

    public String getScLocation() {
        return scLocation;
    }

    public void setScLocation(String scLocation) {
        this.scLocation = scLocation;
    }

    public String getScTel() {
        return scTel;
    }

    public void setScTel(String scTel) {
        this.scTel = scTel;
    }

    public String getScEmail() {
        return scEmail;
    }

    public void setScEmail(String scEmail) {
        this.scEmail = scEmail;
    }

    public String getScInfo() {
        return scInfo;
    }

    public void setScInfo(String scInfo) {
        this.scInfo = scInfo;
    }
}
