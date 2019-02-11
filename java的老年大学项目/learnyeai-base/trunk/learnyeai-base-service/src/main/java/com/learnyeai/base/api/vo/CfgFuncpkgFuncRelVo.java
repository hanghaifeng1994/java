package com.learnyeai.base.api.vo;

import com.learnyeai.core.support.BaseVo;

/**
 * 功能包_功能关联表
 *
 * @author zhangpz
 */
public class CfgFuncpkgFuncRelVo extends BaseVo {

    /**
    * 功能包id
    */
    private String pkgId;
    /**
    * 功能id
    */
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

    public static class CF {
        public static String pkgId = "pkgId";  // 功能包id
        public static String funcId = "funcId";  // 功能id

    }

}
