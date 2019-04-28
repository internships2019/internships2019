package com.ylq.internships.config;

import com.github.pagehelper.PageHelper;
import com.ylq.internships.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Properties;


@Configuration
public class MySpringMvcConfigurer implements WebMvcConfigurer {

    //配置mybatis的分页插件pageHelper
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("/main/login");
        registry.addViewController("/test").setViewName("/main/test");
        registry.addViewController("/add-school").setViewName("/manager/school-add");
        registry.addViewController("/edit-school").setViewName("/manager/school-edit");
        registry.addViewController("/edit-manager").setViewName("/manager/manager-edit");
        registry.addViewController("/add-school-manager").setViewName("/manager/school-manager-add");
        registry.addViewController("/company-list").setViewName("/manager/company-list");
        registry.addViewController("/company-add").setViewName("/manager/company-add");
        registry.addViewController("/company-edit").setViewName("/manager/company-edit");
        registry.addViewController("/student-enter").setViewName("/school/student-enter");
        registry.addViewController("/class-list").setViewName("/school/class-list");
        registry.addViewController("/class-add").setViewName("/school/class-add");
        registry.addViewController("/class-explain").setViewName("/school/class-explain");
        registry.addViewController("/student-enter-add").setViewName("/school/student-enter-add");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/**/toLogin","/login.html","/test","/**/*.wx")//"/**/login/*",
                .excludePathPatterns("/**/*.png")
                .excludePathPatterns("/**/css/*","/**/js/*","/**/*.js","/**/fonts/*","/**/images/*","/**/jstest/*","/**/layui/*","/**/layer.css");
    }

}
