package com.learnyeai.learnai.utils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.MDC;

import com.learnyeai.learnai.consts.AppR;
import com.learnyeai.learnai.consts.SessR;

public class MdcLog {

    /**
     * 日志要素-客户信息
     * 
     * @param session
     */
    public static void custInfo(HttpSession session) {
        MDC.put(AppR.MDC_USER_ID, (String) session.getAttribute(SessR.CUST_NO));
        MDC.put(AppR.MDC_LOGIN_ID, (String) session.getAttribute(SessR.LOGIN_ID));
    }

    /**
     * 日志要素-客户端信息
     * 
     * @param session
     */
    public static void clientInfo(HttpSession session) {
        MDC.put(AppR.MDC_CLIENT_OS, (String) session.getAttribute(SessR.CLIENT_OS));
        MDC.put(AppR.MDC_CLIENT_NO, (String) session.getAttribute(SessR.CLIENT_NO));
        MDC.put(AppR.MDC_CLIENT_VER_NO, (String) session.getAttribute(SessR.CLIENT_VER_NO));
    }

    /**
     * 日志要素--客户端信息-基础部分
     * 
     * @param request
     */
    public static void clientInfo(ServletRequest request) {
        // 客户端IP
        MDC.put(AppR.MDC_CLIENT_IP, request.getRemoteHost());
    }
}
