package com.ylq.internships.controller;

import com.ylq.internships.config.WxConfig;
import com.ylq.internships.entity.Manager;
import com.ylq.internships.service.ManagerService;
import com.ylq.internships.utils.CommonUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import org.springframework.util.StringUtils;

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


    @RequestMapping("/managerIndex")
    public String toManagerIndex(HttpSession session, Map<String,Object> map){
        logger.info("toManagerIndex方法执行了");
        System.out.println(session.getAttribute("user").toString());
        map.put("session",session);
        return "/manager/index";
    }

    @RequestMapping("/schoolManagerIndex")
    public String toSchoolManagerIndex(HttpSession session, Map<String,Object> map){
        logger.info("toSchoolManagerIndex方法执行了");
        System.out.println(session.getAttribute("user").toString());
        map.put("session",session);
        return "/school/index";
    }

    @ResponseBody
    @RequestMapping(value = "/getOpenid.wx", method = RequestMethod.GET)
    public String getOpenid(String code,String user_type,String unit_name,String user_no,String p_id) {
        String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
        try {
            if (StringUtils.isEmpty(code)) {
                System.out.println("code为空");
            } else {
                WxConfig wxConfig = new WxConfig();
                String requestUrl = WX_URL.replace("APPID", wxConfig.APP_ID).replace("SECRET", wxConfig.APP_SECRET)
                        .replace("JSCODE", code).replace("authorization_code", wxConfig.GRANTTYPE);
                JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
                if (jsonObject != null) {
                    try {
                        // 业务操作
                        String openid = jsonObject.getString("openid");
                        logger.info("openid>>>>>"+openid);
                        return openid;
                    } catch (Exception e) {
                        System.out.println("业务操作失败");
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("code无效");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "错误";
    }
}
