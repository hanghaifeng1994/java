package com.learnyeai.base.web.api;

import com.learnyeai.base.model.ShMerchantScheme;
import com.learnyeai.base.service.ShMerchantSchemeWyService;
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
@RequestMapping("${adminPath}" + ShMerchantSchemeAction.BASE_URL)
public class ShMerchantSchemeAction extends ApiBaseController<ShMerchantScheme> {
    public static final String BASE_URL = "/ShMerchantScheme/";

    @Autowired
    private ShMerchantSchemeWyService shMerchantSchemeWyService;

    @Override
    protected BaseService<ShMerchantScheme> getBaseService() {
        return shMerchantSchemeWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
