package com.learnyeai.activity.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.activity.model.ActMarking;
import com.learnyeai.activity.service.ActMarkingWyService;
import com.learnyeai.learnai.support.IBusinessContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.learnyeai.learnai.support.MyPage;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yl
 */
@Component
public class ActMarkingController extends BaseController<ActMarking> {

    @Autowired
    private ActMarkingWyService actMarkingWyService;

    @Override
    protected BaseService<ActMarking> getService() {
        return actMarkingWyService;
    }



    @Override
    public Object execute(IBusinessContext ctx){
        ActMarking mk = actMarkingWyService.convert2Bean(ctx.getParamMap());
        String method = CtxHeadUtil.getControllerMethod();
        Map<String,Object> map = new HashMap<>();
        if("queryPage".equals(method)){
            MyPage<ActMarking> page = actMarkingWyService.queryPage(mk,new HashMap());
            return super.rtnPageList4Report(page);
        }
        if("save".equals(method)){
            actMarkingWyService.saveData(mk);
            return null;
        }
        return super.execute(ctx);
    }




}
