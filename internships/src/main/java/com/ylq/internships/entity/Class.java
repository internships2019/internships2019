package com.ylq.internships.entity;

/**
 * 班级实体
 */
public class Class {
    //学校名称
    private String sScName;
    //班级名称
    private String className;
    //学院名称
    private String collegeName;
    //专业名称
    private String displineName;
    //班级人数
    private String classStuNum;
    //辅导员姓名
    private String instructorName;
    //辅导员联系电话
    private String instructorTel;

    public Class() {
    }

    public Class(String sScName, String className, String collegeName, String displineName, String classStuNum, String instructorName, String instructorTel) {
        this.sScName = sScName;
        this.className = className;
        this.collegeName = collegeName;
        this.displineName = displineName;
        this.classStuNum = classStuNum;
        this.instructorName = instructorName;
        this.instructorTel = instructorTel;
    }

    public String getsScName() {
        return sScName;
    }

    public void setsScName(String sScName) {
        this.sScName = sScName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getDisplineName() {
        return displineName;
    }

    public void setDisplineName(String displineName) {
        this.displineName = displineName;
    }

    public String getClassStuNum() {
        return classStuNum;
    }

    public void setClassStuNum(String classStuNum) {
        this.classStuNum = classStuNum;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorTel() {
        return instructorTel;
    }

    public void setInstructorTel(String instructorTel) {
        this.instructorTel = instructorTel;
    }

    @Override
    public String toString() {
        return "Class{" +
                "sScName='" + sScName + '\'' +
                ", className='" + className + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", displineName='" + displineName + '\'' +
                ", classStuNum=" + classStuNum +
                ", instructorName='" + instructorName + '\'' +
                ", instructorTel='" + instructorTel + '\'' +
                '}';
    }
}
