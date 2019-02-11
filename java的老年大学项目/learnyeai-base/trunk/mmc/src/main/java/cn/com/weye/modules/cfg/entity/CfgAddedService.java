package cn.com.weye.modules.cfg.entity;

import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.BBaseEntity;
import java.util.Date;

/**
 * 增值服务
 *
 * @author yl
 */
public class CfgAddedService extends BBaseEntity {

    /**
     * id
     */
    private String asId;
    /**
     * 增值服务名称
     */
    private String asName;
    /**
     * 服务价格
     */
    private Long asPrice;
    /**
     * 编码
     */
    private String asCode;
    /**
     * 状态：0未启用、1启用、2作废
     */
    private String asStatus;
    /**
     * 描述
     */
    private String asDesc;
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
//    开始时间
    private Date beginDate;
//    结束时间
    private Date endDate;

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAsId() {
        return asId;
    }

    public void setAsId(String asId) {
        this.asId = asId;
    }
    public String getAsName() {
        return asName;
    }

    public void setAsName(String asName) {
        this.asName = asName;
    }
    public Long getAsPrice() {
        return asPrice;
    }

    public void setAsPrice(Long asPrice) {
        this.asPrice = asPrice;
    }
    public String getAsCode() {
        return asCode;
    }

    public void setAsCode(String asCode) {
        this.asCode = asCode;
    }
    public String getAsStatus() {
        return asStatus;
    }

    public void setAsStatus(String asStatus) {
        this.asStatus = asStatus;
    }
    public String getAsDesc() {
        return asDesc;
    }

    public void setAsDesc(String asDesc) {
        this.asDesc = asDesc;
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

        public static String TABLE_NAME = "CFG_ADDED_SERVICE";   // 表名

        public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String asId = "AS_ID";  // id
        public static String asName = "AS_NAME";  // 增值服务名称
        public static String asPrice = "AS_PRICE";  // 服务价格
        public static String asCode = "AS_CODE";  // 编码
        public static String asStatus = "AS_STATUS";  // 状态：0未启用、1启用、2作废
        public static String asDesc = "AS_DESC";  // 描述
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateBy = "UPDATE_BY";  // 更新人
        public static String updateDate = "UPDATE_DATE";  // 更新时间

    }
}
