package com.learnyeai.tools.security;

import com.learnyeai.tools.common.StringUtils;

public class FilterUtil {
	/**
	 * 格式化手机号
	 * 
	 * @param mobileNo
	 * @return
	 */
	public static String formatMobileNo(String s) {
		if (StringUtils.isEmpty(s))
			return s;
		int length = s.length();
		if (length < 7) {
			return s;
		}
		return s.substring(0, 3) + "****" + s.substring(length - 3);
	}

	/**
	 * 证件号格式化
	 * 
	 * @param idNo
	 * @return
	 */
	public static String formatIdNo(String s) {
		if (StringUtils.isEmpty(s))
			return s;
		int length = s.length();
		if (length < 6) {
			return s;
		}
		return "****" + s.substring(length - 4);
	}

	/**
	 * 家庭地址格式化
	 * 
	 * @param addr
	 * @return
	 */
	public static String formatAddr(String addr) {
		return addr;
	}
}
