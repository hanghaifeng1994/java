package com.learnyeai.activity.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * 活动参与人员
 *
 * @author yl
 */
public class ActActivityMemer extends BaseEntity {

    /**
    * 活动id
    */
    @Id
    @Column(name = "ACT_ID")
    private String actId;

    /**
     * 用户id
     */
    @Column(name = "JOINUP_USER_ID")
    private String joinupUserId;
    /**
     * 参加时间
     */
    @Column(name = "JOINUP_DATE")
    private Date joinupDate;

    private List<IsSignUpVo> list;

    public List<IsSignUpVo> getList() {
        return list;
    }

    public void setList(List<IsSignUpVo> list) {
        this.list = list;
    }

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

    public static class TF {

        public static String TABLE_NAME = "ACT_ACTIVITY_MEMER";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String actId = "ACT_ID";  // 活动id
        public static String joinupUserId = "JOINUP_USER_ID";  // 用户id
        public static String joinupDate = "JOINUP_DATE";  // 参加时间

    }
}
