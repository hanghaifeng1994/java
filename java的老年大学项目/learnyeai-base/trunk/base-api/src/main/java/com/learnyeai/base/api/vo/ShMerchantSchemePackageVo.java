package com.learnyeai.base.api.vo;

import com.learnyeai.core.support.BaseVo;

/**
 * 商户方案功能包
 *
 * @author zhangpz
 */
public class ShMerchantSchemePackageVo extends BaseVo {

    /**
    * id
    */
    private String mspId;

    /**
     * 商户方案id
     */
    private String mchtSchmId;
    /**
     * 功能包id
     */
    private String pkgId;
    /**
     * 版本功能包历史id
     */
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

    public static class CF {
        public static String mspId = "mspId";  // id
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id
        public static String pkgId = "pkgId";  // 功能包id
        public static String edtPkgHisId = "edtPkgHisId";  // 版本功能包历史id

    }

}
