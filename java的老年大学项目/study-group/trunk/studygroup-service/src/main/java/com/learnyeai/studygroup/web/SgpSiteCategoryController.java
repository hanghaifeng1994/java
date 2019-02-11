package com.learnyeai.studygroup.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.studygroup.model.SgpSiteCategory;
import com.learnyeai.studygroup.service.SgpSiteCategoryWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yl
 */
@Component
public class SgpSiteCategoryController extends BaseController<SgpSiteCategory> {

    @Autowired
    private SgpSiteCategoryWyService sgpSiteCategoryWyService;

    @Override
    protected BaseService<SgpSiteCategory> getService() {
        return sgpSiteCategoryWyService;
    }
    public Object execute(IBusinessContext ctx) {
        String method = CtxHeadUtil.getControllerMethod();
        if("showAndHideBatch".equals(method)){
           return sgpSiteCategoryWyService.showAndHideBatch(ctx);
        }
        if("queryPage".equals(method)){
            return sgpSiteCategoryWyService.queryPageExt(ctx);
        }
        return  super.execute(ctx);
    }
}
