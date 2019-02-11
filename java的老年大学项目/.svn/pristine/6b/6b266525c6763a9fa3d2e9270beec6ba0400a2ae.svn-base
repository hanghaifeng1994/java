package com.learnyeai.schoolclass.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 学员-班级
 *
 * @author twang
 */
public class ClzStudentClazz extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "SC_ID")
    private String scId;

    /**
     * 学生id
     */
    @Column(name = "CUST_ID")
    private String custId;
    /**
     * 班级id
     */
    @Column(name = "CZ_ID")
    private String czId;
    /**
     * 是否是证书班级
     */
    @Column(name = "CZ_CERTED")
    private String czCerted;
    /**
     * 昵称
     */
    @Column(name = "CUST_NICKNAME")
    private String custNickname;
    /**
     * 状态：0报名中、1报名成功
     */
    @Column(name = "NORMAL")
    private String normal;
    /**
     * 报名时间
     */
    @Column(name = "SINGUP_DATE")
    private Date singupDate;
    /**
     * 学习进度
     */
    @Column(name = "PROCESS")
    private BigDecimal process;
    /**
     * 测验成绩
     */
    @Column(name = "EXAM_SCORE")
    private BigDecimal examScore;
    /**
     * 是否生成证书
     */
    @Column(name = "CERTED")
    private String certed;
    /**
     * 已生成的证书id
     */
    @Column(name = "UC_ID")
    private String ucId;
    /**
     * 总学时是否完成
     */
    @Column(name = "STUDYLENGTH_FINISHED")
    private String studylengthFinished;
    /**
     * 必修改课是否完成
     */
    @Column(name = "MUST_STUDYLENGTH_FINISHED")
    private String mustStudylengthFinished;
    /**
     * 选修课是否完成
     */
    @Column(name = "SEL_STUDYLENGTH_FINISHED")
    private String selStudylengthFinished;
    /**
     * 测验成绩是否完成
     */
    @Column(name = "EXAM_SCORE_FINISHED")
    private String examScoreFinished;
    /**
     * 是否完成
     */
    @Column(name = "FINISHED")
    private String finished;
    /**
     * 完成时间
     */
    @Column(name = "FINISHED_DATE")
    private Date finishedDate;
    /**
     * 站点
     */
    @Column(name = "SITE_ID")
    private String siteId;
    /**
     * 身份1专家2学员
     */
    @Column(name = "USER_AUTH")
    private String userAuth;
	@Transient
	private String czName;

	public String getCzName() {
		return czName;
	}

	public void setCzName(String czName) {
		this.czName = czName;
	}

	public String getScId() {
        return scId;
    }

    public void setScId(String scId) {
        this.scId = scId;
    }
    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
    public String getCzId() {
        return czId;
    }

    public void setCzId(String czId) {
        this.czId = czId;
    }
    public String getCzCerted() {
        return czCerted;
    }

    public void setCzCerted(String czCerted) {
        this.czCerted = czCerted;
    }
    public String getCustNickname() {
        return custNickname;
    }

    public void setCustNickname(String custNickname) {
        this.custNickname = custNickname;
    }
    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }
    public Date getSingupDate() {
        return singupDate;
    }

    public void setSingupDate(Date singupDate) {
        this.singupDate = singupDate;
    }
    public BigDecimal getProcess() {
        return process;
    }

    public void setProcess(BigDecimal process) {
        this.process = process;
    }
    public BigDecimal getExamScore() {
        return examScore;
    }

    public void setExamScore(BigDecimal examScore) {
        this.examScore = examScore;
    }
    public String getCerted() {
        return certed;
    }

    public void setCerted(String certed) {
        this.certed = certed;
    }
    public String getUcId() {
        return ucId;
    }

    public void setUcId(String ucId) {
        this.ucId = ucId;
    }
    public String getStudylengthFinished() {
        return studylengthFinished;
    }

    public void setStudylengthFinished(String studylengthFinished) {
        this.studylengthFinished = studylengthFinished;
    }
    public String getMustStudylengthFinished() {
        return mustStudylengthFinished;
    }

    public void setMustStudylengthFinished(String mustStudylengthFinished) {
        this.mustStudylengthFinished = mustStudylengthFinished;
    }
    public String getSelStudylengthFinished() {
        return selStudylengthFinished;
    }

    public void setSelStudylengthFinished(String selStudylengthFinished) {
        this.selStudylengthFinished = selStudylengthFinished;
    }
    public String getExamScoreFinished() {
        return examScoreFinished;
    }

    public void setExamScoreFinished(String examScoreFinished) {
        this.examScoreFinished = examScoreFinished;
    }
    public String getFinished() {
        return finished;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }
    public Date getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(Date finishedDate) {
        this.finishedDate = finishedDate;
    }
    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    public String getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(String userAuth) {
        this.userAuth = userAuth;
    }

    public static class TF {

        public static String TABLE_NAME = "CLZ_STUDENT_CLAZZ";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String scId = "SC_ID";  // id
        public static String custId = "CUST_ID";  // 学生id
        public static String czId = "CZ_ID";  // 班级id
        public static String czCerted = "CZ_CERTED";  // 是否是证书班级
        public static String custNickname = "CUST_NICKNAME";  // 昵称
        public static String normal = "NORMAL";  // 状态：0报名中、1报名成功
        public static String singupDate = "SINGUP_DATE";  // 报名时间
        public static String process = "PROCESS";  // 学习进度
        public static String examScore = "EXAM_SCORE";  // 测验成绩
        public static String certed = "CERTED";  // 是否生成证书
        public static String ucId = "UC_ID";  // 已生成的证书id
        public static String studylengthFinished = "STUDYLENGTH_FINISHED";  // 总学时是否完成
        public static String mustStudylengthFinished = "MUST_STUDYLENGTH_FINISHED";  // 必修改课是否完成
        public static String selStudylengthFinished = "SEL_STUDYLENGTH_FINISHED";  // 选修课是否完成
        public static String examScoreFinished = "EXAM_SCORE_FINISHED";  // 测验成绩是否完成
        public static String finished = "FINISHED";  // 是否完成
        public static String finishedDate = "FINISHED_DATE";  // 完成时间
        public static String siteId = "SITE_ID";  // 站点
        public static String userAuth = "USER_AUTH";  // 身份1专家2学员

    }
}
