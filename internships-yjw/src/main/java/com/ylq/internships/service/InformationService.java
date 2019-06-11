package com.ylq.internships.service;


import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Information;

public interface InformationService {
    PageInfo<Information> getInfos(String school_name,int page, int limit);
    Information getLatest();
    Information getById(String id);
}
