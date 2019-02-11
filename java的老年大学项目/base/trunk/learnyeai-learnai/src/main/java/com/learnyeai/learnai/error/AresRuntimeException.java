package com.learnyeai.learnai.error;

import com.learnyeai.core.exception.BusinessException;
import com.learnyeai.core.utils.MessageSoureUtil;

public class AresRuntimeException extends BusinessException {

	private static final long serialVersionUID = 1L;

	// 参数
	private Object args[];

	public AresRuntimeException() {
		super();
		this.messageCode = "999";
	}

	public AresRuntimeException(String messageKey) {
		super();
		if(null != messageKey)
			this.messageCode = messageKey;
		this.args = emptyargs;
	}

	public AresRuntimeException(String messageKey, Object... args) {
		super();
		this.messageCode = messageKey;
		this.args = args;
	}

	public AresRuntimeException(String messageKey, Throwable cause) {
		super(messageKey, cause);
		this.args = emptyargs;
	}

	public AresRuntimeException(String messageKey, Throwable cause,
			Object... args) {
		super(messageKey,cause);
		this.args = args;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public String getMessage() {
		if(message == null){
			return MessageSoureUtil.getMessage(this.messageCode, args);
		}else {
			String msg = MessageSoureUtil.getMessage(this.messageCode, args);
			if(null != msg){
				return msg;
			}
		}

		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object[] getArgs() {
		return args;
	}

	public AresRuntimeException iniMessage(String message) {
		this.message = message;
		return this;
	}
	public AresRuntimeException iniData(Object data) {
		this.data = data;
		return this;
	}

	public AresRuntimeException iniCauseMsg(String causeMsg) {
		this.causeMsg = causeMsg;
		return this;
	}
	public static AresRuntimeException build(String code){
		return new AresRuntimeException(code);
	}
	public static AresRuntimeException build(String code, String msg){
		AresRuntimeException e = new AresRuntimeException(code);
		e.setMessage(msg);
		return e;
	}
}