package com.learnyeai.resource.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.resource.model.ResSiteCategoryRel;
import com.learnyeai.resource.service.ResSiteCategoryRelWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + ResSiteCategoryRelController.BASE_URL)
public class ResSiteCategoryRelController extends BaseController<ResSiteCategoryRel> {
    public static final String BASE_URL = "/ResSiteCategoryRel/";

    @Autowired
    private ResSiteCategoryRelWyService resSiteCategoryRelWyService;

    @Override
    protected BaseService<ResSiteCategoryRel> getService() {
        return resSiteCategoryRelWyService;
    }
}
