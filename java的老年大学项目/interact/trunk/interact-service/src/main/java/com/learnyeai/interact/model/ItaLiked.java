package com.learnyeai.interact.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * 点赞
 *
 * @author yl
 */
public class ItaLiked extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "LK_ID")
    private String lkId;

    /**
     * 对象id
     */
    @Column(name = "OBJ_ID")
    private String objId;
    /**
     * 对象类型
     */
    @Column(name = "TYPE")
    private String type;
    /**
     * 被点赞人id
     */
    @Column(name = "THE_USER_ID")
    private String theUserId;
    /**
     * 点赞人名称
     */
    @Column(name = "LK_USER_NAME")
    private String lkUserName;
    /**
     * 1点赞、2取消点赞
     */
    @Column(name = "LK_STATUS")
    private String lkStatus;
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
    @Transient
    private List<ItaLiked> list;

    public List<ItaLiked> getList() {
        return list;
    }

    public void setList(List<ItaLiked> list) {
        this.list = list;
    }

    public String getLkId() {
        return lkId;
    }

    public void setLkId(String lkId) {
        this.lkId = lkId;
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
    public String getTheUserId() {
        return theUserId;
    }

    public void setTheUserId(String theUserId) {
        this.theUserId = theUserId;
    }
    public String getLkUserName() {
        return lkUserName;
    }

    public void setLkUserName(String lkUserName) {
        this.lkUserName = lkUserName;
    }
    public String getLkStatus() {
        return lkStatus;
    }

    public void setLkStatus(String lkStatus) {
        this.lkStatus = lkStatus;
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

        public static String TABLE_NAME = "ITA_LIKED";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String lkId = "LK_ID";  // id
        public static String objId = "OBJ_ID";  // 对象id
        public static String type = "TYPE";  // 对象类型
        public static String theUserId = "THE_USER_ID";  // 被点赞人id
        public static String lkUserName = "LK_USER_NAME";  // 点赞人名称
        public static String lkStatus = "LK_STATUS";  // 1点赞、2取消点赞
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id

    }
}
