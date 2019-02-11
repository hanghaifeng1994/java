package com.learnyeai.base.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 订单功能包
 *
 * @author zhangpz
 */
public class ShOrderPackage extends BaseEntity {

    /**
    * 订单功能包Id
    */
    @Id
    @Column(name = "ORD_PKG_ID")
    private String ordPkgId;

    /**
     * 商户订单id
     */
    @Column(name = "ORD_ID")
    private String ordId;
    /**
     * 版本功能包历史id
     */
    @Column(name = "EDT_PKG_HIS_ID")
    private String edtPkgHisId;
    /**
     * 功能包名称
     */
    @Column(name = "PKG_NAME")
    private String pkgName;

    public String getOrdPkgId() {
        return ordPkgId;
    }

    public void setOrdPkgId(String ordPkgId) {
        this.ordPkgId = ordPkgId;
    }
    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }
    public String getEdtPkgHisId() {
        return edtPkgHisId;
    }

    public void setEdtPkgHisId(String edtPkgHisId) {
        this.edtPkgHisId = edtPkgHisId;
    }
    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    public static class TF {

        public static String TABLE_NAME = "SH_ORDER_PACKAGE";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String ordPkgId = "ORD_PKG_ID";  // 订单功能包Id
        public static String ordId = "ORD_ID";  // 商户订单id
        public static String edtPkgHisId = "EDT_PKG_HIS_ID";  // 版本功能包历史id
        public static String pkgName = "PKG_NAME";  // 功能包名称

    }
}
