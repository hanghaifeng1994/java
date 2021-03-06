package com.learnyeai.interact.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 收藏
 *
 * @author yl
 */
public class ItaCollection extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "CLT_ID")
    private String cltId;

    /**
     * 标签
     */
    @Column(name = "TAG")
    private String tag;
    /**
     * 对象id
     */
    @Column(name = "OBJ_ID")
    private String objId;
    /**
     * 类型
     */
    @Column(name = "TYPE")
    private String type;
    /**
     * 1收藏、2取消收藏
     */
    @Column(name = "CLT_STATUS")
    private String cltStatus;
    /**
     * 创建人
     */
    @Column(name = "CREATE_BY")
    private String createBy;
    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATE")
    private Date createDate;
    /**
     * 商户id
     */
    @Column(name = "MCHT_ID")
    private String mchtId;
    /**
     * 商户方案id
     */
    @Column(name = "MCHT_SCHM_ID")
    private String mchtSchmId;

    public String getCltId() {
        return cltId;
    }

    public void setCltId(String cltId) {
        this.cltId = cltId;
    }
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getCltStatus() {
        return cltStatus;
    }

    public void setCltStatus(String cltStatus) {
        this.cltStatus = cltStatus;
    }
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public String getMchtId() {
        return mchtId;
    }

    public void setMchtId(String mchtId) {
        this.mchtId = mchtId;
    }
    public String getMchtSchmId() {
        return mchtSchmId;
    }

    public void setMchtSchmId(String mchtSchmId) {
        this.mchtSchmId = mchtSchmId;
    }

    public static class TF {

        public static String TABLE_NAME = "ITA_COLLECTION";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String cltId = "CLT_ID";  // id
        public static String tag = "TAG";  // 标签
        public static String objId = "OBJ_ID";  // 对象id
        public static String type = "TYPE";  // 类型
        public static String cltStatus = "CLT_STATUS";  // 1收藏、2取消收藏
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id

    }
}
