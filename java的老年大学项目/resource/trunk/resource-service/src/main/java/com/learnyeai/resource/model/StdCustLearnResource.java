package com.learnyeai.resource.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import java.util.Date;

/**
 * 客户学习资源
 *
 * @author twang
 */
public class StdCustLearnResource extends BaseEntity {

	/**
	 * id
	 */
	@Id
	@Column(name = "LRES_ID")
	private String lresId;

	/**
	 * 学习人id
	 */
	@Column(name = "STUDY_USER_ID")
	private String studyUserId;
	/**
	 * 资源id
	 */
	@Column(name = "RES_ID")
	private String resId;
	/**
	 * 来源0:资源;1:课程
	 */
	@Column(name = "SOURCE")
	private Integer source;
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
	 * 学习断点
	 */
	@Column(name = "STUDY_BREAKPOINT")
	private Long studyBreakpoint;
	/**
	 * 是否完成
	 */
	@Column(name = "STUDY_FINISHED")
	private String studyFinished;
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

	@Transient
	private String resName;

	public String getLresId() {
		return lresId;
	}

	public void setLresId(String lresId) {
		this.lresId = lresId;
	}

	public String getStudyUserId() {
		return studyUserId;
	}

	public void setStudyUserId(String studyUserId) {
		this.studyUserId = studyUserId;
	}

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
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

	public Long getStudyBreakpoint() {
		return studyBreakpoint;
	}

	public void setStudyBreakpoint(Long studyBreakpoint) {
		this.studyBreakpoint = studyBreakpoint;
	}

	public String getStudyFinished() {
		return studyFinished;
	}

	public void setStudyFinished(String studyFinished) {
		this.studyFinished = studyFinished;
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

		public static String TABLE_NAME = "STD_CUST_LEARN_RESOURCE"; // 表名

		// public static String TABLE_SCHEMA = ConfigUtils.getValue(""); // 库名

		public static String lresId = "LRES_ID"; // id
		public static String studyUserId = "STUDY_USER_ID"; // 学习人id
		public static String resId = "RES_ID"; // 资源id
		public static String source = "SOURCE"; // 来源0:资源;1:课程
		public static String studyTime = "STUDY_TIME"; // 学习时长
		public static String studyNum = "STUDY_NUM"; // 学习次数
		public static String studyBreakpoint = "STUDY_BREAKPOINT"; // 学习断点
		public static String studyFinished = "STUDY_FINISHED"; // 是否完成
		public static String createDate = "CREATE_DATE"; // 创建时间
		public static String updateDate = "UPDATE_DATE"; // 更新时间
		public static String siteId = "SITE_ID"; // 站点
		public static String mchtId = "MCHT_ID"; // 商户id
		public static String mchtSchmId = "MCHT_SCHM_ID"; // 商户方案id

	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}
}
