package com.learnyeai.studygroup.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.studygroup.model.SgpMember;
import com.learnyeai.studygroup.service.SgpMemberWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.learnyeai.learnai.support.IBusinessContext;
import javax.annotation.Resource;

/**
 *
 * @author yl
 */
@Component
public class SgpMemberController extends BaseController<SgpMember> {

    @Autowired
    private SgpMemberWyService sgpMemberWyService;

    @Override
    protected BaseService<SgpMember> getService() {
        return sgpMemberWyService;
    }

    @Override
    public Object execute(IBusinessContext ctx) {
        String transCode = ctx.getTransCode();
        String method = CtxHeadUtil.getControllerMethod();
        if("joinTeam".equals(method)){
            sgpMemberWyService.saveDate(ctx);
            return null;
        }
        if("queryPage".equals(method)){
          return   sgpMemberWyService.queryPageForMember(ctx);
        }
        if("isJoin".equals(method)){
            return sgpMemberWyService.isJoin(ctx);
        }
        if("myQueryPage".equals(method)){
            return sgpMemberWyService.myQueryPage(ctx);
        }
        return null;
    }
}
