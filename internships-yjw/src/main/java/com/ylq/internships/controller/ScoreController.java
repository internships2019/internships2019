package com.ylq.internships.controller;

import com.github.pagehelper.PageInfo;
import com.ylq.internships.dto.ScoreDto;
import com.ylq.internships.entity.Score;
import com.ylq.internships.service.ScoreService;
import com.ylq.internships.utils.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    private Logger logger= LoggerFactory.getLogger(getClass());

    //查询成绩后台接口
    @GetMapping("/find_score_list")
    public String findScoreList(int page, int limit, String unitName, String status){
        logger.info("ScoreController的findScoreList执行了==="+unitName+"===="+status);
        PageInfo<Score> pageInfo = scoreService.findScoreList(page, limit, unitName, status);
        return PageUtil.getScoreJson(pageInfo.getList(), pageInfo.getTotal());
    }

    //通过学生名查询成绩后台接口
    @GetMapping("/find_score_byName")
    public String findScorByName(int page, int limit, String sScName, String stuName){
        logger.info("ScoreController的findScoreList执行了==="+sScName+"===="+stuName);
        PageInfo<Score> pageInfo = scoreService.findScoreListByName(page, limit, sScName, stuName);
        return PageUtil.getScoreJson(pageInfo.getList(), pageInfo.getTotal());
    }

    //修改考勤成绩后台接口
    @PostMapping("/edit_attanScore")
    public Score editAttanScore(@RequestBody Score score){
        System.out.println(score.toString());
        return scoreService.editAttanScore(score);
    }

    @PostMapping("/batch_update")
    public String batchUpdate(@RequestBody ScoreDto scoreDto){
        System.out.println(scoreDto.toString());
        scoreService.batchUpdate(scoreDto.getsScName(),scoreDto.getAttanScore(),scoreDto.getList());
        return null;
    }
}
