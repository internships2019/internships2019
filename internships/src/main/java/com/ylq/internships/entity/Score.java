package com.ylq.internships.entity;

/**
 * 成绩实体
 */
public class Score {
    //成绩编号
    private String scoreId;
    //学生微信号
    private String wxNo;
    //考勤分数
    private Double attanScore;
    //考核分数
    private Double apprScore;
    //综合分数
    private Double intagrateScore;
    //综合分数
    private String scName;
    //分值占比标准实体
    private ScoreStandard scoreStandard;

    public Score() {
    }

    public Score(String scoreId, String wxNo, Double attanScore, Double apprScore, Double intagrateScore, String scName) {
        this.scoreId = scoreId;
        this.wxNo = wxNo;
        this.attanScore = attanScore;
        this.apprScore = apprScore;
        this.intagrateScore = intagrateScore;
        this.scName = scName;
    }

    public String getScName() {
        return scName;
    }

    public void setScName(String scName) {
        this.scName = scName;
    }

    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId;
    }

    public String getWxNo() {
        return wxNo;
    }

    public void setWxNo(String wxNo) {
        this.wxNo = wxNo;
    }

    public Double getAttanScore() {
        return attanScore;
    }

    public void setAttanScore(Double attanScore) {
        this.attanScore = attanScore;
    }

    public Double getApprScore() {
        return apprScore;
    }

    public void setApprScore(Double apprScore) {
        this.apprScore = apprScore;
    }

    public Double getIntagrateScore() {
        return intagrateScore;
    }

    public void setIntagrateScore(Double intagrateScore) {
        this.intagrateScore = intagrateScore;
    }

    public ScoreStandard getScoreStandard() {
        return scoreStandard;
    }

    public void setScoreStandard(ScoreStandard scoreStandard) {
        this.scoreStandard = scoreStandard;
    }
}
