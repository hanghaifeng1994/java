package com.learnyeai.newsmq;


import com.learnyeai.rabbitmq.bean.MqVo;

public class NewsMq extends MqVo {
    private String  adId;
    /**
     * 对象id
     */
    private String objId;
    /**
     * 对象日志id
     */
    private String objLogId;
    /**
     * 业务类型
     */
    private String serviceType;
    /**
     * 审核状态
     */
    private String adStatus;
    /**
     * 审核意见
     */
    private String adContent;

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
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

    public String getAdStatus() {
        return adStatus;
    }

    public void setAdStatus(String adStatus) {
        this.adStatus = adStatus;
    }

    public String getAdContent() {
        return adContent;
    }

    public void setAdContent(String adContent) {
        this.adContent = adContent;
    }
}
