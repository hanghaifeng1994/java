package com.learnyeai.schoolclass.api.vo;

import com.learnyeai.core.support.BaseVo;

/**
 * 班级-测验
 *
 * @author twang
 */
public class ClzClazzTestVo extends BaseVo {

    /**
    * ID
    */
    private String ctId;

    /**
     * 班级id
     */
    private String czId;
    /**
     * 测验id
     */
    private String tsId;

    public String getCtId() {
        return ctId;
    }

    public void setCtId(String ctId) {
        this.ctId = ctId;
    }
    public String getCzId() {
        return czId;
    }

    public void setCzId(String czId) {
        this.czId = czId;
    }
    public String getTsId() {
        return tsId;
    }

    public void setTsId(String tsId) {
        this.tsId = tsId;
    }

    public static class TF {
        public static String ctId = "ctId";  // ID
        public static String czId = "czId";  // 班级id
        public static String tsId = "tsId";  // 测验id

    }

}
