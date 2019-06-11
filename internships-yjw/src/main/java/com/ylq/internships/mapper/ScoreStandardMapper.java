package com.ylq.internships.mapper;

import com.ylq.internships.entity.ScoreStandard;
import org.apache.ibatis.annotations.Mapper;

/**
 * 分值占比持久化接口
 */
@Mapper
public interface ScoreStandardMapper {
    void insertScoreStandard(ScoreStandard scoreStandard);
    ScoreStandard getStandard(String sc_name);
}
