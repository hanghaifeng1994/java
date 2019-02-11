package com.learnyeai.servicebase.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 添加
 * Created by zpz on 2018/4/10.
 */
//@WebFilter(filterName = "trancodeFilter", urlPatterns = "/*")
public class TrancodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        StringBuffer url = req.getRequestURL();
        String contextPath = req.getContextPath();
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
