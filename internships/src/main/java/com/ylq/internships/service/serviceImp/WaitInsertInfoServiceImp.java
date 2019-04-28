package com.ylq.internships.service.serviceImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.WaitInsertInfo;
import com.ylq.internships.mapper.WaitInsertInfoMapper;
import com.ylq.internships.service.WaitInsertInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaitInsertInfoServiceImp implements WaitInsertInfoService {

    @Autowired
    private WaitInsertInfoMapper waitInsertInfoMapper;

    //获取已录学生列表
    @Override
    public PageInfo<WaitInsertInfo> findStudentAll(int page,int limit,String unitName, String pStatus) {
        PageHelper.startPage(page,limit);
        List<WaitInsertInfo> list = waitInsertInfoMapper.getStudentAll(unitName, pStatus);
        PageInfo<WaitInsertInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
