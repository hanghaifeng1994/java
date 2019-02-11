package com.learnyeai.studygroup.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 小组成员
 *
 * @author yl
 */
public class SgpMemberVo extends BaseVo {

    /**
    * 小组id
    */
    private String sgpId;
    /**
    * 客户id
    */
    private String custId;

    /**
     * 创建时间
     */
    private Date createDate;

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

    public static class CF {
        public static String sgpId = "sgpId";  // 小组id
        public static String custId = "custId";  // 客户id
        public static String createDate = "createDate";  // 创建时间

    }

}
