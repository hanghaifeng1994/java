package com.learnyeai.homework.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 作业
 *
 * @author twang
 */
public class WkHomework extends BaseEntity {

	/**
	 * 作业id
	 */
	@Id
	@Column(name = "HW_ID")
	private String hwId;

	/**
	 * 标题
	 */
	@Column(name = "HW_TITLE")
	private String hwTitle;
	/**
	 * 内容
	 */
	@Column(name = "HW_CONTENT")
	private String hwContent;
	/**
	 * 0未发布、1已发布
	 */
	@Column(name = "HW_STATUS")
	private String hwStatus;
	/**
	 * 交作业截止时间
	 */
	@Column(name = "HW_ENDDATE")
	private Date hwEnddate;
	/**
	 * 单位是天
	 */
	@Column(name = "HW_WORK_TIME_LIMIT")
	private Integer hwWorkTimeLimit;
	/**
	 * 交作业人数
	 */
	@Column(name = "HW_SUBMIT_NUM")
	private Long hwSubmitNum;
	/**
	 * 创建人
	 */
	@Column(name = "CREATE_BY")
	private String createBy;
	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_DATE")
	private Date createDate;
	/**
	 * 更新人
	 */
	@Column(name = "UPDATE_BY")
	private String updateBy;
	/**
	 * 更新时间
	 */
	@Column(name = "UPDATE_DATE")
	private Date updateDate;
	/**
	 * 删除标记
	 */
	@Column(name = "DEL_FLAG")
	private String delFlag;
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
	private List<String> siteIds;// 站点id列表

	/**
	 * 作业附件
	 */
	@Transient
	private List<WkHomeworkAttachment> homeworkAttachments = new ArrayList<WkHomeworkAttachment>();

	public String getHwId() {
		return hwId;
	}

	public void setHwId(String hwId) {
		this.hwId = hwId;
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

	public String getHwStatus() {
		return hwStatus;
	}

	public void setHwStatus(String hwStatus) {
		this.hwStatus = hwStatus;
	}

	public Date getHwEnddate() {
		return hwEnddate;
	}

	public void setHwEnddate(Date hwEnddate) {
		this.hwEnddate = hwEnddate;
	}

	public Integer getHwWorkTimeLimit() {
		return hwWorkTimeLimit;
	}

	public void setHwWorkTimeLimit(Integer hwWorkTimeLimit) {
		this.hwWorkTimeLimit = hwWorkTimeLimit;
	}

	public Long getHwSubmitNum() {
		return hwSubmitNum;
	}

	public void setHwSubmitNum(Long hwSubmitNum) {
		this.hwSubmitNum = hwSubmitNum;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
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

		public static String TABLE_NAME = "WK_HOMEWORK"; // 表名

		// public static String TABLE_SCHEMA = ConfigUtils.getValue(""); // 库名

		public static String hwId = "HW_ID"; // 作业id
		public static String hwTitle = "HW_TITLE"; // 标题
		public static String hwContent = "HW_CONTENT"; // 内容
		public static String hwStatus = "HW_STATUS"; // 0未发布、1已发布
		public static String hwEnddate = "HW_ENDDATE"; // 交作业截止时间
		public static String hwWorkTimeLimit = "HW_WORK_TIME_LIMIT"; // 单位是天
		public static String hwSubmitNum = "HW_SUBMIT_NUM"; // 交作业人数
		public static String createBy = "CREATE_BY"; // 创建人
		public static String createDate = "CREATE_DATE"; // 创建时间
		public static String updateBy = "UPDATE_BY"; // 更新人
		public static String updateDate = "UPDATE_DATE"; // 更新时间
		public static String delFlag = "DEL_FLAG"; // 删除标记
		public static String siteId = "SITE_ID"; // 站点
		public static String mchtId = "MCHT_ID"; // 商户id
		public static String mchtSchmId = "MCHT_SCHM_ID"; // 商户方案id

	}

	public List<WkHomeworkAttachment> getHomeworkAttachments() {
		return homeworkAttachments;
	}

	public void setHomeworkAttachments(List<WkHomeworkAttachment> homeworkAttachments) {
		this.homeworkAttachments = homeworkAttachments;
	}

	public List<String> getSiteIds() {
		return siteIds;
	}

	public void setSiteIds(List<String> siteIds) {
		this.siteIds = siteIds;
	}
}
