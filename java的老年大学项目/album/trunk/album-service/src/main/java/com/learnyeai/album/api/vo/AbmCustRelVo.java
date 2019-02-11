package com.learnyeai.album.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 相册人员关联表
 *
 * @author yl
 */
public class AbmCustRelVo extends BaseVo {

    /**
    * 客户id
    */
    private String custId;
    /**
    * 相册id
    */
    private String abmId;

    /**
     * 开始时间
     */
    private Date visitStartDate;
    /**
     * 结束时间
     */
    private Date visitEndDate;
    /**
     * 创建时间
     */
    private Date createDate;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
    public String getAbmId() {
        return abmId;
    }

    public void setAbmId(String abmId) {
        this.abmId = abmId;
    }
    public Date getVisitStartDate() {
        return visitStartDate;
    }

    public void setVisitStartDate(Date visitStartDate) {
        this.visitStartDate = visitStartDate;
    }
    public Date getVisitEndDate() {
        return visitEndDate;
    }

    public void setVisitEndDate(Date visitEndDate) {
        this.visitEndDate = visitEndDate;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public static class CF {
        public static String custId = "custId";  // 客户id
        public static String abmId = "abmId";  // 相册id
        public static String visitStartDate = "visitStartDate";  // 开始时间
        public static String visitEndDate = "visitEndDate";  // 结束时间
        public static String createDate = "createDate";  // 创建时间

    }

}
