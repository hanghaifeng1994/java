package com.learnyeai.rabbitmq.result;

import com.learnyeai.core.utils.SpringContextUtils;
import com.learnyeai.rabbitmq.listener.AbstractMessageResultListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 缓存生产者所有消息处理结果“监听”
 * Created by zpz on 2018/6/12.
 */
@Component
public class MessageResultListenerMap {
    private static Map<String, AbstractMessageResultListener> resultListenerMap = new HashMap();

    @Autowired
    private SpringContextUtils springContextUtils;
    @PostConstruct
    public void init(){
        Map<String, AbstractMessageResultListener> list = springContextUtils.getApplicationContext().getBeansOfType(AbstractMessageResultListener.class);
        for(Iterator<AbstractMessageResultListener> it = list.values().iterator(); it.hasNext();){
            AbstractMessageResultListener o = it.next();
            resultListenerMap.put(o.getQueueKey(), o);
        }

    }

    public AbstractMessageResultListener getListener(String key){
        if(resultListenerMap.containsKey(key)){
            return resultListenerMap.get(key);
        }
        return null;
    }
}
