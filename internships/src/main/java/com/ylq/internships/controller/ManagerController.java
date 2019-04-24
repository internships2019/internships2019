package com.ylq.internships.controller;

import com.github.pagehelper.PageInfo;
import com.ylq.internships.entity.Manager;
import com.ylq.internships.service.ManagerService;
import com.ylq.internships.service.SchoolService;
import com.ylq.internships.utils.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;
    @Autowired
    private SchoolService schoolService;
    Logger logger= LoggerFactory.getLogger(getClass());

    //修改用户信息页
    @RequestMapping("/to_edit_Information")
    public String personalInformation(HttpSession session, Map<String,Object> map){
        logger.info("personalInformation方法执行了");
        map.put("session",session);
        return "/main/personal-edit-information";
    }

    //用户欢迎页
    @RequestMapping("/to_welcome")
    public String toWelcome(HttpSession session, Map<String,Object> map){
        logger.info("toWelcome方法执行了");
        map.put("session",session);
        return "/manager/welcome";
    }

    //用户登出
    @RequestMapping("/logOut")
    public String logOut(HttpSession session){
        logger.info("logOut方法执行了");
        session.setAttribute("user",null);
        return "redirect:/login";
    }

    //返回学校列表页面
    @RequestMapping("/shool_list.manager")
    public String shoolList(HttpSession session, Map<String,Object> map){
        logger.info("shoolList方法执行了");
        map.put("session",session);
        return "/manager/school-list";
    }

    //返回学校管理员列表页面
    @RequestMapping("/school_manager_list.manager")
    public String schoolManagerlList(HttpSession session, Map<String,Object> map){
        logger.info("shooManagerlList方法执行了");
        map.put("session",session);
        return "/manager/school-manager-list";
    }


    //返回学校管理员
    @ResponseBody
    @RequestMapping("/get_school_manager_list.manager")
    public String getSchoolManagerList(int page,int limit){
        logger.info("getSchoolManagerList方法执行了");
        PageInfo<Manager> pageInfo = managerService.findSchoolManager(page, limit);
        return PageUtil.getManagerJson(pageInfo.getList(),pageInfo.getTotal());
    }

    //修改用户信息
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

    //添加管理员
    @ResponseBody
    @RequestMapping("/add_school_manager")
    public String addManager(@RequestBody Manager manager){
        logger.info("ManagerController的addManager方法执行了"+manager.toString());
        if (managerService.findMangerByAccount(manager.getManAccount())==null){
            managerService.addManager(manager);
            return "1";
        }
        return "2";
    }

    //修改管理员
    @ResponseBody
    @RequestMapping("/edit_manager.manager")
    public String editManager(@RequestBody Manager manager){
        logger.info("ManagerController的editManager方法执行了"+manager.toString());
        managerService.editManager(manager);
        return "null";
    }

    //删除管理员
    @ResponseBody
    @RequestMapping("/delete_manager.manager")
    public void removeManager(@RequestBody String manAccount){
        logger.info("ManagerController的removeManager方法执行了"+manAccount);
        managerService.removeManager(manAccount);
    }

    //批删除管理员
    @ResponseBody
    @RequestMapping("/batch_manager.manager")
    public void removeBatchManager(@RequestBody String[] manAccounts){
        logger.info("ManagerController的removeBatchManager方法执行了"+manAccounts);
        managerService.removeBatchManager(manAccounts);
    }
}
