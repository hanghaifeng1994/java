package com.learnyeai.base.web;

import com.learnyeai.base.model.ShMerchantSchemePackage;
import com.learnyeai.base.service.ShMerchantSchemePackageWyService;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangpz
 */
@Component
public class ShMerchantSchemePackageController extends BaseController<ShMerchantSchemePackage> {
    @Autowired
    private ShMerchantSchemePackageWyService shMerchantSchemePackageService;

    @Override
    protected BaseService<ShMerchantSchemePackage> getService() {
        return shMerchantSchemePackageService;
    }
}
