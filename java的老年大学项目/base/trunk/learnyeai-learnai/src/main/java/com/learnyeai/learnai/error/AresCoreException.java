package com.learnyeai.learnai.error;

import com.learnyeai.core.utils.MessageSoureUtil;
import com.learnyeai.learnai.consts.CoreR;

public class AresCoreException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	// 消息码
	private final String messageKey;

	// 已经用message-source处理的消息
	private String resolvedMessage;

	// 参数
	private Object args[];

	public AresCoreException(String messageKey) {
		super();
		this.messageKey = messageKey;
		this.args = CoreR.EMPTY_PARAMS;
	}

	public AresCoreException(String messageKey, Object... args) {
		super();
		this.messageKey = messageKey;
		this.args = args;
	}

	public AresCoreException(String messageKey, Throwable cause) {
		super(cause);
		this.messageKey = messageKey;
		this.args = CoreR.EMPTY_PARAMS;
	}

	public AresCoreException(String messageKey, Throwable cause, Object... args) {
		super(cause);
		this.messageKey = messageKey;
		this.args = args;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public String getResolvedMessage() {
		return resolvedMessage;
	}

	public void setResolvedMessage(String resolvedMessage) {
		this.resolvedMessage = resolvedMessage;
	}

	public Object[] getArgs() {
		return args;
	}


	@Override
	public String getMessage() {
		if(resolvedMessage == null){
			return MessageSoureUtil.getMessage(this.messageKey, args);
		}else {
			String msg = MessageSoureUtil.getMessage(this.messageKey, args);
			if(null != msg){
				return msg;
			}
		}

		return resolvedMessage;
	}
}
