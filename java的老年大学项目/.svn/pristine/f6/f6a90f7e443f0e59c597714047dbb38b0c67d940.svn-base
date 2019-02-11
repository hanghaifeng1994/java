package com.learnyeai.album.providermsg;

import com.learnyeai.album.model.AbmAlbum;
import com.learnyeai.album.service.AbmAlbumWyService;
import com.learnyeai.mq.AuditlogConstans;
import com.learnyeai.mq.AuditlogMq;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import com.learnyeai.rabbitmq.listener.AbstractMessageResultListener;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by zpz on 2018/6/26.
 */
@Component
public class AuditLogMessageResultListener extends AbstractMessageResultListener {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private AbmAlbumWyService abmAlbumWyService;
    @Override
    protected void deal(RabbitMetaMessage metaMessage) throws WeyeRabbitException {
        String resultMsg = (metaMessage.getDealResult()).replace("\"","");
        AuditlogMq mq =(AuditlogMq)metaMessage.getPayload();
        AbmAlbum n=new AbmAlbum();
        n.setAbmId(mq.getObjId());
        n.setAuditId(resultMsg);
        n.setMchtId(mq.getMchtId());
        n.setMchtSchmId(mq.getMchtSchmId());
        abmAlbumWyService.save(n);
        logger.info("消息已处理{}", metaMessage.getMsgId());
    }

    @Override
    public String getQueueKey() {
        return AuditlogConstans.AUDITLOG_EXCHANGE + "_" + AuditlogConstans.AUDITLOG_KEY;
    }
}
