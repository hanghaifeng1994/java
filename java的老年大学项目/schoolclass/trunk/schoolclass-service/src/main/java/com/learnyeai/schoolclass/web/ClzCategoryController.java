package com.learnyeai.schoolclass.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.schoolclass.model.ClzCategory;
import com.learnyeai.schoolclass.service.ClzCategoryWyService;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + ClzCategoryController.BASE_URL)
public class ClzCategoryController extends BaseController<ClzCategory> {
    public static final String BASE_URL = "/clzCategory/";

    @Autowired
    private ClzCategoryWyService clzCategoryWyService;

    @Override
    protected BaseService<ClzCategory> getService() {
        return clzCategoryWyService;
    }

    @Override
    public Object execute(IBusinessContext ctx) {
        String method = CtxHeadUtil.getControllerMethod();
        if("save".equals(method)){
            return  clzCategoryWyService.saveData(ctx);
        }
        if("queryPage".equals(method)){
            ClzCategory cz= clzCategoryWyService.convert2Bean(ctx.getParamMap());
            if(StringUtils.isBlank(cz.getParentId())){
                cz.setParentId("0");
            }
            MyPage<ClzCategory>   page=  clzCategoryWyService.queryPage(cz,ctx.getParamMap());
            return rtnPageList4Report(page);
        }
        if("delete".equals(method)){
            return clzCategoryWyService.deleteData(ctx);
        }
        if("queryPageUse".equals(method)){
          List<ClzCategory> list=  clzCategoryWyService.queryPageUse(ctx);
          MyPage page=new MyPage(list);
          return super.rtnPageList4Report(page);
        }
        return  super.execute(ctx);
    }
}
