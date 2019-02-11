package com.learnyeai.cert.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class CertUtil {

	public static List<String> convertSiteIds(String ids) {
		List<String> siteIds = new ArrayList<String>();
		if (StringUtils.isNotBlank(ids)) {
			for (String siteId : ids.split(",")) {
				siteIds.add(siteId);
			}
		} else {
			return null;
		}
		return siteIds;
	}

	/**
	 * 将数字格式化为指定位数的字符串，用零补齐 注意10的bits次幂后的记过一定要大于i
	 * 
	 * @param i
	 * @param bits
	 * @return
	 */
	public static String format(long i, int bits) {
		double num = Math.pow(10, bits);
		num = num + i;
		return String.valueOf((int) num).substring(1);
	}
}
