package com.ylq.internships.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

    Logger logger= LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("进入拦截器！");
        logger.info(request.getRequestURI());
        Object user=request.getSession().getAttribute("user");
        if (user!=null){
            return true;
        }
        request.getRequestDispatcher("/login").forward(request,response);
        return false;
    }
}
