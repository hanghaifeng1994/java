package com.learnyeai.base.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 用户角色
 *
 * @author zhangpz
 */
public class CustUserRole extends BaseEntity {

    /**
    * 用户id
    */
    @Id
    @Column(name = "CUST_ID")
    private String custId;
    /**
    * 角色id
    */
    @Id
    @Column(name = "ROLE_ID")
    private String roleId;


    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public static class TF {

        public static String TABLE_NAME = "CUST_USER_ROLE";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String custId = "CUST_ID";  // 用户id
        public static String roleId = "ROLE_ID";  // 角色id

    }
}
