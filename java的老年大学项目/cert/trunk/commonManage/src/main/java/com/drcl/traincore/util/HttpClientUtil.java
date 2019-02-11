package com.drcl.traincore.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 和http server进行http通讯工具工具类
 *
 * @author yfang
 *
 */
public class HttpClientUtil {
	protected static final Log log = LogFactory.getLog(HttpClientUtil.class);
	private static final String ENCODING_UTF ="utf-8";

	/**
	 * 向一个url发送一个get请求
	 *
	 * @param url
	 * @author qianhb date: 2009.06.24
	 */
	public static synchronized void reqUrl(String url) {
		HttpClient client = new HttpClient();
		client.getHttpConnectionManager().getParams().setConnectionTimeout(500);  
		client.getHttpConnectionManager().getParams().setSoTimeout(500);
		GetMethod method = new GetMethod(url);
		BufferedReader br = null;

		try {
			int returnCode = client.executeMethod(method);
			if (returnCode == HttpStatus.SC_NOT_IMPLEMENTED) {
				System.err
						.println("The Post method is not implemented by this URI");
				// still consume the response body
				method.getResponseBodyAsString();
			} else {
				br = new BufferedReader(new InputStreamReader(method
						.getResponseBodyAsStream()));
				String readLine;
				while (((readLine = br.readLine()) != null)) {
					log.debug(readLine);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * 向一个url提交post请求，
	 * @param url
	 * @param paramsStr 参数串
	 * @param method
	 * @return String 请求后返回的串
	 */
	public static String post(String url, String paramsStr,
							  String method) throws Exception{

		HttpClient client = new HttpClient();
		client.getHttpConnectionManager().getParams().setConnectionTimeout(500);  
		client.getHttpConnectionManager().getParams().setSoTimeout(500);
		HttpMethod httpMethod = new PostMethod(url);

		if (method.equalsIgnoreCase("get")) {
			httpMethod = new GetMethod(url);
		}
		httpMethod.setQueryString(paramsStr);
		try {
			int returnCode = client.executeMethod(httpMethod);
			if (returnCode == HttpStatus.SC_OK) {
				return httpMethod.getResponseBodyAsString();
			}else if (returnCode == HttpStatus.SC_NOT_IMPLEMENTED) {
				System.err
						.println("The Post method is not implemented by this URI");
			}
		} catch (Exception e) {
			System.err.println(e);
			throw e;
		} finally {
			httpMethod.releaseConnection();
		}
		return "";
	}


	/**
	 * 从二位数组作为参数，先url post数据
	 * 编码方式utf-8
	 * @param url
	 * @param param
	 * @return 返回的全文
	 */
	public static String post(String url,String[][] param)throws Exception{
		HttpClient client = new HttpClient();
		client.getHttpConnectionManager().getParams().setConnectionTimeout(500);  
		client.getHttpConnectionManager().getParams().setSoTimeout(500);
		//client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 60000); 
		//client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 60000);
		PostMethod postMethod = new PostMethod(url);

		try {
			client.getParams().setContentCharset(ENCODING_UTF);// 设置编码

			for (String[] temp : param)
			{
				postMethod.addParameter(new NameValuePair(temp[0], temp[1]));// 传递文本框的username及values
			}

			int tmpStatusCode = client.executeMethod(postMethod);

			//如果成功返回
			if (tmpStatusCode == HttpStatus.SC_OK) {
				return postMethod.getResponseBodyAsString();

			} else {
				return "";
			}
		} catch (Exception e) {
			System.err.println(e);
			throw e;
		} finally {
			postMethod.releaseConnection();
		}
	}

	public static void main(String args[]) {
		// HttpClientUtil.logout();
	}
}
