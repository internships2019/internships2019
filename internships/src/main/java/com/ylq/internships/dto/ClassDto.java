package com.ylq.internships.dto;

/**
 * 与修改班级界面连接的班级实体
 */
public class ClassDto {
    //学校名称
    private String sScName;
    //旧班级名称
    private String oldClassName;
    //新班级名称
    private String newClassName;
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

    public ClassDto() {
    }

    public ClassDto(String sScName, String oldClassName, String newClassName, String collegeName, String displineName, String classStuNum, String instructorName, String instructorTel) {
        this.sScName = sScName;
        this.oldClassName = oldClassName;
        this.newClassName = newClassName;
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

    public String getOldClassName() {
        return oldClassName;
    }

    public void setOldClassName(String oldClassName) {
        this.oldClassName = oldClassName;
    }

    public String getNewClassName() {
        return newClassName;
    }

    public void setNewClassName(String newClassName) {
        this.newClassName = newClassName;
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
        return "ClassDto{" +
                "sScName='" + sScName + '\'' +
                ", oldClassName='" + oldClassName + '\'' +
                ", newClassName='" + newClassName + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", displineName='" + displineName + '\'' +
                ", classStuNum='" + classStuNum + '\'' +
                ", instructorName='" + instructorName + '\'' +
                ", instructorTel='" + instructorTel + '\'' +
                '}';
    }
}
