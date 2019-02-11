package com.learnyeai.activity.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.activity.model.ActResults;
import com.learnyeai.activity.service.ActResultsWyService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 *
 * @author yl
 */
@Component
public class ActResultsController extends BaseController<ActResults> {

    @Autowired
    private ActResultsWyService actResultsWyService;
    @Override
    protected BaseService<ActResults> getService() {
        return actResultsWyService;
    }
    @Override
    public Object execute(IBusinessContext ctx) {
        String method = CtxHeadUtil.getControllerMethod();
        ActResults actResults= actResultsWyService.convert2Bean(ctx.getParamMap());
        if("queryPage".equals(method)){
          MyPage page= actResultsWyService.queryPage(actResults ,new HashMap());
            return super.rtnPageList4Report(page);
        }
        if("queryById".equals(method)){
            return actResultsWyService.queryById(actResults);
        }
        if("delete".equals(method)){
            return actResultsWyService.deleteBatch(actResults);
        }
        if("save".equals(method)){
            //如果是新增默认状态为未发布
            if(StringUtils.isBlank(actResults.getRstId())){
                actResults.setRstStatus("0");
            }
            actResultsWyService.save(actResults);
            return MapUtil.newMap("id",actResults.getRstId());
        }
        if("sumbitAudit".equals(method)){
           return  actResultsWyService.sumbitAudit(actResults);
        }
        if("audit".equals(method)){
            try {
                return actResultsWyService.audit(ctx);
            } catch (WeyeRabbitException e) {
                e.printStackTrace();
            }
        }
        return super.execute(ctx);
    }

}
