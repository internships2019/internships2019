package com.ylq.internships.entity;

/**
 * 待录人员信息实体
 */
public class WaitInsertInfo {
    //待录人员信息编号
    private Integer id;
    //单位名称
    private String unitName;
    //人员编号
    private String pNo;
    //姓名
    private String pName;
    //身份证号
    private String pId;
    //身份(学生，带队老师，指导老师)
    private String pStatus;
    //性别
    private String pSex;
    //联系方式
    private String pTel;
    //照片
    private String pImg;
    //学生班级名称
    private String className;

    public WaitInsertInfo() {
    }

    public WaitInsertInfo(Integer id, String unitName, String pNo, String pName, String pId, String pStatus, String pSex, String pTel, String pImg, String className) {
        this.id = id;
        this.unitName = unitName;
        this.pNo = pNo;
        this.pName = pName;
        this.pId = pId;
        this.pStatus = pStatus;
        this.pSex = pSex;
        this.pTel = pTel;
        this.pImg = pImg;
        this.className = className;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getpNo() {
        return pNo;
    }

    public void setpNo(String pNo) {
        this.pNo = pNo;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
