package com.drcl.traincore.util.im.vo;

import java.util.List;
import java.util.Map;

public class ResponseVO {
	Map<String, String> data;//
	String message;//
	String success;//
	public Map<String, String> getData() {
		return data;
	}
	public void setData(Map<String, String> data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	
}
