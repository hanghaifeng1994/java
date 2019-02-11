package com.learnyeai.learnai.session.vo;

/**
 * 简单通用的返回结果类
 * @author lc3@yitong.com.cn
 */
public class SimpleResult {

    /**
     * 成功状态
     */
    private boolean seccess = true;
    /**
     * 返回消息
     */
    private String msg;
    /**
     * 返回结果
     */
    private Object result;
    /**
     * 异常信息
     */
    private Throwable cause;

    public SimpleResult(boolean seccess, String msg, Throwable cause) {
        this.cause = cause;
        this.seccess = seccess;
        this.msg = msg;
    }

    public SimpleResult(boolean seccess, String msg, Object result) {
        this.result = result;
        this.seccess = seccess;
        this.msg = msg;
    }

    public SimpleResult(boolean seccess, String msg) {
        this.seccess = seccess;
        this.msg = msg;
    }

    public SimpleResult() {
    }

    public boolean isSeccess() {
        return seccess;
    }

    public SimpleResult setSeccess(boolean seccess) {
        this.seccess = seccess;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public SimpleResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getResult() {
        return result;
    }

    public SimpleResult setResult(Object result) {
        this.result = result;
        return this;
    }

    public Throwable getCause() {
        return cause;
    }

    public SimpleResult setCause(Throwable cause) {
        this.cause = cause;
        return this;
    }
}
