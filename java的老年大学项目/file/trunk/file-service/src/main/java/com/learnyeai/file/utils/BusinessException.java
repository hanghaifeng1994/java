package com.learnyeai.file.utils;

/**
 * Created by zpz on 2018/9/1.
 */
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
