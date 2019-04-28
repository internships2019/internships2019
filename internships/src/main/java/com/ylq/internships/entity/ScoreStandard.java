package com.ylq.internships.entity;

/**
 * 分值占比实体
 */
public class ScoreStandard {
    //分值占比编号
    private Integer standardId;
    //分值占比所属学校
    private String scName;
    //考勤成绩分值占比
    private Double attanPecent;
    //考核成绩分值占比
    private Double apprPecent;

    public ScoreStandard() {
    }

    public ScoreStandard( String scName, Double attanPecent, Double apprPecent) {
        this.scName = scName;
        this.attanPecent = attanPecent;
        this.apprPecent = apprPecent;
    }

    public Integer getStandardId() {
        return standardId;
    }

    public void setStandardId(Integer standardId) {
        this.standardId = standardId;
    }

    public String getScName() {
        return scName;
    }

    public void setScName(String scName) {
        this.scName = scName;
    }

    public Double getAttanPecent() {
        return attanPecent;
    }

    public void setAttanPecent(Double attanPecent) {
        this.attanPecent = attanPecent;
    }

    public Double getApprPecent() {
        return apprPecent;
    }

    public void setApprPecent(Double apprPecent) {
        this.apprPecent = apprPecent;
    }
}
