package com.ylq.internships.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 招聘岗位信息实体
 */
public class CompanyJob {
    //招聘岗位信息编号
    private Integer jobId;
    //招聘岗位所属企业名称
    private String comName;
    //岗位名称
    private String jobName;
    //工作地点
    private String workPlace;
    //岗位描述
    private String workDescription;
    //岗位信息发布时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date postTime;
    //截止申请时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date endTime;
    //岗位状态(可申请，截止申请)
    private String adState;
    //招收人数
    private Integer recruitNum;
    //发布实习岗位学校名
    private String sScName;
    //已招人数
    private Integer nowNum;

    public CompanyJob() {
    }

    public CompanyJob(Integer id, String comName,String sScName,String jobName, String workPlace, String workDescription, Date postTime, Date endTime, String adState, Integer recruitNum,int nowNum) {
        this.jobId = id;
        this.comName = comName;
        this.jobName = jobName;
        this.workPlace = workPlace;
        this.workDescription = workDescription;
        this.postTime = postTime;
        this.endTime = endTime;
        this.adState = adState;
        this.recruitNum = recruitNum;
        this.sScName=sScName;
        this.nowNum=nowNum;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public Date getPostTime() {
        return  postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAdState() {
        return adState;
    }

    public void setAdState(String adState) {
        this.adState = adState;
    }

    public Integer getRecruitNum() {
        return recruitNum;
    }

    public void setRecruitNum(Integer recruitNum) {
        this.recruitNum = recruitNum;
    }

    public String getsScName() {
        return sScName;
    }

    public void setsScName(String sScName) {
        this.sScName = sScName;
    }

    public Integer getNowNum() {
        return nowNum;
    }

    public void setNowNum(Integer nowNum) {
        this.nowNum = nowNum;
    }



    @Override
    public String toString() {
        return "CompanyJob{" +
                "jobId=" + jobId +
                ", comName='" + comName + '\'' +
                ", jobName='" + jobName + '\'' +
                ", workPlace='" + workPlace + '\'' +
                ", workDescription='" + workDescription + '\'' +
                ", postTime=" + postTime +
                ", endTime=" + endTime +
                ", adState='" + adState + '\'' +
                ", recruitNum=" + recruitNum +
                ", sScName='" + sScName + '\'' +
                ", nowNum=" + nowNum +
                '}';
    }
}
