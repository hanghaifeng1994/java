package com.drcl.traincore.util;

import java.io.IOException;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpPostDiagramUtils {
	private static RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000).build();

	public static String post(String url, String json) {
		CloseableHttpClient httpClient = HttpClients.custom().build();
		ResponseHandler<String> responseHandler = new BasicResponseHandler();
		HttpPost httpPost = new HttpPost(url);
		try {
			httpPost.setConfig(requestConfig);
			StringEntity requestEntity = new StringEntity(json,"utf-8");  
	        requestEntity.setContentEncoding("UTF-8");                
	        httpPost.setHeader("Content-type", "application/json");  
	        httpPost.setEntity(requestEntity);  
			return httpClient.execute(httpPost, responseHandler);
			//final HttpEntity entity = response.getEntity();
			//final String rs = EntityUtils.toString(entity, "UTF-8");
		//	EntityUtils.consume(entity);
			//return rs;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			HttpClientUtils.closeQuietly(httpClient);
		}
		return null;
	}
}
