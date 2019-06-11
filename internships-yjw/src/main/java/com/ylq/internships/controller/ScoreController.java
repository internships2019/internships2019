package com.ylq.internships.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qiniu.util.Json;
import com.ylq.internships.entity.Score;
import com.ylq.internships.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @RequestMapping("/getScoreWx.wx")
    public String getScoreWx(String openid, String sc_name) {

        JSON json = new JSONObject();
        Score score = scoreService.getScore(openid, sc_name);
        ((JSONObject) json).put("attan", score.getAttanScore());
        ((JSONObject) json).put("appr", score.getApprScore());
        ((JSONObject) json).put("inta", score.getIntagrateScore());
        return json.toJSONString();
    }
}
