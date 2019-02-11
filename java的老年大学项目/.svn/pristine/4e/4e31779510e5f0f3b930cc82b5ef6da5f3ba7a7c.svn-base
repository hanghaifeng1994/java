package com.learnyeai.base.web;

import com.learnyeai.base.model.CustInfo;
import com.learnyeai.base.model.CustRole;
import com.learnyeai.base.service.RolePermissionWyService;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.IController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zpz on 2018/9/15.
 */
@Component
public class RolePermissionController implements IController {
    @Autowired
    private RolePermissionWyService rolePermissionWyService;
    @Override
    public Object execute(IBusinessContext iBusinessContext) {
        String method = CtxHeadUtil.getControllerMethod();
        if(null == method) {
            throw new RuntimeException();
        }
        if(method.equals("queryCustInfoListByPerm"))
            return this.queryCustInfoListByPerm(iBusinessContext);
        else if(method.equals("queryRoleListByPerm"))
            return this.queryRoleListByPerm(iBusinessContext);
        return null;
    }
    // 根据权限查询用户
    public List<CustInfo> queryCustInfoListByPerm(IBusinessContext ctx){
        String perm = ctx.getParam("perm");
        return rolePermissionWyService.queryCustInfoListByPerm(perm);
    }
    // 根据权限查询角色列表
    public List<CustRole> queryRoleListByPerm(IBusinessContext ctx){
        String perm = ctx.getParam("perm");
        return rolePermissionWyService.queryRoleListByPerm(perm);
    }

}
