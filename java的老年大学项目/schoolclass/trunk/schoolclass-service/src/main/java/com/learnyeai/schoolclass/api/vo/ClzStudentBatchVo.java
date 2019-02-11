package com.learnyeai.schoolclass.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 批次人员
 *
 * @author twang
 */
public class ClzStudentBatchVo extends BaseVo {

    /**
    * 学生批次id
    */
    private String sbId;

    /**
     * 学生id
     */
    private String custId;
    /**
     * 批次id
     */
    private String batchId;
    /**
     * 学员班级id
     */
    private String scId;
    /**
     * 班级id
     */
    private String czId;
    /**
     * 报名时间
     */
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
        public static String sbId = "sbId";  // 学生批次id
        public static String custId = "custId";  // 学生id
        public static String batchId = "batchId";  // 批次id
        public static String scId = "scId";  // 学员班级id
        public static String czId = "czId";  // 班级id
        public static String singupDate = "singupDate";  // 报名时间

    }

}
