package com.learnyeai.base.web;

import com.learnyeai.base.model.CfgScheme;
import com.learnyeai.base.service.CfgSchemeWyService;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangpz
 */
@Component
public class CfgSchemeController extends BaseController<CfgScheme> {
    @Autowired
    private CfgSchemeWyService cfgSchemeService;

    @Override
    protected BaseService<CfgScheme> getService() {
        return cfgSchemeService;
    }
}
