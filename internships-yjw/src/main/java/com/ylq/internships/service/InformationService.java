package com.ylq.internships.service;


import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Information;

public interface InformationService {
    PageInfo<Information> findInformation(int page,int limit,String sScName);
    void addInformation(Information information);
    void editInformation(Information information);
    void removeInformation(Integer infoId);
    void batchRemoveInformation(Integer[] infoIds);
}
