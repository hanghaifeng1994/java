package com.learnyeai.testing.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.learnyeai.learnai.support.BaseEntity;

/**
 * 用户测验表
 *
 * @author twang
 */
public class TestingStudentTest extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 学员
     */
    @Column(name = "STUDENT_USER_ID")
    private String studentUserId;
    /**
     * 测验
     */
    @Column(name = "TS_ID")
    private String tsId;
    /**
     * 得分
     */
    @Column(name = "SCORE")
    private BigDecimal score;
    /**
     * 是否优秀
     */
    @Column(name = "EXCELLENT")
    private String excellent;
    /**
     * 是否合格
     */
    @Column(name = "QUALIFIED")
    private String qualified;
    /**
     * 测验总次数
     */
    @Column(name = "TEST_NUM")
    private Integer testNum;
    /**
     * 合格时间
     */
    @Column(name = "QUALIFIED_DATE")
    private Date qualifiedDate;
    /**
     * 更新时间
     */
    @Column(name = "UPDATE_DATE")
	private Date updateDate;

    /**
     * 测验名称
     */
    @Transient
    private String name;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getStudentUserId() {
        return studentUserId;
    }

    public void setStudentUserId(String studentUserId) {
        this.studentUserId = studentUserId;
    }
    public String getTsId() {
        return tsId;
    }

    public void setTsId(String tsId) {
        this.tsId = tsId;
    }
    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
    public String getExcellent() {
        return excellent;
    }

    public void setExcellent(String excellent) {
        this.excellent = excellent;
    }
    public String getQualified() {
        return qualified;
    }

    public void setQualified(String qualified) {
        this.qualified = qualified;
    }
    public Integer getTestNum() {
        return testNum;
    }

    public void setTestNum(Integer testNum) {
        this.testNum = testNum;
    }
    public Date getQualifiedDate() {
        return qualifiedDate;
    }

    public void setQualifiedDate(Date qualifiedDate) {
        this.qualifiedDate = qualifiedDate;
    }
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public static class TF {

        public static String TABLE_NAME = "TESTING_STUDENT_TEST";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String id = "ID";  // ID
        public static String studentUserId = "STUDENT_USER_ID";  // 学员
        public static String tsId = "TS_ID";  // 测验
        public static String score = "SCORE";  // 得分
        public static String excellent = "EXCELLENT";  // 是否优秀
        public static String qualified = "QUALIFIED";  // 是否合格
        public static String testNum = "TEST_NUM";  // 测验总次数
        public static String qualifiedDate = "QUALIFIED_DATE";  // 合格时间
        public static String updateDate = "UPDATE_DATE";  // 更新时间

    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
