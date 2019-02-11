package com.learnyeai.course.model;

import com.google.common.collect.Lists;
import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * 课程章节
 *
 * @author twang
 */
public class CrsChapter extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "CPT_ID")
    private String cptId;

    /**
     * 名称
     */
    @Column(name = "CPT_NAME")
    private String cptName;
    /**
     * 介绍
     */
    @Column(name = "CPT_INFO")
    private String cptInfo;
    /**
     * 封面
     */
    @Column(name = "CPT_PHOTO")
    private String cptPhoto;
    /**
     * 最大学习时间
     */
    @Column(name = "CPT_MAX_STUDY_TIME")
    private Long cptMaxStudyTime;
    /**
     * 排序
     */
    @Column(name = "CPT_SORT")
    private Long cptSort;
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
     * 课程id
     */
    @Column(name = "CS_ID")
    private String csId;
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
    
	private List<CrsChapter> childs = Lists.newArrayList();

    public String getCptId() {
        return cptId;
    }

    public void setCptId(String cptId) {
        this.cptId = cptId;
    }
    public String getCptName() {
        return cptName;
    }

    public void setCptName(String cptName) {
        this.cptName = cptName;
    }
    public String getCptInfo() {
        return cptInfo;
    }

    public void setCptInfo(String cptInfo) {
        this.cptInfo = cptInfo;
    }
    public String getCptPhoto() {
        return cptPhoto;
    }

    public void setCptPhoto(String cptPhoto) {
        this.cptPhoto = cptPhoto;
    }
    public Long getCptMaxStudyTime() {
        return cptMaxStudyTime;
    }

    public void setCptMaxStudyTime(Long cptMaxStudyTime) {
        this.cptMaxStudyTime = cptMaxStudyTime;
    }
    public Long getCptSort() {
        return cptSort;
    }

    public void setCptSort(Long cptSort) {
        this.cptSort = cptSort;
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
    public String getCsId() {
        return csId;
    }

    public void setCsId(String csId) {
        this.csId = csId;
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

        public static String TABLE_NAME = "CRS_CHAPTER";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String cptId = "CPT_ID";  // id
        public static String cptName = "CPT_NAME";  // 名称
        public static String cptInfo = "CPT_INFO";  // 介绍
        public static String cptPhoto = "CPT_PHOTO";  // 封面
        public static String cptMaxStudyTime = "CPT_MAX_STUDY_TIME";  // 最大学习时间
        public static String cptSort = "CPT_SORT";  // 排序
        public static String parentId = "PARENT_ID";  // 父id
        public static String parentIds = "PARENT_IDS";  // 所有父ids
        public static String csId = "CS_ID";  // 课程id
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateBy = "UPDATE_BY";  // 更新人
        public static String updateDate = "UPDATE_DATE";  // 更新时间
        public static String delFlag = "DEL_FLAG";  // 删除标记
        public static String siteId = "SITE_ID";  // 站点
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id

    }

	public List<CrsChapter> getChilds() {
		return childs;
	}

	public void setChilds(List<CrsChapter> childs) {
		this.childs = childs;
	}
}
