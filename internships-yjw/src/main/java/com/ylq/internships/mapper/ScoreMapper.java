package com.ylq.internships.mapper;


import com.ylq.internships.entity.Score;
import org.apache.ibatis.annotations.Mapper;

/**
 * 成绩持久化接口
 */
@Mapper
public interface ScoreMapper {
    Score getScore(String openid);
    void updateAttanScore(String openid,Double attan_score);
    void updateScore(String openid,Double attan_score,Double inta_score);
    void updateIntaScore(String openid,Double inta_score);
}
