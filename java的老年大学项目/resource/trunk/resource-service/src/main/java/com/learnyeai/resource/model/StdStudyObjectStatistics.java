package com.learnyeai.resource.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 学习对象统计
 *
 * @author yl
 */
public class StdStudyObjectStatistics extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "SOS_ID")
    private String sosId;

    /**
     * 对象id
     */
    @Column(name = "OBJ_ID")
    private String objId;
    /**
     * 1资源、2课程
     */
    @Column(name = "TYPE")
    private String type;
    /**
     * 学习时长
     */
    @Column(name = "STUDY_TIME")
    private Long studyTime;
    /**
     * 学习次数
     */
    @Column(name = "STUDY_NUM")
    private Long studyNum;
    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATE")
    private Date createDate;
    /**
     * 更新时间
     */
    @Column(name = "UPDATE_DATE")
    private Date updateDate;
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

    public String getSosId() {
        return sosId;
    }

    public void setSosId(String sosId) {
        this.sosId = sosId;
    }
    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Long getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(Long studyTime) {
        this.studyTime = studyTime;
    }
    public Long getStudyNum() {
        return studyNum;
    }

    public void setStudyNum(Long studyNum) {
        this.studyNum = studyNum;
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

        public static String TABLE_NAME = "STD_STUDY_OBJECT_STATISTICS";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String sosId = "SOS_ID";  // id
        public static String objId = "OBJ_ID";  // 对象id
        public static String type = "TYPE";  // 1资源、2课程
        public static String studyTime = "STUDY_TIME";  // 学习时长
        public static String studyNum = "STUDY_NUM";  // 学习次数
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateDate = "UPDATE_DATE";  // 更新时间
        public static String siteId = "SITE_ID";  // 站点
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id

    }
}
