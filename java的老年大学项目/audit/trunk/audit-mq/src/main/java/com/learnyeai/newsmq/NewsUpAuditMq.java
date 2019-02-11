package com.learnyeai.newsmq;


import com.learnyeai.rabbitmq.bean.MqVo;

public class NewsUpAuditMq extends MqVo {
    /**
     * 对象id
     */
    private String objId;
    /**
     * 审核状态
     */
    private String auditStatus;
    /**
     * 上报站点
     */
    private String reportSiteId;

    public String getReportSiteId() {
        return reportSiteId;
    }

    public void setReportSiteId(String reportSiteId) {
        this.reportSiteId = reportSiteId;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getObjId() {

        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }
}
