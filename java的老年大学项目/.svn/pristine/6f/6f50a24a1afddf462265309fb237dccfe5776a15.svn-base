package com.learnyeai.course.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.course.model.CrsCatalogCourseRel;
import com.learnyeai.course.service.CrsCatalogCourseRelWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + CrsCatalogCourseRelController.BASE_URL)
public class CrsCatalogCourseRelController extends BaseController<CrsCatalogCourseRel> {
    public static final String BASE_URL = "/CrsCatalogCourseRel/";

    @Autowired
    private CrsCatalogCourseRelWyService crsCatalogCourseRelWyService;

    @Override
    protected BaseService<CrsCatalogCourseRel> getService() {
        return crsCatalogCourseRelWyService;
    }
}
