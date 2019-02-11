package com.learnyeai.base.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 商户方案功能包
 *
 * @author zhangpz
 */
public class ShMerchantSchemePackage extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "MSP_ID")
    private String mspId;

    /**
     * 商户方案id
     */
    @Column(name = "MCHT_SCHM_ID")
    private String mchtSchmId;
    /**
     * 功能包id
     */
    @Column(name = "PKG_ID")
    private String pkgId;
    /**
     * 版本功能包历史id
     */
    @Column(name = "EDT_PKG_HIS_ID")
    private String edtPkgHisId;

    public String getMspId() {
        return mspId;
    }

    public void setMspId(String mspId) {
        this.mspId = mspId;
    }
    public String getMchtSchmId() {
        return mchtSchmId;
    }

    public void setMchtSchmId(String mchtSchmId) {
        this.mchtSchmId = mchtSchmId;
    }
    public String getPkgId() {
        return pkgId;
    }

    public void setPkgId(String pkgId) {
        this.pkgId = pkgId;
    }
    public String getEdtPkgHisId() {
        return edtPkgHisId;
    }

    public void setEdtPkgHisId(String edtPkgHisId) {
        this.edtPkgHisId = edtPkgHisId;
    }

    public static class TF {

        public static String TABLE_NAME = "SH_MERCHANT_SCHEME_PACKAGE";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String mspId = "MSP_ID";  // id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id
        public static String pkgId = "PKG_ID";  // 功能包id
        public static String edtPkgHisId = "EDT_PKG_HIS_ID";  // 版本功能包历史id

    }
}
