package com.learnyeai.learnai.net.netWay.socket;

import com.learnyeai.learnai.net.INetConnect;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.core.config.ConfigUtils;
import com.learnyeai.tools.common.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.Socket;

@Component
public class NetConnect4Socket implements INetConnect {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	protected boolean isConnected; // 是否建立连接

	private String serverIP = ConfigUtils.getValue("QZ_SERVER_IP");

	private int serverPort = ConfigUtils.getValue("QZ_SERVER_PORT", 80);

	// 并发线程计数
	private int cnt = 0;
	
	// 线程锁
	private boolean running = false;

	private int LIMIT = ConfigUtils.getValue("LIMIT_INTE_THREADS", 1);;

	protected Socket socket;

	public NetConnect4Socket() {
	}

	public boolean connect(IBusinessContext ctx, String transCode) {
		cnt++;
		if (cnt > LIMIT && running) {
			// 激活线程锁
			logger.info("inte.service_busy {}", --cnt);
			// 抛出异常，服务正忙
			throw new AresRuntimeException("inte.service_busy");
		}
		
		long startTime = System.currentTimeMillis();
		String responseStr = null;
		String errorMsg = "net.response_is_empty" ;
		try {
			cnt++;
			running = true;
			Object req = ctx.getRequestEntry();
			logger.info("\n=========手机银行【{}】--->行方前置:request start ===============",transCode);
			logger.info("request data:{}",req.toString());
			logger.info("\n=========手机银行--->行方前置:request end   ===============");
			
			SocketClient client = new SocketClient(serverIP, serverPort);
			byte[] datas;
			if(req instanceof String ){
				datas = client.sendData(req.toString());
				responseStr = datas.toString();
				ctx.setResponseEntry(responseStr);
			}else {
				datas = client.sendBytesData((byte[])req);
				ctx.setResponseEntry(datas);
				responseStr = "true";
			}
			
			return true;
		} finally {
			if (running) {
				running = false;// 释放线程锁
			}
			cnt -= 2;// 减法大于加法，可修正计数错误
			cnt = Math.max(0, cnt);// 并发线程结束
			
			logger.info("\n=========行方前置--->手机银行 【{}】：response start===========",transCode);
			if (StringUtils.isBlank(responseStr)) {
				logger.info("net.response_is_empty {},{}", transCode,errorMsg);
				long end = System.currentTimeMillis();
				logger.info("{} 交易耗时:{} ms", transCode, (end - startTime));
				logger.info("\n====================行方前置--->手机银行:response  end=========================");
				throw new AresRuntimeException(errorMsg);
			}
			logger.info(responseStr);
			long endTime = System.currentTimeMillis();
			logger.info("{} 交易耗时:{} ms", transCode, (endTime - startTime));
			logger.info("\n====================行方前置--->手机银行:response  end=========================");
		}
	}

}
