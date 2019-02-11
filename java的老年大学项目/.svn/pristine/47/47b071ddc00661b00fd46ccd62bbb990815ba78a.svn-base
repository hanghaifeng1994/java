package com.learnyeai.dynamics.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 动态人员关联表
 *
 * @author yl
 */
public class DynDynamicsCustRel extends BaseEntity {

    /**
    * 接收人id
    */
    @Id
    @Column(name = "RCV_USER_ID")
    private String rcvUserId;

    /**
     * 动态id
     */
    @Column(name = "DYN_ID")
    private String dynId;

    public String getRcvUserId() {
        return rcvUserId;
    }

    public void setRcvUserId(String rcvUserId) {
        this.rcvUserId = rcvUserId;
    }
    public String getDynId() {
        return dynId;
    }

    public void setDynId(String dynId) {
        this.dynId = dynId;
    }

    public static class TF {

        public static String TABLE_NAME = "DYN_DYNAMICS_CUST_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String rcvUserId = "RCV_USER_ID";  // 接收人id
        public static String dynId = "DYN_ID";  // 动态id

    }
}
