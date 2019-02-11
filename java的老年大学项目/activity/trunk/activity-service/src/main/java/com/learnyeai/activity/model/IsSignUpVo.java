package com.learnyeai.activity.model;

/**
 *
 */
public class IsSignUpVo {
    private String actId;

    private String custId;
    /**
     * 0否 1是
     */
    private String status;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActId() {

        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }
}
