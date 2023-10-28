package com.dreamstu.springtlias.filter;/*
Name: LoginCheckFilter
CreatDate: 2023/10/27 21:42
*/

import com.alibaba.fastjson.JSONObject;
import com.dreamstu.springtlias.pojo.Result;
import com.dreamstu.springtlias.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
@WebFilter("/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取URL
        String requestURI = request.getRequestURI();
        log.info("请求的URL为: {}", requestURI );

        //1,如果为login行为,放行
        if (requestURI.contains("login")){
            log.info("请求为登录,放行");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //2,获取请求头的token
        String jwt = request.getHeader("token");


        //3,检查是否携带JWT令牌
        if (!StringUtils.hasLength(jwt)){
            log.info("token为空,未登录!");
            Result notLogin = Result.error("NOT_LOGIN");

            String jsonString = JSONObject.toJSONString(notLogin);
            response.getWriter().write(jsonString);
            return;
        }

        //4,检查JWT令牌是否合法
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析失败");
            Result notLogin = Result.error("NOT_LOGIN");

            String jsonString = JSONObject.toJSONString(notLogin);
            response.getWriter().write(jsonString);
            return;
        }


        //5,放行
        log.info("放行");
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
