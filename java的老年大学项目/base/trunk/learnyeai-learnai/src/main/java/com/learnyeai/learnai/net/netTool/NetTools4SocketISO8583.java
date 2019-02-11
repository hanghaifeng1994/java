package com.learnyeai.learnai.net.netTool;

import com.learnyeai.learnai.support.IBusinessContext;
import org.springframework.stereotype.Component;

import com.learnyeai.learnai.net.INetConfParser;
import com.learnyeai.learnai.net.INetConnect;
import com.learnyeai.learnai.net.INetTools;
import com.learnyeai.learnai.net.IRequstBuilder;
import com.learnyeai.learnai.net.IResponseParser;

@Component
public class NetTools4SocketISO8583 implements INetTools {

//	@Autowired
//	@Qualifier("netConfParser")
	INetConfParser confParser;
//	@Autowired
//	@Qualifier("netRequest8583")
	IRequstBuilder reqBuilder;
//	@Autowired
//    @Qualifier("netConnect4SocketTest")
//	@Qualifier("netConnect4Socket")
	INetConnect connect;
//	@Autowired
//	@Qualifier("netResponse8583")
	IResponseParser rspParser;

	@Override
	public boolean execute(IBusinessContext ctx, String transCode) {
		reqBuilder.buildSendMessage(ctx, confParser, transCode);
		connect.connect(ctx, transCode);
		rspParser.parserResponseData(ctx, confParser, transCode);
		return true;
	}

}
