package com.learnyeai.base.web.api;

import com.learnyeai.base.model.TimeExpiresBk;
import com.learnyeai.base.service.TimeExpiresBkWyService;
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
@RequestMapping("${adminPath}" + TimeExpiresBkAction.BASE_URL)
public class TimeExpiresBkAction extends ApiBaseController<TimeExpiresBk> {
    public static final String BASE_URL = "/TimeExpiresBk/";

    @Autowired
    private TimeExpiresBkWyService timeExpiresBkWyService;

    @Override
    protected BaseService<TimeExpiresBk> getBaseService() {
        return timeExpiresBkWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
