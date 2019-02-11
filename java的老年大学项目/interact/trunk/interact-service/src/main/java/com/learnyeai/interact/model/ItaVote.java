package com.learnyeai.interact.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * 投票
 *
 * @author yl
 */
public class ItaVote extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "VT_ID")
    private String vtId;

    /**
     * 对像id
     */
    @Column(name = "OBJ_ID")
    private String objId;
    /**
     * 类型
     */
    @Column(name = "TYPE")
    private String type;
    /**
     * 投票人id
     */
    @Column(name = "VT_USER_ID")
    private String vtUserId;
    /**
     * 投标人名称
     */
    @Column(name = "VT_USER_NAME")
    private String vtUserName;
    /**
     * 投票时间
     */
    @Column(name = "VT_DATE")
    private Date vtDate;
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
    private List<ItaVote> list;

    public List<ItaVote> getList() {
        return list;
    }

    public void setList(List<ItaVote> list) {
        this.list = list;
    }

    public String getVtId() {
        return vtId;
    }

    public void setVtId(String vtId) {
        this.vtId = vtId;
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
    public String getVtUserId() {
        return vtUserId;
    }

    public void setVtUserId(String vtUserId) {
        this.vtUserId = vtUserId;
    }
    public String getVtUserName() {
        return vtUserName;
    }

    public void setVtUserName(String vtUserName) {
        this.vtUserName = vtUserName;
    }
    public Date getVtDate() {
        return vtDate;
    }

    public void setVtDate(Date vtDate) {
        this.vtDate = vtDate;
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

        public static String TABLE_NAME = "ITA_VOTE";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String vtId = "VT_ID";  // ID
        public static String objId = "OBJ_ID";  // 对像id
        public static String type = "TYPE";  // 类型
        public static String vtUserId = "VT_USER_ID";  // 投票人id
        public static String vtUserName = "VT_USER_NAME";  // 投标人名称
        public static String vtDate = "VT_DATE";  // 投票时间
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id

    }
}
