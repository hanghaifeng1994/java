package com.learnyeai.audit.web;


import com.learnyeai.audit.model.AdtAuditLog;
import com.learnyeai.audit.service.AdtAuditLogWyService;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.IBusinessContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangpz
 */
@Component
public class AdtAuditLogController extends BaseController<AdtAuditLog> {
    public static final String BASE_URL = "/AdtAuditLog/";

    @Autowired
    private AdtAuditLogWyService adtAuditLogWyService;

    @Override
    protected WeyeBaseService<AdtAuditLog> getService() {
        return adtAuditLogWyService;
    }
    @Override
    public Object execute(IBusinessContext ctx) {
        String method = CtxHeadUtil.getControllerMethod();
        if("queryPageByIds".equals(method)){
            return  adtAuditLogWyService.queryPageByIds(ctx);
        }
        return super.execute(ctx);
    }
}
