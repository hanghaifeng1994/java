package com.learnyeai.base.web.api;

import com.learnyeai.base.model.ShStore;
import com.learnyeai.base.service.ShStoreWyService;
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
@RequestMapping("${adminPath}" + ShStoreAction.BASE_URL)
public class ShStoreAction extends ApiBaseController<ShStore> {
    public static final String BASE_URL = "/ShStore/";

    @Autowired
    private ShStoreWyService shStoreWyService;

    @Override
    protected BaseService<ShStore> getBaseService() {
        return shStoreWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
