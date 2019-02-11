package com.learnyeai.learnai.net.netWay.socket;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.net.INetConnect;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.net.netMsg.iso8583.Iso8583Util;
import com.learnyeai.core.config.ConfigUtils;
import com.learnyeai.core.utils.SpringContextUtils;
import com.learnyeai.tools.common.StringUtils;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class NetConnect4SocketTest implements INetConnect {

	private Logger logger = LoggerFactory.getLogger(getClass());

    private static final String rootpath = "WEB-INF/data/xml/";
    private String template = "{0}{1}.xml";
    
    // 并发线程计数
 	private int cnt = 0;
 	
 	// 线程锁
 	private boolean running = false;

 	private int LIMIT = ConfigUtils.getValue("LIMIT_INTE_THREADS", 1);;

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

        // 当前缓存中没有配置信息进行加载
        Document doc = null;
        String responseStr = null;

		String filePath = "";
        try {
        	cnt++;
			running = true;

			// 输出请求报文
			Object req = ctx.getRequestEntry();
			logger.info("\n=========手机银行【{}】--->行方前置:request start ===============",transCode);
			logger.info("request data:{}", req.toString());
			logger.info("\n=========手机银行--->行方前置:request end   ===============");

			byte[] datas;
			if(req instanceof String ){
				filePath = StringUtils.message(template, rootpath, transCode);
				logger.debug("trans defined file :{}", filePath);
				responseStr = SpringContextUtils.loadUtf8Resouce(filePath);
//            	doc = XmlUtil.readText(responseStr);
//            	ctx.setResponseEntry(doc.asXML());
				ctx.setResponseEntry(responseStr);
				ctx.setResponseEntry(responseStr);
			}else {
				template = "{0}{1}.txt";
				filePath = StringUtils.message(template, rootpath, transCode);
				logger.debug("trans defined file :{}", filePath);
				responseStr = SpringContextUtils.loadUtf8Resouce(filePath);

				String head = responseStr.substring(0,10);
				String str8583 = responseStr.substring(10);//8583报文
				String  bitMap128 = str8583.substring(0,128);//128位图
				String data = str8583.substring(128);//数据区

				Iso8583Util iso8583Util = new Iso8583Util();
				byte[] headBytes = head.getBytes();
				byte[] bitMap = iso8583Util.get16BitByteFromStr(bitMap128);
				byte[] dataBytes = data.getBytes("UTF-8");
				//组装
				byte[] package8583=null;
				package8583= Iso8583Util.arrayApend(package8583, headBytes);
				package8583= Iso8583Util.arrayApend(package8583, bitMap);
				package8583= Iso8583Util.arrayApend(package8583, dataBytes);
				ctx.setResponseEntry(package8583);
			}
        } catch (Exception e) {
            logger.warn("common.file_not_found:", filePath);
            throw new AresRuntimeException("common.file_not_found");
        }finally{
        	if (running) {
				running = false;// 释放线程锁
			}
			cnt -= 2;// 减法大于加法，可修正计数错误
			cnt = Math.max(0, cnt);// 并发线程结束
			
			logger.debug("\n==================行方前置--->手机银行: response start:==================\n{}", responseStr);
			long end = new Date().getTime();
			logger.debug("交易【{}】 耗时 times:{} ms", transCode, (end - start));
			logger.debug("\n====================交易:【{}】 response end====================\n", transCode);
        }

        return true;
    }
}
