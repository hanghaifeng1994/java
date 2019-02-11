package com.learnyeai.resultbill.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.mq.ParseRabbitMsg;
import com.learnyeai.mq.RabbitMq;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import com.learnyeai.rabbitmq.sender.RabbitSender;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;
import com.learnyeai.resultbill.model.BilCustExt;
import com.learnyeai.resultbill.service.BilCustExtWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yl
 */
@Component
public class BilCustExtController extends BaseController<BilCustExt> {

    @Autowired
    private BilCustExtWyService bilCustExtWyService;
    @Autowired
    private RabbitSender rabbitSender;

    @Override
    protected BaseService<BilCustExt> getService() {
        return bilCustExtWyService;
    }
    public Object execute(IBusinessContext ctx) {
        String transCode = ctx.getTransCode();
        String method = CtxHeadUtil.getControllerMethod();
        if("queryPageByUser".equals(method)){
            return super.queryPage(ctx);
        }
        return  super.execute(ctx);
    }
}
