package com.learnyeai.resource.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 客户学习记录
 *
 * @author yl
 */
public class StdCustLearnRecordVo extends BaseVo {

    /**
    * id
    */
    private String rcdId;

    /**
     * 学习人id
     */
    private String studyUserId;
    /**
     * 课程id
     */
    private String csId;
    /**
     * 章节id
     */
    private String cptId;
    /**
     * 资源id
     */
    private String resId;
    /**
     * 学习断点
     */
    private Long studyBreakpoint;
    /**
     * 开始时间
     */
    private Date startDate;
    /**
     * 结束时间
     */
    private Date endDate;
    /**
     * 学习时长
     */
    private Long studyTime;
    /**
     * 回调次数
     */
    private Integer callbackTimes;
    /**
     * 站点
     */
    private String siteId;
    /**
     * 商户id
     */
    private String mchtId;
    /**
     * 商户方案id
     */
    private String mchtSchmId;

    public String getRcdId() {
        return rcdId;
    }

    public void setRcdId(String rcdId) {
        this.rcdId = rcdId;
    }
    public String getStudyUserId() {
        return studyUserId;
    }

    public void setStudyUserId(String studyUserId) {
        this.studyUserId = studyUserId;
    }
    public String getCsId() {
        return csId;
    }

    public void setCsId(String csId) {
        this.csId = csId;
    }
    public String getCptId() {
        return cptId;
    }

    public void setCptId(String cptId) {
        this.cptId = cptId;
    }
    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }
    public Long getStudyBreakpoint() {
        return studyBreakpoint;
    }

    public void setStudyBreakpoint(Long studyBreakpoint) {
        this.studyBreakpoint = studyBreakpoint;
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
    public Long getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(Long studyTime) {
        this.studyTime = studyTime;
    }
    public Integer getCallbackTimes() {
        return callbackTimes;
    }

    public void setCallbackTimes(Integer callbackTimes) {
        this.callbackTimes = callbackTimes;
    }
    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
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
        public static String rcdId = "rcdId";  // id
        public static String studyUserId = "studyUserId";  // 学习人id
        public static String csId = "csId";  // 课程id
        public static String cptId = "cptId";  // 章节id
        public static String resId = "resId";  // 资源id
        public static String studyBreakpoint = "studyBreakpoint";  // 学习断点
        public static String startDate = "startDate";  // 开始时间
        public static String endDate = "endDate";  // 结束时间
        public static String studyTime = "studyTime";  // 学习时长
        public static String callbackTimes = "callbackTimes";  // 回调次数
        public static String siteId = "siteId";  // 站点
        public static String mchtId = "mchtId";  // 商户id
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id

    }

}
