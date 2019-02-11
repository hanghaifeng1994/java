package com.learnyeai.activity.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 活动参与人员
 *
 * @author yl
 */
public class ActActivityMemerVo extends BaseVo {

    /**
    * 活动id
    */
    private String actId;

    /**
     * 用户id
     */
    private String joinupUserId;
    /**
     * 参加时间
     */
    private Date joinupDate;

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }
    public String getJoinupUserId() {
        return joinupUserId;
    }

    public void setJoinupUserId(String joinupUserId) {
        this.joinupUserId = joinupUserId;
    }
    public Date getJoinupDate() {
        return joinupDate;
    }

    public void setJoinupDate(Date joinupDate) {
        this.joinupDate = joinupDate;
    }

    public static class CF {
        public static String actId = "actId";  // 活动id
        public static String joinupUserId = "joinupUserId";  // 用户id
        public static String joinupDate = "joinupDate";  // 参加时间

    }

}
