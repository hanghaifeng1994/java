package com.learnyeai.resource.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.resource.model.ResPtrescsResourceRel;
import com.learnyeai.resource.service.ResPtrescsResourceRelWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + ResPtrescsResourceRelController.BASE_URL)
public class ResPtrescsResourceRelController extends BaseController<ResPtrescsResourceRel> {
    public static final String BASE_URL = "/ResPtrescsResourceRel/";

    @Autowired
    private ResPtrescsResourceRelWyService resPtrescsResourceRelWyService;

    @Override
    protected BaseService<ResPtrescsResourceRel> getService() {
        return resPtrescsResourceRelWyService;
    }
}
