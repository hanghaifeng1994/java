package com.learnyeai.base.web;

import com.learnyeai.base.model.ShOrderPackage;
import com.learnyeai.base.service.ShOrderPackageWyService;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangpz
 */
@Component
public class ShOrderPackageController extends BaseController<ShOrderPackage> {
    @Autowired
    private ShOrderPackageWyService shOrderPackageService;

    @Override
    protected BaseService<ShOrderPackage> getService() {
        return shOrderPackageService;
    }
}
