package com.learnyeai.activity.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;


import com.learnyeai.activity.model.ActSiteCategoryRel;
import com.learnyeai.activity.service.ActSiteCategoryRelWyService;
import com.learnyeai.learnai.support.IBusinessContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yl
 */
@Component
public class ActSiteCategoryRelController extends BaseController<ActSiteCategoryRel> {

    @Autowired
    private ActSiteCategoryRelWyService actSiteCategoryRelWyService;

    @Override
    protected BaseService<ActSiteCategoryRel> getService() {
        return actSiteCategoryRelWyService;
    }

    @Override
    public Object execute(IBusinessContext ctx){
        String method = CtxHeadUtil.getControllerMethod();
        ActSiteCategoryRel ascr = actSiteCategoryRelWyService.convert2Bean(ctx.getParamMap());
        /*if("queryPage".equals(method)){
            return actSiteCategoryRelWyService.queryPageAll(ascr);
        }*/

        return super.execute(ctx);
    }



}
