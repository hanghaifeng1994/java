package com.learnyeai.schoolclass.model;

import java.util.Date;

public class ScheduleInfo {
    private String czScId;

    private String czId;

    private String scContent;

    private String scName;

    private String timeParse;

    private String scTearcherName;

    private String scTearcher;
    private String scStatus;

    private Date startDate;

    private Date endDate;

    private Date scRealStartDate;

    private Date scRealEndDate;

    private Long czNum;

    private int czRealNum;
    private String czSignId;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCzSignId() {
        return czSignId;
    }

    public void setCzSignId(String czSignId) {
        this.czSignId = czSignId;
    }

    public Long getCzNum() {
        return czNum;
    }

    public void setCzNum(Long czNum) {
        this.czNum = czNum;
    }

    public int getCzRealNum() {
        return czRealNum;
    }

    public void setCzRealNum(int czRealNum) {
        this.czRealNum = czRealNum;
    }

    public Date getScRealStartDate() {
        return scRealStartDate;
    }

    public void setScRealStartDate(Date scRealStartDate) {
        this.scRealStartDate = scRealStartDate;
    }

    public Date getScRealEndDate() {
        return scRealEndDate;
    }

    public void setScRealEndDate(Date scRealEndDate) {
        this.scRealEndDate = scRealEndDate;
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

    public String getScStatus() {
        return scStatus;
    }

    public void setScStatus(String scStatus) {
        this.scStatus = scStatus;
    }

    public String getCzId() {
        return czId;
    }

    public void setCzId(String czId) {
        this.czId = czId;
    }

    public String getScContent() {
        return scContent;
    }

    public void setScContent(String scContent) {
        this.scContent = scContent;
    }

    public String getScName() {
        return scName;
    }

    public void setScName(String scName) {
        this.scName = scName;
    }

    public String getTimeParse() {
        return timeParse;
    }

    public void setTimeParse(String timeParse) {
        this.timeParse = timeParse;
    }

    public String getScTearcherName() {
        return scTearcherName;
    }

    public void setScTearcherName(String scTearcherName) {
        this.scTearcherName = scTearcherName;
    }

    public String getScTearcher() {
        return scTearcher;
    }

    public void setScTearcher(String scTearcher) {
        this.scTearcher = scTearcher;
    }

    public String getCzScId() {

        return czScId;
    }

    public void setCzScId(String czScId) {
        this.czScId = czScId;
    }
}
