package com.ylq.internships.service.serviceImp;

import com.ylq.internships.entity.Score;
import com.ylq.internships.entity.ScoreStandard;
import com.ylq.internships.mapper.ScoreMapper;
import com.ylq.internships.mapper.ScoreStandardMapper;
import com.ylq.internships.service.ScoreStandardService;
import com.ylq.internships.utils.MathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScoreStandardServiceImp implements ScoreStandardService {

    @Autowired
    private ScoreStandardMapper scoreStandardMapper;
    @Autowired
    private ScoreMapper scoreMapper;

    //查询分值占比
    @Override
    public ScoreStandard findScoreStandard(String scName) {
        return scoreStandardMapper.getScoreStadard(scName);
    }

    //修改分值占比
    @Transactional
    @Override
    public void editScoreStandard(ScoreStandard scoreStandard) {
        scoreStandard.setApprPecent(MathUtils.printNoMoreZero(1-scoreStandard.getAttanPecent()));
        System.out.println(scoreStandard.toString());
        scoreStandardMapper.updateScoreStandard(scoreStandard);
        List<Score> list = scoreMapper.getScoreList2(scoreStandard.getScName());
        for (int i=0;i<list.size();i++){
            list.get(i).setIntagrateScore(list.get(i).getAttanScore()*scoreStandard.getAttanPecent()
                    +list.get(i).getApprScore()*scoreStandard.getApprPecent());
            System.out.println(list.get(i).getIntagrateScore());
            scoreMapper.updateIntagrateScore(list.get(i));
        }
    }

    //添加分值占比
    @Transactional
    @Override
    public void addScoreStandard(ScoreStandard scoreStandard) {
        scoreStandardMapper.insertScoreStandard(scoreStandard);
    }
}
