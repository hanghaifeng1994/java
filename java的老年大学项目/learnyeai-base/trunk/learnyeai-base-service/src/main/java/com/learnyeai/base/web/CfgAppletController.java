package com.learnyeai.base.web;

import com.learnyeai.base.model.CfgApplet;
import com.learnyeai.base.service.CfgAppletWyService;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangpz
 */
@Component
public class CfgAppletController extends BaseController<CfgApplet> {
    @Autowired
    private CfgAppletWyService cfgAppletService;

    @Override
    protected BaseService<CfgApplet> getService() {
        return cfgAppletService;
    }
}
