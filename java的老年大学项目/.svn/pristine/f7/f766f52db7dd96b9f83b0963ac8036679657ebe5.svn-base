package com.learnyeai.interact.web;

import com.learnyeai.interact.model.ItaInteractionTimes;
import com.learnyeai.interact.service.ItaInteractionTimesWyService;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.common.support.WeyeBaseService;

import com.learnyeai.interact.model.ItaShare;
import com.learnyeai.interact.service.ItaShareWyService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.iml.CurrentUserInfoIml;
import com.learnyeai.tools.common.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author yl
 */
@Component
public class ItaShareController extends BaseController<ItaShare> {

    @Autowired
    private ItaShareWyService itaShareWyService;
    @Autowired
    private ItaInteractionTimesWyService itaInteractionTimesWyService;
    @Autowired
    CurrentUserInfoIml currentUserInfoIml;
    @Override
    protected WeyeBaseService<ItaShare> getService() {
        return itaShareWyService;
    }
    @Override
    public Object execute(IBusinessContext ctx) {
        String method = CtxHeadUtil.getControllerMethod();
        ItaShare is=itaShareWyService.convert2Bean(ctx.getParamMap());
        if("save".equals(method)){
            is.setCustName(currentUserInfoIml.getLoginName());
            is.setCustId(currentUserInfoIml.getId());
             itaShareWyService.saveData(is);
           return MapUtil.newMap("id",is.getId());
        }
        return super.execute(ctx);
    }
}
