package com.learnyeai.course.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 课程分类
 *
 * @author twang
 */
public class CrsCatalog extends BaseEntity {

	/**
	 * id
	 */
	@Id
	@Column(name = "CAT_ID")
	private String catId;

	/**
	 * 分类名称
	 */
	@Column(name = "CAT_NAME")
	private String catName;
	/**
	 * 排序
	 */
	@Column(name = "CAT_SORT")
	private Long catSort;
	/**
	 * 等级
	 */
	@Column(name = "CAT_LEVEL")
	private Integer catLevel;
	/**
	 * 父id
	 */
	@Column(name = "PARENT_ID")
	private String parentId;
	/**
	 * 所有父ids
	 */
	@Column(name = "PARENT_IDS")
	private String parentIds;
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
	private String showStatus;
	
	@Transient
	private List<String> siteIds;//站点id列表
	
	private List<CrsCatalog> childs = new ArrayList<CrsCatalog>();;

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public Long getCatSort() {
		return catSort;
	}

	public void setCatSort(Long catSort) {
		this.catSort = catSort;
	}

	public Integer getCatLevel() {
		return catLevel;
	}

	public void setCatLevel(Integer catLevel) {
		this.catLevel = catLevel;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
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

		public static String TABLE_NAME = "CRS_CATALOG"; // 表名

		// public static String TABLE_SCHEMA = ConfigUtils.getValue(""); // 库名

		public static String catId = "CAT_ID"; // id
		public static String catName = "CAT_NAME"; // 分类名称
		public static String catSort = "CAT_SORT"; // 排序
		public static String catLevel = "CAT_LEVEL"; // 等级
		public static String parentId = "PARENT_ID"; // 父id
		public static String parentIds = "PARENT_IDS"; // 所有父ids
		public static String createBy = "CREATE_BY"; // 创建人
		public static String createDate = "CREATE_DATE"; // 创建时间
		public static String updateBy = "UPDATE_BY"; // 更新人
		public static String updateDate = "UPDATE_DATE"; // 更新时间
		public static String delFlag = "DEL_FLAG"; // 删除标记
		public static String siteId = "SITE_ID"; // 站点
		public static String mchtId = "MCHT_ID"; // 商户id
		public static String mchtSchmId = "MCHT_SCHM_ID"; // 商户方案id

	}

	public String getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(String showStatus) {
		this.showStatus = showStatus;
	}

	public List<String> getSiteIds() {
		return siteIds;
	}

	public void setSiteIds(List<String> siteIds) {
		this.siteIds = siteIds;
	}

	public List<CrsCatalog> getChilds() {
		return childs;
	}

	public void setChilds(List<CrsCatalog> childs) {
		this.childs = childs;
	}
}
