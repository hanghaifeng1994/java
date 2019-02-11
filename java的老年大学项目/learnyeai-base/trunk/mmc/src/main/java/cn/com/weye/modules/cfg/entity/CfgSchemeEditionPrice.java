package cn.com.weye.modules.cfg.entity;

import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.BBaseEntity;
import java.util.Date;

/**
 * 方案版本价格
 *
 * @author yl
 */
public class CfgSchemeEditionPrice extends BBaseEntity {

    /**
     * id
     */
    private String edtPrcId;
    /**
     * 方案版本id
     */
    private String schmEdtId;
    /**
     * 名称
     */
    private String edtPrcName;
    /**
     * 年价格
     */
    private Long edtPrcYearPrice;
    /**
     * 月价格
     */
    private Long edtPrcMonthPrice;
    /**
     * 门店数
     */
    private Long edtPrcStoreNum;
    /**
     * 状态：0禁用、1启用、作废
     */
    private String edtPrcStatus;
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

    public String getEdtPrcId() {
        return edtPrcId;
    }

    public void setEdtPrcId(String edtPrcId) {
        this.edtPrcId = edtPrcId;
    }
    public String getSchmEdtId() {
        return schmEdtId;
    }

    public void setSchmEdtId(String schmEdtId) {
        this.schmEdtId = schmEdtId;
    }
    public String getEdtPrcName() {
        return edtPrcName;
    }

    public void setEdtPrcName(String edtPrcName) {
        this.edtPrcName = edtPrcName;
    }
    public Long getEdtPrcYearPrice() {
        return edtPrcYearPrice;
    }

    public void setEdtPrcYearPrice(Long edtPrcYearPrice) {
        this.edtPrcYearPrice = edtPrcYearPrice;
    }
    public Long getEdtPrcMonthPrice() {
        return edtPrcMonthPrice;
    }

    public void setEdtPrcMonthPrice(Long edtPrcMonthPrice) {
        this.edtPrcMonthPrice = edtPrcMonthPrice;
    }
    public Long getEdtPrcStoreNum() {
        return edtPrcStoreNum;
    }

    public void setEdtPrcStoreNum(Long edtPrcStoreNum) {
        this.edtPrcStoreNum = edtPrcStoreNum;
    }
    public String getEdtPrcStatus() {
        return edtPrcStatus;
    }

    public void setEdtPrcStatus(String edtPrcStatus) {
        this.edtPrcStatus = edtPrcStatus;
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

        public static String TABLE_NAME = "CFG_SCHEME_EDITION_PRICE";   // 表名

        public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String edtPrcId = "EDT_PRC_ID";  // id
        public static String schmEdtId = "SCHM_EDT_ID";  // 方案版本id
        public static String edtPrcName = "EDT_PRC_NAME";  // 名称
        public static String edtPrcYearPrice = "EDT_PRC_YEAR_PRICE";  // 年价格
        public static String edtPrcMonthPrice = "EDT_PRC_MONTH_PRICE";  // 月价格
        public static String edtPrcStoreNum = "EDT_PRC_STORE_NUM";  // 门店数
        public static String edtPrcStatus = "EDT_PRC_STATUS";  // 状态：0禁用、1启用、作废
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateBy = "UPDATE_BY";  // 更新人
        public static String updateDate = "UPDATE_DATE";  // 更新时间
        public static String delFlag = "DEL_FLAG";  // 删除标记

    }
}
