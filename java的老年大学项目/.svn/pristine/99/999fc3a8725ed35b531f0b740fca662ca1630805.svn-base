package com.learnyeai.resource.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.resource.model.ResCategoryResourceRel;
import com.learnyeai.resource.service.ResCategoryResourceRelWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + ResCategoryResourceRelController.BASE_URL)
public class ResCategoryResourceRelController extends BaseController<ResCategoryResourceRel> {
    public static final String BASE_URL = "/ResCategoryResourceRel/";

    @Autowired
    private ResCategoryResourceRelWyService resCategoryResourceRelWyService;

    @Override
    protected BaseService<ResCategoryResourceRel> getService() {
        return resCategoryResourceRelWyService;
    }
}
