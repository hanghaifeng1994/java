package com.learnyeai.base.web.api;

import com.learnyeai.base.model.UrDevice;
import com.learnyeai.base.service.UrDeviceWyService;
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
@RequestMapping("${adminPath}" + UrDeviceAction.BASE_URL)
public class UrDeviceAction extends ApiBaseController<UrDevice> {
    public static final String BASE_URL = "/UrDevice/";

    @Autowired
    private UrDeviceWyService urDeviceWyService;

    @Override
    protected BaseService<UrDevice> getBaseService() {
        return urDeviceWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
