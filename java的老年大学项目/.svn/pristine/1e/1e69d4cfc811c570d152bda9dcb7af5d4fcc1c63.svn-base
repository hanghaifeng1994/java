package com.learnyeai.base.web;

import com.learnyeai.base.model.CfgModule;
import com.learnyeai.base.service.CfgModuleWyService;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangpz
 */
@Component
public class CfgModuleController extends BaseController<CfgModule> {
    @Autowired
    private CfgModuleWyService cfgModuleService;

    @Override
    protected BaseService<CfgModule> getService() {
        return cfgModuleService;
    }
}
