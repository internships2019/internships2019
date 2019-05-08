package com.ylq.internships.service.serviceImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Manager;
import com.ylq.internships.mapper.ManagerMapper;
import com.ylq.internships.service.ManagerService;
import com.ylq.internships.utils.Contant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManagerServiceImp implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;
    Logger logger= LoggerFactory.getLogger(getClass());


    //查询用户信息
    @Override
    public Manager findMangerByAccount(String manAccount) {
        logger.info("findMangerByAccount方法执行了======"+manAccount);
        return managerMapper.getMangerByAccount(manAccount);
    }

    //修改管理人员信息
    @Transactional
    @Override
    public void editManager(Manager manager) {
        logger.info("editManager方法执行了======"+manager);
        managerMapper.updateManager(manager);
    }

    //查询学校管理员列表
    @Override
    public PageInfo<Manager> findSchoolManager(int page,int limit) {
        logger.info("findSchoolManager方法执行了");
        PageHelper.startPage(page,limit);
        List<Manager> list = managerMapper.getSchoolManager(Contant.MANAGER_SCHOOL);
        PageInfo<Manager> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //创建管理员
    @Transactional
    @Override
    public void addManager(Manager manager) {
        managerMapper.insertManager(manager);
    }

    //删除管理员
    @Transactional
    @Override
    public void removeManager(String manAccount) {
        managerMapper.deleteManager(manAccount);
    }

    //批删除管理员
    @Transactional
    @Override
    public void removeBatchManager(String[] manAccounts) {
        managerMapper.deleteBatchManager(manAccounts);
    }
}
