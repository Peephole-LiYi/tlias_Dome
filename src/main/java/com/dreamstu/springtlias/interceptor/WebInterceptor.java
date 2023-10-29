package com.dreamstu.springtlias.interceptor;/*
Name: WebInterceptor
CreatDate: 2023/10/28 20:23
*/

import com.alibaba.fastjson.JSONObject;
import com.dreamstu.springtlias.pojo.Result;
import com.dreamstu.springtlias.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class WebInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        //获取URL
        String requestURI = request.getRequestURI();
        log.info("请求的URL为: {}", requestURI );

        //1,如果为login行为,放行
        if (requestURI.contains("login")){
            log.info("请求为登录,放行");
            return true;
        }

        //2,获取请求头的token
        String jwt = request.getHeader("token");


        //3,检查是否携带JWT令牌
        if (!StringUtils.hasLength(jwt)){
            log.info("token为空,未登录!");
            Result notLogin = Result.error("NOT_LOGIN");

            String jsonString = JSONObject.toJSONString(notLogin);
            response.getWriter().write(jsonString);
            return false;
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
            return false;
        }


        //5,放行
        log.info("放行");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
