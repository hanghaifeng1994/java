package com.learnyeai.resource.api.vo;

import com.learnyeai.core.support.BaseVo;

/**
 * 
 *
 * @author twang
 */
public class StdConfigVo extends BaseVo {

    /**
    * ID
    */
    private String id;

    /**
     * 配置项目
     */
    private String cgItem;
    /**
     * 配置值
     */
    private String cgValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getCgItem() {
        return cgItem;
    }

    public void setCgItem(String cgItem) {
        this.cgItem = cgItem;
    }
    public String getCgValue() {
        return cgValue;
    }

    public void setCgValue(String cgValue) {
        this.cgValue = cgValue;
    }

    public static class TF {
        public static String id = "id";  // ID
        public static String cgItem = "cgItem";  // 配置项目
        public static String cgValue = "cgValue";  // 配置值

    }

}
