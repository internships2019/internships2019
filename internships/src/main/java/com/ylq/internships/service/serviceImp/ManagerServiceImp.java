package com.ylq.internships.service.serviceImp;

import com.ylq.internships.entity.Manager;
import com.ylq.internships.mapper.ManagerMapper;
import com.ylq.internships.service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImp implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;
    Logger logger= LoggerFactory.getLogger(getClass());


    @Override
    public Manager findMangerByAccount(String manAccount) {
        logger.info("findMangerByAccount方法执行了======"+manAccount);
        return managerMapper.getMangerByAccount(manAccount);
    }

    @Override
    public void editManager(Manager manager) {
        logger.info("editManager方法执行了======"+manager);
        managerMapper.updateManager(manager);
    }
}
