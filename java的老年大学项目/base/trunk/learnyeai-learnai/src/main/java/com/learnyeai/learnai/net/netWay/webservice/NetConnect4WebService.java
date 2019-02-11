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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;

import com.learnyeai.learnai.net.INetConnect;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.core.config.ConfigUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.net.netConf.NetConst;

/**
 * @ClassName: NetConnect4WebService
 * @Description: TODO
 * @author: 李朋飞（lpf@yitong.com.cn）
 * @date: 2015年8月27日 上午8:59:21
 */
@Controller
public class NetConnect4WebService implements INetConnect {
	/**
	 * @FieldName: logger
	 * @FieldType: Logger
	 * @Description: 日志
	 */
	private Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * @FieldName: serverURL
	 * @FieldType: String
	 * @Description:webservice地址
	 */
	private String serverURL = ConfigUtils.getValue("WEBSERVICE_URL");
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
		// 测试请求报文生成
		long start = new Date().getTime();
		// XML to JSON
		HttpURLConnection httpConn = null;
		PrintWriter out = null;
		BufferedReader in = null;
		String responseStr = null;

		String url = String.format(serverURL, transCode);
		logger.debug("webservice url:{}", url);
		try {
			URL urlClient = new URL(url);
			httpConn = (HttpURLConnection) urlClient.openConnection();
			setHttpConnection(httpConn);
			showHttpRequestHeaders(httpConn);
			String xmlStr = (String) ctx.getRequestEntry();
			logger.debug("webservice request is:\n{}", xmlStr);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(httpConn.getOutputStream());
			// 发送请求参数
			out.print(xmlStr);
			out.flush();

			in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), NetConst.UTF_8));
			StringBuffer sb = new StringBuffer();
			String line;
			boolean firstLine = true;
			while ((line = in.readLine()) != null) {
				if (firstLine) {
					firstLine = false;
				} else {
					sb.append("\n");
				}
				sb.append(line);
			}
			responseStr = sb.toString();
			logger.debug("webservice response is:\n{}", responseStr);
			showHttpResponseHeaders(httpConn);
			ctx.setResponseEntry(responseStr);
			return true;
		} catch (MalformedURLException e) {
			logger.error(serverURL, e);
			throw new AresRuntimeException("net.connect_error");
		} catch (IOException e) {
			logger.error(serverURL, e);
			throw new AresRuntimeException("net.connect_error");
		} finally {
			long end = new Date().getTime();
			logger.debug("{} times:{} ms", serverURL, (end - start));
			if (out != null) {
				out.close();
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
	}

	/**
	 * 
	 * @Title: showHttpResponseHeaders
	 * @Description: TODO 测试请求头
	 * @param httpConn
	 */
	private void showHttpResponseHeaders(HttpURLConnection httpConn) {
		if (logger.isDebugEnabled()) {
			logger.debug("response headers:{}", httpConn.getHeaderFields());
		}
	}

	/**
	 * 
	 * @Title: showHttpRequestHeaders
	 * @Description: TODO 请求头
	 * @param httpConn
	 */
	private void showHttpRequestHeaders(HttpURLConnection httpConn) {
		if (logger.isDebugEnabled()) {
			logger.debug("request headers:{}", httpConn.getRequestProperties());
		}
	}

	/**
	 * 
	 * @Title: setHttpConnection
	 * @Description: TODO 设置请求属性信息
	 * @param httpConn
	 * @throws ProtocolException
	 */
	private void setHttpConnection(HttpURLConnection httpConn)throws ProtocolException {
		httpConn.setRequestMethod("POST");
		httpConn.setConnectTimeout(30000);
		httpConn.setReadTimeout(10000);
		httpConn.setRequestProperty("Connection", "keep-alive");
		httpConn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
		httpConn.setRequestProperty("Content-Type", "application/soap+xml");
		httpConn.setRequestProperty("Accept", "application/xml");
		httpConn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/14.0.803.0 Safari/535.1");
		httpConn.setDoInput(true);
		httpConn.setDoOutput(true);
	}

}
