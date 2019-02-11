package com.learnyeai.cert.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 学员证书
 *
 * @author twang
 */
public class CtUserCertVo extends BaseVo {

    /**
    * 用户证书id
    */
    private String ucId;

    /**
     * 报名用户id
     */
    private String ucUserId;
    /**
     * 证书id
     */
    private String ctId;
    /**
     * 身份证
     */
    private String ucIdcard;
    /**
     * 姓名
     */
    private String ucName;
    /**
     * 单位
     */
    private String ucUnit;
    /**
     * 项目
     */
    private String ucProgram;
    /**
     * 年度
     */
    private String ucYear;
    /**
     * 学时/学分
     */
    private String ucScore;
    /**
     * 证书名称
     */
    private String ucCertName;
    /**
     * 证书编号
     */
    private String ucCertNo;
    /**
     * 生成证书时间
     */
    private Date ucGenTime;
    /**
     * 发布状态
     */
    private String ucPubStatus;
    /**
     * 发布时间
     */
    private Date ucPubDate;
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
        public static String ucId = "ucId";  // 用户证书id
        public static String ucUserId = "ucUserId";  // 报名用户id
        public static String ctId = "ctId";  // 证书id
        public static String ucIdcard = "ucIdcard";  // 身份证
        public static String ucName = "ucName";  // 姓名
        public static String ucUnit = "ucUnit";  // 单位
        public static String ucProgram = "ucProgram";  // 项目
        public static String ucYear = "ucYear";  // 年度
        public static String ucScore = "ucScore";  // 学时/学分
        public static String ucCertName = "ucCertName";  // 证书名称
        public static String ucCertNo = "ucCertNo";  // 证书编号
        public static String ucGenTime = "ucGenTime";  // 生成证书时间
        public static String ucPubStatus = "ucPubStatus";  // 发布状态
        public static String ucPubDate = "ucPubDate";  // 发布时间
        public static String siteId = "siteId";  // 站点
        public static String mchtId = "mchtId";  // 商户id
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id

    }

}
