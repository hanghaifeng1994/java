package com.learnyeai.activity.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 打分
 *
 * @author yl
 */
public class ActMarking extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "MK_ID")
    private String mkId;

    /**
     * 作品id
     */
    @Column(name = "WKS_ID")
    private String wksId;
    /**
     * 打分
     */
    @Column(name = "MK_SCORE")
    private Integer mkScore;
    /**
     * 打分人id
     */
    @Column(name = "MK_USER_ID")
    private String mkUserId;
    /**
     * 打分人名称
     */
    @Column(name = "MK_USER_NAME")
    private String mkUserName;
    /**
     * 打分时间
     */
    @Column(name = "MK_DATE")
    private Date mkDate;
    /**
     * 更新时间
     */
    @Column(name = "UPDATE_DATE")
    private Date updateDate;
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

    public String getMkId() {
        return mkId;
    }

    public void setMkId(String mkId) {
        this.mkId = mkId;
    }
    public String getWksId() {
        return wksId;
    }

    public void setWksId(String wksId) {
        this.wksId = wksId;
    }
    public Integer getMkScore() {
        return mkScore;
    }

    public void setMkScore(Integer mkScore) {
        this.mkScore = mkScore;
    }
    public String getMkUserId() {
        return mkUserId;
    }

    public void setMkUserId(String mkUserId) {
        this.mkUserId = mkUserId;
    }
    public String getMkUserName() {
        return mkUserName;
    }

    public void setMkUserName(String mkUserName) {
        this.mkUserName = mkUserName;
    }
    public Date getMkDate() {
        return mkDate;
    }

    public void setMkDate(Date mkDate) {
        this.mkDate = mkDate;
    }
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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

        public static String TABLE_NAME = "ACT_MARKING";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String mkId = "MK_ID";  // ID
        public static String wksId = "WKS_ID";  // 作品id
        public static String mkScore = "MK_SCORE";  // 打分
        public static String mkUserId = "MK_USER_ID";  // 打分人id
        public static String mkUserName = "MK_USER_NAME";  // 打分人名称
        public static String mkDate = "MK_DATE";  // 打分时间
        public static String updateDate = "UPDATE_DATE";  // 更新时间
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id

    }
}
