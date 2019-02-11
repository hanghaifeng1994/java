package com.learnyeai.base.web.api;

import com.learnyeai.base.model.TimeExpires;
import com.learnyeai.base.service.TimeExpiresWyService;
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
@RequestMapping("${adminPath}" + TimeExpiresAction.BASE_URL)
public class TimeExpiresAction extends ApiBaseController<TimeExpires> {
    public static final String BASE_URL = "/TimeExpires/";

    @Autowired
    private TimeExpiresWyService timeExpiresWyService;

    @Override
    protected BaseService<TimeExpires> getBaseService() {
        return timeExpiresWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
