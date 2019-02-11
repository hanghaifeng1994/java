package com.learnyeai.resource.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 客户学习记录
 *
 * @author yl
 */
public class StdCustLearnRecord extends BaseEntity {
	
    /**
    * id
    */
    @Id
    @Column(name = "RCD_ID")
    private String rcdId;

    /**
     * 学习人id
     */
    @Column(name = "STUDY_USER_ID")
    private String studyUserId;
    /**
     * 课程id
     */
    @Column(name = "CS_ID")
    private String csId;
    /**
     * 章节id
     */
    @Column(name = "CPT_ID")
    private String cptId;
    /**
     * 资源id
     */
    @Column(name = "RES_ID")
    private String resId;
    /**
     * 学习断点
     */
    @Column(name = "STUDY_BREAKPOINT")
    private Long studyBreakpoint;
    /**
     * 开始时间
     */
    @Column(name = "START_DATE")
    private Date startDate;
    /**
     * 结束时间
     */
    @Column(name = "END_DATE")
    private Date endDate;
    /**
     * 学习时长
     */
    @Column(name = "STUDY_TIME")
    private Long studyTime;
    /**
     * 回调次数
     */
    @Column(name = "CALLBACK_TIMES")
    private Integer callbackTimes;
    /**
     * 站点
     */
    @Column(name = "SITE_ID")
    private String siteId;
    /**
     * 商户id
     */
    @Column(name = "MCHT_ID")
    private String mchtId;
    /**
     * 商户方案id
     */
    @Column(name = "MCHT_SCHM_ID")
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

        public static String TABLE_NAME = "STD_CUST_LEARN_RECORD";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String rcdId = "RCD_ID";  // id
        public static String studyUserId = "STUDY_USER_ID";  // 学习人id
        public static String csId = "CS_ID";  // 课程id
        public static String cptId = "CPT_ID";  // 章节id
        public static String resId = "RES_ID";  // 资源id
        public static String studyBreakpoint = "STUDY_BREAKPOINT";  // 学习断点
        public static String startDate = "START_DATE";  // 开始时间
        public static String endDate = "END_DATE";  // 结束时间
        public static String studyTime = "STUDY_TIME";  // 学习时长
        public static String callbackTimes = "CALLBACK_TIMES";  // 回调次数
        public static String siteId = "SITE_ID";  // 站点
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id

    }
}
