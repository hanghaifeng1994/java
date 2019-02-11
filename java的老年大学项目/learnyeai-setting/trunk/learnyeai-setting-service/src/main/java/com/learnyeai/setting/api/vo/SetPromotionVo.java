package com.learnyeai.setting.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 推广
 *
 * @author zhangpz
 */
public class SetPromotionVo extends BaseVo {

    /**
    * id
    */
    private String id;

    /**
     * 业务类型
     */
    private String serviceType;
    /**
     * 0禁用、1启用
     */
    private String status;
    /**
     * 标题
     */
    private String title;
    /**
     * 图片
     */
    private String imgs;
    /**
     * url
     */
    private String url;
    /**
     * 排序
     */
    private Long sort;
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
     * 备注
     */
    private String remarks;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
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
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public static class CF {
        public static String id = "id";  // id
        public static String serviceType = "serviceType";  // 业务类型
        public static String status = "status";  // 0禁用、1启用
        public static String title = "title";  // 标题
        public static String imgs = "imgs";  // 图片
        public static String url = "url";  // url
        public static String sort = "sort";  // 排序
        public static String createBy = "createBy";  // 创建人
        public static String createDate = "createDate";  // 创建时间
        public static String updateBy = "updateBy";  // 更新人
        public static String updateDate = "updateDate";  // 更新时间
        public static String remarks = "remarks";  // 备注
        public static String delFlag = "delFlag";  // 删除标记
        public static String siteId = "siteId";  // 站点
        public static String mchtId = "mchtId";  // 商户id
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id

    }

}
