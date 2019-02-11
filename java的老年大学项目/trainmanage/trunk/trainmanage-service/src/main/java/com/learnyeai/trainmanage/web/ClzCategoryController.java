package com.learnyeai.trainmanage.web;

import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.MyPage;

import com.learnyeai.trainmanage.model.ClzCategory;
import com.learnyeai.trainmanage.service.ClzCategoryWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.learnyeai.learnai.support.IBusinessContext;

import java.util.HashMap;

/**
 *
 * @author yl
 */
@Component
public class ClzCategoryController extends BaseController<ClzCategory> {

    @Autowired
    private ClzCategoryWyService clzCategoryWyService;

    @Override
    protected BaseService<ClzCategory> getService() {
        return clzCategoryWyService;
    }


    public Object execute(IBusinessContext ctx){
        String method = CtxHeadUtil.getControllerMethod();
        ClzCategory ccg = clzCategoryWyService.convert2Bean(ctx.getParamMap());
        if("save".equals(method)){
            return clzCategoryWyService.saveDate(ctx);
        }
        if("delete".equals(method)){
            return clzCategoryWyService.delBatch(ctx);
        }
        if("queryById".equals(method)){
            return clzCategoryWyService.queryById(ccg.getCatId());
        }
        if("queryPage".equals(method)){
             MyPage<ClzCategory> page = clzCategoryWyService.queryPage(ccg,new HashMap());
             return super.rtnPageList4Report(page);
        }
        if("update".equals(method)){
            return clzCategoryWyService.updateBySelect(ccg);
        }
        return super.execute(ctx);
    }

}
