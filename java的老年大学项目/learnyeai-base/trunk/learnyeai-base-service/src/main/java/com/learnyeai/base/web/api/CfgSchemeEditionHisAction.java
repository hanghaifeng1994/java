package com.learnyeai.base.web.api;

import com.learnyeai.base.model.CfgSchemeEditionHis;
import com.learnyeai.base.service.CfgSchemeEditionHisWyService;
import com.learnyeai.learnai.support.ApiBaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author zhangpz
 */
@RestController
@RequestMapping("${adminPath}" + CfgSchemeEditionHisAction.BASE_URL)
public class CfgSchemeEditionHisAction extends ApiBaseController<CfgSchemeEditionHis> {
    public static final String BASE_URL = "/CfgSchemeEditionHis/";

    @Autowired
    private CfgSchemeEditionHisWyService cfgSchemeEditionHisWyService;

    @Override
    protected BaseService<CfgSchemeEditionHis> getBaseService() {
        return cfgSchemeEditionHisWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
