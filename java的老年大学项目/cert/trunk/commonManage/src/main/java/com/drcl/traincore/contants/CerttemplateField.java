//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: qingang
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
package com.drcl.traincore.contants;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import cn.common.lib.util.web.PropertyUtils;
import cn.common.lib.vo.LabelValue;

/**
 * 
 * 证书模板类型
 * 
 * @author fangyong
 * @version 1.0
 * @since 2013-1-30
 */
public class CerttemplateField {
	/**
	 * 证书模板配置文件
	 */
	public static final String CERTTEMPLATE_FILENAME = "/certtemplate.properties";

	public static List<LabelValue> enumTextList = new ArrayList<LabelValue>();

	/**
	 * 设计模板关系对应字段
	 */
	static {
		String certField = PropertyUtils.getPropertyWithConfigName(CERTTEMPLATE_FILENAME, "cert.text.field");

		if (StringUtils.isNotBlank(certField)) {
			String[] certFieldArray = certField.split(",");
			if (certFieldArray != null && certFieldArray.length > 0) {
				for (int value = 1; value <= certFieldArray.length; value++) {
					String certFieldVal = certFieldArray[value - 1];
					String[] certValArray = certFieldVal.split("=");
					enumTextList.add(new LabelValue(certValArray[0], certValArray[1]));
				}
			}
		}

	}

	public final static String CETTEMPLATE_PATH = "/certtemplate"; // 证书模版背景保存地址

	public static List<LabelValue> enumImageList = new ArrayList<LabelValue>();

	/**
	 * 设计模板关系对应图片
	 */
	static {
		String certField = PropertyUtils.getPropertyWithConfigName(CERTTEMPLATE_FILENAME, "cert.image.field");

		if (StringUtils.isNotBlank(certField)) {
			String[] certFieldArray = certField.split(",");
			if (certFieldArray != null && certFieldArray.length > 0) {
				for (int value = 1; value <= certFieldArray.length; value++) {
					String certFieldVal = certFieldArray[value - 1];
					String[] certValArray = certFieldVal.split("=");
					enumImageList.add(new LabelValue(certValArray[0], certValArray[1]));
				}
			}
		}

	}

	// 线下证书设计模板
	public static List<LabelValue> enumOfflineTextList = new ArrayList<LabelValue>();

	/**
	 * 设计模板关系对应字段
	 */
	static {
		String certField = PropertyUtils.getPropertyWithConfigName(CERTTEMPLATE_FILENAME, "certoffline.text.field");

		if (StringUtils.isNotBlank(certField)) {
			String[] certFieldArray = certField.split(",");
			if (certFieldArray != null && certFieldArray.length > 0) {
				for (int value = 1; value <= certFieldArray.length; value++) {
					String certFieldVal = certFieldArray[value - 1];
					String[] certValArray = certFieldVal.split("=");
					enumOfflineTextList.add(new LabelValue(certValArray[0], certValArray[1]));
				}
			}
		}

	}

	// 线下证书设计模板
	public static List<LabelValue> enumOfflineImageList = new ArrayList<LabelValue>();

	/**
	 * 设计模板关系对应图片
	 */
	static {
		String certField = PropertyUtils.getPropertyWithConfigName(CERTTEMPLATE_FILENAME, "certoffline.image.field");

		if (StringUtils.isNotBlank(certField)) {
			String[] certFieldArray = certField.split(",");
			if (certFieldArray != null && certFieldArray.length > 0) {
				for (int value = 1; value <= certFieldArray.length; value++) {
					String certFieldVal = certFieldArray[value - 1];
					String[] certValArray = certFieldVal.split("=");
					enumOfflineImageList.add(new LabelValue(certValArray[0], certValArray[1]));
				}
			}
		}

	}
}
