package com.learnyeai.learnai.net.netWay.http;

import java.util.Date;

import com.learnyeai.learnai.net.INetConnect;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.core.config.ConfigUtils;
import com.learnyeai.core.utils.SpringContextUtils;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.tools.common.StringUtils;
import com.learnyeai.tools.common.XmlUtil;

@Component
public class NetConnect4HttpTest implements INetConnect {

	private Logger logger = LoggerFactory.getLogger(getClass());

    private static final String rootpath = "data/xml/";
    private String template = "{0}{1}.xml";
    
    // 并发线程计数
 	private int cnt = 0;
 	
 	// 线程锁
 	private boolean running = false;

 	private int LIMIT = ConfigUtils.getValue("LIMIT_INTE_THREADS", 1);

	@Override
    public boolean connect(IBusinessContext ctx, String transCode) {
		cnt++;
		if (cnt > LIMIT && running) {
			// 激活线程锁
			logger.info("inte.service_busy {}", --cnt);
			// 抛出异常，服务正忙
			throw new AresRuntimeException("inte.service_busy");
		}
		
		// 请求开始时间
		long start = new Date().getTime();
		
        String filePath = StringUtils.message(template, rootpath, transCode);
        logger.debug("trans defined file :{}", filePath);
        
        // 输出请求报文
        String xmlStr = (String) ctx.getRequestEntry();
		logger.debug("\n====================手机银行【{}】--->行方前置: request start:====================\n{}", transCode, XmlUtil.formatXmlStr(xmlStr));
		logger.debug("\n====================交易:【{}】 request end====================\n", transCode);
        // 当前缓存中没有配置信息进行加载
        Document doc = null;
        String responseStr = null;
        try {
        	cnt++;
			running = true;
			
            responseStr = SpringContextUtils.loadUtf8Resouce(filePath);
            doc = XmlUtil.readText(responseStr);
            ctx.setResponseEntry(doc.asXML());
        } catch (Exception e) {
            logger.warn("common.file_not_found:", filePath);
            throw new AresRuntimeException("common.file_not_found");
        }finally{
        	if (running) {
				running = false;// 释放线程锁
			}
			cnt -= 2;// 减法大于加法，可修正计数错误
			cnt = Math.max(0, cnt);// 并发线程结束
			
			logger.debug("\n==================行方前置--->手机银行: response start:==================\n{}", XmlUtil.formatXmlStr(responseStr));
			long end = new Date().getTime();
			logger.debug("交易【{}】 耗时 times:{} ms", transCode, (end - start));
			logger.debug("\n====================交易:【{}】 response end====================\n", transCode);
        }

        return true;
    }

}
