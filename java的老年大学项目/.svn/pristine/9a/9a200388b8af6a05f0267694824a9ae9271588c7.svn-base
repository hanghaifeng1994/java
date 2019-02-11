package com.learnyeai.rabbitmq.result;

import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import com.learnyeai.rabbitmq.util.RabbitProductCache;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zpz on 2018/6/25.
 */
@Component
public class MqResultTask {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MqResultDeal resultDeal;

    @Autowired
    @Qualifier(value = "redisTemplateMq")
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RabbitProductCache rabbitProductCache;
    private ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
    private CountDownLatch endCount;

    public void reDoAll(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        MDC.put("transCode", "mq/send");
        logger.info("定时重新处理消息开始");
        // ，LastDate 为空或、要大于10分钟
        Set<Object> keys = redisTemplate.opsForHash().keys(rabbitProductCache.getCacheKey());
        ArrayList<Object> listKey = new ArrayList();

        endCount = new CountDownLatch(keys.size());
        for(Iterator<Object> it = keys.iterator(); it.hasNext();){
            Object key = it.next();
            listKey.add(key);
            // 一次处理30个
            if(listKey.size() <= 30)
                continue;

            try{
                List<Object> listMsg = redisTemplate.opsForHash().multiGet(rabbitProductCache.getCacheKey(), listKey);
                listKey.clear();
                toDo(listMsg);

            }catch (Exception e){
                for (int i=0; i< listKey.size(); i++){
                    endCount.countDown();
                }
                listKey.clear();
                logger.error("获取缓存数据失败", e);
            }
        }
        // 处理最后记录
        try{
            List<Object> listMsg = redisTemplate.opsForHash().multiGet(rabbitProductCache.getCacheKey(), listKey);
            listKey.clear();
            toDo(listMsg);

        }catch (Exception e){
            for (int i=0; i< listKey.size(); i++){
                endCount.countDown();
            }
            listKey.clear();
            logger.error("获取缓存数据失败", e);
        }
        try {
            endCount.await();
            logger.info("定时重新处理消息结束，总共处理 {} 个消息", keys.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    private void toDo(List<Object> listMsg){
        for (Object o : listMsg) {
            if(!(o instanceof RabbitMetaMessage)){
                endCount.countDown();
                continue;
            }
            RabbitMetaMessage msg = (RabbitMetaMessage)o;
            fixedThreadPool.execute(()->{
                try {
                    resultDeal.deal(msg);
                }catch (Exception e){
                    logger.error("重新处理消息失败" + msg.getMsgId(), e);
                }
                endCount.countDown();
            });
        }

    }
}
