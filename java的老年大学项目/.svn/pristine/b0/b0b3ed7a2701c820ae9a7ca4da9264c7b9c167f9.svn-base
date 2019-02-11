package com.learnyeai.base.web;

import com.learnyeai.base.model.PtsetPlatform;
import com.learnyeai.base.model.PtsetSite;
import com.learnyeai.base.service.CustInfoWyService;
import com.learnyeai.base.service.PtsetPlatformWyService;
import com.learnyeai.base.service.PtsetSiteWyService;
import com.learnyeai.base.vo.PtSitesVo;
import com.learnyeai.learnai.consts.PtCons;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.IController;
import com.learnyeai.tools.common.BeanHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 平台站点列表
 * Created by zpz on 2018/8/24.
 */
@Component
public class StaffPtSitesListController implements IController {
    @Autowired
    private PtsetSiteWyService siteWyService;
    @Autowired
    private CustInfoWyService custInfoWyService;
    @Autowired
    private PtsetPlatformWyService platformWyService;

    @Override
    public Object execute(IBusinessContext ctx) {
        // 如果用户id为空，查询所有平台站点
        String custId = ctx.getParam("custId");
        List<String> siteIdList = custInfoWyService.queryStaffMngSiteIds(custId);
        List<PtsetSite> list = new ArrayList<>();
        for(String siteId : siteIdList){
            PtsetSite site = siteWyService.queryById(siteId);
            if(null == site)
                continue;
            if(PtCons.ENABLE_DISABLE.E.getVal().equals(site.getStatus())){
                list.add(site);
            }
        }

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
