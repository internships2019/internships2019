package com.ylq.internships.entity;

import static com.ylq.internships.utils.Contant.WAIT_INTENSHIP;

/**
 * 绑定微信号后的学生实体
 */
public class Student {
    //学生微信号
    private String wxNo;
    //学生学号
    private String sNo;
    //学生姓名
    private String sName;
    //学生性别
    private String sSex;
    //学生照片
    private String sImg;
    //学生学校名称
    private String sScName;
    //学生分配状态
    private String sState;
    //学生联系号码
    private String stuTel;
    //学生班级名称
    private String className;
    //学生动态项目实体
    private StuAllot stuAllot;
    //班级实体
    private Class aClass;

    public Student() {
    }

    public Student(String wxNo, String sNo, String sName, String sSex, String sImg, String sScName, String sState, String stuTel, String className) {
        this.wxNo = wxNo;
        this.sNo = sNo;
        this.sName = sName;
        this.sSex = sSex;
        this.sImg = sImg;
        this.sScName = sScName;
        this.sState = sState;
        this.stuTel = stuTel;
        this.className = className;
    }

    public Student initStu(String opid, WaitInsertInfo w) {
        Student student = new Student(opid, w.getpNo(), w.getpName(), w.getpSex(), w.getpImg(), w.getUnitName(), WAIT_INTENSHIP, w.getpTel(), w.getClassName());
        return student;
    }

    public String getWxNo() {
        return wxNo;
    }

    public void setWxNo(String wxNo) {
        this.wxNo = wxNo;
    }

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public String getsImg() {
        return sImg;
    }

    public void setsImg(String sImg) {
        this.sImg = sImg;
    }

    public String getsScName() {
        return sScName;
    }

    public void setsScName(String sScName) {
        this.sScName = sScName;
    }

    public String getsState() {
        return sState;
    }

    public void setsState(String sState) {
        this.sState = sState;
    }

    public String getStuTel() {
        return stuTel;
    }

    public void setStuTel(String stuTel) {
        this.stuTel = stuTel;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public StuAllot getStuAllot() {
        return stuAllot;
    }

    public void setStuAllot(StuAllot stuAllot) {
        this.stuAllot = stuAllot;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }
}
