package com.learnyeai.resource.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 
 *
 * @author twang
 */
public class StdConfig extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 配置项目
     */
    @Column(name = "CG_ITEM")
    private String cgItem;
    /**
     * 配置值
     */
    @Column(name = "CG_VALUE")
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

        public static String TABLE_NAME = "STD_CONFIG";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String id = "ID";  // ID
        public static String cgItem = "CG_ITEM";  // 配置项目
        public static String cgValue = "CG_VALUE";  // 配置值

    }
}
