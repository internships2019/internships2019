package com.ylq.internships.service.serviceImp;

import com.ylq.internships.entity.ScoreStandard;
import com.ylq.internships.mapper.ScoreStandardMapper;
import com.ylq.internships.service.ScoreStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreStandardServiceImp implements ScoreStandardService {

    @Autowired
    private ScoreStandardMapper scoreStandardMapper;

    //添加分值占比
    @Transactional
    @Override
    public void addScoreStandard(ScoreStandard scoreStandard) {
        scoreStandardMapper.insertScoreStandard(scoreStandard);
    }
}
