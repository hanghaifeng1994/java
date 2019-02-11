package com.learnyeai.course.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.course.model.CrsSiteCourseRel;
import com.learnyeai.course.service.CrsSiteCourseRelWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + CrsSiteCourseRelController.BASE_URL)
public class CrsSiteCourseRelController extends BaseController<CrsSiteCourseRel> {
    public static final String BASE_URL = "/CrsSiteCourseRel/";

    @Autowired
    private CrsSiteCourseRelWyService crsSiteCourseRelWyService;

    @Override
    protected BaseService<CrsSiteCourseRel> getService() {
        return crsSiteCourseRelWyService;
    }
}
