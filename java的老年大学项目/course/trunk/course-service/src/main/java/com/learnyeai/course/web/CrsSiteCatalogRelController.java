package com.learnyeai.course.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.course.model.CrsSiteCatalogRel;
import com.learnyeai.course.service.CrsSiteCatalogRelWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + CrsSiteCatalogRelController.BASE_URL)
public class CrsSiteCatalogRelController extends BaseController<CrsSiteCatalogRel> {
    public static final String BASE_URL = "/CrsSiteCatalogRel/";

    @Autowired
    private CrsSiteCatalogRelWyService crsSiteCatalogRelWyService;

    @Override
    protected BaseService<CrsSiteCatalogRel> getService() {
        return crsSiteCatalogRelWyService;
    }
}
