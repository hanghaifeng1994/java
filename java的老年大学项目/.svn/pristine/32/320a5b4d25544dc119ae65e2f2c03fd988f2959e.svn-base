package com.learnyeai.course.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.course.model.CrsPtrescsCourseRel;
import com.learnyeai.course.service.CrsPtrescsCourseRelWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + CrsPtrescsCourseRelController.BASE_URL)
public class CrsPtrescsCourseRelController extends BaseController<CrsPtrescsCourseRel> {
    public static final String BASE_URL = "/CrsPtrescsCourseRel/";

    @Autowired
    private CrsPtrescsCourseRelWyService crsPtrescsCourseRelWyService;

    @Override
    protected BaseService<CrsPtrescsCourseRel> getService() {
        return crsPtrescsCourseRelWyService;
    }
}
