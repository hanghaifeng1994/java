package cn.com.weye.modules.cfg.entity;

import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.BBaseEntity;
import java.util.Date;

/**
 * 方案版本功能包
 *
 * @author zpzxskxsk@126.com
 */
public class CfgSchmEdtPackage extends BBaseEntity {

    /**
     * 方案版本功能包id
     */
    private String edtPkgId;
    /**
     * 功能包id
     */
    private String pkgId;
    /**
     * 方案版本id
     */
    private String schmEdtId;
    /**
     * 0禁用、1启用
     */
    private String edtPkgStatus;
    /**
     * 1基础、2增值
     */
    private String edtPkgType;
    /**
     * 年价格
     */
    private Long edtPkgYearPrice;
    /**
     * 月价格
     */
    private Long edtPkgMonthPrice;
    /**
     * 模块id
     */
    private String mdlId;
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

    public String getEdtPkgId() {
        return edtPkgId;
    }

    public void setEdtPkgId(String edtPkgId) {
        this.edtPkgId = edtPkgId;
    }
    public String getPkgId() {
        return pkgId;
    }

    public void setPkgId(String pkgId) {
        this.pkgId = pkgId;
    }
    public String getSchmEdtId() {
        return schmEdtId;
    }

    public void setSchmEdtId(String schmEdtId) {
        this.schmEdtId = schmEdtId;
    }
    public String getEdtPkgStatus() {
        return edtPkgStatus;
    }

    public void setEdtPkgStatus(String edtPkgStatus) {
        this.edtPkgStatus = edtPkgStatus;
    }
    public String getEdtPkgType() {
        return edtPkgType;
    }

    public void setEdtPkgType(String edtPkgType) {
        this.edtPkgType = edtPkgType;
    }
    public Long getEdtPkgYearPrice() {
        return edtPkgYearPrice;
    }

    public void setEdtPkgYearPrice(Long edtPkgYearPrice) {
        this.edtPkgYearPrice = edtPkgYearPrice;
    }
    public Long getEdtPkgMonthPrice() {
        return edtPkgMonthPrice;
    }

    public void setEdtPkgMonthPrice(Long edtPkgMonthPrice) {
        this.edtPkgMonthPrice = edtPkgMonthPrice;
    }
    public String getMdlId() {
        return mdlId;
    }

    public void setMdlId(String mdlId) {
        this.mdlId = mdlId;
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

        public static String TABLE_NAME = "CFG_SCHM_EDT_PACKAGE";   // 表名

        public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String edtPkgId = "EDT_PKG_ID";  // 方案版本功能包id
        public static String pkgId = "PKG_ID";  // 功能包id
        public static String schmEdtId = "SCHM_EDT_ID";  // 方案版本id
        public static String edtPkgStatus = "EDT_PKG_STATUS";  // 0禁用、1启用
        public static String edtPkgType = "EDT_PKG_TYPE";  // 1基础、2增值
        public static String edtPkgYearPrice = "EDT_PKG_YEAR_PRICE";  // 年价格
        public static String edtPkgMonthPrice = "EDT_PKG_MONTH_PRICE";  // 月价格
        public static String mdlId = "MDL_ID";  // 模块id
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateBy = "UPDATE_BY";  // 更新人
        public static String updateDate = "UPDATE_DATE";  // 更新时间

    }
}
