package com.learnyeai.audit.web;

import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseController;

import com.learnyeai.audit.model.AdtReportUp;
import com.learnyeai.audit.service.AdtReportUpWyService;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author zhangpz
 */
@Component
public class AdtReportUpController extends BaseController<AdtReportUp> {
    public static final String BASE_URL = "/AdtReportUp/";

    @Autowired
    private AdtReportUpWyService adtReportUpWyService;

    @Override
    protected WeyeBaseService<AdtReportUp> getService() {
        return adtReportUpWyService;
    }
    @RequestMapping("audit")
    public String  audit(AdtReportUp adtReportUp) throws WeyeRabbitException {
        return adtReportUp.getRpId();
    }
}
