package com.learnyeai.studygroup.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 小组经验
 *
 * @author yl
 */
public class SgpStudyGroupExperienceVo extends BaseVo {

    /**
    * 小组id
    */
    private String sgpId;
    /**
    * 经验id
    */
    private String epcId;

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
    public String getEpcId() {
        return epcId;
    }

    public void setEpcId(String epcId) {
        this.epcId = epcId;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public static class CF {
        public static String sgpId = "sgpId";  // 小组id
        public static String epcId = "epcId";  // 经验id
        public static String createDate = "createDate";  // 创建时间

    }

}
