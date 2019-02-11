package com.learnyeai.base.web.api;

import com.learnyeai.base.model.CfgSchemeEdition;
import com.learnyeai.base.service.CfgSchemeEditionWyService;
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
@RequestMapping("${adminPath}" + CfgSchemeEditionAction.BASE_URL)
public class CfgSchemeEditionAction extends ApiBaseController<CfgSchemeEdition> {
    public static final String BASE_URL = "/CfgSchemeEdition/";

    @Autowired
    private CfgSchemeEditionWyService cfgSchemeEditionWyService;

    @Override
    protected BaseService<CfgSchemeEdition> getBaseService() {
        return cfgSchemeEditionWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
