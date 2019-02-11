package com.learnyeai.rabbitmq.consumer.demo.mq;

import com.learnyeai.rabbitmq.bean.MqVo;

/**
 * Created by zpz on 2018/6/13.
 */
public class DemoMq extends MqVo {
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
