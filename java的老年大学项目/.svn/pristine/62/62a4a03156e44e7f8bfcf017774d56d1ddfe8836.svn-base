package com.learnyeai.dynamics.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 数据动态
 *
 * @author yl
 */
public class DynData extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 业务类型
     */
    @Column(name = "SERVICE_TYPE")
    private String serviceType;
    /**
     * 对象id
     */
    @Column(name = "OBJ_ID")
    private String objId;
    /**
     * 操作说明
     */
    @Column(name = "OP_INFO")
    private String opInfo;
    /**
     * 操作人id
     */
    @Column(name = "OP_USER_ID")
    private String opUserId;
    /**
     * 操作人名称
     */
    @Column(name = "OP_USER_NAME")
    private String opUserName;
    /**
     * 操作时间
     */
    @Column(name = "OP_DATE")
    private Date opDate;
    /**
     * 商户id
     */
    @Column(name = "MCHT_ID")
    private String mchtId;
    /**
     * 商户方案id
     */
    @Column(name = "MCHT_SCHM_ID")
    private String mchtSchmId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }
    public String getOpInfo() {
        return opInfo;
    }

    public void setOpInfo(String opInfo) {
        this.opInfo = opInfo;
    }
    public String getOpUserId() {
        return opUserId;
    }

    public void setOpUserId(String opUserId) {
        this.opUserId = opUserId;
    }
    public String getOpUserName() {
        return opUserName;
    }

    public void setOpUserName(String opUserName) {
        this.opUserName = opUserName;
    }
    public Date getOpDate() {
        return opDate;
    }

    public void setOpDate(Date opDate) {
        this.opDate = opDate;
    }
    public String getMchtId() {
        return mchtId;
    }

    public void setMchtId(String mchtId) {
        this.mchtId = mchtId;
    }
    public String getMchtSchmId() {
        return mchtSchmId;
    }

    public void setMchtSchmId(String mchtSchmId) {
        this.mchtSchmId = mchtSchmId;
    }

    public static class TF {

        public static String TABLE_NAME = "DYN_DATA";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String id = "ID";  // id
        public static String serviceType = "SERVICE_TYPE";  // 业务类型
        public static String objId = "OBJ_ID";  // 对象id
        public static String opInfo = "OP_INFO";  // 操作说明
        public static String opUserId = "OP_USER_ID";  // 操作人id
        public static String opUserName = "OP_USER_NAME";  // 操作人名称
        public static String opDate = "OP_DATE";  // 操作时间
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id

    }
}
