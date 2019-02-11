package com.learnyeai.mq;


import com.learnyeai.rabbitmq.bean.MqVo;

import java.util.Date;

/**
 * Created by yl on 2018/6/13.
 * aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
 */
public class AuditlogMq extends MqVo {
    /**
     * 对象id
     */
    private String objId;
    /**
     * 对象快照id
     */
    private String objLogId;
    /**
     * 业务类型
     */
    private String serviceType;
    /**
     * 审核人
     */
    private String adUserId;
    /**
     * 审核人名称
     */
    private String adUserName;
    /**
     * 审核内容
     */
    private String adContent;
    /**
     * 审核日期
     */
    private Date adTime;
    /**
     * 审核状态
     */
    private String status;
    /**
     * 商户id
     */
    private String mchtId;
    /**
     * 商户方案id
     */
    private String mchtSchmId;

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

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public String getObjLogId() {
        return objLogId;
    }

    public void setObjLogId(String objLogId) {
        this.objLogId = objLogId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(String adUserId) {
        this.adUserId = adUserId;
    }

    public String getAdUserName() {
        return adUserName;
    }

    public void setAdUserName(String adUserName) {
        this.adUserName = adUserName;
    }

    public String getAdContent() {
        return adContent;
    }

    public void setAdContent(String adContent) {
        this.adContent = adContent;
    }

    public Date getAdTime() {
        return adTime;
    }

    public void setAdTime(Date adTime) {
        this.adTime = adTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
