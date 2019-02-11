package com.learnyeai.base.web.api;

import com.learnyeai.base.model.CustInfo;
import com.learnyeai.base.service.CustInfoWyService;
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
@RequestMapping("${adminPath}" + CustInfoAction.BASE_URL)
public class CustInfoAction extends ApiBaseController<CustInfo> {
    public static final String BASE_URL = "/CustInfo/";

    @Autowired
    private CustInfoWyService custInfoWyService;

    @Override
    protected BaseService<CustInfo> getBaseService() {
        return custInfoWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }

    @RequestMapping(value = "/queryByLoginName")
    public CustInfo queryByLoginName(String loginName, String mchtId){
        return custInfoWyService.queryByLoginName(loginName, mchtId, null);
    }
}
