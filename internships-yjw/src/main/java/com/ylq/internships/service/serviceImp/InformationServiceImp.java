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
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class InformationServiceImp  implements InformationService {

    @Autowired
    private InformationMapper informationMapper;
    Logger logger= LoggerFactory.getLogger(getClass());

    //查询通知列表
    @Override
    public PageInfo<Information> findInformation(int page,int limit,String sScName) {
        logger.info("InformationServiceImp的findInformation执行了");
        PageHelper.startPage(page,limit);
        List<Information> list = informationMapper.getInformationList(sScName);
        PageInfo<Information> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //发布通知
    @Transactional
    @Override
    public void addInformation(Information information) {
        logger.info("InformationServiceImp的addInformation执行了");
        information.setInfoTime(new Date());
        informationMapper.insertInformation(information);
    }

    //修改通知
    @Transactional
    @Override
    public void editInformation(Information information) {
        logger.info("InformationServiceImp的addInformation执行了");
        informationMapper.updateInformation(information);
    }

    //删除通知
    @Override
    public void removeInformation(Integer infoId) {
        logger.info("InformationServiceImp的removeInformation执行了");
        informationMapper.deleteInformation(infoId);
    }

    //批量删除通知
    @Transactional
    @Override
    public void batchRemoveInformation(Integer[] infoIds) {
        logger.info("InformationServiceImp的batchRemoveInformation执行了");
        informationMapper.batchDeleteInformation(infoIds);
    }
}
