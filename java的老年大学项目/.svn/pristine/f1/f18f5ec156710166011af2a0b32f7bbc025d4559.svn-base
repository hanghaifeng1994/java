package com.learnyeai.schoolclass.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 
 *
 * @author twang
 */
public class ClzClazzSign extends BaseEntity {

    /**
    * 签到id
    */
    @Id
    @Column(name = "CZ_SIGN_ID")
    private String czSignId;

    /**
     * 日程id
     */
    @Column(name = "CZ_SC_ID")
    private String czScId;
    /**
     * 班级id
     */
    @Column(name = "CZ_ID")
    private String czId;
    /**
     * 学员id
     */
    @Column(name = "CUST_ID")
    private String custId;
    /**
     * 签到时间
     */
    @Column(name = "CZ_SIGN_START_DATE")
    private Date czSignStartDate;
    /**
     * 下课签退时间
     */
    @Column(name = "CZ_SIGN_END_DATE")
    private Date czSignEndDate;
    /**
     * 0未签到1已签到2已签退
     */
    @Column(name = "STATUS")
    private String status;
    @Transient
    private String tearchers;
    @Transient
    private  String scheduleName;
    @Transient
    private String parseDate;
    @Transient
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getParseDate() {
        return parseDate;
    }

    public void setParseDate(String parseDate) {
        this.parseDate = parseDate;
    }

    public String getTearchers() {
        return tearchers;
    }

    public void setTearchers(String tearchers) {
        this.tearchers = tearchers;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public String getCzSignId() {
        return czSignId;
    }

    public void setCzSignId(String czSignId) {
        this.czSignId = czSignId;
    }
    public String getCzScId() {
        return czScId;
    }

    public void setCzScId(String czScId) {
        this.czScId = czScId;
    }
    public String getCzId() {
        return czId;
    }

    public void setCzId(String czId) {
        this.czId = czId;
    }
    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
    public Date getCzSignStartDate() {
        return czSignStartDate;
    }

    public void setCzSignStartDate(Date czSignStartDate) {
        this.czSignStartDate = czSignStartDate;
    }
    public Date getCzSignEndDate() {
        return czSignEndDate;
    }

    public void setCzSignEndDate(Date czSignEndDate) {
        this.czSignEndDate = czSignEndDate;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class TF {

        public static String TABLE_NAME = "CLZ_CLAZZ_SIGN";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String czSignId = "CZ_SIGN_ID";  // 签到id
        public static String czScId = "CZ_SC_ID";  // 日程id
        public static String czId = "CZ_ID";  // 班级id
        public static String custId = "CUST_ID";  // 学员id
        public static String czSignStartDate = "CZ_SIGN_START_DATE";  // 签到时间
        public static String czSignEndDate = "CZ_SIGN_END_DATE";  // 下课签退时间
        public static String status = "STATUS";  // 0未签到1已签到2已签退

    }
}
