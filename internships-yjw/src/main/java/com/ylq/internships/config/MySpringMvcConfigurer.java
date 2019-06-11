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
        registry.addViewController("/personal-information").setViewName("/main/personal-information");
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
        registry.addViewController("/student-enter-edit").setViewName("/school/student-enter-edit");
        registry.addViewController("/student-information").setViewName("/school/student-information");
        registry.addViewController("/image-upload").setViewName("/school/image-upload");
        registry.addViewController("/student-explain").setViewName("/school/student-explain");
        registry.addViewController("/class-edit").setViewName("/school/class-edit");
        registry.addViewController("/teacher-enter").setViewName("/school/teacher-enter");
        registry.addViewController("/teacher-list").setViewName("/school/teacher-list");
        registry.addViewController("/teacher-add").setViewName("/school/teacher-add");
        registry.addViewController("/teacher-explain").setViewName("/school/teacher-explain");
        registry.addViewController("/teacher-information").setViewName("/school/teacher-information");
        registry.addViewController("/teacher-edit").setViewName("/school/teacher-edit");
        registry.addViewController("/job-add").setViewName("/school/job-add");
        registry.addViewController("/job-list").setViewName("/school/job-list");
        registry.addViewController("/job-edit").setViewName("/school/job-edit");
        registry.addViewController("/job-history-list").setViewName("/school/job-history-list");
        registry.addViewController("/student-stay-list").setViewName("/school/student-stay-list");
        registry.addViewController("/student-stay-information").setViewName("/school/student-stay-information");
        registry.addViewController("/stu-allot-list").setViewName("/school/stu-allot-list");
        registry.addViewController("/company-index").setViewName("/company/index");
        registry.addViewController("/teacher-practice-list").setViewName("/company/teacher-practice-list");
        registry.addViewController("/teacher-practice-add").setViewName("/company/teacher-practice-add");
        registry.addViewController("/teacher-prepare").setViewName("/company/teacher-prepare");
        registry.addViewController("/company-stu-allot-list").setViewName("/company/stu-allot-list");
        registry.addViewController("/company-student-list").setViewName("/company/student-list");
        registry.addViewController("/company-student-information").setViewName("/company/student-information");
        registry.addViewController("/school-student-internship-list").setViewName("/school/student-internship-list");
        registry.addViewController("/school-student-clock-record").setViewName("/school/student-clock-record");
        registry.addViewController("/school-notice-add").setViewName("/school/notice-add");
        registry.addViewController("/school-notice-list").setViewName("/school/notice-list");
        registry.addViewController("/school-notice-infor").setViewName("/school/notice-infor");
        registry.addViewController("/school-notice-update").setViewName("/school/notice-update");
        registry.addViewController("/school-score-list").setViewName("/school/score-list");
        registry.addViewController("/school-score-standard").setViewName("/school/score-standard");
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
