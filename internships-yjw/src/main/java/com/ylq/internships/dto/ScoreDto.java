package com.ylq.internships.dto;

import com.ylq.internships.entity.Score;

import java.util.List;

public class ScoreDto {
    private List<Score> list;
    private String sScName;
    private Double attanScore;

    public List<Score> getList() {
        return list;
    }

    public void setList(List<Score> list) {
        this.list = list;
    }

    public String getsScName() {
        return sScName;
    }

    public void setsScName(String sScName) {
        this.sScName = sScName;
    }

    public Double getAttanScore() {
        return attanScore;
    }

    public void setAttanScore(Double attanScore) {
        this.attanScore = attanScore;
    }

    @Override
    public String toString() {
        return "ScoreDto{" +
                "list=" + list +
                ", sScName='" + sScName + '\'' +
                ", attanScore=" + attanScore +
                '}';
    }
}
