package com.learnyeai.base.web.api;

import com.learnyeai.base.model.CfgModule;
import com.learnyeai.base.service.CfgModuleWyService;
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
@RequestMapping("${adminPath}" + CfgModuleAction.BASE_URL)
public class CfgModuleAction extends ApiBaseController<CfgModule> {
    public static final String BASE_URL = "/CfgModule/";

    @Autowired
    private CfgModuleWyService cfgModuleWyService;

    @Override
    protected BaseService<CfgModule> getBaseService() {
        return cfgModuleWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
