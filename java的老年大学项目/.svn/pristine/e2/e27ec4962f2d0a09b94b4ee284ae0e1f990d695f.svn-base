package com.learnyeai.learnai.web;

import com.learnyeai.learnai.consts.AppR;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.engine.AbstractChannelEngine;
import com.learnyeai.learnai.engine.ChannelEngineFactory;
import com.learnyeai.learnai.support.IBusinessContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * Created by zpz on 2016/4/11.
 * 渠道分发器
 */
@Order(999)
@Controller
public class ChannelDispacher {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public final static Charset UTF8 = Charset.forName("UTF-8");

    private Charset charset = UTF8;

    @Autowired
    private ChannelEngineFactory channelEngineFactory;


    @ResponseBody
    @RequestMapping("/**/*.do")
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        IBusinessContext ctx = ThreadContextUtil.getCtx();

        long beginTimes = new Date().getTime();

        AbstractChannelEngine channelEngine = null;
        try{
            String uri = request.getRequestURI();
            String contextPath = request.getContextPath();
            String url = uri.substring(contextPath.length());
            // 找到渠道、找到transcode
            String transCode = null;
            {
                String channel = null;
                int index = url.lastIndexOf(".");
                transCode = url.substring(1, index);
                String arr[] = transCode.split("/");
                /**
                 * url 格式，/渠道/../controller/method.do
                 * 如果少于2个，认为错误，如果只有两个，认为是通用渠道。
                 */
                if(arr.length < 2) {
                    logger.error("接口不存在");
                    return "地址错误";
                }

                channel = arr[0];

                // 不是渠道话，会获取默认渠道
                channelEngine = channelEngineFactory.getChannelEngine(channel);
            }
            // 输出日志
            MDC.put(AppR.MDC_TRANS_CODE, transCode);
            ctx.setTransCode(transCode);

            String rslt = channelEngine.execute(request, ctx);
            return rslt;

        }catch (Exception e){
            logger.error("error", e.getMessage());
            e.printStackTrace();
        }finally {
            //所耗时间
            logger.info("USE_TIME{}", new Date().getTime() - beginTimes);
        }
        return "内错无法处理";
    }
}
