package com.learnyeai.base.web;

import com.learnyeai.base.model.CfgSchemeEditionHis;
import com.learnyeai.base.service.CfgSchemeEditionHisWyService;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangpz
 */
@Component
public class CfgSchemeEditionHisController extends BaseController<CfgSchemeEditionHis> {
    @Autowired
    private CfgSchemeEditionHisWyService cfgSchemeEditionHisService;

    @Override
    protected BaseService<CfgSchemeEditionHis> getService() {
        return cfgSchemeEditionHisService;
    }
}
