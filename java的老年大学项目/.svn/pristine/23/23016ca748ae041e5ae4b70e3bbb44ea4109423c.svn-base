package com.learnyeai.base.web;

import com.learnyeai.base.model.ShStore;
import com.learnyeai.base.service.ShStoreWyService;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangpz
 */
@Component
public class ShStoreController extends BaseController<ShStore> {
    @Autowired
    private ShStoreWyService shStoreService;

    @Override
    protected BaseService<ShStore> getService() {
        return shStoreService;
    }
}
