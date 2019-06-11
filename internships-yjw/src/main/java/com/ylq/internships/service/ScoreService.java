package com.ylq.internships.service;


import com.ylq.internships.entity.Score;

public interface ScoreService {

    Score getScore(String openid,String sc_name);
}
