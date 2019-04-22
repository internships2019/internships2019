package com.ylq.internships.entity;

/**
 * 扣分项实体
 */
public class DeductStandard {
    //扣分项编号
    private Integer deductId;
    //学生微信号
    private String wxNo;
    //扣分值
    private Double deductScore;
    //扣分类型
    private String deductType;

    public DeductStandard() {
    }

    public DeductStandard(Integer deductId, String wxNo, Double deductScore, String deductType) {
        this.deductId = deductId;
        this.wxNo = wxNo;
        this.deductScore = deductScore;
        this.deductType = deductType;
    }

    public Integer getDeductId() {
        return deductId;
    }

    public void setDeductId(Integer deductId) {
        this.deductId = deductId;
    }

    public String getWxNo() {
        return wxNo;
    }

    public void setWxNo(String wxNo) {
        this.wxNo = wxNo;
    }

    public Double getDeductScore() {
        return deductScore;
    }

    public void setDeductScore(Double deductScore) {
        this.deductScore = deductScore;
    }

    public String getDeductType() {
        return deductType;
    }

    public void setDeductType(String deductType) {
        this.deductType = deductType;
    }
}
