/**
 * Copyright ©2015 上海屹通. All rights reserved.
 *  
 * @Title: NetConnect4WebService.java
 * @Prject: mbank
 * @Description: TODO
 * @Package: cn.com.zhisou.ares.net.netWay.webservice
 * @author: 李朋飞（lpf@yitong.com.cn）
 * @date: 2015年8月27日 上午8:59:21
 * @version: V1.0
 */
package com.learnyeai.learnai.net.netWay.webservice;

import java.util.Date;

import com.learnyeai.learnai.net.INetConnect;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.core.utils.SpringContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.tools.common.StringUtils;

/**
 * @ClassName: NetConnect4WebServiceTest
 * @Description: TODO 测试
 * @author: 李朋飞（lpf@yitong.com.cn）
 * @date: 2015年8月27日 上午8:59:21
 */
@Controller
public class NetConnect4WebServiceTest implements INetConnect {
	/**
	 * @FieldName: logger
	 * @FieldType: Logger
	 * @Description: 日志
	 */
	private Logger logger = LoggerFactory.getLogger(getClass());
    private static final String rootpath = "data/soap/";
    private String template = "{0}{1}.xml";
	/*
	 * 
	 * (non Javadoc)
	 * @Title: connect
	 * @Description: TODO
	 * @param ctx
	 * @param transCode
	 * @return
	 * @see cn.com.zhisou.ares.base.INetConnect#connect(cn.com.zhisou.ares.base.IBusinessContext, java.lang.String)
	 */
	@Override
	public boolean connect(IBusinessContext ctx, String transCode) {
		long start = new Date().getTime();
		String responseStr = null;
		try {
			String xmlStr = (String) ctx.getRequestEntry();
			logger.debug("Webservice request is:\n{}", xmlStr);
			String filePath = StringUtils.message(template, rootpath, transCode);
			logger.debug("Webservice resource filePath is:{}",filePath);
			responseStr = SpringContextUtils.loadUtf8Resouce(filePath);
			logger.debug("Webservice response is:\n{}", responseStr);
			ctx.setResponseEntry(responseStr);
			return true;
		}catch(Exception e){
			logger.error("Read local resource exception", e);
			throw new AresRuntimeException("Net.connect_error");
		}finally {
			long end = new Date().getTime();
			logger.debug("{} Times:{} ms", "localhost", (end - start));
		}
	}
}
