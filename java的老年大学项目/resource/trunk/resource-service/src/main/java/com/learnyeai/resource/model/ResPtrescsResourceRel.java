package com.learnyeai.resource.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 资源-平台资源大类
 *
 * @author twang
 */
public class ResPtrescsResourceRel extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 平台资源大类id
     */
    @Column(name = "PTRES_CS_ID")
    private String ptresCsId;
    /**
     * 资源id
     */
    @Column(name = "RES_ID")
    private String resId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getPtresCsId() {
        return ptresCsId;
    }

    public void setPtresCsId(String ptresCsId) {
        this.ptresCsId = ptresCsId;
    }
    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public static class TF {

        public static String TABLE_NAME = "RES_PTRESCS_RESOURCE_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String id = "ID";  // id
        public static String ptresCsId = "PTRES_CS_ID";  // 平台资源大类id
        public static String resId = "RES_ID";  // 资源id

    }
}
