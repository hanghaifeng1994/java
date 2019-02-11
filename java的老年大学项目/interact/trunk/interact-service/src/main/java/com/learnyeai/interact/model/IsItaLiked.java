package com.learnyeai.interact.model;

public class IsItaLiked {
    /**
     * 点赞id
     */
    private String lkId;
    /**
     * 状态 0为为点赞 1已点赞
     */
    private String status;

    /**
     * 对象id
     */
    private String objId;


    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public String getLkId() {
        return lkId;
    }

    public void setLkId(String lkId) {
        this.lkId = lkId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
