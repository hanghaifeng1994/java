package com.learnyeai.base.web.api;

import com.learnyeai.base.model.CfgSchmEdtPackage;
import com.learnyeai.base.service.CfgSchmEdtPackageWyService;
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
@RequestMapping("${adminPath}" + CfgSchmEdtPackageAction.BASE_URL)
public class CfgSchmEdtPackageAction extends ApiBaseController<CfgSchmEdtPackage> {
    public static final String BASE_URL = "/CfgSchmEdtPackage/";

    @Autowired
    private CfgSchmEdtPackageWyService cfgSchmEdtPackageWyService;

    @Override
    protected BaseService<CfgSchmEdtPackage> getBaseService() {
        return cfgSchmEdtPackageWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
