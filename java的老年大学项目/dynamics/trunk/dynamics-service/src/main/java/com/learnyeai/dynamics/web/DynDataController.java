package com.learnyeai.dynamics.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.common.support.WeyeBaseService;

import com.learnyeai.dynamics.model.DynData;
import com.learnyeai.dynamics.service.DynDataWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yl
 */
@Component
public class DynDataController extends BaseController<DynData> {

    @Autowired
    private DynDataWyService dynDataWyService;

    @Override
    protected WeyeBaseService<DynData> getService() {
        return dynDataWyService;
    }
}
