package com.learnyeai.rabbitmq.util;

/**
 * Created by zpz on 2018/6/12.
 */
public class WeyeRabbitException extends Exception {
    public WeyeRabbitException() {
    }

    public WeyeRabbitException(String message) {
        super(message);
    }

    public WeyeRabbitException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeyeRabbitException(Throwable cause) {
        super(cause);
    }

    public WeyeRabbitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
