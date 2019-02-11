package com.learnyeai.base.web.api;

import com.learnyeai.base.model.SmsTmpl;
import com.learnyeai.base.service.SmsTmplWyService;
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
@RequestMapping("${adminPath}" + SmsTmplAction.BASE_URL)
public class SmsTmplAction extends ApiBaseController<SmsTmpl> {
    public static final String BASE_URL = "/SmsTmpl/";

    @Autowired
    private SmsTmplWyService smsTmplWyService;

    @Override
    protected BaseService<SmsTmpl> getBaseService() {
        return smsTmplWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
