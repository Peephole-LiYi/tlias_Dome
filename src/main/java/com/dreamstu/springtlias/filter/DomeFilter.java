package com.dreamstu.springtlias.filter;/*
Name: DomeFilter
CreatDate: 2023/10/27 21:16
*/


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class DomeFilter implements Filter {
    //初始化方法,只调用一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化方法执行!");
    }

    //只要拦截到请求就拦截
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截到请求!");
        //放行操作
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("放行后");
    }

    //销毁方法,只执行一次
    @Override
    public void destroy() {
        System.out.println("destroy 销毁方法执行了!");
    }
}
