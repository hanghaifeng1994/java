package com.learnyeai.course.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 客户学习章节
 *
 * @author twang
 */
public class CrsCustLearnChapterVo extends BaseVo {

    /**
    * id
    */
    private String lcptId;

    /**
     * 课程id
     */
    private String csId;
    /**
     * 章节id
     */
    private String cptId;
    /**
     * 当前资源id
     */
    private String curResId;
    /**
     * 是否完成
     */
    private String studyFinished;
    /**
     * 学习人id
     */
    private String studyUserId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 更新时间
     */
    private Date updateDate;
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

    public String getLcptId() {
        return lcptId;
    }

    public void setLcptId(String lcptId) {
        this.lcptId = lcptId;
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
    public String getCurResId() {
        return curResId;
    }

    public void setCurResId(String curResId) {
        this.curResId = curResId;
    }
    public String getStudyFinished() {
        return studyFinished;
    }

    public void setStudyFinished(String studyFinished) {
        this.studyFinished = studyFinished;
    }
    public String getStudyUserId() {
        return studyUserId;
    }

    public void setStudyUserId(String studyUserId) {
        this.studyUserId = studyUserId;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
        public static String lcptId = "lcptId";  // id
        public static String csId = "csId";  // 课程id
        public static String cptId = "cptId";  // 章节id
        public static String curResId = "curResId";  // 当前资源id
        public static String studyFinished = "studyFinished";  // 是否完成
        public static String studyUserId = "studyUserId";  // 学习人id
        public static String createDate = "createDate";  // 创建时间
        public static String updateDate = "updateDate";  // 更新时间
        public static String siteId = "siteId";  // 站点
        public static String mchtId = "mchtId";  // 商户id
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id

    }

}
