package com.learnyeai.base.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 时间到期处理
 *
 * @author zhangpz
 */
public class TimeExpires extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "TE_ID")
    private String teId;

    /**
     * 0未处理、1处理、2处理失败
     */
    @Column(name = "TE_STATUS")
    private String teStatus;
    /**
     * 过期时间
     */
    @Column(name = "TE_EXPIRE_DATE")
    private Date teExpireDate;
    /**
     * 业务类型
     */
    @Column(name = "TE_SERVICE_TYPE")
    private String teServiceType;
    /**
     * 逗号分割，根据具体业务类型、参数处理相关逻辑
     */
    @Column(name = "TE_SERVICE_PARAMS")
    private String teServiceParams;
    /**
     * 对象id
     */
    @Column(name = "TE_OBJ_ID")
    private String teObjId;
    /**
     * 客户id
     */
    @Column(name = "TE_CUST_ID")
    private String teCustId;
    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATE")
    private Date createDate;
    /**
     * 更新时间
     */
    @Column(name = "UPDATE_DATE")
    private Date updateDate;
    /**
     * 备注
     */
    @Column(name = "REMARKS")
    private String remarks;

    public String getTeId() {
        return teId;
    }

    public void setTeId(String teId) {
        this.teId = teId;
    }
    public String getTeStatus() {
        return teStatus;
    }

    public void setTeStatus(String teStatus) {
        this.teStatus = teStatus;
    }
    public Date getTeExpireDate() {
        return teExpireDate;
    }

    public void setTeExpireDate(Date teExpireDate) {
        this.teExpireDate = teExpireDate;
    }
    public String getTeServiceType() {
        return teServiceType;
    }

    public void setTeServiceType(String teServiceType) {
        this.teServiceType = teServiceType;
    }
    public String getTeServiceParams() {
        return teServiceParams;
    }

    public void setTeServiceParams(String teServiceParams) {
        this.teServiceParams = teServiceParams;
    }
    public String getTeObjId() {
        return teObjId;
    }

    public void setTeObjId(String teObjId) {
        this.teObjId = teObjId;
    }
    public String getTeCustId() {
        return teCustId;
    }

    public void setTeCustId(String teCustId) {
        this.teCustId = teCustId;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public static class TF {

        public static String TABLE_NAME = "TIME_EXPIRES";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String teId = "TE_ID";  // ID
        public static String teStatus = "TE_STATUS";  // 0未处理、1处理、2处理失败
        public static String teExpireDate = "TE_EXPIRE_DATE";  // 过期时间
        public static String teServiceType = "TE_SERVICE_TYPE";  // 业务类型
        public static String teServiceParams = "TE_SERVICE_PARAMS";  // 逗号分割，根据具体业务类型、参数处理相关逻辑
        public static String teObjId = "TE_OBJ_ID";  // 对象id
        public static String teCustId = "TE_CUST_ID";  // 客户id
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateDate = "UPDATE_DATE";  // 更新时间
        public static String remarks = "REMARKS";  // 备注

    }
}
