package com.learnyeai.schoolclass.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 
 *
 * @author twang
 */
public class ClzClazzSignVo extends BaseVo {

    /**
    * 签到id
    */
    private String czSignId;

    /**
     * 日程id
     */
    private String czScId;
    /**
     * 班级id
     */
    private String czId;
    /**
     * 学员id
     */
    private String custId;
    /**
     * 签到时间
     */
    private Date czSignStartDate;
    /**
     * 下课签退时间
     */
    private Date czSignEndDate;
    /**
     * 0未签到1已签到2已签退
     */
    private String status;

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
        public static String czSignId = "czSignId";  // 签到id
        public static String czScId = "czScId";  // 日程id
        public static String czId = "czId";  // 班级id
        public static String custId = "custId";  // 学员id
        public static String czSignStartDate = "czSignStartDate";  // 签到时间
        public static String czSignEndDate = "czSignEndDate";  // 下课签退时间
        public static String status = "status";  // 0未签到1已签到2已签退

    }

}
