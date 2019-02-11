package com.learnyeai.base.web.api;

import com.learnyeai.base.model.ShMerchant;
import com.learnyeai.base.service.ShMerchantWyService;
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
@RequestMapping("${adminPath}" + ShMerchantAction.BASE_URL)
public class ShMerchantAction extends ApiBaseController<ShMerchant> {
    public static final String BASE_URL = "/ShMerchant/";

    @Autowired
    private ShMerchantWyService shMerchantWyService;

    @Override
    protected BaseService<ShMerchant> getBaseService() {
        return shMerchantWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
