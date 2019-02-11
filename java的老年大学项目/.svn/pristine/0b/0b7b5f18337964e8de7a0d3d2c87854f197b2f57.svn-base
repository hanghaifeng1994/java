package com.learnyeai.base.web;

import com.learnyeai.base.model.ShMerchant;
import com.learnyeai.base.service.ShMerchantWyService;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangpz
 */
@Component
public class ShMerchantController extends BaseController<ShMerchant> {
    @Autowired
    private ShMerchantWyService shMerchantService;

    @Override
    protected BaseService<ShMerchant> getService() {
        return shMerchantService;
    }
}
