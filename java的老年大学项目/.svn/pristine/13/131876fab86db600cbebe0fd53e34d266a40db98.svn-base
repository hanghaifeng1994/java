package com.learnyeai.rabbitmq.util;

import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Calendar;

/**
 * Created by zpz on 2018/6/11.
 */

@Component
public class RabbitProductCache {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier(value = "redisTemplateMq")
    private RedisTemplate<String, Object> redisTemplate;

    @Value("${spring.application.name}")
    private String applicationName;

    private String cacheKey;

    @PostConstruct
    public void init(){
        cacheKey = applicationName;
        int idx = applicationName.lastIndexOf("_");

        if(idx > -1){
            cacheKey = applicationName.substring(0,idx);
        }
        cacheKey = cacheKey + "::MQ_product";
    }

    public String getCacheKey() {
        return cacheKey;
    }

    public boolean add(RabbitMetaMessage metaMessage){
        String id = metaMessage.getMsgId();
        metaMessage.setReturnCallback(false);
        if(metaMessage.getCreateDate() == null){
            metaMessage.setCreateDate(Calendar.getInstance().getTime());
        }

        try {
            redisTemplate.opsForHash().put(cacheKey, id, metaMessage);
            return true;
        }catch (Exception e){
            logger.info("redis mq添加消息失败 {} {}", id, e.getMessage());
        }
        return false;
    }
    public RabbitMetaMessage get(String msgId){
        RabbitMetaMessage metaMessage = null;
        try {
            metaMessage = (RabbitMetaMessage) redisTemplate.opsForHash().get(cacheKey, msgId);
            return metaMessage;
        }catch (Exception e){
            logger.info("redis mq获取消息失败 {} {}", msgId, e.getMessage());
        }
        return metaMessage;
    }
    public boolean del(String msgId){
        try {
            redisTemplate.opsForHash().delete(cacheKey, msgId);
            return true;
        }catch (Exception e){
            logger.info("redis mq删除消息失败 {} {}", msgId, e.getMessage());
        }
        return false;
    }

    public boolean confirm(String msgId){
        try {
            RabbitMetaMessage o = (RabbitMetaMessage)redisTemplate.opsForHash().get(cacheKey, msgId);
            o.setMsgStatus(1);
            redisTemplate.opsForHash().put(cacheKey, msgId, o);
            return true;
        }catch (Exception e){
            logger.info("redis mq保存消息失败 {} {}", msgId, e.getMessage());
        }
        return false;
    }
    public boolean fail(String msgId){
        try {
            RabbitMetaMessage o = (RabbitMetaMessage)redisTemplate.opsForHash().get(cacheKey, msgId);
            o.setMsgStatus(2);
            redisTemplate.opsForHash().put(cacheKey, msgId, o);
            return true;
        }catch (Exception e){
            logger.info("redis mq保存消息失败 {} {}", msgId, e.getMessage());
        }
        return false;
    }
    public RabbitMetaMessage rtn(String msgId){
        try {
            RabbitMetaMessage o = (RabbitMetaMessage)redisTemplate.opsForHash().get(cacheKey, msgId);
            o.setReturnDate(Calendar.getInstance().getTime());
            o.setReturnTimes(o.getReturnTimes()+1);
            redisTemplate.opsForHash().put(cacheKey, msgId, o);
            return o;
        }catch (Exception e){
            logger.info("redis mq添加消息失败 {} {}", msgId, e.getMessage());
        }
        return null;
    }

}
