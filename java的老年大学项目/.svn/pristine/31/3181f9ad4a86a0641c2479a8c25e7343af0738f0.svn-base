package com.learnyeai.base.web.api;

import com.learnyeai.base.model.CfgScheme;
import com.learnyeai.base.service.CfgSchemeWyService;
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
@RequestMapping("${adminPath}" + CfgSchemeAction.BASE_URL)
public class CfgSchemeAction extends ApiBaseController<CfgScheme> {
    public static final String BASE_URL = "/CfgScheme/";

    @Autowired
    private CfgSchemeWyService cfgSchemeWyService;

    @Override
    protected BaseService<CfgScheme> getBaseService() {
        return cfgSchemeWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
