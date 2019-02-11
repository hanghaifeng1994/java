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
public class ClzClazzSchedule extends BaseEntity {

    /**
    * 班级日程id
    */
    @Id
    @Column(name = "CZ_SC_ID")
    private String czScId;

    /**
     * 班级名称
     */
    @Column(name = "CZ_ID")
    private String czId;
    /**
     * 日程内容
     */
    @Column(name = "SC_CONTENT")
    private String scContent;
    /**
     * 日程名称
     */
    @Column(name = "SC_NAME")
    private String scName;
    /**
     * 0未开始1进行中2已结束
     */
    @Column(name = "SC_STATUS")
    private String scStatus;
    /**
     * 开始时间
     */
    @Column(name = "START_DATE")
    private Date startDate;
    /**
     * 结束时间
     */
    @Column(name = "END_DATE")
    private Date endDate;
    /**
     * 辅导老师id
     */
    @Column(name = "SC_TEARCHER")
    private String scTearcher;
    /**
     * 实际开始时间
     */
    @Column(name = "SC_REAL_START_DATE")
    private Date scRealStartDate;
    /**
     * 时间结束时间
     */
    @Column(name = "SC_REAL_END_DATE")
    private Date scRealEndDate;
    /**
     * 创建人
     */
    @Column(name = "CREATE_BY")
    private String createBy;
    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATE")
    private Date createDate;
    /**
     * 更新人
     */
    @Column(name = "UPDATE_BY")
    private String updateBy;
    /**
     * 更新日期
     */
    @Column(name = "UPDATE_DATE")
    private Date updateDate;
    /**
     * 应到人数
     */
    @Transient
    private Long czNum;
    /**
     * 实到人数
     */
    @Transient
    private int czRealNum;

    public Long getCzNum() {
        return czNum;
    }

    public void setCzNum(Long czNum) {
        this.czNum = czNum;
    }

    public int getCzRealNum() {
        return czRealNum;
    }

    public void setCzRealNum(int czRealNum) {
        this.czRealNum = czRealNum;
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
    public String getScContent() {
        return scContent;
    }

    public void setScContent(String scContent) {
        this.scContent = scContent;
    }
    public String getScName() {
        return scName;
    }

    public void setScName(String scName) {
        this.scName = scName;
    }
    public String getScStatus() {
        return scStatus;
    }

    public void setScStatus(String scStatus) {
        this.scStatus = scStatus;
    }
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public String getScTearcher() {
        return scTearcher;
    }

    public void setScTearcher(String scTearcher) {
        this.scTearcher = scTearcher;
    }
    public Date getScRealStartDate() {
        return scRealStartDate;
    }

    public void setScRealStartDate(Date scRealStartDate) {
        this.scRealStartDate = scRealStartDate;
    }
    public Date getScRealEndDate() {
        return scRealEndDate;
    }

    public void setScRealEndDate(Date scRealEndDate) {
        this.scRealEndDate = scRealEndDate;
    }
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public static class TF {

        public static String TABLE_NAME = "CLZ_CLAZZ_SCHEDULE";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String czScId = "CZ_SC_ID";  // 班级日程id
        public static String czId = "CZ_ID";  // 班级名称
        public static String scContent = "SC_CONTENT";  // 日程内容
        public static String scName = "SC_NAME";  // 日程名称
        public static String scStatus = "SC_STATUS";  // 0未开始1进行中2已结束
        public static String startDate = "START_DATE";  // 开始时间
        public static String endDate = "END_DATE";  // 结束时间
        public static String scTearcher = "SC_TEARCHER";  // 辅导老师id
        public static String scRealStartDate = "SC_REAL_START_DATE";  // 实际开始时间
        public static String scRealEndDate = "SC_REAL_END_DATE";  // 时间结束时间
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateBy = "UPDATE_BY";  // 更新人
        public static String updateDate = "UPDATE_DATE";  // 更新日期

    }
}
