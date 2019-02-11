package com.learnyeai.cert.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import java.util.Date;
import java.util.List;

/**
 * 学员证书
 *
 * @author twang
 */
public class CtUserCert extends BaseEntity {

    /**
    * 用户证书id
    */
    @Id
    @Column(name = "UC_ID")
    private String ucId;

    /**
     * 报名用户id
     */
    @Column(name = "UC_USER_ID")
    private String ucUserId;
    /**
     * 证书id
     */
    @Column(name = "CT_ID")
    private String ctId;
    /**
     * 身份证
     */
    @Column(name = "UC_IDCARD")
    private String ucIdcard;
    /**
     * 姓名
     */
    @Column(name = "UC_NAME")
    private String ucName;
    /**
     * 单位
     */
    @Column(name = "UC_UNIT")
    private String ucUnit;
    /**
     * 项目
     */
    @Column(name = "UC_PROGRAM")
    private String ucProgram;
    /**
     * 年度
     */
    @Column(name = "UC_YEAR")
    private String ucYear;
    /**
     * 学时/学分
     */
    @Column(name = "UC_SCORE")
    private String ucScore;
    /**
     * 证书名称
     */
    @Column(name = "UC_CERT_NAME")
    private String ucCertName;
    /**
     * 证书编号
     */
    @Column(name = "UC_CERT_NO")
    private String ucCertNo;
    /**
     * 生成证书时间
     */
    @Column(name = "UC_GEN_TIME")
    private Date ucGenTime;
    /**
     * 发布状态
     */
    @Column(name = "UC_PUB_STATUS")
    private String ucPubStatus;
    /**
     * 发布时间
     */
    @Column(name = "UC_PUB_DATE")
    private Date ucPubDate;
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
    
    @Transient
	private List<String> siteIds;//站点id列表

    public String getUcId() {
        return ucId;
    }

    public void setUcId(String ucId) {
        this.ucId = ucId;
    }
    public String getUcUserId() {
        return ucUserId;
    }

    public void setUcUserId(String ucUserId) {
        this.ucUserId = ucUserId;
    }
    public String getCtId() {
        return ctId;
    }

    public void setCtId(String ctId) {
        this.ctId = ctId;
    }
    public String getUcIdcard() {
        return ucIdcard;
    }

    public void setUcIdcard(String ucIdcard) {
        this.ucIdcard = ucIdcard;
    }
    public String getUcName() {
        return ucName;
    }

    public void setUcName(String ucName) {
        this.ucName = ucName;
    }
    public String getUcUnit() {
        return ucUnit;
    }

    public void setUcUnit(String ucUnit) {
        this.ucUnit = ucUnit;
    }
    public String getUcProgram() {
        return ucProgram;
    }

    public void setUcProgram(String ucProgram) {
        this.ucProgram = ucProgram;
    }
    public String getUcYear() {
        return ucYear;
    }

    public void setUcYear(String ucYear) {
        this.ucYear = ucYear;
    }
    public String getUcScore() {
        return ucScore;
    }

    public void setUcScore(String ucScore) {
        this.ucScore = ucScore;
    }
    public String getUcCertName() {
        return ucCertName;
    }

    public void setUcCertName(String ucCertName) {
        this.ucCertName = ucCertName;
    }
    public String getUcCertNo() {
        return ucCertNo;
    }

    public void setUcCertNo(String ucCertNo) {
        this.ucCertNo = ucCertNo;
    }
    public Date getUcGenTime() {
        return ucGenTime;
    }

    public void setUcGenTime(Date ucGenTime) {
        this.ucGenTime = ucGenTime;
    }
    public String getUcPubStatus() {
        return ucPubStatus;
    }

    public void setUcPubStatus(String ucPubStatus) {
        this.ucPubStatus = ucPubStatus;
    }
    public Date getUcPubDate() {
        return ucPubDate;
    }

    public void setUcPubDate(Date ucPubDate) {
        this.ucPubDate = ucPubDate;
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

        public static String TABLE_NAME = "CT_USER_CERT";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String ucId = "UC_ID";  // 用户证书id
        public static String ucUserId = "UC_USER_ID";  // 报名用户id
        public static String ctId = "CT_ID";  // 证书id
        public static String ucIdcard = "UC_IDCARD";  // 身份证
        public static String ucName = "UC_NAME";  // 姓名
        public static String ucUnit = "UC_UNIT";  // 单位
        public static String ucProgram = "UC_PROGRAM";  // 项目
        public static String ucYear = "UC_YEAR";  // 年度
        public static String ucScore = "UC_SCORE";  // 学时/学分
        public static String ucCertName = "UC_CERT_NAME";  // 证书名称
        public static String ucCertNo = "UC_CERT_NO";  // 证书编号
        public static String ucGenTime = "UC_GEN_TIME";  // 生成证书时间
        public static String ucPubStatus = "UC_PUB_STATUS";  // 发布状态
        public static String ucPubDate = "UC_PUB_DATE";  // 发布时间
        public static String siteId = "SITE_ID";  // 站点
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id

    }

	public List<String> getSiteIds() {
		return siteIds;
	}

	public void setSiteIds(List<String> siteIds) {
		this.siteIds = siteIds;
	}
}
