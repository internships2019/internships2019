package com.ylq.internships.entity;

/**
 * 老师实体
 */
public class Teacher {
    //老师微信号
    private String wxNo;
    //老师所属单位名称
    private String unitName;
    //老师在单位中的编号
    private String unitNo;
    //老师姓名
    private String pName;
    //老师身份证号
    private String pId;
    //老师身份(带队老师，指导老师)
    private String pStatus;
    //老师性别
    private String pSex;
    //老师联系电话
    private String pTel;
    //老师照片
    private String pImg;

    public Teacher() {
    }

    public Teacher(String wxNo, String unitName, String unitNo, String pName, String pId, String pStatus, String pSex, String pTel, String pImg) {
        this.wxNo = wxNo;
        this.unitName = unitName;
        this.unitNo = unitNo;
        this.pName = pName;
        this.pId = pId;
        this.pStatus = pStatus;
        this.pSex = pSex;
        this.pTel = pTel;
        this.pImg = pImg;
    }

    public String getWxNo() {
        return wxNo;
    }

    public void setWxNo(String wxNo) {
        this.wxNo = wxNo;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpStatus() {
        return pStatus;
    }

    public void setpStatus(String pStatus) {
        this.pStatus = pStatus;
    }

    public String getpSex() {
        return pSex;
    }

    public void setpSex(String pSex) {
        this.pSex = pSex;
    }

    public String getpTel() {
        return pTel;
    }

    public void setpTel(String pTel) {
        this.pTel = pTel;
    }

    public String getpImg() {
        return pImg;
    }

    public void setpImg(String pImg) {
        this.pImg = pImg;
    }
}
