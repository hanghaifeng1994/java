package com.learnyeai.course.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 客户学习资源
 *
 * @author twang
 */
public class StdCustLearnResourceVo extends BaseVo {

    /**
    * id
    */
    private String lresId;

    /**
     * 学习人id
     */
    private String studyUserId;
    /**
     * 资源id
     */
    private String resId;
    /**
     * 来源0:资源;1:课程
     */
    private Integer source;
    /**
     * 学习时长
     */
    private Long studyTime;
    /**
     * 学习次数
     */
    private Long studyNum;
    /**
     * 学习断点
     */
    private Long studyBreakpoint;
    /**
     * 是否完成
     */
    private String studyFinished;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 更新时间
     */
    private Date updateDate;
    /**
     * 站点
     */
    private String siteId;
    /**
     * 商户id
     */
    private String mchtId;
    /**
     * 商户方案id
     */
    private String mchtSchmId;
    
    private String resName;

    public String getLresId() {
        return lresId;
    }

    public void setLresId(String lresId) {
        this.lresId = lresId;
    }
    public String getStudyUserId() {
        return studyUserId;
    }

    public void setStudyUserId(String studyUserId) {
        this.studyUserId = studyUserId;
    }
    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }
    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }
    public Long getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(Long studyTime) {
        this.studyTime = studyTime;
    }
    public Long getStudyNum() {
        return studyNum;
    }

    public void setStudyNum(Long studyNum) {
        this.studyNum = studyNum;
    }
    public Long getStudyBreakpoint() {
        return studyBreakpoint;
    }

    public void setStudyBreakpoint(Long studyBreakpoint) {
        this.studyBreakpoint = studyBreakpoint;
    }
    public String getStudyFinished() {
        return studyFinished;
    }

    public void setStudyFinished(String studyFinished) {
        this.studyFinished = studyFinished;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    public String getMchtId() {
        return mchtId;
    }

    public void setMchtId(String mchtId) {
        this.mchtId = mchtId;
    }
    public String getMchtSchmId() {
        return mchtSchmId;
    }

    public void setMchtSchmId(String mchtSchmId) {
        this.mchtSchmId = mchtSchmId;
    }

    public static class TF {
        public static String lresId = "lresId";  // id
        public static String studyUserId = "studyUserId";  // 学习人id
        public static String resId = "resId";  // 资源id
        public static String source = "source";  // 来源0:资源;1:课程
        public static String studyTime = "studyTime";  // 学习时长
        public static String studyNum = "studyNum";  // 学习次数
        public static String studyBreakpoint = "studyBreakpoint";  // 学习断点
        public static String studyFinished = "studyFinished";  // 是否完成
        public static String createDate = "createDate";  // 创建时间
        public static String updateDate = "updateDate";  // 更新时间
        public static String siteId = "siteId";  // 站点
        public static String mchtId = "mchtId";  // 商户id
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id

    }

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

}
