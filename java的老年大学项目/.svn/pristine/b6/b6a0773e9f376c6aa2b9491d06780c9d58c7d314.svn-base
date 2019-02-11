package com.learnyeai.rabbitmq.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by zpz on 2018/6/11.
 */

@Component
public class RabbitConsumerCache {
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
        cacheKey = cacheKey + "::MQ_consumer";
    }

    public long inc(String msgId){
        try {
            Long consumerCount = redisTemplate.opsForHash().increment(cacheKey,
                    msgId, 1);

            logger.info("当前消息ID:{} 消费次数：{}", msgId, consumerCount);
            return consumerCount;
        }catch (Exception e){
            logger.info("redis mq增加消费次数异常的{} {}", msgId, e.getMessage());
        }
        return -1;
    }
    public void del(String msgId){
        try {
            redisTemplate.opsForHash().delete(cacheKey, msgId);
        }catch (Exception e){
            logger.info("redis mq删除消费次数异常 {} {}", msgId, e.getMessage());
        }
    }
}
