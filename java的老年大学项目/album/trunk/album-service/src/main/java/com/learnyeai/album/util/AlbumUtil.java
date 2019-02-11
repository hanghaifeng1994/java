package com.learnyeai.album.util;

import com.learnyeai.base.api.bean.BaseInfoDao;
import com.learnyeai.base.api.util.CurrentBaseInfoUtil;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.mq.AuditlogConstans;
import com.learnyeai.mq.AuditlogMq;
import com.learnyeai.rabbitmq.bean.MqVo;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AlbumUtil {

    /**
     * 装配消息实体
     * @param
     * @return
     */
    public static RabbitMetaMessage toParseRabbitMetaMessage(AuditlogMq auditlogMq){
        /** 生成一个发送对象 */
        RabbitMetaMessage rabbitMetaMessage = new RabbitMetaMessage();
        /**设置交换机 */
        rabbitMetaMessage.setExchange(AuditlogConstans.AUDITLOG_EXCHANGE);
        /**指定routing key */
        rabbitMetaMessage.setRoutingKey(AuditlogConstans.AUDITLOG_KEY);
        /** 设置需要传递的消息体,可以是任意对象 */
        MqVo vo = auditlogMq;
        rabbitMetaMessage.setPayload(vo);

        return  rabbitMetaMessage;
    }
}
