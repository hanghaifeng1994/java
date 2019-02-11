package com.learnyeai.base.web.api;

import com.learnyeai.base.model.PtsetSite;
import com.learnyeai.base.service.PtsetSiteWyService;
import com.learnyeai.learnai.support.ApiBaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 * @author zhangpz
 */
@RestController
@RequestMapping("${adminPath}" + PtsetSiteAction.BASE_URL)
public class PtsetSiteAction extends ApiBaseController<PtsetSite> {
    public static final String BASE_URL = "/PtsetSite/";

    @Autowired
    private PtsetSiteWyService ptsetSiteWyService;

    @Override
    protected BaseService<PtsetSite> getBaseService() {
        return ptsetSiteWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }

    @RequestMapping(value = "/queryByPt/{ptId}", method = RequestMethod.GET)
    public List<PtsetSite> queryByPt(@PathVariable String ptId){
        /*PtsetSite pp = new PtsetSite();
        pp.setPtId(ptId);
        return ptsetSiteWyService.queryList(pp, null);*/
        return ptsetSiteWyService.queryByPt(ptId);
    }
}
