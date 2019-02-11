package com.learnyeai.cert.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.cert.model.CtSiteCertRel;
import com.learnyeai.cert.service.CtSiteCertRelWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + CtSiteCertRelController.BASE_URL)
public class CtSiteCertRelController extends BaseController<CtSiteCertRel> {
    public static final String BASE_URL = "/CtSiteCertRel/";

    @Autowired
    private CtSiteCertRelWyService ctSiteCertRelWyService;

    @Override
    protected BaseService<CtSiteCertRel> getService() {
        return ctSiteCertRelWyService;
    }
}
