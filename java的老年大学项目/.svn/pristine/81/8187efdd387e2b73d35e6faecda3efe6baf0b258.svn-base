package com.learnyeai.activity.web;

import com.learnyeai.activity.model.ActActivity;
import com.learnyeai.activity.service.ActActivityWyService;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.activity.model.ActActivityWorks;
import com.learnyeai.activity.service.ActActivityWorksWyService;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.learnai.support.iml.CurrentUserInfoIml;
import com.learnyeai.learnai.support.MyPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author yl
 */
@Component
public class ActActivityWorksController extends BaseController<ActActivityWorks> {

    @Autowired
    private ActActivityWorksWyService actActivityWorksWyService;

    @Autowired
    private CurrentUserInfoIml currentUserInfoIml;
    @Autowired
    private ActActivityWyService actActivityWyService;

    @Override
    protected BaseService<ActActivityWorks> getService() {
        return actActivityWorksWyService;
    }



    @Override
    public Object execute(IBusinessContext ctx){
        ActActivityWorks wks = actActivityWorksWyService.convert2Bean(ctx.getParamMap());
        String method = CtxHeadUtil.getControllerMethod();
        Map<String,Object> map = new HashMap<>();
        if("delete".equals(method)){
            return  actActivityWorksWyService.deleteall(wks);
        }
        if("queryPage".equals(method)){
            wks.setWksUserId(currentUserInfoIml.getId());
            MyPage<ActActivityWorks> page = actActivityWorksWyService.queryPage(wks,new HashMap());
            return super.rtnPageList4Report(page);
        }
        if("save".equals(method)){
            return actActivityWorksWyService.saveData(wks);
        }
        if("sumbitAudit".equals(method)){
            return  actActivityWorksWyService.sumbitAudit(wks);
        }
        if("audit".equals(method)){
            try {
                return actActivityWorksWyService.audit(ctx);
            } catch (WeyeRabbitException e) {
                e.printStackTrace();
            }
        }
        if("queryPageByActId".equals(method)){
            String actId=MapUtil.singleNodeText(ctx.getParamMap(),"actId");
            ActActivity ac=actActivityWyService.queryById(actId);
            String title="";
            if(ac!=null){
                title= ac.getActTitle();
            }
            List list= super.queryPage(ctx);
            for (Object l:list){
                ActActivityWorks a=(ActActivityWorks)l;
                a.setActName(title);
            }
            return  list;
        }

        return super.execute(ctx);
    }
}
