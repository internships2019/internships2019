package com.ylq.internships.controller;

import com.ylq.internships.config.WxConfig;
import com.ylq.internships.dto.StudentInsert;
import com.ylq.internships.entity.WaitInsertInfo;
import com.ylq.internships.service.StudentService;
import com.ylq.internships.service.WaitInsertInfoService;
import com.ylq.internships.utils.CommonUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/waitInsertInfo")
public class WaitInsertInfoController {
    @Autowired
    WaitInsertInfoService waitInsertInfoService;
    Logger logger= LoggerFactory.getLogger(getClass());

    @ResponseBody
    @RequestMapping(value="/person_insert.wx")
    public String personInsert(String openid,String user_type,String unit_name,String user_no,String p_id) {

        WaitInsertInfo waitInsertInfo = new WaitInsertInfo(unit_name, user_no, p_id, user_type);

        logger.info("waitInsertInfo>>>>>>"+waitInsertInfo.toString());
//        logger.info("openid>>>>>"+openid);
//        logger.info("unit_name>>>>>"+unit_name);
//        logger.info("user_type>>>>>"+user_type);
//        logger.info("user_no>>>>>"+user_no);
        logger.info("p_id>>>>>"+p_id);

//        logger.info(studentInsert.toString());
        return waitInsertInfoService.pInsert(openid, waitInsertInfo);
    }
//
//    @RequestMapping(value = "/getOpenid.wx", method = RequestMethod.GET)
//    public String getOpenid(String code,String user_type,String unit_name,String user_no,String p_id) {
//        String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
//        try {
//            if (StringUtils.isEmpty(code)) {
//                System.out.println("code为空");
//            } else {
//                WxConfig wxConfig = new WxConfig();
//                String requestUrl = WX_URL.replace("APPID", wxConfig.APP_ID).replace("SECRET", wxConfig.APP_SECRET)
//                        .replace("JSCODE", code).replace("authorization_code", wxConfig.GRANTTYPE);
//                JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
//                if (jsonObject != null) {
//                    try {
//                        // 业务操作
//                        String openid = jsonObject.getString("openid");
//                        WaitInsertInfo waitInsertInfo = new WaitInsertInfo(unit_name,user_no,p_id,user_type);
//                        waitInsertInfoService.pInsert(openid,waitInsertInfo);
//                        return openid;
//                    } catch (Exception e) {
//                        System.out.println("业务操作失败");
//                        e.printStackTrace();
//                    }
//                } else {
//                    System.out.println("code无效");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "错误";
//    }
}
