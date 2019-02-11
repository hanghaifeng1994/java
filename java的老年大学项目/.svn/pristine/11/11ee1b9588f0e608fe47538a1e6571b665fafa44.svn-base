package com.learnyeai.studygroup.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 小组才艺
 *
 * @author yl
 */
public class SgpStudyGroupTalent extends BaseEntity {

    /**
    * 小组id
    */
    @Id
    @Column(name = "SGP_ID")
    private String sgpId;
    /**
    * 才艺id
    */
    @Id
    @Column(name = "TLT_ID")
    private String tltId;

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
    public String getTltId() {
        return tltId;
    }

    public void setTltId(String tltId) {
        this.tltId = tltId;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public static class TF {

        public static String TABLE_NAME = "SGP_STUDY_GROUP_TALENT";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String sgpId = "SGP_ID";  // 小组id
        public static String tltId = "TLT_ID";  // 才艺id
        public static String createDate = "CREATE_DATE";  // 创建时间

    }
}
