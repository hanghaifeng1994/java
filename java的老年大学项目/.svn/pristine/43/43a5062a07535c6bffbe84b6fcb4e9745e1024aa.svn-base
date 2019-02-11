package com.learnyeai.homework.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import com.learnyeai.learnai.support.BaseEntity;

/**
 * 作业附件
 *
 * @author twang
 */
public class WkHomeworkAttachment extends BaseEntity {

	public static String TYPE_HW = "0";// 作业附件
	public static String TYPE_UH = "1";// 用户作业附件
	public static String TYPE_MH = "2";// 老师批阅附件

	/**
	 * id
	 */
	@Id
	@Column(name = "ATM_ID")
	private String atmId;

	/**
	 * 作业id,用户作业id,老师批阅id
	 */
	@Column(name = "OBJ_ID")
	private String objId;
	/**
	 * 0:作业附件;1:用户作业附件;2:老师批阅附件
	 */
	@Column(name = "TYPE")
	private String type;
	/**
	 * 附件id
	 */
	@Column(name = "FILE_ID")
	private String fileId;
	/**
	 * 附件名称
	 */
	@Column(name = "FILE_NAME")
	private String fileName;
	/**
	 * 上传时间
	 */
	@Column(name = "UPLOAD_TIME")
	private Date uploadTime;
	/**
	 * 删除标识
	 */
	@Column(name = "DEL_FLAG")
	private String delFlag;

	public String getAtmId() {
		return atmId;
	}

	public void setAtmId(String atmId) {
		this.atmId = atmId;
	}

	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public static class TF {

		public static String TABLE_NAME = "WK_HOMEWORK_ATTACHMENT"; // 表名

		// public static String TABLE_SCHEMA = ConfigUtils.getValue(""); // 库名

		public static String atmId = "ATM_ID"; // id
		public static String objId = "OBJ_ID"; // 作业id,用户作业id,老师批阅id
		public static String type = "TYPE"; // 0:作业附件;1:用户作业附件;2:老师批阅附件
		public static String fileId = "FILE_ID"; // 附件id
		public static String fileName = "FILE_NAME"; // 附件名称
		public static String uploadTime = "UPLOAD_TIME"; // 上传时间
		public static String delFlag = "DEL_FLAG"; // 删除标识

	}
}
