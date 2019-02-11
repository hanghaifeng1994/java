package com.learnyeai.learnai.net;

import com.learnyeai.learnai.support.IBusinessContext;

/**
 * 报文构建器接口
 * 
 * @author yaoym
 * 
 */
public interface IRequstBuilder {
	/**
	 * 生成请求报文
	 * 
	 * @param busiContext
	 * @param transCode
	 * @return
	 */
	public boolean buildSendMessage(IBusinessContext busiContext,
			INetConfParser confParser, String transCode);
}