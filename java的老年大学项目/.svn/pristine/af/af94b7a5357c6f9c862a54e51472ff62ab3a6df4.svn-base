package com.learnyeai.base.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 角色菜单
 *
 * @author zhangpz
 */
public class CustRoleFunc extends BaseEntity {

    /**
    * 角色id
    */
    @Id
    @Column(name = "ROLE_ID")
    private String roleId;
    /**
    * 功能id
    */
    @Id
    @Column(name = "FUNC_ID")
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

    public static class TF {

        public static String TABLE_NAME = "CUST_ROLE_FUNC";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String roleId = "ROLE_ID";  // 角色id
        public static String funcId = "FUNC_ID";  // 功能id

    }
}
