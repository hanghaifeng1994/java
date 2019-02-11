package com.learnyeai.rabbitmq.listener;

import com.learnyeai.rabbitmq.bean.MqVo;
import com.learnyeai.rabbitmq.util.RabbitProductCache;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;
import com.learnyeai.tools.common.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * 消费者处理后完后，生产者回调，所有需要处理结果回调都要实现并配置此监听
 * 查询是否已经处理过回调了，没有开始处理。
 * Created by zpz on 2018/6/12.
 */
public abstract class AbstractMessageResultListener {
//    private String queueKey; // 交互 + "_" + queue
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RabbitProductCache rabbitProductCache;
    public boolean doResult(RabbitMetaMessage metaMessage){
        MDC.put("transCode", "mq/send/" + metaMessage.getExchange() + "_" + metaMessage.getRoutingKey());
        String msgId = metaMessage.getMsgId();
        try{
            logger.info("结果回调处理 {}", msgId);
            // payload转换成对象
            if(metaMessage.getPayload() instanceof String){
                try{
                    Class<?> cs = Class.forName(metaMessage.getPayloadClass());
                    Object o = JsonMapper.getInstance().fromJson(metaMessage.getPayload().toString(), cs);
                    metaMessage.setPayload(o);
                }catch (Exception e){
                    logger.error("消息损坏{}", msgId);
                }
            }
            toDo(metaMessage);
            try{
                rabbitProductCache.del(msgId);
            }catch (Exception e1){
                logger.error("消息处理成功，删除消息缓存失败" + msgId, e1 );
            }
            return true;
        }catch (Exception e){
            // 标识回调处理失败
            try{
                rabbitProductCache.fail(msgId);
            }catch (Exception e1){
                logger.error("修改消息缓存失败" + msgId, e1 );
            }

            logger.error("结果回调处理异常 " + msgId, e);
        }
        return false;
    }
    // 数据库缓存一致性
    @Transactional
    private void toDo(RabbitMetaMessage metaMessage) throws WeyeRabbitException {
        deal(metaMessage);
        // 成功删除缓存数据
        rabbitProductCache.del(metaMessage.getMsgId());
    }
    @Transactional
    protected abstract void deal(RabbitMetaMessage metaMessage) throws WeyeRabbitException;

    public abstract String getQueueKey();
}
