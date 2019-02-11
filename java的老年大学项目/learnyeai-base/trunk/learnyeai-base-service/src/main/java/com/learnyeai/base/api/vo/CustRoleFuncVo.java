package com.learnyeai.base.api.vo;

import com.learnyeai.core.support.BaseVo;

/**
 * 角色菜单
 *
 * @author zhangpz
 */
public class CustRoleFuncVo extends BaseVo {

    /**
    * 角色id
    */
    private String roleId;
    /**
    * 功能id
    */
    private String funcId;


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }

    public static class CF {
        public static String roleId = "roleId";  // 角色id
        public static String funcId = "funcId";  // 功能id

    }

}
