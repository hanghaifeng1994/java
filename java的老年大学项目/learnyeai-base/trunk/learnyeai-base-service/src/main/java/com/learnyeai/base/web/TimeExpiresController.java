package com.learnyeai.base.web;

import com.learnyeai.base.model.TimeExpires;
import com.learnyeai.base.service.TimeExpiresWyService;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangpz
 */
@Component
public class TimeExpiresController extends BaseController<TimeExpires> {
    @Autowired
    private TimeExpiresWyService timeExpiresService;

    @Override
    protected BaseService<TimeExpires> getService() {
        return timeExpiresService;
    }
}
