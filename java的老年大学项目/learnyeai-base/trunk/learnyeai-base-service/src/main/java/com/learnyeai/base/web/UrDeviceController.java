package com.learnyeai.base.web;

import com.learnyeai.base.model.UrDevice;
import com.learnyeai.base.service.UrDeviceWyService;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangpz
 */
@Component
public class UrDeviceController extends BaseController<UrDevice> {
    @Autowired
    private UrDeviceWyService urDeviceService;

    @Override
    protected BaseService<UrDevice> getService() {
        return urDeviceService;
    }
}
