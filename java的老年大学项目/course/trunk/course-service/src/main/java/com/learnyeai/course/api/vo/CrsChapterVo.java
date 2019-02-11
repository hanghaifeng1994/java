package com.learnyeai.course.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 课程章节
 *
 * @author twang
 */
public class CrsChapterVo extends BaseVo {

    /**
    * id
    */
    private String cptId;

    /**
     * 名称
     */
    private String cptName;
    /**
     * 介绍
     */
    private String cptInfo;
    /**
     * 封面
     */
    private String cptPhoto;
    /**
     * 最大学习时间
     */
    private Long cptMaxStudyTime;
    /**
     * 排序
     */
    private Long cptSort;
    /**
     * 父id
     */
    private String parentId;
    /**
     * 所有父ids
     */
    private String parentIds;
    /**
     * 课程id
     */
    private String csId;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateDate;
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
        public static String cptId = "cptId";  // id
        public static String cptName = "cptName";  // 名称
        public static String cptInfo = "cptInfo";  // 介绍
        public static String cptPhoto = "cptPhoto";  // 封面
        public static String cptMaxStudyTime = "cptMaxStudyTime";  // 最大学习时间
        public static String cptSort = "cptSort";  // 排序
        public static String parentId = "parentId";  // 父id
        public static String parentIds = "parentIds";  // 所有父ids
        public static String csId = "csId";  // 课程id
        public static String createBy = "createBy";  // 创建人
        public static String createDate = "createDate";  // 创建时间
        public static String updateBy = "updateBy";  // 更新人
        public static String updateDate = "updateDate";  // 更新时间
        public static String delFlag = "delFlag";  // 删除标记
        public static String siteId = "siteId";  // 站点
        public static String mchtId = "mchtId";  // 商户id
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id

    }

}
