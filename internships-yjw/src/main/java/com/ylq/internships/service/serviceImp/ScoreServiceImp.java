package com.ylq.internships.service.serviceImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Score;
import com.ylq.internships.entity.ScoreStandard;
import com.ylq.internships.mapper.ScoreMapper;
import com.ylq.internships.mapper.ScoreStandardMapper;
import com.ylq.internships.service.ScoreService;
import com.ylq.internships.utils.Contant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreServiceImp implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private ScoreStandardMapper scoreStandardMapper;
    private Logger logger= LoggerFactory.getLogger(getClass());

    @Override
    public PageInfo<Score> findScoreList(int page, int limit, String unitName, String status) {
        if (Contant.SCHOOL.equals(status)){
            PageHelper.startPage(page,limit);
            List<Score> list = scoreMapper.getScoreList(unitName);
            PageInfo<Score> pageInfo = new PageInfo<>(list);
            return pageInfo;
        }else if (Contant.COMPANY.equals(status)){

        }
        return null;
    }

    @Override
    public PageInfo<Score> findScoreListByName(int page, int limit, String sScName, String stuName) {
        PageHelper.startPage(page,limit);
        List<Score> list = scoreMapper.getScoreListByName(sScName, stuName);
        PageInfo<Score> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }



    //修改考勤成绩
    @Transactional
    @Override
    public Score editAttanScore(Score score) {
        logger.info("ScoreServiceImp的editAttanScore执行了===="+score.toString());
        ScoreStandard scoreStadard = scoreStandardMapper.getScoreStadard(score.getScName());
        System.out.println(score.getAttanScore()*scoreStadard.getAttanPecent()+score.getApprScore()*scoreStadard.getApprPecent());
        score.setIntagrateScore(score.getAttanScore()*scoreStadard.getAttanPecent()+score.getApprScore()*scoreStadard.getApprPecent());
        try {
            scoreMapper.updateAttanScore(score);
            return  score;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //批量修改考勤成绩
    @Transactional
    @Override
    public void batchUpdate(String sScName, Double attanScore,List<Score> list) {
        ScoreStandard scoreStadard = scoreStandardMapper.getScoreStadard(sScName);
        List<Score> listNotNull=new ArrayList<>();
        List<Score> listNull=new ArrayList<>();
        for (Score s:list){
            s.setAttanScore(attanScore);
            if (s.getIntagrateScore()==null){
                listNull.add(s);
            }else {
                listNotNull.add(s);
            }
        }
        for (int i=0;i<listNotNull.size();i++){
            listNotNull.get(i).setIntagrateScore(listNotNull.get(i).getAttanScore()*scoreStadard.getAttanPecent()+listNotNull.get(i).getApprScore()*scoreStadard.getApprPecent());
            System.out.println(listNotNull.get(i));
            scoreMapper.updateAttanScore(listNotNull.get(i));
        }
        for (int i=0;i<listNull.size();i++){
            System.out.println(listNull.get(i));
            scoreMapper.updateAttanScore2(listNull.get(i));
        }
    }

    //企业指导老师添加/修改考核成绩
    @Transactional
    @Override
    public void editApprScore(String wxNo,Double apprScore) {
        Score score = scoreMapper.getScoreByWxNo(wxNo); 
        score.setApprScore(apprScore);
        ScoreStandard scoreStadard = scoreStandardMapper.getScoreStadard(score.getScName());
        score.setIntagrateScore(score.getAttanScore()*scoreStadard.getAttanPecent()+score.getApprScore()*scoreStadard.getApprPecent());
        System.out.println(score.toString());
        scoreMapper.insertScore(score);
    }
}
