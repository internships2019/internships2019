package com.ylq.internships.service.serviceImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.School;
import com.ylq.internships.mapper.SchoolMapper;
import com.ylq.internships.service.SchoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SchoolServiceImp  implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;
    Logger logger= LoggerFactory.getLogger(getClass());

    //获取学校列表
    @Override
    public PageInfo<School> getAll(int page,int limit) {
        logger.info("SchoolServiceImp的getAll执行==="+page+"===");
        PageHelper.startPage(page,limit);
        List<School> list =schoolMapper.getAll();
        PageInfo<School> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //通过学校名查询学校
    @Override
    public School getSchoolByName(String schoolName) {
        logger.info("SchoolServiceImp的getSchoolByName执行");
        return schoolMapper.getSchoolByName(schoolName);
    }

    //查询所有的学习名称
    @Override
    public List<String> getAllName() {
        logger.info("SchoolServiceImp的getAllName执行");
        return schoolMapper.getAllName();
    }

    //添加学校
    @Transactional
    @Override
    public void addSchool(School school) {
        logger.info("SchoolServiceImp的gaddSchool执行==="+school.toString());
        schoolMapper.insertSchool(school);
    }

    //修改学校
    @Transactional
    @Override
    public void editSchol(School school) {
        logger.info("SchoolServiceImp的editSchol执行==="+school.toString());
        schoolMapper.updateSchool(school);
    }

    //删除学校
    @Transactional
    @Override
    public void removeSchool(String scName) {
        logger.info("SchoolServiceImp的removeSchool执行==="+scName);
        schoolMapper.deleteSchool(scName);
    }
}
