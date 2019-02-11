package com.learnyeai.base.web;

import com.learnyeai.base.model.ShAppletSetting;
import com.learnyeai.base.service.ShAppletSettingWyService;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangpz
 */
@Component
public class ShAppletSettingController extends BaseController<ShAppletSetting> {
    @Autowired
    private ShAppletSettingWyService shAppletSettingService;

    @Override
    protected BaseService<ShAppletSetting> getService() {
        return shAppletSettingService;
    }
}
