package com.learnyeai.base.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户设备
 *
 * @author zhangpz
 */
public class UrDevice extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "DEV_ID")
    private String devId;

    /**
     * UUID
     */
    @Column(name = "UUID")
    private String uuid;
    /**
     * 客户id
     */
    @Column(name = "CUST_ID")
    private String custId;
    /**
     * 1登录、2退出登录、3在其它设备登录
     */
    @Column(name = "DEV_STATUS")
    private String devStatus;
    /**
     * 绑定时间
     */
    @Column(name = "BIND_DATE")
    private Date bindDate;
    /**
     * IP: IPHONE PD: IPAD AD: ANDROID AP: ANDROID PAD
     */
    @Column(name = "CLIENT_TYPE")
    private String clientType;
    /**
     * 客户端版本
     */
    @Column(name = "CLIENT_VER_NO")
    private String clientVerNo;
    /**
     * 客户端详情
     */
    @Column(name = "CLIENT_INFO")
    private String clientInfo;
    /**
     * I:IOS A:ANDROID
     */
    @Column(name = "CLIENT_OS")
    private String clientOs;
    /**
     * 创建人
     */
    @Column(name = "CREATE_BY")
    private String createBy;
    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATE")
    private Date createDate;
    /**
     * 更新时间
     */
    @Column(name = "UPDATE_DATE")
    private Date updateDate;
    /**
     * 删除标记
     */
    @Column(name = "DEL_FLAG")
    private String delFlag;

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
    public String getDevStatus() {
        return devStatus;
    }

    public void setDevStatus(String devStatus) {
        this.devStatus = devStatus;
    }
    public Date getBindDate() {
        return bindDate;
    }

    public void setBindDate(Date bindDate) {
        this.bindDate = bindDate;
    }
    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }
    public String getClientVerNo() {
        return clientVerNo;
    }

    public void setClientVerNo(String clientVerNo) {
        this.clientVerNo = clientVerNo;
    }
    public String getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(String clientInfo) {
        this.clientInfo = clientInfo;
    }
    public String getClientOs() {
        return clientOs;
    }

    public void setClientOs(String clientOs) {
        this.clientOs = clientOs;
    }
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public static class TF {

        public static String TABLE_NAME = "UR_DEVICE";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String devId = "DEV_ID";  // ID
        public static String uuid = "UUID";  // UUID
        public static String custId = "CUST_ID";  // 客户id
        public static String devStatus = "DEV_STATUS";  // 1登录、2退出登录、3在其它设备登录
        public static String bindDate = "BIND_DATE";  // 绑定时间
        public static String clientType = "CLIENT_TYPE";  // IP: IPHONE PD: IPAD AD: ANDROID AP: ANDROID PAD
        public static String clientVerNo = "CLIENT_VER_NO";  // 客户端版本
        public static String clientInfo = "CLIENT_INFO";  // 客户端详情
        public static String clientOs = "CLIENT_OS";  // I:IOS A:ANDROID
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateDate = "UPDATE_DATE";  // 更新时间
        public static String delFlag = "DEL_FLAG";  // 删除标记

    }
}
