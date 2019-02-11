package com.learnyeai.base.web;

import com.learnyeai.base.model.ShMerchantScheme;
import com.learnyeai.base.service.ShMerchantSchemeWyService;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangpz
 */
@Component
public class ShMerchantSchemeController extends BaseController<ShMerchantScheme> {
    @Autowired
    private ShMerchantSchemeWyService shMerchantSchemeService;

    @Override
    protected BaseService<ShMerchantScheme> getService() {
        return shMerchantSchemeService;
    }
}
