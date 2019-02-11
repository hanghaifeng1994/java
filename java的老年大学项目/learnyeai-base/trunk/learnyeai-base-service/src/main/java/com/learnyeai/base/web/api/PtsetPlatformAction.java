package com.learnyeai.base.web.api;

import com.learnyeai.base.model.PtsetPlatform;
import com.learnyeai.base.service.PtsetPlatformWyService;
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
@RequestMapping("${adminPath}" + PtsetPlatformAction.BASE_URL)
public class PtsetPlatformAction extends ApiBaseController<PtsetPlatform> {
    public static final String BASE_URL = "/PtsetPlatform/";

    @Autowired
    private PtsetPlatformWyService ptsetPlatformWyService;

    @Override
    protected BaseService<PtsetPlatform> getBaseService() {
        return ptsetPlatformWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
