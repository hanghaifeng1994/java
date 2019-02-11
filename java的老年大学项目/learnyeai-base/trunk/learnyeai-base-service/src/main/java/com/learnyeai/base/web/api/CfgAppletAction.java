package com.learnyeai.base.web.api;

import com.learnyeai.base.model.CfgApplet;
import com.learnyeai.base.service.CfgAppletWyService;
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
@RequestMapping("${adminPath}" + CfgAppletAction.BASE_URL)
public class CfgAppletAction extends ApiBaseController<CfgApplet> {
    public static final String BASE_URL = "/CfgApplet/";

    @Autowired
    private CfgAppletWyService cfgAppletWyService;

    @Override
    protected BaseService<CfgApplet> getBaseService() {
        return cfgAppletWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
