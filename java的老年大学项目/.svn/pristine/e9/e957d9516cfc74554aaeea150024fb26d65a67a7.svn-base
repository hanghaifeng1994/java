package com.learnyeai.studygroup.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.MyPage;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.studygroup.model.SgpCategory;
import com.learnyeai.studygroup.service.SgpCategoryWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author yl
 */
@Component
public class SgpCategoryController extends BaseController<SgpCategory> {

    @Autowired
    private SgpCategoryWyService sgpCategoryWyService;

    @Override
    protected BaseService<SgpCategory> getService() {
        return sgpCategoryWyService;
    }

    public Object execute(IBusinessContext ctx) {
        String method = CtxHeadUtil.getControllerMethod();
        SgpCategory scg = sgpCategoryWyService.convert2Bean(ctx.getParamMap());
        if("save".equals(method)){
            return  sgpCategoryWyService.saveData(ctx);
        }
        if("delete".equals(method)){
            String id =(String) this.getService().getId(ctx.getParamMap());
            return sgpCategoryWyService.delBatch(id);
        }
        if("queryById".equals(method)){
            return sgpCategoryWyService.queryById(scg.getCatId());
        }
        if("queryPage".equals(method)){
            MyPage<SgpCategory> page = sgpCategoryWyService.queryPage(scg,new HashMap());
            return super.rtnPageList4Report(page);
        }
        if("queryShowPage".equals(method)){
          List<SgpCategory> list=  sgpCategoryWyService.queryShowPage(ctx);
          MyPage<SgpCategory> page=new MyPage<>(list);
          return  rtnPageList4Report(page);
        }
       return  super.execute(ctx);
    }
}
