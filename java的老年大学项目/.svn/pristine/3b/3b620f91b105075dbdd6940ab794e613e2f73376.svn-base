package com.learnyeai.dynamics.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.common.support.WeyeBaseService;

import com.learnyeai.dynamics.model.DynDynamicsCustRel;
import com.learnyeai.dynamics.service.DynDynamicsCustRelWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yl
 */
@Component
public class DynDynamicsCustRelController extends BaseController<DynDynamicsCustRel> {

    @Autowired
    private DynDynamicsCustRelWyService dynDynamicsCustRelWyService;

    @Override
    protected WeyeBaseService<DynDynamicsCustRel> getService() {
        return dynDynamicsCustRelWyService;
    }
}
