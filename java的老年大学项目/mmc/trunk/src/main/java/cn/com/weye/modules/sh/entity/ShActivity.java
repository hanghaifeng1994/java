package cn.com.weye.modules.sh.entity;

import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.BBaseEntity;
import java.util.Date;

/**
 * 活动
 *
 * @author yl
 */
public class ShActivity extends BBaseEntity {

    /**
     * 活动id
     */
    private String actId;
    /**
     * 活动名称
     */
    private String actName;
    /**
     * 活动描述
     */
    private String actDesc;
    /**
     * 优惠金额
     */
    private Long actDiscountAmount;
    /**
     * 开始时间
     */
    private Date actStartDate;
    /**
     * 结束时间
     */
    private Date actEndDate;
    /**
     * 0未发布，1发布
     */
    private String actStatus;
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

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }
    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }
    public String getActDesc() {
        return actDesc;
    }

    public void setActDesc(String actDesc) {
        this.actDesc = actDesc;
    }
    public Long getActDiscountAmount() {
        return actDiscountAmount;
    }

    public void setActDiscountAmount(Long actDiscountAmount) {
        this.actDiscountAmount = actDiscountAmount;
    }
    public Date getActStartDate() {
        return actStartDate;
    }

    public void setActStartDate(Date actStartDate) {
        this.actStartDate = actStartDate;
    }
    public Date getActEndDate() {
        return actEndDate;
    }

    public void setActEndDate(Date actEndDate) {
        this.actEndDate = actEndDate;
    }
    public String getActStatus() {
        return actStatus;
    }

    public void setActStatus(String actStatus) {
        this.actStatus = actStatus;
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

    public static class TF {

        public static String TABLE_NAME = "SH_ACTIVITY";   // 表名

        public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String actId = "ACT_ID";  // 活动id
        public static String actName = "ACT_NAME";  // 活动名称
        public static String actDesc = "ACT_DESC";  // 活动描述
        public static String actDiscountAmount = "ACT_DISCOUNT_AMOUNT";  // 优惠金额
        public static String actStartDate = "ACT_START_DATE";  // 开始时间
        public static String actEndDate = "ACT_END_DATE";  // 结束时间
        public static String actStatus = "ACT_STATUS";  // 0未发布，1发布
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateBy = "UPDATE_BY";  // 更新人
        public static String updateDate = "UPDATE_DATE";  // 更新时间

    }
}
