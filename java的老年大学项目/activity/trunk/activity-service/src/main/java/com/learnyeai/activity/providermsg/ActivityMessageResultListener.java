package com.learnyeai.activity.providermsg;

import com.learnyeai.activity.model.ActActivity;
import com.learnyeai.activity.model.ActActivityWorks;
import com.learnyeai.activity.model.ActResults;
import com.learnyeai.activity.service.ActActivityWorksWyService;
import com.learnyeai.activity.service.ActActivityWyService;
import com.learnyeai.activity.service.ActResultsWyService;
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
 * Created by yl on 2018/6/26.
 */
@Component
public class ActivityMessageResultListener extends AbstractMessageResultListener {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private ActActivityWyService actActivityWyService;
    @Resource
    private ActResultsWyService actResultsWyService;
    @Resource
    private ActActivityWorksWyService actActivityWorksWyService;

    @Override
    protected void deal(RabbitMetaMessage metaMessage) throws WeyeRabbitException {
        String resultMsg = (metaMessage.getDealResult()).replace("\"","");
        AuditlogMq mq =(AuditlogMq)metaMessage.getPayload();
        String type=mq.getServiceType();
        if("activity_service".equals(type)){
            ActActivity n=new ActActivity();
            n.setActId(mq.getObjId());
            n.setActAuditId(resultMsg);
            n.setMchtId(mq.getMchtId());
            n.setMchtSchmId(mq.getMchtSchmId());
            actActivityWyService.save(n);
        }else if("activity_service_result".equals(type)){
            ActResults result=new ActResults();
            result.setRstId(mq.getObjId());
            result.setRstAuditId(resultMsg);
            result.setMchtId(mq.getMchtId());
            result.setMchtSchmId(mq.getMchtSchmId());
            actResultsWyService.save(result);
        }else if("activity_service_work".equals(type)){
            ActActivityWorks work=new ActActivityWorks();
            work.setWksId(mq.getObjId());
            work.setWksAuditId(resultMsg);
            work.setMchtId(mq.getMchtId());
            work.setMchtSchmId(mq.getMchtSchmId());
            actActivityWorksWyService.save(work);
        }
        logger.info("消息已处理{}", metaMessage.getMsgId());
    }

    @Override
    public String getQueueKey() {
        return AuditlogConstans.AUDITLOG_EXCHANGE + "_" + AuditlogConstans.AUDITLOG_KEY;
    }
}
