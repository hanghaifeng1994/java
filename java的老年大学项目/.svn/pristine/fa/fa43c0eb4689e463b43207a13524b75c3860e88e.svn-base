package com.learnyeai.base.web;

import com.learnyeai.base.api.util.BaseCons;
import com.learnyeai.learnai.consts.PtCons;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.base.model.PtsetSite;
import com.learnyeai.base.service.PtsetSiteWyService;
import com.learnyeai.learnai.support.IBusinessContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangpz
 */
@Component
public class PtsetSiteController extends BaseController<PtsetSite> {

    @Autowired
    private PtsetSiteWyService ptsetSiteWyService;

    @Override
    protected BaseService<PtsetSite> getService() {
        return ptsetSiteWyService;
    }

    @Override
    protected Object doDispached(IBusinessContext context, String method) {
        Object rst = super.doDispached(context, method);
        if(method.equals("setMainSite"))
            setMainSite(context);
        else if(method.equals("enableSite"))
            enableSite(context);
        else if(method.equals("disableSite"))
            disableSite(context);

        return rst;
    }

    @Override
    public Object save(IBusinessContext ctx) {
        PtsetSite site = getService().convert2Bean(ctx.getParamMap());
        if(site.getSiteId() == null){
            site.setStatus(PtCons.ENABLE_DISABLE.E.getVal());
            site.setSiteType(BaseCons.PTSET_SITE_TYPE.SS.getVal());
        }else {
            site.setStatus(null);
            site.setSiteType(null);
        }
        CtxHeadUtil.setReportDataDealType("1");
        ptsetSiteWyService.save(site);
        return site.getSiteId();
    }

    /**
     * 设为主站点
     * @param ctx
     */
    public void setMainSite(IBusinessContext ctx){
        String siteId = ctx.getParam("siteId");
        ptsetSiteWyService.setMainSite(siteId);
    }

    /**
     * 启用
     * @param ctx
     */
    public void enableSite(IBusinessContext ctx){
        String siteIds = ctx.getParam("siteIds");
        String[] siteIdArr = siteIds.split(",");
        ptsetSiteWyService.enable(siteIdArr, true);
    }

    /**
     * 禁用
     * @param ctx
     */
    public void disableSite(IBusinessContext ctx){
        String siteIds = ctx.getParam("siteIds");
        String[] siteIdArr = siteIds.split(",");
        ptsetSiteWyService.enable(siteIdArr, false);
    }
}
