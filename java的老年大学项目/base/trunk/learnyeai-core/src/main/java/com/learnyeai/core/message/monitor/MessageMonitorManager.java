package com.learnyeai.core.message.monitor;

import com.learnyeai.core.message.listener.MessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhanglong
 * @date 15/7/14
 */
public class MessageMonitorManager {

    private static final Logger logger = LoggerFactory.getLogger(MessageMonitorManager.class);

    private static final Map<String, Set<MessageListener>> messageListeners = new HashMap();

    private static int queueIndex = 1;

    /**
     * 注册监听
     * @param pipeName 通道名
     * @param messageListener 监听的listener
     */
    public static void registerMessageListener(String pipeName, MessageListener messageListener) {
        synchronized(messageListeners) {
            if(null != messageListeners) {
                Set listenerSet = messageListeners.get(pipeName);
                if(null == listenerSet) {
                    listenerSet = new LinkedHashSet();
                }
                listenerSet.add(messageListener);
                messageListeners.put(pipeName, listenerSet);
            }
        }
    }

    /**
     * 收到消息 解析 并发送给相应的实现处理
     * @param receiveMessage 业务名+消息内容 如：数据字典变更，DICT_CHANGE：USER_STATUS，
     *                       前面是业务名，后面是数据字典的type,消息具体内容是接收方和发送方协商。
     * @param sign 0：表示 queue 单发单收  1：表示 topic 单发多收
     */
    public static void doMessage(String receiveMessage, int sign) {
        String[] message = receiveMessage.split(":");
        if(null != message && message.length == 2) {
            String pipeName = message[0];
            String body = message[1];
            Set<MessageListener> messageListenerSet = messageListeners.get(pipeName);
            if(null != messageListenerSet) {
                int index = 1;
                int listenerCnt = messageListenerSet.size();
                if(queueIndex > listenerCnt) {
                    queueIndex = 1;
                }
                for (MessageListener listener : messageListenerSet) {
                    try {
                        if(0 == sign) {
                            if(index == queueIndex) {
                                listener.onDo(body);
                                queueIndex++;
                                return;
                            }
                            index++;
                        }else {
                            listener.onDo(body);
                        }
                    } catch (Exception e) {
                        if (logger.isWarnEnabled()) {
                            logger.warn("通道名：" + pipeName + "，消息:" + body + ",处理异常", e);
                        }
                    }
                }
            }
        }
    }
}
