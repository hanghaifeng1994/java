package com.learnyeai.homework.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.learnyeai.learnai.support.BaseEntity;

/**
 * 作业反馈
 *
 * @author twang
 */
public class WkUserHomework extends BaseEntity {

	/**
	 * id
	 */
	@Id
	@Column(name = "UH_ID")
	private String uhId;

	/**
	 * 作业id
	 */
	@Column(name = "HW_ID")
	private String hwId;
	/**
	 * 内容
	 */
	@Column(name = "UH_CONTENT")
	private String uhContent;
	/**
	 * 0未提交、1已提交
	 */
	@Column(name = "UH_STATUS")
	private String uhStatus;
	/**
	 * 交作业时间
	 */
	@Column(name = "UH_SUBMIT_DATE")
	private Date uhSubmitDate;
	/**
	 * 交作业人id
	 */
	@Column(name = "CUST_ID")
	private String custId;
	/**
	 * 交作业人名称
	 */
	@Column(name = "CUST_NAME")
	private String custName;
	/**
	 * 评星
	 */
	@Column(name = "UH_STAR_NUM")
	private Double uhStarNum;
	/**
	 * 得分
	 */
	@Column(name = "UH_SCORE")
	private Double uhScore;
	/**
	 * 0未评分、1已评分
	 */
	@Column(name = "UH_SCORE_STATUS")
	private String uhScoreStatus;
	/**
	 * 评分时间
	 */
	@Column(name = "UH_SCORE_DATE")
	private Date uhScoreDate;
	/**
	 * 评分人id
	 */
	@Column(name = "UH_SCORE_USER_ID")
	private String uhScoreUserId;
	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_DATE")
	private Date createDate;
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
	/**
	 * 评分内容
	 */
	@Column(name = "UH_SCORE_CONTENT")
	private String uhScoreContent;

	/**
	 * 作业标题
	 */
	@Transient
	private String hwTitle;
	/**
	 * 作业标题
	 */
	@Transient
	private String hwContent;

	/**
	 * 作业附件
	 */
	@Transient
	private List<WkHomeworkAttachment> homeworkAttachments = new ArrayList<WkHomeworkAttachment>();

	/**
	 * 用户提交的作业附件
	 */
	@Transient
	private List<WkHomeworkAttachment> userHomeworkAttachments = new ArrayList<WkHomeworkAttachment>();
	
	@Transient
	private List<String> siteIds;// 站点id列表

	public String getUhId() {
		return uhId;
	}

	public void setUhId(String uhId) {
		this.uhId = uhId;
	}

	public String getHwId() {
		return hwId;
	}

	public void setHwId(String hwId) {
		this.hwId = hwId;
	}

	public String getUhContent() {
		return uhContent;
	}

	public void setUhContent(String uhContent) {
		this.uhContent = uhContent;
	}

	public String getUhStatus() {
		return uhStatus;
	}

	public void setUhStatus(String uhStatus) {
		this.uhStatus = uhStatus;
	}

	public Date getUhSubmitDate() {
		return uhSubmitDate;
	}

	public void setUhSubmitDate(Date uhSubmitDate) {
		this.uhSubmitDate = uhSubmitDate;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Double getUhStarNum() {
		return uhStarNum;
	}

	public void setUhStarNum(Double uhStarNum) {
		this.uhStarNum = uhStarNum;
	}

	public Double getUhScore() {
		return uhScore;
	}

	public void setUhScore(Double uhScore) {
		this.uhScore = uhScore;
	}

	public String getUhScoreStatus() {
		return uhScoreStatus;
	}

	public void setUhScoreStatus(String uhScoreStatus) {
		this.uhScoreStatus = uhScoreStatus;
	}

	public Date getUhScoreDate() {
		return uhScoreDate;
	}

	public void setUhScoreDate(Date uhScoreDate) {
		this.uhScoreDate = uhScoreDate;
	}

	public String getUhScoreUserId() {
		return uhScoreUserId;
	}

	public void setUhScoreUserId(String uhScoreUserId) {
		this.uhScoreUserId = uhScoreUserId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	public String getUhScoreContent() {
		return uhScoreContent;
	}

	public void setUhScoreContent(String uhScoreContent) {
		this.uhScoreContent = uhScoreContent;
	}

	public static class TF {

		public static String TABLE_NAME = "WK_USER_HOMEWORK"; // 表名

		// public static String TABLE_SCHEMA = ConfigUtils.getValue(""); // 库名

		public static String uhId = "UH_ID"; // id
		public static String hwId = "HW_ID"; // 作业id
		public static String uhContent = "UH_CONTENT"; // 内容
		public static String uhStatus = "UH_STATUS"; // 0未提交、1已提交
		public static String uhSubmitDate = "UH_SUBMIT_DATE"; // 交作业时间
		public static String custId = "CUST_ID"; // 交作业人id
		public static String custName = "CUST_NAME"; // 交作业人名称
		public static String uhStarNum = "UH_STAR_NUM"; // 评星
		public static String uhScore = "UH_SCORE"; // 得分
		public static String uhScoreStatus = "UH_SCORE_STATUS"; // 0未评分、1已评分
		public static String uhScoreDate = "UH_SCORE_DATE"; // 评分时间
		public static String uhScoreUserId = "UH_SCORE_USER_ID"; // 评分人id
		public static String createDate = "CREATE_DATE"; // 创建时间
		public static String siteId = "SITE_ID"; // 站点
		public static String mchtId = "MCHT_ID"; // 商户id
		public static String mchtSchmId = "MCHT_SCHM_ID"; // 商户方案id
		public static String uhScoreContent = "UH_SCORE_CONTENT"; // 评分内容

	}

	public String getHwTitle() {
		return hwTitle;
	}

	public void setHwTitle(String hwTitle) {
		this.hwTitle = hwTitle;
	}

	public String getHwContent() {
		return hwContent;
	}

	public void setHwContent(String hwContent) {
		this.hwContent = hwContent;
	}

	public List<WkHomeworkAttachment> getHomeworkAttachments() {
		return homeworkAttachments;
	}

	public void setHomeworkAttachments(List<WkHomeworkAttachment> homeworkAttachments) {
		this.homeworkAttachments = homeworkAttachments;
	}

	public List<WkHomeworkAttachment> getUserHomeworkAttachments() {
		return userHomeworkAttachments;
	}

	public void setUserHomeworkAttachments(List<WkHomeworkAttachment> userHomeworkAttachments) {
		this.userHomeworkAttachments = userHomeworkAttachments;
	}

	public List<String> getSiteIds() {
		return siteIds;
	}

	public void setSiteIds(List<String> siteIds) {
		this.siteIds = siteIds;
	}
}
