package com.ylq.internships.service;


import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Score;

import java.util.List;

public interface ScoreService {
    PageInfo<Score> findScoreList(int page,int limit,String unitName,String status);
    PageInfo<Score> findScoreListByName(int page,int limit,String sScName,String stuName);
    Score editAttanScore(Score score);
    void editApprScore(String wxNo,Double apprScore);
    void batchUpdate(String sScName, Double attanScore, List<Score> list);
}
