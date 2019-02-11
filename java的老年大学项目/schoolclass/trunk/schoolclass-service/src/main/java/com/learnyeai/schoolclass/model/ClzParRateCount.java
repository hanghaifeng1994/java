package com.learnyeai.schoolclass.model;

import java.math.BigDecimal;

/**
 * 出勤率
 */
public class ClzParRateCount {
    /**
     * 总人数
     */
    private int totalMember;
    /**
     * 出勤人次
     */
    private int totalPar;
    /**
     * 平均出勤率
     */
    private String  avgParRate;
    /**
     * 评论人数
     */
    private int commentNumber;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotalMember() {
        return totalMember;
    }

    public void setTotalMember(int totalMember) {
        this.totalMember = totalMember;
    }

    public int getTotalPar() {
        return totalPar;
    }

    public void setTotalPar(int totalPar) {
        this.totalPar = totalPar;
    }

    public String getAvgParRate() {
        return avgParRate;
    }

    public void setAvgParRate(String avgParRate) {
        this.avgParRate = avgParRate;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }
}
