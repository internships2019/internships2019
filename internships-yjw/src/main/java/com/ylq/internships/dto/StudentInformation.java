package com.ylq.internships.dto;


import com.ylq.internships.entity.StuAllot;
import com.ylq.internships.entity.Student;

/**
 * 实习中学生与页面交换的详细信息实体
 */
public class StudentInformation {
    //带队老师电话
    private String scTel;
    //企业指导老师电话
    private String comTel;
    //专业名
    private String displineName;
    //住宿地址
    private String liveLocation;
    //学生项目实体
   private StuAllot stuAllot;

    public String getScTel() {
        return scTel;
    }

    public void setScTel(String scTel) {
        this.scTel = scTel;
    }

    public String getComTel() {
        return comTel;
    }

    public void setComTel(String comTel) {
        this.comTel = comTel;
    }

    public String getLiveLocation() {
        return liveLocation;
    }

    public void setLiveLocation(String liveLocation) {
        this.liveLocation = liveLocation;
    }

    public StuAllot getStuAllot() {
        return stuAllot;
    }

    public void setStuAllot(StuAllot stuAllot) {
        this.stuAllot = stuAllot;
    }

    public String getDisplineName() {
        return displineName;
    }

    public void setDisplineName(String displineName) {
        this.displineName = displineName;
    }

    @Override
    public String toString() {
        return "StudentInformation{" +
                "scTel='" + scTel + '\'' +
                ", comTel='" + comTel + '\'' +
                ", displineName='" + displineName + '\'' +
                ", liveLocation='" + liveLocation + '\'' +
                ", stuAllot=" + stuAllot +
                '}';
    }
}
