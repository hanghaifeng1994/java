package com.learnyeai.schoolclass.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 班级报名批次-课程
 *
 * @author twang
 */
public class ClzBatchCourse extends BaseEntity {

    /**
    * 批次课程id
    */
    @Id
    @Column(name = "BC_ID")
    private String bcId;

    /**
     * 班级批次id
     */
    @Column(name = "BATCH_ID")
    private String batchId;
    /**
     * 课程id
     */
    @Column(name = "CS_ID")
    private String csId;
    /**
     * 1选修课、2必修课
     */
    @Column(name = "CS_TYPE")
    private Integer csType;
    /**
     * 学时
     */
    @Column(name = "CS_STUDYLENGTH")
    private BigDecimal csStudylength;
    /**
     * 金额
     */
    @Column(name = "CS_AMOUNT")
    private BigDecimal csAmount;

    public String getBcId() {
        return bcId;
    }

    public void setBcId(String bcId) {
        this.bcId = bcId;
    }
    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }
    public String getCsId() {
        return csId;
    }

    public void setCsId(String csId) {
        this.csId = csId;
    }
    public Integer getCsType() {
        return csType;
    }

    public void setCsType(Integer csType) {
        this.csType = csType;
    }
    public BigDecimal getCsStudylength() {
        return csStudylength;
    }

    public void setCsStudylength(BigDecimal csStudylength) {
        this.csStudylength = csStudylength;
    }
    public BigDecimal getCsAmount() {
        return csAmount;
    }

    public void setCsAmount(BigDecimal csAmount) {
        this.csAmount = csAmount;
    }

    public static class TF {

        public static String TABLE_NAME = "CLZ_BATCH_COURSE";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String bcId = "BC_ID";  // 批次课程id
        public static String batchId = "BATCH_ID";  // 班级批次id
        public static String csId = "CS_ID";  // 课程id
        public static String csType = "CS_TYPE";  // 1选修课、2必修课
        public static String csStudylength = "CS_STUDYLENGTH";  // 学时
        public static String csAmount = "CS_AMOUNT";  // 金额

    }
}
