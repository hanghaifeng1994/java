package com.learnyeai.activity.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.activity.model.ActActivityMemer;
import com.learnyeai.activity.service.ActActivityMemerWyService;
import com.learnyeai.learnai.support.IBusinessContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yl
 */
@Component
public class ActActivityMemerController extends BaseController<ActActivityMemer> {

    @Autowired
    private ActActivityMemerWyService actActivityMemerWyService;

    @Override
    protected BaseService<ActActivityMemer> getService() {
        return actActivityMemerWyService;
    }
    @Override
    public Object execute(IBusinessContext ctx){
        String method = CtxHeadUtil.getControllerMethod();
        ActActivityMemer am= actActivityMemerWyService.convert2Bean(ctx.getParamMap());
        if("signUp".equals(method)){
           return  actActivityMemerWyService.saveData(am);
        }
        if("personPage".equals(method)){
            return actActivityMemerWyService.personPage(am);
        }
        if("isSignUp".equals(method)){
            return actActivityMemerWyService.isSignUp(am);
        }
        return super.execute(ctx);
    }
}
