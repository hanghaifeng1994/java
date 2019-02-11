package com.learnyeai.base.web;

import com.learnyeai.base.model.CustLgnInfo;
import com.learnyeai.base.service.CustLgnInfoWyService;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangpz
 */
@Component
public class CustLgnInfoController extends BaseController<CustLgnInfo> {
    @Autowired
    private CustLgnInfoWyService custLgnInfoService;

    @Override
    protected BaseService<CustLgnInfo> getService() {
        return custLgnInfoService;
    }
}
