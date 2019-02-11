package com.learnyeai.activity.web;

import com.learnyeai.activity.model.ActCategory;
import com.learnyeai.activity.model.ActCategoryActivity;
import com.learnyeai.activity.service.ActCategoryActivityWyService;
import com.learnyeai.activity.service.ActCategoryWyService;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.activity.model.ActActivity;
import com.learnyeai.activity.service.ActActivityWyService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.mq.AuditlogMq;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;
import com.learnyeai.tools.common.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author yl
 */
@Component
public class ActActivityController extends BaseController<ActActivity> {

    @Autowired
    private ActActivityWyService actActivityWyService;
    @Autowired
    ActCategoryActivityWyService actCategoryActivityWyService;
    @Autowired
    ActCategoryWyService actCategoryWyService;

    @Override
    protected BaseService<ActActivity> getService() {
        return actActivityWyService;
    }
    @Override
    public Object execute(IBusinessContext ctx) {
        String method = CtxHeadUtil.getControllerMethod();
        ActActivity ac= actActivityWyService.convert2Bean(ctx.getParamMap());
        if("queryPage".equals(method)){
            return   actActivityWyService.queryPageManger(ctx);
        }
        if("save".equals(method)){
           return   actActivityWyService.saveData(ac);
        }
        if("delete".equals(method)){
            return  actActivityWyService.deleteData(ac);
        }
        if("queryById".equals(method)){
            ActActivity aa = actActivityWyService.queryById(ac);
            ActCategoryActivity aca=new ActCategoryActivity();
            aca.setActId(aa.getActId());
            String catName="";
            String catId="";
            //ACT_CATEGORY_ACTIVITY
            List<ActCategoryActivity> acas=  actCategoryActivityWyService.queryList(aca,ctx.getParamMap());
           for (ActCategoryActivity a:acas){
                int i=1;
               ActCategory actCategory=  actCategoryWyService.queryById((acas.get(0)).getCatId());
               if(actCategory!=null){
                   if(i==acas.size()){
                       catName+=actCategory.getCatName();
                       catId+=actCategory.getCatId();
                   }else{
                       catName+=actCategory.getCatName()+",";
                       catId+=actCategory.getCatId()+",";
                   }
               }
               aa.setCatName(catName);
               aa.setCatId(catId);
           }
            return  aa;
        }
        if("queryPageByCriteria".equals(method)){
            return actActivityWyService.queryPageByCriteria(ctx);
        }
        if("sumbitAudit".equals(method)){
            return  actActivityWyService.sumbitAudit(ac);
        }
        if("audit".equals(method)){
            try {
                return actActivityWyService.audit(ctx);
            } catch (WeyeRabbitException e) {
                e.printStackTrace();
            }
        }
        if("publish".equals(method)){
          int num =  actActivityWyService.publish(ac);
          return MapUtil.newMap("num",num);
        }
        if("sendLowerPage".equals(method)){
            return actActivityWyService.lowerSendPage(ctx);
        }
        if("queryPageUse".equals(method)){
            return actActivityWyService.queryPageUse(ctx);
        }
        if("myQueryPage".equals(method)){
            List<ActActivity> list= actActivityWyService.myQueryPage(ctx);
            MyPage<ActActivity> page=new MyPage(list);
        }
        return super.execute(ctx);
    }
}
