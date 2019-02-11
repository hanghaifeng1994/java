package com.learnyeai.schoolclass.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 批次人员
 *
 * @author twang
 */
public class ClzStudentBatch extends BaseEntity {

    /**
    * 学生批次id
    */
    @Id
    @Column(name = "SB_ID")
    private String sbId;

    /**
     * 学生id
     */
    @Column(name = "CUST_ID")
    private String custId;
    /**
     * 批次id
     */
    @Column(name = "BATCH_ID")
    private String batchId;
    /**
     * 学员班级id
     */
    @Column(name = "SC_ID")
    private String scId;
    /**
     * 班级id
     */
    @Column(name = "CZ_ID")
    private String czId;
    /**
     * 报名时间
     */
    @Column(name = "SINGUP_DATE")
    private Date singupDate;

    public String getSbId() {
        return sbId;
    }

    public void setSbId(String sbId) {
        this.sbId = sbId;
    }
    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }
    public String getScId() {
        return scId;
    }

    public void setScId(String scId) {
        this.scId = scId;
    }
    public String getCzId() {
        return czId;
    }

    public void setCzId(String czId) {
        this.czId = czId;
    }
    public Date getSingupDate() {
        return singupDate;
    }

    public void setSingupDate(Date singupDate) {
        this.singupDate = singupDate;
    }

    public static class TF {

        public static String TABLE_NAME = "CLZ_STUDENT_BATCH";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String sbId = "SB_ID";  // 学生批次id
        public static String custId = "CUST_ID";  // 学生id
        public static String batchId = "BATCH_ID";  // 批次id
        public static String scId = "SC_ID";  // 学员班级id
        public static String czId = "CZ_ID";  // 班级id
        public static String singupDate = "SINGUP_DATE";  // 报名时间

    }
}
