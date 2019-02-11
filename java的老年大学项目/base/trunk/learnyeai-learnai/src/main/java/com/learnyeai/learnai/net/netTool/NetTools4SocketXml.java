package com.learnyeai.learnai.net.netTool;

import com.learnyeai.learnai.net.INetConfParser;
import com.learnyeai.learnai.net.INetConnect;
import com.learnyeai.learnai.net.INetTools;
import com.learnyeai.learnai.net.IResponseParser;
import com.learnyeai.learnai.support.IBusinessContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.learnyeai.learnai.net.IRequstBuilder;

@Component
public class NetTools4SocketXml implements INetTools {

	@Autowired
	@Qualifier("netConfParser")
	INetConfParser confParser;
	@Autowired
	@Qualifier("netRequest4Xml")
	IRequstBuilder reqBuilder;
	@Autowired
    @Qualifier("netConnect4SocketTest")
	//	@Qualifier("netConnect4Socket")
			INetConnect connect;
	@Autowired
	@Qualifier("netResponse4Xml")
	IResponseParser rspParser;

	@Override
	public boolean execute(IBusinessContext ctx, String transCode) {
		reqBuilder.buildSendMessage(ctx, confParser, transCode);
		connect.connect(ctx, transCode);
		rspParser.parserResponseData(ctx, confParser, transCode);
		return true;
	}

}
