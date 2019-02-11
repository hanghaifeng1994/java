package com.learnyeai.studygroup.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;
import com.learnyeai.studygroup.model.SgpStudyGroup;
import com.learnyeai.studygroup.service.SgpStudyGroupWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 *
 * @author yl
 */
@Component
public class SgpStudyGroupController extends BaseController<SgpStudyGroup> {

    @Autowired
    private SgpStudyGroupWyService sgpStudyGroupWyService;

    @Override
    protected BaseService<SgpStudyGroup> getService() {
        return sgpStudyGroupWyService;
    }



    @Override
    public Object execute(IBusinessContext ctx) {
        SgpStudyGroup aag = sgpStudyGroupWyService.convert2Bean(ctx.getParamMap());
        String method = CtxHeadUtil.getControllerMethod();
        if("queryPage".equals(method)){
         return    sgpStudyGroupWyService.queryPageExt(ctx);
        }
        if("delete".equals(method)){
            return sgpStudyGroupWyService.deleteall(aag);
        }
        if("sumbitAudit".equals(method)){
            return sgpStudyGroupWyService.sumbitAudit(aag);
        }

        if("delete".equals(method)){
            return sgpStudyGroupWyService.delBatch(ctx);
        }
        if("save".equals(method)){
             sgpStudyGroupWyService.saveData(ctx);
            return new HashMap<>();
        }
        if("audit".equals(method)){
            try {
                sgpStudyGroupWyService.audit(ctx);
            } catch (WeyeRabbitException e) {
                e.printStackTrace();
            }
            return null;
        }
      return  super.execute(ctx);
    }
}
