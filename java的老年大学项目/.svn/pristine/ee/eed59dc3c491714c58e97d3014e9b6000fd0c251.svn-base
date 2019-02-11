package com.learnyeai.base.web.api;

import com.learnyeai.base.model.ShMerchantSchemePackage;
import com.learnyeai.base.service.ShMerchantSchemePackageWyService;
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
@RequestMapping("${adminPath}" + ShMerchantSchemePackageAction.BASE_URL)
public class ShMerchantSchemePackageAction extends ApiBaseController<ShMerchantSchemePackage> {
    public static final String BASE_URL = "/ShMerchantSchemePackage/";

    @Autowired
    private ShMerchantSchemePackageWyService shMerchantSchemePackageWyService;

    @Override
    protected BaseService<ShMerchantSchemePackage> getBaseService() {
        return shMerchantSchemePackageWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
