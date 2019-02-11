package com.learnyeai.base.web;

import com.learnyeai.base.model.SmsTmpl;
import com.learnyeai.base.service.SmsTmplWyService;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangpz
 */
@Component
public class SmsTmplController extends BaseController<SmsTmpl> {
    @Autowired
    private SmsTmplWyService smsTmplService;

    @Override
    protected BaseService<SmsTmpl> getService() {
        return smsTmplService;
    }
}
