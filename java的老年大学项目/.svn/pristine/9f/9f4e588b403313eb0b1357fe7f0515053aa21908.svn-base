package com.learnyeai.resultbill.providermsg;

import com.learnyeai.mq.ResultbillConstans;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import com.learnyeai.rabbitmq.listener.AbstractMessageResultListener;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by zpz on 2018/6/26.
 */
@Component
public class NewsMessageResultListener extends AbstractMessageResultListener {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void deal(RabbitMetaMessage metaMessage) throws WeyeRabbitException {
        logger.info("消息已处理{}", metaMessage.getMsgId());
    }

    @Override
    public String getQueueKey() {
        return ResultbillConstans.RESULTBILL_EXCHANGE + "_" + ResultbillConstans.RESULTBILL_KEY;
    }
}
