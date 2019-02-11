package com.learnyeai.base.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 方案版本功能包历史
 *
 * @author zhangpz
 */
public class CfgSchmEdtPackageHis extends BaseEntity {

    /**
    * 方案版本功能包历史id
    */
    @Id
    @Column(name = "EDT_PKG_HIS_ID")
    private String edtPkgHisId;

    /**
     * 方案版本功能包id
     */
    @Column(name = "EDT_PKG_ID")
    private String edtPkgId;
    /**
     * 功能包id
     */
    @Column(name = "PKG_ID")
    private String pkgId;
    /**
     * 功能包名称
     */
    @Column(name = "PKG_NAME")
    private String pkgName;
    /**
     * 方案版本历史id
     */
    @Column(name = "SCHM_EDT_HIS_ID")
    private String schmEdtHisId;
    /**
     * 1基础、2增值
     */
    @Column(name = "EDT_PKG_TYPE")
    private String edtPkgType;
    /**
     * 年价格
     */
    @Column(name = "EDT_PKG_YEAR_PRICE")
    private Long edtPkgYearPrice;
    /**
     * 月价格
     */
    @Column(name = "EDT_PKG_MONTH_PRICE")
    private Long edtPkgMonthPrice;
    /**
     * 模块id
     */
    @Column(name = "MDL_ID")
    private String mdlId;
    /**
     * 模块名称
     */
    @Column(name = "MDL_NAME")
    private String mdlName;
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

    public String getEdtPkgHisId() {
        return edtPkgHisId;
    }

    public void setEdtPkgHisId(String edtPkgHisId) {
        this.edtPkgHisId = edtPkgHisId;
    }
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
    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }
    public String getSchmEdtHisId() {
        return schmEdtHisId;
    }

    public void setSchmEdtHisId(String schmEdtHisId) {
        this.schmEdtHisId = schmEdtHisId;
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
    public String getMdlName() {
        return mdlName;
    }

    public void setMdlName(String mdlName) {
        this.mdlName = mdlName;
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

    public static class TF {

        public static String TABLE_NAME = "CFG_SCHM_EDT_PACKAGE_HIS";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String edtPkgHisId = "EDT_PKG_HIS_ID";  // 方案版本功能包历史id
        public static String edtPkgId = "EDT_PKG_ID";  // 方案版本功能包id
        public static String pkgId = "PKG_ID";  // 功能包id
        public static String pkgName = "PKG_NAME";  // 功能包名称
        public static String schmEdtHisId = "SCHM_EDT_HIS_ID";  // 方案版本历史id
        public static String edtPkgType = "EDT_PKG_TYPE";  // 1基础、2增值
        public static String edtPkgYearPrice = "EDT_PKG_YEAR_PRICE";  // 年价格
        public static String edtPkgMonthPrice = "EDT_PKG_MONTH_PRICE";  // 月价格
        public static String mdlId = "MDL_ID";  // 模块id
        public static String mdlName = "MDL_NAME";  // 模块名称
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间

    }
}
