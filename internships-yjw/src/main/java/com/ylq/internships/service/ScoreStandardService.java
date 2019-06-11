package com.ylq.internships.service;


import com.ylq.internships.entity.ScoreStandard;

public interface ScoreStandardService {

    //查询分值占比
    ScoreStandard findScoreStandard(String scName);

    void editScoreStandard(ScoreStandard scoreStandard);

    //添加分值占比
    void addScoreStandard(ScoreStandard scoreStandard);
}
