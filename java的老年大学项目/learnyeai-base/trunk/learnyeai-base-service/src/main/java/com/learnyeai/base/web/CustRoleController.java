package com.learnyeai.base.web;

import com.learnyeai.learnai.consts.PtCons;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.base.model.CustRole;
import com.learnyeai.base.service.CustRoleWyService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.tools.common.BeanMapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 *
 * @author zhangpz
 */
@Component
public class CustRoleController extends BaseController<CustRole> {

    @Autowired
    private CustRoleWyService custRoleWyService;

    @Override
    protected Object doDispached(IBusinessContext context, String method) {
        Object rst = super.doDispached(context, method);
        if(method.equals("enable"))
            enable(context);
        else if(method.equals("disable"))
            disable(context);
        else if(method.equals("roleForm")){
            rst = this.roleForm(context);
        }
        return rst;
    }

    @Override
    protected BaseService<CustRole> getService() {
        return custRoleWyService;
    }

    public void enable(IBusinessContext ctx){
        String roleIds = ctx.getParam("roleIds");
        String[] roleIdArr = roleIds.split(",");
        custRoleWyService.enable(roleIdArr, true);
    }

    public void disable(IBusinessContext ctx){
        String roleIds = ctx.getParam("roleIds");
        String[] roleIdArr = roleIds.split(",");
        custRoleWyService.enable(roleIdArr, false);
    }

    @Override
    public Object save(IBusinessContext ctx) {

        String roleId = custRoleWyService.saveRoleFuncs(ctx);
        CtxHeadUtil.setReportDataDealType("1");
        return roleId;
    }

    public Object roleForm(IBusinessContext ctx){
        // 查询角色信息，角色功能点
        String roleId = ctx.getParam("roleId");
        CustRole role = custRoleWyService.queryById(roleId);
        if(null == role){
            throw AresRuntimeException.build("custRole.notExist").iniMessage("角色不存在");
        }
        Map<String, Object> roleMap = null;
        try {
            roleMap = BeanMapUtils.convertBean(role);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        List<String> funcIdList = custRoleWyService.queryRoleFuncIdList(roleId);
        roleMap.put("funcIds", StringUtils.join(funcIdList, ","));
        return roleMap;
    }
}
