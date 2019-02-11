package com.learnyeai.schoolclass.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.schoolclass.model.ClzSiteCategoryRel;
import com.learnyeai.schoolclass.service.ClzSiteCategoryRelWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + ClzSiteCategoryRelController.BASE_URL)
public class ClzSiteCategoryRelController extends BaseController<ClzSiteCategoryRel> {
    public static final String BASE_URL = "/clzSiteCategoryRel/";

    @Autowired
    private ClzSiteCategoryRelWyService clzSiteCategoryRelWyService;

    @Override
    protected BaseService<ClzSiteCategoryRel> getService() {
        return clzSiteCategoryRelWyService;
    }

    @Override
    public Object execute(IBusinessContext ctx) {
        String method = CtxHeadUtil.getControllerMethod();
        if("show".equals(method)){
            clzSiteCategoryRelWyService.saveData(ctx);
        }
        return super.execute(ctx);
    }
}
