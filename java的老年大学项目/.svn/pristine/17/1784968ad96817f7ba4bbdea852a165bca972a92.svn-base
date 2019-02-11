package com.learnyeai.dynamics.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.common.support.WeyeBaseService;

import com.learnyeai.dynamics.model.DynDynamics;
import com.learnyeai.dynamics.service.DynDynamicsWyService;
import com.learnyeai.learnai.support.IBusinessContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yl
 */
@Component
public class DynDynamicsController extends BaseController<DynDynamics> {

    @Autowired
    private DynDynamicsWyService dynDynamicsWyService;

    @Override
    protected WeyeBaseService<DynDynamics> getService() {
        return dynDynamicsWyService;
    }

    @Override
    public Object execute(IBusinessContext ctx) {
        String method = CtxHeadUtil.getControllerMethod();
        DynDynamics dyn=dynDynamicsWyService.convert2Bean(ctx.getParamMap());
        if("insert".equals(method)){
                return dynDynamicsWyService.saveData(dyn);
        }
        return super.execute(ctx);
    }
}
