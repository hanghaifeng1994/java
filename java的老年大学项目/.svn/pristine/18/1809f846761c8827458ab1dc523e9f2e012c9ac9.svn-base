package com.learnyeai.studygroup.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.studygroup.model.SgpSiteStudygroupRel;
import com.learnyeai.studygroup.service.SgpSiteStudygroupRelWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yl
 */
@Component
public class SgpSiteStudygroupRelController extends BaseController<SgpSiteStudygroupRel> {

    @Autowired
    private SgpSiteStudygroupRelWyService sgpSiteStudygroupRelWyService;

    @Override
    protected BaseService<SgpSiteStudygroupRel> getService() {
        return sgpSiteStudygroupRelWyService;
    }

    public Object execute(IBusinessContext ctx) {
        String method = CtxHeadUtil.getControllerMethod();
        if("queryPageUse".equals(method)){
         return    sgpSiteStudygroupRelWyService.queryPageUse(ctx);
        }
        return super.execute(ctx);
    }
}
