package com.learnyeai.album.web;

import com.learnyeai.album.model.AbmSiteCategoryRel;
import com.learnyeai.album.service.AbmSiteCategoryRelWyService;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.album.model.AbmCategory;
import com.learnyeai.album.service.AbmCategoryWyService;
import com.learnyeai.learnai.support.IBusinessContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yl
 */
@Component
public class AbmCategoryController extends BaseController<AbmCategory> {

    @Autowired
    private AbmCategoryWyService abmCategoryWyService;
    @Autowired
    private AbmSiteCategoryRelWyService abmSiteCategoryRelWyService;

    @Override
    protected BaseService<AbmCategory> getService() {
        return abmCategoryWyService;
    }
    @Override
    public Object execute(IBusinessContext ctx) {
        String method = CtxHeadUtil.getControllerMethod();
        if("save".equals(method)){
            return abmCategoryWyService.saveData(ctx);
        }
        if("queryPageUse".equals(method)){
            return abmSiteCategoryRelWyService.queryPageUse(ctx);
        }
        if("delete".equals(method)){
            return abmCategoryWyService.delBatch(ctx);
        }
        return super.execute(ctx);
    }
}
