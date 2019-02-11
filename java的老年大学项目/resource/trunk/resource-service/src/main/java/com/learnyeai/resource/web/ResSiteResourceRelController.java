package com.learnyeai.resource.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.resource.model.ResSiteResourceRel;
import com.learnyeai.resource.service.ResSiteResourceRelWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + ResSiteResourceRelController.BASE_URL)
public class ResSiteResourceRelController extends BaseController<ResSiteResourceRel> {
    public static final String BASE_URL = "/ResSiteResourceRel/";

    @Autowired
    private ResSiteResourceRelWyService resSiteResourceRelWyService;

    @Override
    protected BaseService<ResSiteResourceRel> getService() {
        return resSiteResourceRelWyService;
    }
}
