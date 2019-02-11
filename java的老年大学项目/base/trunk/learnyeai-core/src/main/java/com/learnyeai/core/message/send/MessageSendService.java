package com.learnyeai.core.message.send;

/**
 * Created by winkie on 15/6/29.
 */
public interface MessageSendService {

    /**
     * 发送消息 一发多收
     * @param pipeName 通道名
     * @param message 消息体（业务名 + “：” + 消息内容）
     */
    public <T> void sendTopic(String pipeName, T message);

    /**
     * 发送消息 一发一收
     * @param pipeName 通道名
     * @param message 消息体（业务名 + “：” + 消息内容）
     */
    public <T> void sendQueue(String pipeName, T message);
}
