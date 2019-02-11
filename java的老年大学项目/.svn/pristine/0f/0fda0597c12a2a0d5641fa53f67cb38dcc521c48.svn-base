package com.learnyeai.base.web.api;

import com.learnyeai.base.model.ShOrderPackage;
import com.learnyeai.base.service.ShOrderPackageWyService;
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
@RequestMapping("${adminPath}" + ShOrderPackageAction.BASE_URL)
public class ShOrderPackageAction extends ApiBaseController<ShOrderPackage> {
    public static final String BASE_URL = "/ShOrderPackage/";

    @Autowired
    private ShOrderPackageWyService shOrderPackageWyService;

    @Override
    protected BaseService<ShOrderPackage> getBaseService() {
        return shOrderPackageWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
