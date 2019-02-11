package cn.com.weye.modules.sh.entity;

import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.BBaseEntity;

/**
 * 订单功能包
 *
 * @author yl
 */
public class ShOrderPackage extends BBaseEntity {

    /**
     * 订单功能包Id
     */
    private String ordPkgId;
    /**
     * 商户订单id
     */
    private String ordId;
    /**
     * 版本功能包历史id
     */
    private String edtPkgHisId;
    /**
     * 功能包名称
     */
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

        public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String ordPkgId = "ORD_PKG_ID";  // 订单功能包Id
        public static String ordId = "ORD_ID";  // 商户订单id
        public static String edtPkgHisId = "EDT_PKG_HIS_ID";  // 版本功能包历史id
        public static String pkgName = "PKG_NAME";  // 功能包名称

    }
}
