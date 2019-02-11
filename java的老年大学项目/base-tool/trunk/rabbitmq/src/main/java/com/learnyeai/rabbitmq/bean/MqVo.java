package com.learnyeai.rabbitmq.bean;

import java.io.Serializable;

/**
 * 所有消息bean都要继承此bean
 * Created by zpz on 2018/6/12.
 */
public class MqVo implements Serializable{
    private String cacheKey;    // 生产者队列缓存key，发消息时自动设置此key

    public String getCacheKey() {
        return cacheKey;
    }

    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }
}
