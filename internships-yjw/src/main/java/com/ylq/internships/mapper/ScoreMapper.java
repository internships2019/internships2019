package com.ylq.internships.mapper;


import com.ylq.internships.entity.Score;
import com.ylq.internships.entity.ScoreStandard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 成绩持久化接口
 */
@Mapper
public interface ScoreMapper {
    List<Score> getScoreList(String sScName);
    List<Score> getScoreList2(String sScName);
    List<Score> getScoreListByName(@Param("sScName") String sScName,@Param("stuName") String stuName);
    Score getScoreByWxNo(String wxNo);
    void insertScore(Score score);
    void updateAttanScore(Score score);
    void updateAttanScore2(Score score);
    void updateIntagrateScore(Score score);
    //企业指导老师添加考核成绩
    void updateApprScore(Score score);
}
