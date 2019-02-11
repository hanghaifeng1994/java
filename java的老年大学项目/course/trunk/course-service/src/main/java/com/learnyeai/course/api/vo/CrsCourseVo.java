package com.learnyeai.course.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 课程
 *
 * @author twang
 */
public class CrsCourseVo extends BaseVo {

    /**
    * id
    */
    private String csId;

    /**
     * 名称
     */
    private String csName;
    /**
     * 课程编号
     */
    private String csSerialNo;
    /**
     * 标签
     */
    private String csTag;
    /**
     * 简介
     */
    private String csInfo;
    /**
     * 封面
     */
    private String csPhoto;
    /**
     * 配图
     */
    private String csImgs;
    /**
     * 积分
     */
    private Integer csPoints;
    /**
     * 价格
     */
    private BigDecimal csPrice;
    /**
     * 学分/学时
     */
    private BigDecimal csStudylength;
    /**
     * 讲师
     */
    private String csLecturer;
    /**
     * 有效期开始时间
     */
    private Date csCopyrightStartdate;
    /**
     * 有效期结束时间
     */
    private Date csCopyrightEnddate;
    /**
     * 总时长
     */
    private Long csTotalTime;
    /**
     * 课程类型1:公需课;2:专业课;3:开放课
     */
    private Short csModel;
    /**
     * 分类字符串
     */
    private String csCatstr;
    /**
     * 是否要求学习时长
     */
    private String csStudyneed;
    /**
     * 要求学习时长(分钟)
     */
    private Long csStudyTime;
    /**
     * 是否要求作业成绩
     */
    private String csHomeworkneed;
    /**
     * 要求作业成绩
     */
    private BigDecimal csHomeworkScore;
    /**
     * 是否要求测验成绩
     */
    private String csExamneed;
    /**
     * 要求测验成绩
     */
    private BigDecimal csExamScore;
    /**
     * 是否要求总成绩
     */
    private String csScoreneed;
    /**
     * 要求总成绩
     */
    private BigDecimal csScore;
    /**
     * 0未发布、1已发布
     */
    private String csPubStatus;
    /**
     * 发布时间
     */
    private Date csPubDate;
    /**
     * 推荐状态
     */
    private String csTjStatus;
    /**
     * 推荐时间
     */
    private Date csTjDate;
    /**
     * 状态：0未提交、1审核中、2审核通过、3审核失败、4不需要审核
     */
    private String csStatus;
    /**
     * 审核id
     */
    private String csAuditId;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 更新人
     */
    private String updateBy;
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
    /**
     * 教育大类
     */
    private String eduCat;

    public String getCsId() {
        return csId;
    }

    public void setCsId(String csId) {
        this.csId = csId;
    }
    public String getCsName() {
        return csName;
    }

    public void setCsName(String csName) {
        this.csName = csName;
    }
    public String getCsSerialNo() {
        return csSerialNo;
    }

    public void setCsSerialNo(String csSerialNo) {
        this.csSerialNo = csSerialNo;
    }
    public String getCsTag() {
        return csTag;
    }

    public void setCsTag(String csTag) {
        this.csTag = csTag;
    }
    public String getCsInfo() {
        return csInfo;
    }

    public void setCsInfo(String csInfo) {
        this.csInfo = csInfo;
    }
    public String getCsPhoto() {
        return csPhoto;
    }

    public void setCsPhoto(String csPhoto) {
        this.csPhoto = csPhoto;
    }
    public String getCsImgs() {
        return csImgs;
    }

    public void setCsImgs(String csImgs) {
        this.csImgs = csImgs;
    }
    public Integer getCsPoints() {
        return csPoints;
    }

    public void setCsPoints(Integer csPoints) {
        this.csPoints = csPoints;
    }
    public BigDecimal getCsPrice() {
        return csPrice;
    }

    public void setCsPrice(BigDecimal csPrice) {
        this.csPrice = csPrice;
    }
    public BigDecimal getCsStudylength() {
        return csStudylength;
    }

    public void setCsStudylength(BigDecimal csStudylength) {
        this.csStudylength = csStudylength;
    }
    public String getCsLecturer() {
        return csLecturer;
    }

    public void setCsLecturer(String csLecturer) {
        this.csLecturer = csLecturer;
    }
    public Date getCsCopyrightStartdate() {
        return csCopyrightStartdate;
    }

    public void setCsCopyrightStartdate(Date csCopyrightStartdate) {
        this.csCopyrightStartdate = csCopyrightStartdate;
    }
    public Date getCsCopyrightEnddate() {
        return csCopyrightEnddate;
    }

    public void setCsCopyrightEnddate(Date csCopyrightEnddate) {
        this.csCopyrightEnddate = csCopyrightEnddate;
    }
    public Long getCsTotalTime() {
        return csTotalTime;
    }

    public void setCsTotalTime(Long csTotalTime) {
        this.csTotalTime = csTotalTime;
    }
    public Short getCsModel() {
        return csModel;
    }

    public void setCsModel(Short csModel) {
        this.csModel = csModel;
    }
    public String getCsCatstr() {
        return csCatstr;
    }

    public void setCsCatstr(String csCatstr) {
        this.csCatstr = csCatstr;
    }
    public String getCsStudyneed() {
        return csStudyneed;
    }

    public void setCsStudyneed(String csStudyneed) {
        this.csStudyneed = csStudyneed;
    }
    public Long getCsStudyTime() {
        return csStudyTime;
    }

    public void setCsStudyTime(Long csStudyTime) {
        this.csStudyTime = csStudyTime;
    }
    public String getCsHomeworkneed() {
        return csHomeworkneed;
    }

    public void setCsHomeworkneed(String csHomeworkneed) {
        this.csHomeworkneed = csHomeworkneed;
    }
    public BigDecimal getCsHomeworkScore() {
        return csHomeworkScore;
    }

    public void setCsHomeworkScore(BigDecimal csHomeworkScore) {
        this.csHomeworkScore = csHomeworkScore;
    }
    public String getCsExamneed() {
        return csExamneed;
    }

    public void setCsExamneed(String csExamneed) {
        this.csExamneed = csExamneed;
    }
    public BigDecimal getCsExamScore() {
        return csExamScore;
    }

    public void setCsExamScore(BigDecimal csExamScore) {
        this.csExamScore = csExamScore;
    }
    public String getCsScoreneed() {
        return csScoreneed;
    }

    public void setCsScoreneed(String csScoreneed) {
        this.csScoreneed = csScoreneed;
    }
    public BigDecimal getCsScore() {
        return csScore;
    }

    public void setCsScore(BigDecimal csScore) {
        this.csScore = csScore;
    }
    public String getCsPubStatus() {
        return csPubStatus;
    }

    public void setCsPubStatus(String csPubStatus) {
        this.csPubStatus = csPubStatus;
    }
    public Date getCsPubDate() {
        return csPubDate;
    }

    public void setCsPubDate(Date csPubDate) {
        this.csPubDate = csPubDate;
    }
    public String getCsTjStatus() {
        return csTjStatus;
    }

    public void setCsTjStatus(String csTjStatus) {
        this.csTjStatus = csTjStatus;
    }
    public Date getCsTjDate() {
        return csTjDate;
    }

    public void setCsTjDate(Date csTjDate) {
        this.csTjDate = csTjDate;
    }
    public String getCsStatus() {
        return csStatus;
    }

    public void setCsStatus(String csStatus) {
        this.csStatus = csStatus;
    }
    public String getCsAuditId() {
        return csAuditId;
    }

    public void setCsAuditId(String csAuditId) {
        this.csAuditId = csAuditId;
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
    public String getEduCat() {
        return eduCat;
    }

    public void setEduCat(String eduCat) {
        this.eduCat = eduCat;
    }

    public static class TF {
        public static String csId = "csId";  // id
        public static String csName = "csName";  // 名称
        public static String csSerialNo = "csSerialNo";  // 课程编号
        public static String csTag = "csTag";  // 标签
        public static String csInfo = "csInfo";  // 简介
        public static String csPhoto = "csPhoto";  // 封面
        public static String csImgs = "csImgs";  // 配图
        public static String csPoints = "csPoints";  // 积分
        public static String csPrice = "csPrice";  // 价格
        public static String csStudylength = "csStudylength";  // 学分/学时
        public static String csLecturer = "csLecturer";  // 讲师
        public static String csCopyrightStartdate = "csCopyrightStartdate";  // 有效期开始时间
        public static String csCopyrightEnddate = "csCopyrightEnddate";  // 有效期结束时间
        public static String csTotalTime = "csTotalTime";  // 总时长
        public static String csModel = "csModel";  // 课程类型1:公需课;2:专业课;3:开放课
        public static String csCatstr = "csCatstr";  // 分类字符串
        public static String csStudyneed = "csStudyneed";  // 是否要求学习时长
        public static String csStudyTime = "csStudyTime";  // 要求学习时长(分钟)
        public static String csHomeworkneed = "csHomeworkneed";  // 是否要求作业成绩
        public static String csHomeworkScore = "csHomeworkScore";  // 要求作业成绩
        public static String csExamneed = "csExamneed";  // 是否要求测验成绩
        public static String csExamScore = "csExamScore";  // 要求测验成绩
        public static String csScoreneed = "csScoreneed";  // 是否要求总成绩
        public static String csScore = "csScore";  // 要求总成绩
        public static String csPubStatus = "csPubStatus";  // 0未发布、1已发布
        public static String csPubDate = "csPubDate";  // 发布时间
        public static String csTjStatus = "csTjStatus";  // 推荐状态
        public static String csTjDate = "csTjDate";  // 推荐时间
        public static String csStatus = "csStatus";  // 状态：0未提交、1审核中、2审核通过、3审核失败、4不需要审核
        public static String csAuditId = "csAuditId";  // 审核id
        public static String createBy = "createBy";  // 创建人
        public static String createDate = "createDate";  // 创建时间
        public static String updateBy = "updateBy";  // 更新人
        public static String updateDate = "updateDate";  // 更新时间
        public static String delFlag = "delFlag";  // 删除标记
        public static String siteId = "siteId";  // 站点
        public static String mchtId = "mchtId";  // 商户id
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id
        public static String eduCat = "eduCat";  // 教育大类

    }

}
