package com.ylq.internships.service.serviceImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Information;
import com.ylq.internships.mapper.InformationMapper;
import com.ylq.internships.service.InformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImp  implements InformationService {

    @Autowired
    InformationMapper informationMapper;
    Logger logger= LoggerFactory.getLogger(getClass());

    @Override
    public PageInfo<Information> getInfos(String school_name,int page, int limit) {
        logger.info("InformationServiceImp的getInfos执行==="+page+"===");
        PageHelper.startPage(page,limit);
        List<Information> list = informationMapper.getAllInfo(school_name);
        PageInfo<Information> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Information getLatest() {
        return informationMapper.getLatest();
    }

    @Override
    public Information getById(String id) {
        return informationMapper.getById(id);
    }
}
