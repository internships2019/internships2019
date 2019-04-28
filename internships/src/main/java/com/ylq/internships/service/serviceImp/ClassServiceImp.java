package com.ylq.internships.service.serviceImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Class;
import com.ylq.internships.mapper.ClassMapper;
import com.ylq.internships.service.ClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassServiceImp implements ClassService {

    @Autowired
    private ClassMapper classMapper;
    Logger logger= LoggerFactory.getLogger(getClass());

    //查询班级列表
    @Override
    public PageInfo<Class> findClassAll(int page, int limit, String sScName) {
        logger.info("ClassServiceImp的findClassAll执行了");
        PageHelper.startPage(page,limit);
        List<Class> list =classMapper.getAll(sScName);
        PageInfo<Class> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //班级名查询班级信息
    @Override
    public List<Class> findByNames(String sScName, String className) {
        logger.info("ClassServiceImp的findByNames执行了");
        return classMapper.getByClassName(sScName,className);
    }

    //添加班级信息
    @Transactional
    @Override
    public void addClass(Class aclass) {
        logger.info("ClassServiceImp的addClass执行了");
        classMapper.insertClass(aclass);
    }

    //批量添加班级信息
    @Transactional
    @Override
    public void addBatchClass(List<Class> list) {
        logger.info("ClassServiceImp的addBatchClass执行了");
        classMapper.insertBatchClass(list);
    }
}
