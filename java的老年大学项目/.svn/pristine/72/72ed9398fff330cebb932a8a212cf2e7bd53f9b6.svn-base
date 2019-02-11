package com.learnyeai.schoolclass.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.schoolclass.model.ClzCategoryClzzRell;
import com.learnyeai.schoolclass.service.ClzCategoryClzzRellWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + ClzCategoryClzzRellController.BASE_URL)
public class ClzCategoryClzzRellController extends BaseController<ClzCategoryClzzRell> {
    public static final String BASE_URL = "/ClzCategoryClzzRell/";

    @Autowired
    private ClzCategoryClzzRellWyService clzCategoryClzzRellWyService;

    @Override
    protected BaseService<ClzCategoryClzzRell> getService() {
        return clzCategoryClzzRellWyService;
    }
}
