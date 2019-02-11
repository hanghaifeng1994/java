package com.learnyeai.schoolclass.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 班级
 *
 * @author twang
 */
public class ClzClazzVo extends BaseVo {

    /**
    * id
    */
    private String czId;

    /**
     * 班级名称
     */
    private String czName;
    /**
     * 封面
     */
    private String czPhoto;
    /**
     * 课时数
     */
    private Integer czHours;
    /**
     * 开始时间
     */
    private Date czStartDate;
    /**
     * 结束时间
     */
    private Date czEndDate;
    /**
     * 上课时间
     */
    private String czTime;
    /**
     * 班级简介
     */
    private String czSummary;
    /**
     * 班级说明
     */
    private String czInfo;
    /**
     * 区域id
     */
    private String areaId;
    /**
     * 地址
     */
    private String czAdress;
    /**
     * 培训方式：1线下、2线上
     */
    private String czTrainingType;
    /**
     * 1免费、2打包、3按课
     */
    private String czChargeMode;
    /**
     * 培训费
     */
    private BigDecimal czTrainingFee;
    /**
     * 培训导师id
     */
    private String czMasterTrainerId;
    /**
     * 培训导师名称
     */
    private String czMasterTrainer;
    /**
     * 辅导老师id
     */
    private String czSecondaryTrainerId;
    /**
     * 辅导老师名称
     */
    private String czSecondaryTrainer;
    /**
     * 是否是证书班级
     */
    private String czCerted;
    /**
     * 证书id
     */
    private String ctId;
    /**
     * 未开始、进行中、已结束
     */
    private String czStatus;
    /**
     * 0未发布、1已发布
     */
    private String czPubStatus;
    /**
     * 总学时要求
     */
    private BigDecimal studylength;
    /**
     * 必修改课要求
     */
    private BigDecimal mustStudylength;
    /**
     * 选修课要求
     */
    private BigDecimal selStudylength;
    /**
     * 报名人数
     */
    private Long czJoinupNum;
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
     * 推荐位置
     */
    private String posid;
    /**
     * 
     */
    private Date czPubDate;
    /**
     * 测验成绩要求
     */
    private BigDecimal examScore;
    /**
     * 
     */
    private Date posidDate;

    public String getCzId() {
        return czId;
    }

    public void setCzId(String czId) {
        this.czId = czId;
    }
    public String getCzName() {
        return czName;
    }

    public void setCzName(String czName) {
        this.czName = czName;
    }
    public String getCzPhoto() {
        return czPhoto;
    }

    public void setCzPhoto(String czPhoto) {
        this.czPhoto = czPhoto;
    }
    public Integer getCzHours() {
        return czHours;
    }

    public void setCzHours(Integer czHours) {
        this.czHours = czHours;
    }
    public Date getCzStartDate() {
        return czStartDate;
    }

    public void setCzStartDate(Date czStartDate) {
        this.czStartDate = czStartDate;
    }
    public Date getCzEndDate() {
        return czEndDate;
    }

    public void setCzEndDate(Date czEndDate) {
        this.czEndDate = czEndDate;
    }
    public String getCzTime() {
        return czTime;
    }

    public void setCzTime(String czTime) {
        this.czTime = czTime;
    }
    public String getCzSummary() {
        return czSummary;
    }

    public void setCzSummary(String czSummary) {
        this.czSummary = czSummary;
    }
    public String getCzInfo() {
        return czInfo;
    }

    public void setCzInfo(String czInfo) {
        this.czInfo = czInfo;
    }
    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
    public String getCzAdress() {
        return czAdress;
    }

    public void setCzAdress(String czAdress) {
        this.czAdress = czAdress;
    }
    public String getCzTrainingType() {
        return czTrainingType;
    }

    public void setCzTrainingType(String czTrainingType) {
        this.czTrainingType = czTrainingType;
    }
    public String getCzChargeMode() {
        return czChargeMode;
    }

    public void setCzChargeMode(String czChargeMode) {
        this.czChargeMode = czChargeMode;
    }
    public BigDecimal getCzTrainingFee() {
        return czTrainingFee;
    }

    public void setCzTrainingFee(BigDecimal czTrainingFee) {
        this.czTrainingFee = czTrainingFee;
    }
    public String getCzMasterTrainerId() {
        return czMasterTrainerId;
    }

    public void setCzMasterTrainerId(String czMasterTrainerId) {
        this.czMasterTrainerId = czMasterTrainerId;
    }
    public String getCzMasterTrainer() {
        return czMasterTrainer;
    }

    public void setCzMasterTrainer(String czMasterTrainer) {
        this.czMasterTrainer = czMasterTrainer;
    }
    public String getCzSecondaryTrainerId() {
        return czSecondaryTrainerId;
    }

    public void setCzSecondaryTrainerId(String czSecondaryTrainerId) {
        this.czSecondaryTrainerId = czSecondaryTrainerId;
    }
    public String getCzSecondaryTrainer() {
        return czSecondaryTrainer;
    }

    public void setCzSecondaryTrainer(String czSecondaryTrainer) {
        this.czSecondaryTrainer = czSecondaryTrainer;
    }
    public String getCzCerted() {
        return czCerted;
    }

    public void setCzCerted(String czCerted) {
        this.czCerted = czCerted;
    }
    public String getCtId() {
        return ctId;
    }

    public void setCtId(String ctId) {
        this.ctId = ctId;
    }
    public String getCzStatus() {
        return czStatus;
    }

    public void setCzStatus(String czStatus) {
        this.czStatus = czStatus;
    }
    public String getCzPubStatus() {
        return czPubStatus;
    }

    public void setCzPubStatus(String czPubStatus) {
        this.czPubStatus = czPubStatus;
    }
    public BigDecimal getStudylength() {
        return studylength;
    }

    public void setStudylength(BigDecimal studylength) {
        this.studylength = studylength;
    }
    public BigDecimal getMustStudylength() {
        return mustStudylength;
    }

    public void setMustStudylength(BigDecimal mustStudylength) {
        this.mustStudylength = mustStudylength;
    }
    public BigDecimal getSelStudylength() {
        return selStudylength;
    }

    public void setSelStudylength(BigDecimal selStudylength) {
        this.selStudylength = selStudylength;
    }
    public Long getCzJoinupNum() {
        return czJoinupNum;
    }

    public void setCzJoinupNum(Long czJoinupNum) {
        this.czJoinupNum = czJoinupNum;
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
    public String getPosid() {
        return posid;
    }

    public void setPosid(String posid) {
        this.posid = posid;
    }
    public Date getCzPubDate() {
        return czPubDate;
    }

    public void setCzPubDate(Date czPubDate) {
        this.czPubDate = czPubDate;
    }
    public BigDecimal getExamScore() {
        return examScore;
    }

    public void setExamScore(BigDecimal examScore) {
        this.examScore = examScore;
    }
    public Date getPosidDate() {
        return posidDate;
    }

    public void setPosidDate(Date posidDate) {
        this.posidDate = posidDate;
    }

    public static class TF {
        public static String czId = "czId";  // id
        public static String czName = "czName";  // 班级名称
        public static String czPhoto = "czPhoto";  // 封面
        public static String czHours = "czHours";  // 课时数
        public static String czStartDate = "czStartDate";  // 开始时间
        public static String czEndDate = "czEndDate";  // 结束时间
        public static String czTime = "czTime";  // 上课时间
        public static String czSummary = "czSummary";  // 班级简介
        public static String czInfo = "czInfo";  // 班级说明
        public static String areaId = "areaId";  // 区域id
        public static String czAdress = "czAdress";  // 地址
        public static String czTrainingType = "czTrainingType";  // 培训方式：1线下、2线上
        public static String czChargeMode = "czChargeMode";  // 1免费、2打包、3按课
        public static String czTrainingFee = "czTrainingFee";  // 培训费
        public static String czMasterTrainerId = "czMasterTrainerId";  // 培训导师id
        public static String czMasterTrainer = "czMasterTrainer";  // 培训导师名称
        public static String czSecondaryTrainerId = "czSecondaryTrainerId";  // 辅导老师id
        public static String czSecondaryTrainer = "czSecondaryTrainer";  // 辅导老师名称
        public static String czCerted = "czCerted";  // 是否是证书班级
        public static String ctId = "ctId";  // 证书id
        public static String czStatus = "czStatus";  // 未开始、进行中、已结束
        public static String czPubStatus = "czPubStatus";  // 0未发布、1已发布
        public static String studylength = "studylength";  // 总学时要求
        public static String mustStudylength = "mustStudylength";  // 必修改课要求
        public static String selStudylength = "selStudylength";  // 选修课要求
        public static String czJoinupNum = "czJoinupNum";  // 报名人数
        public static String createBy = "createBy";  // 创建人
        public static String createDate = "createDate";  // 创建时间
        public static String updateBy = "updateBy";  // 更新人
        public static String updateDate = "updateDate";  // 更新时间
        public static String delFlag = "delFlag";  // 删除标记
        public static String siteId = "siteId";  // 站点
        public static String mchtId = "mchtId";  // 商户id
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id
        public static String posid = "posid";  // 推荐位置
        public static String czPubDate = "czPubDate";  // 
        public static String examScore = "examScore";  // 测验成绩要求
        public static String posidDate = "posidDate";  // 

    }

}
