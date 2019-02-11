package com.learnyeai.base.web;

import com.learnyeai.base.model.CfgSchemeEditionPrice;
import com.learnyeai.base.service.CfgSchemeEditionPriceWyService;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangpz
 */
@Component
public class CfgSchemeEditionPriceController extends BaseController<CfgSchemeEditionPrice> {
    @Autowired
    private CfgSchemeEditionPriceWyService cfgSchemeEditionPriceService;

    @Override
    protected BaseService<CfgSchemeEditionPrice> getService() {
        return cfgSchemeEditionPriceService;
    }
}
