package com.learnyeai.studygroup.providermsg;

import com.learnyeai.mq.AuditlogConstans;
import com.learnyeai.mq.AuditlogMq;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import com.learnyeai.rabbitmq.listener.AbstractMessageResultListener;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;
import com.learnyeai.studygroup.model.SgpStudyGroup;
import com.learnyeai.studygroup.service.SgpStudyGroupWyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by yl on 2018/6/26.
 */
@Component
public class StudyGroupMessageResultListener extends AbstractMessageResultListener {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private SgpStudyGroupWyService sgpStudyGroupWyService;

    @Override
    protected void deal(RabbitMetaMessage metaMessage) throws WeyeRabbitException {
        String resultMsg = (metaMessage.getDealResult()).replace("\"","");
        AuditlogMq mq =(AuditlogMq)metaMessage.getPayload();
        SgpStudyGroup n=new SgpStudyGroup();
        n.setSgpId(mq.getObjId());
        n.setAuditId(resultMsg);
        n.setMchtId(mq.getMchtId());
        n.setMchtSchmId(mq.getMchtSchmId());
        sgpStudyGroupWyService.save(n);
        logger.info("消息已处理{}", metaMessage.getMsgId());
    }

    @Override
    public String getQueueKey() {
        return AuditlogConstans.AUDITLOG_EXCHANGE + "_" + AuditlogConstans.AUDITLOG_KEY;
    }
}
