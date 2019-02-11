package com.learnyeai.base.web;

import com.learnyeai.base.model.PtsetSite;
import com.learnyeai.base.service.PtsetSiteWyService;
import com.learnyeai.base.vo.PtSitesVo;
import com.learnyeai.learnai.consts.PtCons;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.base.model.PtsetPlatform;
import com.learnyeai.base.service.PtsetPlatformWyService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.tools.common.BeanHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zhangpz
 */
@Component
public class PtsetPlatformController extends BaseController<PtsetPlatform> {
    @Autowired
    private PtsetSiteWyService siteWyService;
    @Autowired
    private PtsetPlatformWyService platformWyService;

    @Autowired
    private PtsetPlatformWyService ptsetPlatformWyService;

    @Override
    protected BaseService<PtsetPlatform> getService() {
        return ptsetPlatformWyService;
    }

    @Override
    protected Object doDispached(IBusinessContext context, String method) {
        Object rst = super.doDispached(context, method);
        if(method.equals("ptSitesList"))
            rst = ptSitesList(context);
        return rst;
    }

    public Object ptSitesList(IBusinessContext ctx){
        // 查询可用的站点
        PtsetSite site = new PtsetSite();
        site.setStatus(PtCons.ENABLE_DISABLE.E.getVal());
        List<PtsetSite> list = siteWyService.queryList(site, null);
        Map<String, PtSitesVo> ptSiteMap = new HashMap<>();
        if(list.size() == 0)
            return null;
        for (PtsetSite it : list){
            if(it.getPtId() == null)
                continue;
            String ptId = it.getPtId();
            PtSitesVo pt = null;
            if(ptSiteMap.containsKey(ptId)){
                pt = ptSiteMap.get(ptId);
            }else {
                pt = getPtVo(ptId);
                ptSiteMap.put(ptId, pt);
            }

            pt.getSiteList().add(it);
        }
        return ptSiteMap.values();
    }
    private PtSitesVo getPtVo(String ptId){
        PtSitesVo ptSitesVo = new PtSitesVo();
        PtsetPlatform o = platformWyService.queryById(ptId);
        BeanHelper.copy(o,ptSitesVo);
        return ptSitesVo;
    }
}
