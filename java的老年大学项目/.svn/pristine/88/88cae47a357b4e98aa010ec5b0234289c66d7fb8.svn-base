/**
 * Copyright ©2015 上海屹通. All rights reserved.
 *  
 * @Title: NetTools4WebSoap.java
 * @Prject: mbank
 * @Description: TODO
 * @Package: cn.com.zhisou.ares.net.netTool
 * @author: 李朋飞（lpf@yitong.com.cn）
 * @date: 2015年8月27日 上午8:56:54
 * @version: V1.0
 */
package com.learnyeai.learnai.net.netTool;

import com.learnyeai.learnai.support.IBusinessContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.learnyeai.learnai.net.INetConfParser;
import com.learnyeai.learnai.net.INetConnect;
import com.learnyeai.learnai.net.INetTools;
import com.learnyeai.learnai.net.IRequstBuilder;
import com.learnyeai.learnai.net.IResponseParser;

/**
 * @ClassName: NetTools4WebSoap
 * @Description: TODO
 * @author: 李朋飞（lpf@yitong.com.cn）
 * @date: 2015年8月27日 上午8:56:54
 */
@Component
public class NetTools4WebSoap implements INetTools {
	@Autowired
	@Qualifier("netConfParser")
	INetConfParser confParser;
	@Autowired
	@Qualifier("netRequest4Soap")
	IRequstBuilder reqBuilder;
	@Autowired
    @Qualifier("netConnect4WebServiceTest")
	INetConnect connect;
	@Autowired
	@Qualifier("netResponse4Soap")
	IResponseParser rspParser;
	/*
	 * 
	 * (non Javadoc)
	 * @Title: execute
	 * @Description: TODO
	 * @param ctx
	 * @param transCode
	 * @return
	 * @see cn.com.zhisou.ares.base.INetTools#execute(cn.com.zhisou.ares.base.IBusinessContext, java.lang.String)
	 */
	@Override
	public boolean execute(IBusinessContext ctx, String transCode) {
		reqBuilder.buildSendMessage(ctx, confParser, transCode);
		connect.connect(ctx, transCode);
		rspParser.parserResponseData(ctx, confParser, transCode);
		return true;
	}


}
