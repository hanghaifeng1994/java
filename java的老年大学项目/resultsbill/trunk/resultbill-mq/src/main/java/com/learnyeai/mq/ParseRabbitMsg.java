package com.learnyeai.mq;

import com.learnyeai.rabbitmq.bean.MqVo;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;

public class ParseRabbitMsg {
    /**
     * 装配消息实体
     * @param
     * @return
     */
    public static RabbitMetaMessage toParseRabbitMetaMessage(RabbitMq Mq){
        /** 生成一个发送对象 */
        RabbitMetaMessage rabbitMetaMessage = new RabbitMetaMessage();
        /**设置交换机 */
        rabbitMetaMessage.setExchange(ResultbillConstans.RESULTBILL_EXCHANGE);
        /**指定routing key */
        rabbitMetaMessage.setRoutingKey(ResultbillConstans.RESULTBILL_KEY);
        /** 设置需要传递的消息体,可以是任意对象 */
        MqVo vo = Mq;
        rabbitMetaMessage.setPayload(vo);

        return  rabbitMetaMessage;
    }
}
