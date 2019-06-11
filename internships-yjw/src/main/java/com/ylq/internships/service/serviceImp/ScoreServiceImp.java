package com.ylq.internships.service.serviceImp;

import com.ylq.internships.entity.Score;
import com.ylq.internships.entity.ScoreStandard;
import com.ylq.internships.mapper.ScoreMapper;
import com.ylq.internships.mapper.ScoreStandardMapper;
import com.ylq.internships.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImp implements ScoreService {

    @Autowired
    ScoreMapper scoreMapper;
    @Autowired
    ScoreStandardMapper scoreStandardMapper;

    @Override
    public Score getScore(String openid, String sc_name) {

        Score score = scoreMapper.getScore(openid);

        Double attan_score = score.getAttanScore();

        if (score.getIntagrateScore() == null && score.getApprScore() != null) {
            ScoreStandard standard = scoreStandardMapper.getStandard(sc_name);
            Double inta_score = attan_score * standard.getAttanPecent() + score.getApprScore() * standard.getApprPecent();
            scoreMapper.updateIntaScore(openid, inta_score);
            score.setIntagrateScore(inta_score);
            return score;
        }
        return score;
    }
}
