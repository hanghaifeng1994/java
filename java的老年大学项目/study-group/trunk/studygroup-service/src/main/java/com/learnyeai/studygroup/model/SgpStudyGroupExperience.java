package com.learnyeai.studygroup.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 小组经验
 *
 * @author yl
 */
public class SgpStudyGroupExperience extends BaseEntity {

    /**
    * 小组id
    */
    @Id
    @Column(name = "SGP_ID")
    private String sgpId;
    /**
    * 经验id
    */
    @Id
    @Column(name = "EPC_ID")
    private String epcId;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATE")
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

    public static class TF {

        public static String TABLE_NAME = "SGP_STUDY_GROUP_EXPERIENCE";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String sgpId = "SGP_ID";  // 小组id
        public static String epcId = "EPC_ID";  // 经验id
        public static String createDate = "CREATE_DATE";  // 创建时间

    }
}
