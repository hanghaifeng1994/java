package cn.com.weye.modules.cfg.entity;

import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.BBaseEntity;
import java.util.Date;

/**
 * 行业方案
 *
 * @author zpzxskxsk@126.com
 */
public class CfgScheme extends BBaseEntity {

    /**
     * 行业方案id
     */
    private String schmId;
    /**
     * 行业方案名称
     */
    private String schmName;
    /**
     * 图片
     */
    private String schmPhoto;
    /**
     * 方案概要
     */
    private String schmBrief;
    /**
     * 方案描述
     */
    private String schmDesc;
    /**
     * 行业
     */
    private String schmIndustry;
    /**
     * 图片集
     */
    private String schmImgs;
    /**
     * 0未发布、1已发布
     */
    private String schmStatus;
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
     * 删除标记
     */
    private String delFlag;

    public String getSchmId() {
        return schmId;
    }

    public void setSchmId(String schmId) {
        this.schmId = schmId;
    }
    public String getSchmName() {
        return schmName;
    }

    public void setSchmName(String schmName) {
        this.schmName = schmName;
    }
    public String getSchmPhoto() {
        return schmPhoto;
    }

    public void setSchmPhoto(String schmPhoto) {
        this.schmPhoto = schmPhoto;
    }
    public String getSchmBrief() {
        return schmBrief;
    }

    public void setSchmBrief(String schmBrief) {
        this.schmBrief = schmBrief;
    }
    public String getSchmDesc() {
        return schmDesc;
    }

    public void setSchmDesc(String schmDesc) {
        this.schmDesc = schmDesc;
    }
    public String getSchmIndustry() {
        return schmIndustry;
    }

    public void setSchmIndustry(String schmIndustry) {
        this.schmIndustry = schmIndustry;
    }
    public String getSchmImgs() {
        return schmImgs;
    }

    public void setSchmImgs(String schmImgs) {
        this.schmImgs = schmImgs;
    }
    public String getSchmStatus() {
        return schmStatus;
    }

    public void setSchmStatus(String schmStatus) {
        this.schmStatus = schmStatus;
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

    public static class TF {

        public static String TABLE_NAME = "CFG_SCHEME";   // 表名

        public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String schmId = "SCHM_ID";  // 行业方案id
        public static String schmName = "SCHM_NAME";  // 行业方案名称
        public static String schmPhoto = "SCHM_PHOTO";  // 图片
        public static String schmBrief = "SCHM_BRIEF";  // 方案概要
        public static String schmDesc = "SCHM_DESC";  // 方案描述
        public static String schmIndustry = "SCHM_INDUSTRY";  // 行业
        public static String schmImgs = "SCHM_IMGS";  // 图片集
        public static String schmStatus = "SCHM_STATUS";  // 0未发布、1已发布
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateBy = "UPDATE_BY";  // 更新人
        public static String updateDate = "UPDATE_DATE";  // 更新时间
        public static String delFlag = "DEL_FLAG";  // 删除标记

    }
}
