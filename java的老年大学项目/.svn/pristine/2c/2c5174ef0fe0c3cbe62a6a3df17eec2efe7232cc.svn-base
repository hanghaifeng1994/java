package com.drcl.traincore.util;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 
 * @author hbqian
 * @since 20150818
 * @version 1.0
 * 
 */
public class StringUtil {

	/**
	 * 中国电信号码格式验证 手机段： 133,153,180,181,189,177,1700,173
	 * **/
	private static final String CHINA_TELECOM_PATTERN = "(^1(33|53|7[37]|8[019])\\d{8}$)|(^1700\\d{7}$)";

	/**
	 * 中国联通号码格式验证 手机段：130,131,132,155,156,185,186,145,171,175,176,1707,1708,1709
	 * **/
	private static final String CHINA_UNICOM_PATTERN = "(^1(3[0-2]|4[5]|5[56]|7[1]|7[5]|7[6]|8[56])\\d{8}$)|(^170[7-9]\\d{7}$)";

	/**
	 * 中国移动号码格式验证
	 * 手机段：134,135,136,137,138,139,150,151,152,157,158,159,182,183,184
	 * ,187,188,147,172,178,1705
	 **/
	private static final String CHINA_MOBILE_PATTERN = "(^1(3[4-9]|4[7]|5[0-27-9]|7[2]|7[8]|8[2-478])\\d{8}$)|(^1705\\d{7}$)";

	/**
	 * 仅手机号格式校验
	 */
	private static final String PHONE_PATTERN = new StringBuilder(300).append(CHINA_MOBILE_PATTERN).append("|").append(CHINA_TELECOM_PATTERN).append("|").append(CHINA_UNICOM_PATTERN).toString();

	/**
	 * @Description:把list转换为一个用逗号分隔的字符串 前后都要有逗号，方便查询用,x,模式查询，防止id包含，导致查询不准确
	 */
	public static String listToString(List<String> list) {
		StringBuilder sb = new StringBuilder(",");
		if (list != null && list.size() > 0) {
			for (String tenantId : list) {
				sb.append(tenantId).append(",");
			}
		}
		return sb.toString();
	}

	public static boolean isPhone(String input) {
		return Pattern.matches(PHONE_PATTERN, input);
	}
}
