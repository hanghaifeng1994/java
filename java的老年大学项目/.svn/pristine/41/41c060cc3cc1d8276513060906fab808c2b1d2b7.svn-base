package com.learnyeai.studygroup.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 小组成员
 *
 * @author yl
 */
public class SgpMember extends BaseEntity {

    /**
    * 小组id
    */
    @Id
    @Column(name = "SGP_ID")
    private String sgpId;
    /**
    * 客户id
    */
    @Id
    @Column(name = "CUST_ID")
    private String custId;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATE")
    private Date createDate;
    /**
     * 状态0未参加1参加
     */
    @Transient
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSgpId() {
        return sgpId;
    }

    public void setSgpId(String sgpId) {
        this.sgpId = sgpId;
    }
    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public static class TF {

        public static String TABLE_NAME = "SGP_MEMBER";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String sgpId = "SGP_ID";  // 小组id
        public static String custId = "CUST_ID";  // 客户id
        public static String createDate = "CREATE_DATE";  // 创建时间

    }
}
