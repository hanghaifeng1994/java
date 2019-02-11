/*
 * Copyright 2017-2018 the original author(https://github.com/wj596)
 * 
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */
package com.learnyeai.auth.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 响应封装
 * 
 * @author wangjie (https://github.com/wj596)
 * @date 2016年9月15日
 */
public class BaseResponse extends HashMap<String, Object> {

	private static final long serialVersionUID = 6272655632566784880L;

	// 成功响应
	public static final String RESPOND_SUCCEED = "1";
	// 失败响应
	public static final String RESPOND_FAILURE = "0";

	public static String message_code_key = "code";
	public static String message_msg_key = "message";
	public static String message_data_key = "data";

	private Map data = new HashMap();

	public BaseResponse(){
		this.put(message_data_key, data);
	}

	public static BaseResponse build() {
		return new BaseResponse();
	}
	
	public static BaseResponse ok() {
		BaseResponse baseReturn = new BaseResponse();
		baseReturn.put(message_code_key, RESPOND_SUCCEED);
		return baseReturn;
	}
	
	public static BaseResponse ok(String message) {
		BaseResponse baseReturn = new BaseResponse();
		baseReturn.put(message_code_key, RESPOND_SUCCEED);
		baseReturn.put(message_msg_key, message);
		return baseReturn;
	}
	
	public static BaseResponse fail() {
		BaseResponse baseReturn = new BaseResponse();
		baseReturn.put(message_code_key, RESPOND_FAILURE);
		return baseReturn;
	}
	
	public static BaseResponse fail(String message) {
		BaseResponse baseReturn = new BaseResponse();
		baseReturn.put(message_code_key, RESPOND_FAILURE);
		baseReturn.put(message_msg_key, message);
		return baseReturn;
	}

	public static BaseResponse fail(String code, String message) {
		BaseResponse baseReturn = new BaseResponse();
		baseReturn.put(message_code_key, code);
		baseReturn.put(message_msg_key, message);
		return baseReturn;
	}
	
	public BaseResponse message(String message) {
		this.put(message_msg_key, message);
		return this;
	}

	public BaseResponse add(String key,Object value) {
		this.data.put(key,value);
		return this;
	}
	public Map attributes(){
		return data;
	}
}