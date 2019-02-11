package com.learnyeai.core.message.impl.jms.send;

import com.learnyeai.core.message.send.MessageSendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;

import javax.annotation.Resource;

/**
 * Created by winkie on 15/6/29.
 */
public class JmsMessageSend implements MessageSendService {

    private static Logger logger = LoggerFactory.getLogger(JmsMessageSend.class);

    @Resource(name = "jmsQueueTemplate")
    private JmsTemplate jmsQueueTemplate;

    @Resource(name = "jmsTopicTemplate")
    private JmsTemplate jmsTopicTemplate;

    @Override
    public <T> void sendTopic(String pipeName, T message) {
        if(null == pipeName) {
            logger.error("发送 Topic 消息失败，消息队列名称不能为空。");
        }
        try {
            logger.info("开始发送 Topic 消息，消息队列名称===" + pipeName);
            jmsTopicTemplate.convertAndSend(pipeName, message);
        } catch (JmsException e) {
            logger.error("发送 Topic 消息失败，详细错误为：" + e.getMessage());
        }
    }

    @Override
    public <T> void sendQueue(String pipeName, T message) {
        if(null == pipeName) {
            logger.error("发送 Queue 消息失败，消息队列名称不能为空。");
        }
        try {
            logger.info("开始发送 Queue 消息，消息队列名称===" + pipeName);
            jmsQueueTemplate.convertAndSend(pipeName, message);
        } catch (JmsException e) {
            logger.error("发送 Queue 消息失败，详细错误为：" + e.getMessage());
        }
    }
}
