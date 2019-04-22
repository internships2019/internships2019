package com.ylq.internships.controller;

import com.ylq.internships.entity.Manager;
import com.ylq.internships.service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private ManagerService managerService;
    Logger logger= LoggerFactory.getLogger(getClass());

    @ResponseBody
    @RequestMapping("/toLogin")
    public String login(String name, String password,HttpSession session){//验证用户合法性，并将信息存入session
        logger.info("login方法执行了");
        Manager manager = managerService.findMangerByAccount(name);
        if (manager!=null&&password.equals(manager.getManPassword())){
            session.setAttribute("user",manager);
            switch (manager.getManStatus()){
                case "系统管理员":
                    return "1";
                case "学校管理员":
                    return "2";
                case "企业管理员":
                    return "3";
            }
        }
        return "4";
    }

    @RequestMapping("/toManagerIndex.manager")
    public String toManagerIndex(HttpSession session, Map<String,Object> map){
        logger.info("toManagerIndex方法执行了");
        System.out.println(session.getAttribute("user").toString());
        map.put("session",session);
        return "/manager/index";
    }
}
