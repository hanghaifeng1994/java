package com.learnyeai.base.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 短信模板
 *
 * @author zhangpz
 */
public class SmsTmpl extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "ST_ID")
    private String stId;

    /**
     * 模板类型
     */
    @Column(name = "ST_TYPE")
    private String stType;
    /**
     * 模板编号
     */
    @Column(name = "ST_NO")
    private String stNo;
    /**
     * 模板内容
     */
    @Column(name = "ST_CONT")
    private String stCont;

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }
    public String getStType() {
        return stType;
    }

    public void setStType(String stType) {
        this.stType = stType;
    }
    public String getStNo() {
        return stNo;
    }

    public void setStNo(String stNo) {
        this.stNo = stNo;
    }
    public String getStCont() {
        return stCont;
    }

    public void setStCont(String stCont) {
        this.stCont = stCont;
    }

    public static class TF {

        public static String TABLE_NAME = "SMS_TMPL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String stId = "ST_ID";  // ID
        public static String stType = "ST_TYPE";  // 模板类型
        public static String stNo = "ST_NO";  // 模板编号
        public static String stCont = "ST_CONT";  // 模板内容

    }
}
