package com.learnyeai.base.api.vo;

import com.learnyeai.core.support.BaseVo;

import java.util.Date;

/**
 * 方案版本功能包历史
 *
 * @author zhangpz
 */
public class CfgSchmEdtPackageHisVo extends BaseVo {

    /**
    * 方案版本功能包历史id
    */
    private String edtPkgHisId;

    /**
     * 方案版本功能包id
     */
    private String edtPkgId;
    /**
     * 功能包id
     */
    private String pkgId;
    /**
     * 功能包名称
     */
    private String pkgName;
    /**
     * 方案版本历史id
     */
    private String schmEdtHisId;
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
     * 模块名称
     */
    private String mdlName;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
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

    public static class CF {
        public static String edtPkgHisId = "edtPkgHisId";  // 方案版本功能包历史id
        public static String edtPkgId = "edtPkgId";  // 方案版本功能包id
        public static String pkgId = "pkgId";  // 功能包id
        public static String pkgName = "pkgName";  // 功能包名称
        public static String schmEdtHisId = "schmEdtHisId";  // 方案版本历史id
        public static String edtPkgType = "edtPkgType";  // 1基础、2增值
        public static String edtPkgYearPrice = "edtPkgYearPrice";  // 年价格
        public static String edtPkgMonthPrice = "edtPkgMonthPrice";  // 月价格
        public static String mdlId = "mdlId";  // 模块id
        public static String mdlName = "mdlName";  // 模块名称
        public static String createBy = "createBy";  // 创建人
        public static String createDate = "createDate";  // 创建时间

    }

}
