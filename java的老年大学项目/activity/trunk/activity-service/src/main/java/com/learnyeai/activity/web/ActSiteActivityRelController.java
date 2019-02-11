package com.learnyeai.activity.web;

import com.github.pagehelper.PageHelper;
import com.learnyeai.activity.model.ActActivity;
import com.learnyeai.activity.service.ActActivityWyService;
import com.learnyeai.base.api.util.SiteUtils;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.activity.model.ActSiteActivityRel;
import com.learnyeai.activity.service.ActSiteActivityRelWyService;
import com.learnyeai.learnai.support.IBusinessContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yl
 */
@Component
public class ActSiteActivityRelController extends BaseController<ActSiteActivityRel> {

    @Autowired
    private ActSiteActivityRelWyService actSiteActivityRelWyService;

    @Autowired
    private ActActivityWyService actActivityWyService;

    @Override
    protected BaseService<ActSiteActivityRel> getService() {
        return actSiteActivityRelWyService;
    }

    @Override
    public Object execute(IBusinessContext ctx) {
        String transCode = ctx.getTransCode();
        String method = CtxHeadUtil.getControllerMethod();
        ActSiteActivityRel asar=actSiteActivityRelWyService.convert2Bean(ctx.getParamMap());
        if("queryPage".equals(method)){
            if (asar != null) {
                asar.initPage();
                PageHelper.startPage(asar.getPage(), asar.getRows());
            }
          return   actSiteActivityRelWyService.queryPageRel(asar);
        }
        if("queryPageUse".equals(method)){
            return  actSiteActivityRelWyService.queryPageByUse(asar);
        }
        return super.execute(ctx);
    }

}
