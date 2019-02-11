package com.learnyeai.base.web;

import com.learnyeai.base.model.TimeExpiresBk;
import com.learnyeai.base.service.TimeExpiresBkWyService;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangpz
 */
@Component
public class TimeExpiresBkController extends BaseController<TimeExpiresBk> {
    @Autowired
    private TimeExpiresBkWyService timeExpiresBkService;

    @Override
    protected BaseService<TimeExpiresBk> getService() {
        return timeExpiresBkService;
    }
}
