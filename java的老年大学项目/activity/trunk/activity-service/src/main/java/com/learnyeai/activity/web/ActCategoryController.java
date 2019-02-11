package com.learnyeai.activity.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.activity.model.ActCategory;
import com.learnyeai.activity.service.ActCategoryWyService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.tools.common.StringUtils;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.learnyeai.learnai.support.MyPage;

import java.util.*;

/**
 *
 * @author yl
 */
@Component
public class ActCategoryController extends BaseController<ActCategory> {

    @Autowired
    private ActCategoryWyService actCategoryWyService;

    @Override
    protected BaseService<ActCategory> getService() {
        return actCategoryWyService;
    }

    @Override
    public Object execute(IBusinessContext ctx){
        String transCode = ctx.getTransCode();
        String method = CtxHeadUtil.getControllerMethod();
        ActCategory ac = actCategoryWyService.convert2Bean(ctx.getParamMap());
        Map<String,Object> map = new HashMap<>();
        if("queryPage".equals(method)){
            if(StringUtils.isBlank(ac.getParentId())){
                ac.setParentId("0");
            }
            MyPage page= actCategoryWyService.queryPage(ac,new HashMap());
            return rtnPageList4Report(page);
        }
        if ("deleteById".equals(method)){
            return actCategoryWyService.deleteall(ac);
        }
        if("save".equals(method)){

            return actCategoryWyService.saveDate(ac);
        }
        if("update".equals(method)){
            return actCategoryWyService.updateBySelect(ac);
        }
        if("queryPageUse".equals(method)){
          List<ActCategory> list=  actCategoryWyService.queryPageByUse(ctx);
            MyPage<ActCategory> page=new MyPage<>(list);
           return super.rtnPageList4Report(page);
        }
        return super.execute(ctx);

    }


}
