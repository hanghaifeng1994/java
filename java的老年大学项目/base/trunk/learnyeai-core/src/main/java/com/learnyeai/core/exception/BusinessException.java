package com.learnyeai.core.exception;

import com.learnyeai.core.support.ApiResult;
import com.learnyeai.core.utils.MessageSoureUtil;

/**
 * Created by zpz on 2018/4/28.
 */
public class BusinessException extends RuntimeException{
    // 消息码
    protected String messageCode = ApiResult.RS_ERR_CODE;
    protected String message;
    protected Object data; // 错误数据
    protected String causeMsg; // 原始错误

    protected final static Object[] emptyargs = new Object[]{};

    public BusinessException() {
        this.messageCode = ApiResult.RS_ERR_CODE;
    }
    public BusinessException(String messageCode) {
        this.messageCode = messageCode;
    }

    public BusinessException(String messageCode, String message) {
        super(message);
        this.message = message;
        this.messageCode = messageCode;
    }

    public BusinessException(String messageCode,Throwable cause) {
        super(cause);
        this.messageCode = messageCode;
        this.causeMsg = cause.getMessage();
    }

    @Override
    public String getMessage() {
        if(null == message)
            return super.getMessage();
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCauseMsg() {
        return causeMsg;
    }

    public void setCauseMsg(String causeMsg) {
        this.causeMsg = causeMsg;
    }
}
