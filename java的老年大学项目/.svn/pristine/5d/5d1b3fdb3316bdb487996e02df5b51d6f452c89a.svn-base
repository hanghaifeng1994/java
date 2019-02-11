package com.learnyeai.base.web.api;

import com.learnyeai.base.model.ShOrder;
import com.learnyeai.base.service.ShOrderWyService;
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
@RequestMapping("${adminPath}" + ShOrderAction.BASE_URL)
public class ShOrderAction extends ApiBaseController<ShOrder> {
    public static final String BASE_URL = "/ShOrder/";

    @Autowired
    private ShOrderWyService shOrderWyService;

    @Override
    protected BaseService<ShOrder> getBaseService() {
        return shOrderWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
