package com.ylq.internships.controller;

import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Information;
import com.ylq.internships.service.InformationService;
import com.ylq.internships.utils.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/information")
public class InformationController {
    @Autowired
    private InformationService informationService;
    Logger logger= LoggerFactory.getLogger(getClass());

    //查询通知列表后台接口
    @GetMapping("/find_information_list")
    public String findInformationList(int page,int limit,String sScName){
        logger.info("InformationController的findInformationList执行了==="+page+"===="+limit+"====="+sScName);
        PageInfo<Information> pageInfo = informationService.findInformation(page, limit, sScName);
        return PageUtil.getInformationJson(pageInfo.getList(),pageInfo.getTotal());
    }

    //发布通知后台接口
    @PostMapping("/add_information")
    public void addInformation(@RequestBody Information information){
        logger.info("InformationController的addInformation执行了");
        informationService.addInformation(information);
    }

    //发布通知后台接口
    @PostMapping("/edit_information")
    public void editInformation(@RequestBody Information information){
        logger.info("InformationController的addInformation执行了"+information.toString());
        informationService.editInformation(information);
    }

    //删除通知后台接口
    @PostMapping("/remove_information")
    public void removeInformation(Integer inforId){
        logger.info("InformationController的addInformation执行了"+inforId);
        informationService.removeInformation(inforId);
    }

    //批删除通知后台接口
    @PostMapping("/batch_remove_information")
    public void batchRemoveInformation(Integer[] inforIds){
        logger.info("InformationController的addInformation执行了"+ Arrays.toString(inforIds));
        informationService.batchRemoveInformation(inforIds);
    }
}
