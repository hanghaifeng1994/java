package com.learnyeai.rabbitmq.result;

import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import com.learnyeai.rabbitmq.listener.AbstractMessageResultListener;
import com.learnyeai.rabbitmq.sender.RabbitSender;
import com.learnyeai.rabbitmq.util.MQConstants;
import com.learnyeai.rabbitmq.util.RabbitProductCache;
import com.learnyeai.tools.common.DateHelper;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.google.common.base.Predicates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zpz on 2018/6/23.
 */
@Component
public class MqResultDeal {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RabbitProductCache rabbitProductCache;
    @Autowired
    private MessageResultListenerMap messageResultListenerMap;
    @Autowired
    RabbitSender rabbitSender;
    @Autowired
    @Qualifier(value = "redisTemplateMq")
    private RedisTemplate<String, Object> redisTemplate;

    @PostConstruct
    private void init(){
        // 启一个线程处理队列。
        ResultQueueThread aa = new ResultQueueThread();
        aa.start();
    }

    /**
     *
     * @param metaMessage
     * @return 返回false会重试
     *  返回true，结束
     */
    private boolean toDo(RabbitMetaMessage metaMessage){
        if(metaMessage.getMsgStatus() == 2){ // 处理失败，不再处理
            return true;
        }

        String cacheKey = metaMessage.getMsgId();

        if(metaMessage.getMsgStatus() == 3){ // 重新发送
            try {
                logger.info("手动重新发送 {}", cacheKey);
                //重发消息，
                rabbitSender.reSendMsg(cacheKey, metaMessage);
            }catch (Exception e){
                logger.error("手动重发消息失败{} {}", cacheKey, e.getMessage());
            }
            return true;
        }

        Date curDate = Calendar.getInstance().getTime();
        int secMargin = DateHelper.getDateMargin(metaMessage.getLastDealMsgDate(), curDate,Calendar.SECOND);
        int hMargin = DateHelper.getDateMargin(metaMessage.getCreateDate(), curDate,Calendar.HOUR);
        if(hMargin > MQConstants.MAX_OVERRUN_HOUR){
            logger.warn("消息超过{} 小时，不处理", MQConstants.MAX_OVERRUN_HOUR);
            return true;
        }
        int maxTime = 10 * 60;
        // 长时间未确认，再次发送，否则等待
        // 定时器时间间隔为10分钟，所以如果没确认，每次都会发送
        if(metaMessage.getMsgStatus() == 0){
            if(secMargin > 2 * 60){ // 2分钟没有确认，肯定有问题
                try {
                    logger.info("长时间未确认,重新发送 {}", cacheKey);
                    //重发消息，
                    rabbitSender.reSendMsg(cacheKey, metaMessage);
                }catch (Exception e){
                    logger.error("重发消息失败{} {}", cacheKey, e.getMessage());
                }
                return true;
            }
            logger.error("未确认等待 {}", cacheKey);
            return false;
        }

        // 长久未处理，可能是消费服务停了，要继续等待
        // 未处理返回，
        if(metaMessage.getDealStatus() == 0){
            /*if(margins > maxTime){
                try {
                    logger.info("长时间未处理,重新发送 {}", cacheKey);
                    //重发消息，
                    rabbitSender.reSendMsg(cacheKey, metaMessage);
                }catch (Exception e){
                    logger.error("长时间未处理{} {}", cacheKey, e.getMessage());
                }
                return true;
            }*/
            // 短时间未处理，等待
            return false;
        }

        // 死信
        if(metaMessage.getDealStatus() == 3 ){
            try {
                logger.info("进入死信队列或未确认,重新发送 {}", cacheKey);
                //重发消息，
                rabbitSender.reSendMsg(cacheKey, metaMessage);
            }catch (Exception e){
                logger.error("重发消息失败{} {}", cacheKey, e.getMessage());
            }
            return true;
        }

        // 处理结果
        AbstractMessageResultListener listener = messageResultListenerMap.getListener(metaMessage.getExchange() + "_" + metaMessage.getRoutingKey());
        if(listener != null){
            listener.doResult(metaMessage);
        }else { // 删除缓存中的消息
            logger.info("结果回调，没有监听处理 {}", cacheKey);
            try{
                rabbitProductCache.del(cacheKey);
            }catch (Exception e){
                logger.error("处理失败 " + cacheKey, e);
            }

        }
        return true;
    }
    public boolean deal(RabbitMetaMessage metaMessage){

        metaMessage.setFailTimes(metaMessage.getFailTimes()+1);
        metaMessage.setReturnTimes(0);
        rabbitProductCache.add(metaMessage);

        String cacheKey = metaMessage.getMsgId();

        class ReDealThread implements Callable {

            String msgId;

            public ReDealThread(String msgId) {
                this.msgId = msgId;
            }

            @Override
            public Boolean call() throws Exception {
                // 判断处理状态如果是未处理return false，否则处理
                try{
                    RabbitMetaMessage message = rabbitProductCache.get(msgId);
                    return toDo(message);
                }catch (Exception e){
                    return false;
                }
            }
        }

        Retryer<Boolean> retryer = RetryerBuilder
                .<Boolean>newBuilder()
                //抛出runtime异常、checked异常时都会重试，但是抛出error不会重试。
                .retryIfException()
                .retryIfResult(Predicates.equalTo(false))
                //重试策略  100ms*2^n 最多10s
                .withWaitStrategy(WaitStrategies.exponentialWait(200,
                        1, TimeUnit.SECONDS))
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                .build();

        ReDealThread reSendThread = new ReDealThread(cacheKey);
        try {
            boolean isOk = retryer.call(reSendThread);
            //未发送成功，入死信队列
            if(!isOk) {
                logger.error("处理消息异常 {}", cacheKey);
            }
        } catch (Exception e) {
            logger.error("处理消息异常 " + cacheKey, e);
        }

        metaMessage.setLastDealMsgDate(Calendar.getInstance().getTime());
        rabbitProductCache.add(metaMessage);
        return true;
    }
    private  class ResultQueueThread extends Thread{
        @Override
        public void run() {
            // 服务启动时，晚一点执行
            try {
                Thread.sleep(10000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String queueKey = rabbitProductCache.getCacheKey() + MQConstants.CONSUMER_FINISH_QUEUE_KEY;
            // 创建线程池处理队列
            ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
            while (true){
                // 从阻塞队列中获取数据
                Object o = null;
                try {
                    // 设置阻塞时间为不限，但最终阻塞时间为redis超时时间spring.redis.timeout
                    o = redisTemplate.opsForList().rightPop(queueKey, 0, TimeUnit.HOURS);
                }catch (Exception e){
                    logger.info("获取消息失败 {}", e.getMessage());
                    continue;
                }

                String msgId = o == null ? null : o.toString();
                if(null == msgId){
                    continue;
                }
                RabbitMetaMessage metaMessage = null;
                try{
                    metaMessage = rabbitProductCache.get(msgId);
                }catch (Exception e){
                    logger.error("处理消息结果异常-读取缓存失败 {}", msgId);
                    continue;
                }
                if(null == metaMessage){
                    logger.warn("处理消息结果 数据丢失 {}", msgId);
                    continue;
                }

                final RabbitMetaMessage ttmessage = metaMessage;
                fixedThreadPool.execute(()->{
                    try{
                        MDC.put("transCode", "mq/send/" + ttmessage.getExchange() + "_" + ttmessage.getRoutingKey());
                        String cacheKey = ttmessage.getMsgId();
                        // 处理结果
                        AbstractMessageResultListener listener = messageResultListenerMap.getListener(ttmessage.getExchange() + "_" + ttmessage.getRoutingKey());
                        if(listener != null){
                            listener.doResult(ttmessage);
                        }else { // 删除缓存中的消息
                            logger.info("结果回调，没有监听处理 {}", cacheKey);
                            try{
                                rabbitProductCache.del(cacheKey);
                            }catch (Exception e){
                                logger.error("处理失败 " + cacheKey, e);
                            }

                        }
                    }catch (Exception e){
                        logger.error("处理失败 " + ttmessage.getMsgId(), e);
                    }
                });
            }
        }
    }
}
