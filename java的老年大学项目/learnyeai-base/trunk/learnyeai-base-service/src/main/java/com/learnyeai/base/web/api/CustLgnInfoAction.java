package com.learnyeai.base.web.api;

import com.learnyeai.base.model.CustLgnInfo;
import com.learnyeai.base.service.CustLgnInfoWyService;
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
@RequestMapping("${adminPath}" + CustLgnInfoAction.BASE_URL)
public class CustLgnInfoAction extends ApiBaseController<CustLgnInfo> {
    public static final String BASE_URL = "/CustLgnInfo/";

    @Autowired
    private CustLgnInfoWyService custLgnInfoWyService;

    @Override
    protected BaseService<CustLgnInfo> getBaseService() {
        return custLgnInfoWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
