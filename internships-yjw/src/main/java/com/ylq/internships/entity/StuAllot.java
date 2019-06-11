package com.ylq.internships.entity;

/**
 * 学生动态项目实体
 */
public class StuAllot {
    //项目编号
    private Integer id;
    //学生微信号
    private String sWxNo;
    //项目状态(待审核，已审核，待实习，实习中)
    private String state;
    //企业名称
    private String comName;
    //企业地址
    private String comLocation;
    //企业联系电话
    private String comTel;
    //岗位信息编号
    private Integer jobId;
    //岗位名称
    private String jobName;
    //带队老师微信号
    private String scTeaWx;
    //指导老师微信号
    private String comTeaWx;
    //带队姓名
    private String scTeaName;
    //指导老师姓名
    private String comTeaName;
    //所属学校
    private String sScName;
    //学生实体
    private Student student;

    public StuAllot() {
    }

    public StuAllot(Integer id, String sWxNo, String state, String comName,String comLocation, String comTel,Integer jobId ,String jobName, String scTeaWx, String comTeaWx, String scTeaName, String comTeaName,String sScName) {
        this.id = id;
        this.sWxNo = sWxNo;
        this.state = state;
        this.comName = comName;
        this.comLocation=comLocation;
        this.comTel = comTel;
        this.jobId=jobId;
        this.jobName = jobName;
        this.scTeaWx = scTeaWx;
        this.comTeaWx = comTeaWx;
        this.scTeaName = scTeaName;
        this.comTeaName = comTeaName;
        this.sScName=sScName;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getsWxNo() {
        return sWxNo;
    }

    public void setsWxNo(String sWxNo) {
        this.sWxNo = sWxNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getScTeaWx() {
        return scTeaWx;
    }

    public void setScTeaWx(String scTeaWx) {
        this.scTeaWx = scTeaWx;
    }

    public String getComTeaWx() {
        return comTeaWx;
    }

    public void setComTeaWx(String comTeaWx) {
        this.comTeaWx = comTeaWx;
    }

    public String getScTeaName() {
        return scTeaName;
    }

    public void setScTeaName(String scTeaName) {
        this.scTeaName = scTeaName;
    }

    public String getComTeaName() {
        return comTeaName;
    }

    public void setComTeaName(String comTeaName) {
        this.comTeaName = comTeaName;
    }

    public String getsScName() {
        return sScName;
    }

    public void setsScName(String sScName) {
        this.sScName = sScName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StuAllot{" +
                "id=" + id +
                ", sWxNo='" + sWxNo + '\'' +
                ", state='" + state + '\'' +
                ", comName='" + comName + '\'' +
                ", comLocation='" + comLocation + '\'' +
                ", comTel='" + comTel + '\'' +
                ", jobId=" + jobId +
                ", jobName='" + jobName + '\'' +
                ", scTeaWx='" + scTeaWx + '\'' +
                ", comTeaWx='" + comTeaWx + '\'' +
                ", scTeaName='" + scTeaName + '\'' +
                ", comTeaName='" + comTeaName + '\'' +
                ", sScName='" + sScName + '\'' +
                ", student=" + student +
                '}';
    }
}
