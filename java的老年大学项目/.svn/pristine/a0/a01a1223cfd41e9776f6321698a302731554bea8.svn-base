package com.learnyeai.core.message.impl.jms.listener;

import com.learnyeai.core.message.monitor.MessageMonitorManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author zhanglong
 * @date 15/7/13
 */
public class JmsQueueListener implements MessageListener{

    private static Logger logger = LoggerFactory.getLogger(JmsQueueListener.class);

    protected static final SimpleMessageConverter messageConverter = new SimpleMessageConverter();

    public JmsQueueListener() {
        logger.info("JMS Queue 监听器启动");
    }

    public void onMessage(Message message) {
        try {
            Object obj = messageConverter.fromMessage(message);
            if(obj instanceof String) {
                String str = (String)obj;
                MessageMonitorManager.doMessage(str, 0);
            }
        } catch (JMSException e) {
            logger.error("消息监听器转换消息失败，详细错误为：" + e.getMessage());
        }
    }
}
