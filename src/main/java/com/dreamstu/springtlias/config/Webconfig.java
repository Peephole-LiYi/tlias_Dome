package com.dreamstu.springtlias.config;/*
Name: Webconfig
CreatDate: 2023/10/28 20:30
*/

import com.dreamstu.springtlias.interceptor.WebInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Webconfig implements WebMvcConfigurer {

    @Autowired
    private WebInterceptor webInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webInterceptor).addPathPatterns("/**");
                //.excludePathPatterns("/login");
    }
}