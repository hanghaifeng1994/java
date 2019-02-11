package com.learnyeai.core.support;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * service 返回的异常
 * Created by zpz on 2018/4/26.
 */
public class ApiResult<T> {

    /** 错误码. */
    private String code;

    /** 提示信息. */
    private String message;

    /** 具体的内容. */
    private T data;

    public ApiResult(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public ApiResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess(){
        return RS_SUCESS.equals(this.code);
    }

    // 系统错误，code为4xx 5xx
    public static Pattern sys_err_pattern = null;
    public static boolean isSystemEx(String code){
        if(null == sys_err_pattern){
            sys_err_pattern = Pattern.compile("[45]\\d\\d");
        }
        Matcher match = sys_err_pattern.matcher(code);
        return match.matches();
    }

    public static ApiResult fail(String code, String message) {
        return new ApiResult(code, message);
    }

    /**
     * 内部异常，编码为
     * @param message
     * @return
     */
    public static ApiResult fail(String message){
        return new ApiResult(RS_ERR_CODE, message);
    }

    // 成功code值
    public static final String RS_SUCESS = "1"; // 成功
    public static final String RS_ERR_CODE = "999";   // 代码异常，只是为了通知调用者


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
