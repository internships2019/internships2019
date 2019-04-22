package com.ylq.internships.controller;

import com.ylq.internships.entity.Manager;
import com.ylq.internships.service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;
    Logger logger= LoggerFactory.getLogger(getClass());

    @RequestMapping("/to_edit_Information")
    public String personalInformation(HttpSession session, Map<String,Object> map){
        logger.info("personalInformation方法执行了");
        map.put("session",session);
        return "/main/personal-edit-information";
    }

    @ResponseBody
    @RequestMapping("/edit_information")
    public String editInformation(String oldPassword,String userName,String newPassword,HttpSession session){
        logger.info("editInformation方法执行了"+oldPassword+"===="+userName+"===="+newPassword);
        Manager manager =(Manager)session.getAttribute("user");
        if (manager.getManPassword().equals(oldPassword)){
            manager.setManName(userName);
            manager.setManPassword(newPassword);
            managerService.editManager(manager);
            session.setAttribute("user",managerService.findMangerByAccount(manager.getManAccount()));
            return "1";
        }
        return "2";
    }
}
