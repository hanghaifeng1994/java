package com.learnyeai.schoolclass.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.schoolclass.model.ClzSiteClazz;
import com.learnyeai.schoolclass.service.ClzSiteClazzWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + ClzSiteClazzController.BASE_URL)
public class ClzSiteClazzController extends BaseController<ClzSiteClazz> {
    public static final String BASE_URL = "/ClzSiteClazz/";

    @Autowired
    private ClzSiteClazzWyService clzSiteClazzWyService;

    @Override
    protected BaseService<ClzSiteClazz> getService() {
        return clzSiteClazzWyService;
    }
}
