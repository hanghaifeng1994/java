package com.learnyeai.base.web.api;

import com.learnyeai.base.model.ShAppletSetting;
import com.learnyeai.base.service.ShAppletSettingWyService;
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
@RequestMapping("${adminPath}" + ShAppletSettingAction.BASE_URL)
public class ShAppletSettingAction extends ApiBaseController<ShAppletSetting> {
    public static final String BASE_URL = "/ShAppletSetting/";

    @Autowired
    private ShAppletSettingWyService shAppletSettingWyService;

    @Override
    protected BaseService<ShAppletSetting> getBaseService() {
        return shAppletSettingWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
