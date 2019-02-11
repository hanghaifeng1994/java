package com.learnyeai.resource.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.resource.model.StdConfig;
import com.learnyeai.resource.service.StdConfigWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + StdConfigController.BASE_URL)
public class StdConfigController extends BaseController<StdConfig> {
    public static final String BASE_URL = "/StdConfig/";

    @Autowired
    private StdConfigWyService stdConfigWyService;

    @Override
    protected BaseService<StdConfig> getService() {
        return stdConfigWyService;
    }
}
