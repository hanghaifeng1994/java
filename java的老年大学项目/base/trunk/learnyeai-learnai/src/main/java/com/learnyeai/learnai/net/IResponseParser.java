package com.learnyeai.learnai.net;

import com.learnyeai.learnai.support.IBusinessContext;

public interface IResponseParser {

	/**
	 * 响应报文解析
	 * 
	 * @param busiContext
	 * @param transCode
	 * @return
	 */
	public boolean parserResponseData(IBusinessContext busiContext,
			INetConfParser confParser, String transCode);

}