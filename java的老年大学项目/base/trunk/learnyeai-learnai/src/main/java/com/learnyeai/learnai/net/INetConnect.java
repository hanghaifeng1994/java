package com.learnyeai.learnai.net;

import com.learnyeai.learnai.support.IBusinessContext;

public interface INetConnect {
	/**
	 * 生成请求报文
	 * 
	 * @param busiContext
	 * @param transCode
	 * @return
	 */
	public boolean connect(IBusinessContext busiContext, String transCode);

}
