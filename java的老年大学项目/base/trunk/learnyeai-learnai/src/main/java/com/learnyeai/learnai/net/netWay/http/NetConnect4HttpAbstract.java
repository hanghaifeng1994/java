package com.learnyeai.learnai.net.netWay.http;

import com.learnyeai.learnai.net.INetConnect;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.net.netConf.NetConst;
import com.learnyeai.tools.common.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * http post通用请求
 */
public abstract class NetConnect4HttpAbstract implements INetConnect {

	private Logger logger = LoggerFactory.getLogger(getClass());

	// 获取请求url
	protected abstract String getServerURL();

	/**
	 * http post 请求
	 * @param ctx
	 * 	TRAN_URL
	 * 	ctx.getRequestEntry()
	 * @param transCode
	 * @return
     */
	@Override
	public boolean connect(IBusinessContext ctx, String transCode) {
		// 测试请求报文生成
		long startTime = System.currentTimeMillis();

		HttpURLConnection httpConn = null;
		OutputStreamWriter out = null;
		BufferedReader in = null;
		String responseStr = null;
		String errorMsg = "net.response_is_empty" ;

		String url = StringUtils.message(getServerURL(),
				ctx.getParam(NetConst.TRAN_URL, "undefined"));
		logger.debug("inte url:{}", url);
		try {
			
			URL urlClient = new URL(url);
			httpConn = (HttpURLConnection) urlClient.openConnection();
			setHttpConnection(httpConn);
			showHttpRequestHeaders(httpConn);
			String xmlStr = (String) ctx.getRequestEntry();
			logger.info("\n=========request start ===============",transCode);
			logger.info("request data:{}",xmlStr);
			logger.info("\n=========request end   ===============");
			// 获取URLConnection对象对应的输出流
			out = new OutputStreamWriter(httpConn.getOutputStream(),"utf-8");
			// 发送请求参数
			out.write(xmlStr);
			out.flush();

			in = new BufferedReader(new InputStreamReader(
					httpConn.getInputStream(), NetConst.UTF_8));
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
			ctx.setResponseEntry(responseStr);
			showHttpResponseHeaders(httpConn);
			return true;
		} catch (MalformedURLException e) {
			logger.error(getServerURL(), e);
			throw new AresRuntimeException("net.connect_error");
		} catch (IOException e) {
			logger.error(getServerURL(), e);
			throw new AresRuntimeException("net.connect_error");
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			
			logger.info("\n=========response start===========",transCode);
			if (StringUtils.isBlank(responseStr)) {
				logger.info("net.response_is_empty {},{}", transCode,errorMsg);
				long end = System.currentTimeMillis();
				logger.info("{} 交易耗时:{} ms", transCode, (end - startTime));
				logger.info("\n====================response  end=========================");
				throw new AresRuntimeException(errorMsg);
			}
			long endTime = System.currentTimeMillis();
			logger.info("{} 交易耗时:{} ms", transCode, (endTime - startTime));
			logger.info("\n====================response  end=========================");
		}
	}

	/**
	 * 测试请求头
	 * 
	 * @param httpConn
	 */
	protected void showHttpResponseHeaders(HttpURLConnection httpConn) {
		if (logger.isDebugEnabled()) {
			logger.debug("response headers:{}", httpConn.getHeaderFields());
		}
	}

	/**
	 * 请求头
	 * 
	 * @param httpConn
	 */
	protected void showHttpRequestHeaders(HttpURLConnection httpConn) {
		if (logger.isDebugEnabled()) {
			logger.debug("request headers:{}", httpConn.getRequestProperties());
		}
	}

	/**
	 * 设置请求属性信息，默认json
	 * 
	 * @param httpConn
	 * @throws ProtocolException
	 */
	protected void setHttpConnection(HttpURLConnection httpConn)
			throws ProtocolException{
		httpConn.setRequestMethod("POST");
		httpConn.setConnectTimeout(30000);
		httpConn.setReadTimeout(10000);
		httpConn.setRequestProperty("Connection", "keep-alive");
		httpConn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
		httpConn.setRequestProperty(
				"User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/14.0.803.0 Safari/535.1");


		httpConn.setRequestProperty("Content-Type", "application/json");
		httpConn.setRequestProperty("Accept", "application/json");
		httpConn.setDoInput(true);
		httpConn.setDoOutput(true);
	}

	protected void setHttpConnection4Xml(HttpURLConnection httpConn)
			throws ProtocolException {
		httpConn.setRequestProperty("Content-Type", "application/xml");
		httpConn.setRequestProperty("Accept", "application/xml");
	}
	protected void setHttpConnection4Json(HttpURLConnection httpConn)
			throws ProtocolException {
		httpConn.setRequestProperty("Content-Type", "application/json");
		httpConn.setRequestProperty("Accept", "application/json");
	}

}
