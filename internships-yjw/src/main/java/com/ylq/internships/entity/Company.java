package com.ylq.internships.entity;

/**
 * 企业实体
 */
public class Company {
    //企业名称
    private String comName;
    //企业详细地址
    private String comLocation;
    //企业联系电话
    private String comTel;
    //企业邮箱
    private String comEmail;
    //企业简介
    private String comInfo;
    //企业经度
    private Double comLongtitude;
    //企业纬度
    private Double comLatitude;
    //学校名字
    private String scName;
    //已招人数
    private int nowNum;

    public Company() {
    }

    public Company(String comName, String comLocation, String comTel, String comEmail, String comInfo, Double comLongtitude, Double comLatitude) {
        this.comName = comName;
        this.comLocation = comLocation;
        this.comTel = comTel;
        this.comEmail = comEmail;
        this.comInfo = comInfo;
        this.comLongtitude = comLongtitude;
        this.comLatitude = comLatitude;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComLocation() {
        return comLocation;
    }

    public void setComLocation(String comLocation) {
        this.comLocation = comLocation;
    }

    public String getComTel() {
        return comTel;
    }

    public void setComTel(String comTel) {
        this.comTel = comTel;
    }

    public String getComEmail() {
        return comEmail;
    }

    public void setComEmail(String comEmail) {
        this.comEmail = comEmail;
    }

    public String getComInfo() {
        return comInfo;
    }

    public void setComInfo(String comInfo) {
        this.comInfo = comInfo;
    }

    public Double getComLongtitude() {
        return comLongtitude;
    }

    public void setComLongtitude(Double comLongtitude) {
        this.comLongtitude = comLongtitude;
    }

    public Double getComLatitude() {
        return comLatitude;
    }

    public void setComLatitude(Double comLatitude) {
        this.comLatitude = comLatitude;
    }

    @Override
    public String toString() {
        return "Company{" +
                "comName='" + comName + '\'' +
                ", comLocation='" + comLocation + '\'' +
                ", comTel='" + comTel + '\'' +
                ", comEmail='" + comEmail + '\'' +
                ", comInfo='" + comInfo + '\'' +
                ", comLongtitude=" + comLongtitude +
                ", comLatitude=" + comLatitude +
                '}';
    }
}
