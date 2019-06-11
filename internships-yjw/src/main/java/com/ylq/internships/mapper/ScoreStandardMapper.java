package com.ylq.internships.mapper;

import com.ylq.internships.entity.ScoreStandard;
import org.apache.ibatis.annotations.Mapper;

/**
 * 分值占比持久化接口
 */
@Mapper
public interface ScoreStandardMapper {
    ScoreStandard getScoreStadard(String scName);
    void updateScoreStandard(ScoreStandard scoreStandard);
    void insertScoreStandard(ScoreStandard scoreStandard);
}
