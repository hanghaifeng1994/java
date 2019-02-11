package com.learnyeai.trainmanage.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.trainmanage.model.ClzSiteCategoryRel;
import com.learnyeai.trainmanage.service.ClzSiteCategoryRelWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 *
 * @author yl
 */
@Component
public class ClzSiteCategoryRelController extends BaseController<ClzSiteCategoryRel> {

    @Autowired
    private ClzSiteCategoryRelWyService clzSiteCategoryRelWyService;

    @Override
    protected BaseService<ClzSiteCategoryRel> getService() {
        return clzSiteCategoryRelWyService;
    }

    @Override
    public Object execute(IBusinessContext ctx){
        String method = CtxHeadUtil.getControllerMethod();
        ClzSiteCategoryRel cscr = clzSiteCategoryRelWyService.convert2Bean(ctx.getParamMap());
        if("queryPage".equals(method)){
            return clzSiteCategoryRelWyService.queryPage(cscr,new HashMap());
        }
        if("showAndHideBatch".equals(method)){
            return clzSiteCategoryRelWyService.showAndHideBatch(ctx);
        }
        return super.execute(ctx);
    }

}
