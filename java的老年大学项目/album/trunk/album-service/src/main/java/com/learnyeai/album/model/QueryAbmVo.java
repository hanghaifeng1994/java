package com.learnyeai.album.model;

import com.learnyeai.learnai.support.BaseEntity;

import java.util.Date;

public class QueryAbmVo extends BaseEntity {
    private String siteIds;

    private String catId;

    private String status;

    private Date startDate;

    private Date endDate;

    private String abmName;

    private String[] arr;

    private String abmWeight;

    public String getAbmWeight() {
        return abmWeight;
    }

    public void setAbmWeight(String abmWeight) {
        this.abmWeight = abmWeight;
    }

    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public String getSiteIds() {
        return siteIds;
    }

    public void setSiteIds(String siteIds) {
        this.siteIds = siteIds;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAbmName() {
        return abmName;
    }

    public void setAbmName(String abmName) {
        this.abmName = abmName;
    }
}
