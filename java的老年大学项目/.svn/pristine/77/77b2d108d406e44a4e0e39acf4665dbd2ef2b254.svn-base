package com.learnyeai.base.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 功能包_功能关联表
 *
 * @author zhangpz
 */
public class CfgFuncpkgFuncRel extends BaseEntity {

    /**
    * 功能包id
    */
    @Id
    @Column(name = "PKG_ID")
    private String pkgId;
    /**
    * 功能id
    */
    @Id
    @Column(name = "FUNC_ID")
    private String funcId;


    public String getPkgId() {
        return pkgId;
    }

    public void setPkgId(String pkgId) {
        this.pkgId = pkgId;
    }
    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }

    public static class TF {

        public static String TABLE_NAME = "CFG_FUNCPKG_FUNC_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String pkgId = "PKG_ID";  // 功能包id
        public static String funcId = "FUNC_ID";  // 功能id

    }
}
