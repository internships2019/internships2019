package com.ylq.internships.controller;

import com.ylq.internships.entity.ScoreStandard;
import com.ylq.internships.service.ScoreStandardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scoreStandard")
public class ScoreStandardController {

    @Autowired
    private ScoreStandardService scoreStandardService;
    private Logger logger= LoggerFactory.getLogger(getClass());

    //查询分值占比后台接口
    @GetMapping("/find_scoreStandard")
    public ScoreStandard findScoreStandard(String scName){
        logger.info("ScoreStandardController的findScoreStandard执行了==="+scName);
        return scoreStandardService.findScoreStandard(scName);
    }

    //修改分值占比后台接口
    @PostMapping("/edit_scoreStandard")
    public void editScoreStandard(@RequestBody ScoreStandard scoreStandard){
        System.out.println(scoreStandard.toString());
        scoreStandardService.editScoreStandard(scoreStandard);
    }
}
