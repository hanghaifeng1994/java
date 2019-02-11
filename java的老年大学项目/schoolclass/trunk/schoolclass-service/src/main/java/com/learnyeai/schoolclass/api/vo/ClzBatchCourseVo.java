package com.learnyeai.schoolclass.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.math.BigDecimal;

/**
 * 班级报名批次-课程
 *
 * @author twang
 */
public class ClzBatchCourseVo extends BaseVo {

    /**
    * 批次课程id
    */
    private String bcId;

    /**
     * 班级批次id
     */
    private String batchId;
    /**
     * 课程id
     */
    private String csId;
    /**
     * 1选修课、2必修课
     */
    private Integer csType;
    /**
     * 学时
     */
    private BigDecimal csStudylength;
    /**
     * 金额
     */
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
        public static String bcId = "bcId";  // 批次课程id
        public static String batchId = "batchId";  // 班级批次id
        public static String csId = "csId";  // 课程id
        public static String csType = "csType";  // 1选修课、2必修课
        public static String csStudylength = "csStudylength";  // 学时
        public static String csAmount = "csAmount";  // 金额

    }

}
