package com.learnyeai.base.web.api;

import com.learnyeai.base.model.CfgSchmEdtPackageHis;
import com.learnyeai.base.service.CfgSchmEdtPackageHisWyService;
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
@RequestMapping("${adminPath}" + CfgSchmEdtPackageHisAction.BASE_URL)
public class CfgSchmEdtPackageHisAction extends ApiBaseController<CfgSchmEdtPackageHis> {
    public static final String BASE_URL = "/CfgSchmEdtPackageHis/";

    @Autowired
    private CfgSchmEdtPackageHisWyService cfgSchmEdtPackageHisWyService;

    @Override
    protected BaseService<CfgSchmEdtPackageHis> getBaseService() {
        return cfgSchmEdtPackageHisWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
