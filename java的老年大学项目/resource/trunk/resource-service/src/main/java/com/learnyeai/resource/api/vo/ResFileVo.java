package com.learnyeai.resource.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 资源文件
 *
 * @author twang
 */
public class ResFileVo extends BaseVo {

    /**
    * id
    */
    private String resFielId;

    /**
     * 文件名
     */
    private String fileName;
    /**
     * 资源id
     */
    private String resId;
    /**
     * 文件id
     */
    private String fileId;
    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 文件格式
     */
    private String fileFormat;
    /**
     * 大小
     */
    private Long fileSize;
    /**
     * 后缀
     */
    private String fileSuffix;
    /**
     * 时长
     */
    private Long fileTimeLen;
    /**
     * 下载次数
     */
    private Long downloadNum;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 站点-m
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

    public String getResFielId() {
        return resFielId;
    }

    public void setResFielId(String resFielId) {
        this.resFielId = resFielId;
    }
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }
    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }
    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }
    public Long getFileTimeLen() {
        return fileTimeLen;
    }

    public void setFileTimeLen(Long fileTimeLen) {
        this.fileTimeLen = fileTimeLen;
    }
    public Long getDownloadNum() {
        return downloadNum;
    }

    public void setDownloadNum(Long downloadNum) {
        this.downloadNum = downloadNum;
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
        public static String resFielId = "resFielId";  // id
        public static String fileName = "fileName";  // 文件名
        public static String resId = "resId";  // 资源id
        public static String fileId = "fileId";  // 文件id
        public static String fileType = "fileType";  // 文件类型
        public static String fileFormat = "fileFormat";  // 文件格式
        public static String fileSize = "fileSize";  // 大小
        public static String fileSuffix = "fileSuffix";  // 后缀
        public static String fileTimeLen = "fileTimeLen";  // 时长
        public static String downloadNum = "downloadNum";  // 下载次数
        public static String createBy = "createBy";  // 创建人
        public static String createDate = "createDate";  // 创建时间
        public static String delFlag = "delFlag";  // 删除标记
        public static String siteId = "siteId";  // 站点-m
        public static String mchtId = "mchtId";  // 商户id
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id

    }

}
