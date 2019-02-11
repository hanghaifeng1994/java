package com.learnyeai.base.web.api;

import com.learnyeai.base.model.CfgSchemeEditionPrice;
import com.learnyeai.base.service.CfgSchemeEditionPriceWyService;
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
@RequestMapping("${adminPath}" + CfgSchemeEditionPriceAction.BASE_URL)
public class CfgSchemeEditionPriceAction extends ApiBaseController<CfgSchemeEditionPrice> {
    public static final String BASE_URL = "/CfgSchemeEditionPrice/";

    @Autowired
    private CfgSchemeEditionPriceWyService cfgSchemeEditionPriceWyService;

    @Override
    protected BaseService<CfgSchemeEditionPrice> getBaseService() {
        return cfgSchemeEditionPriceWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
