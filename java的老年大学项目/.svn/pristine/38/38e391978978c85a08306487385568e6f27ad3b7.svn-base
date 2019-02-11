package com.learnyeai.base.web;

import com.learnyeai.base.model.ShOrder;
import com.learnyeai.base.service.ShOrderWyService;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangpz
 */
@Component
public class ShOrderController extends BaseController<ShOrder> {
    @Autowired
    private ShOrderWyService shOrderService;

    @Override
    protected BaseService<ShOrder> getService() {
        return shOrderService;
    }
}
