//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: fangyong
//
//-------------------------------------------------------------------------
// LOOSOFT MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
// THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
// TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
// PARTICULAR PURPOSE, OR NON-INFRINGEMENT. UFINITY SHALL NOT BE
// LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
// MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
//
// THIS SOFTWARE IS NOT DESIGNED OR INTENDED FOR USE OR RESALE AS ON-LINE
// CONTROL EQUIPMENT IN HAZARDOUS ENVIRONMENTS REQUIRING FAIL-SAFE
// PERFORMANCE, SUCH AS IN THE OPERATION OF NUCLEAR FACILITIES, AIRCRAFT
// NAVIGATION OR COMMUNICATION SYSTEMS, AIR TRAFFIC CONTROL, DIRECT LIFE
// SUPPORT MACHINES, OR WEAPONS SYSTEMS, IN WHICH THE FAILURE OF THE
// SOFTWARE COULD LEAD DIRECTLY TO DEATH, PERSONAL INJURY, OR SEVERE
// PHYSICAL OR ENVIRONMENTAL DAMAGE ("HIGH RISK ACTIVITIES"). UFINITY
// SPECIFICALLY DISCLAIMS ANY EXPRESS OR IMPLIED WARRANTY OF FITNESS FOR
// HIGH RISK ACTIVITIES.
//-------------------------------------------------------------------------
package com.drcl.traincore.web.related;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springside.modules.utils.web.struts2.Struts2Utils;

import cn.common.lib.util.file.FileUtils;
import cn.common.lib.util.web.ParamUtils;
import cn.common.lib.util.web.PropertyUtils;
import cn.common.lib.vo.LabelValue;

import com.drcl.traincore.common.util.FileUploadUtils;
import com.drcl.traincore.contants.Constants;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 操作图片或附件上传的Action
 * 
 * @author fangyong
 * @version 1.0
 * @since 2011-3-28
 */
@ParentPackage("json-default")
@Namespace("/related")
@Results({ @Result(name = "success", type = "json", params = { "contentType", "text/html" }), @Result(name = "error", type = "json", params = { "contentType", "text/html" }) })
public class UploadAction extends ActionSupport {

	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = 1L;

	private File picfile;

	private String picfileFileName;

	private String message = null;

	private String avatarname; // 上传成功之后的文件名

	// 上传证书模板图片
	public String uploadCertTemImage() throws Exception {
		// 验证附件的格式和大小
		message = FileUploadUtils.fileTypeValidate(picfileFileName, picfile, Constants.CERTTEMIMAGEFILETYPES, Constants.CERTTEMPLATE_MAXSIZE);

		if (message == null) {
			String date = DateFormatUtils.format(new Date(), "yyyyMM");

			// 设置文件路径，优先存储在本地，如本地存储失败，则存储至服务器路径上
			String localFilePath = PropertyUtils.getPropertyWithConfigName("certtemplate.properties", "upload.path") + Constants.CETTEMPLATE_PATH + "/" + date;

			try { // 　存储文件，获得存储后的文件名
				avatarname = FileUtils.saveFile(localFilePath, picfile, picfileFileName, Constants.CERTTEMPLATE_PREFIX);
				avatarname = "/" + date + "/" + avatarname;// 附件后加上日期方便保存到数据库中
			} catch (Exception e) {
				e.printStackTrace();
				message = "对不起,图片上传失败了!";
			}
		}

		return SUCCESS;
	}

	// 删除证书模板图片
	public String deleteCertTemImage() {
		try {
			HttpServletRequest request = Struts2Utils.getRequest();
			String imageName = ParamUtils.getParameter(request, "imageName", null);

			String filePath = PropertyUtils.getPropertyWithConfigName("certtemplate.properties", "upload.path") + Constants.CETTEMPLATE_PATH + imageName;// 取得附件前半部分名称

			// 判断证书模板图片是否已存在,如存在则删除
			if (!FileUploadUtils.deleteFile(filePath)) {
				Struts2Utils.renderJson(new LabelValue("对不起，文件删除失败.", ""));
			}
		} catch (Exception e) {
			Struts2Utils.renderJson(new LabelValue("系统异常，文件删除失败.", ""));
		}
		return null;
	}

	public String getMessage() {
		return message;
	}

	public String getAvatarname() {
		return avatarname;
	}

	public File getPicfile() {
		return picfile;
	}

	public void setPicfile(File picfile) {
		this.picfile = picfile;
	}

	public String getPicfileFileName() {
		return picfileFileName;
	}

	public void setPicfileFileName(String picfileFileName) {
		this.picfileFileName = picfileFileName;
	}
}
