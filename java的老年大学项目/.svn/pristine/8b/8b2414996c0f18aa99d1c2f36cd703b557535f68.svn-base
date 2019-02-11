/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.learnyeai.tools.common;

import org.apache.commons.lang3.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类, 继承org.apache.commons.lang3.StringUtils类
 * @author ThinkGem
 * @version 2013-05-22
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

	public static final char[] codeSequences = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	public static final char[] code16Sequences = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	public static final char[] charSequences = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private static final char SEPARATOR = '_';
	private static final String CHARSET_NAME = "UTF-8";

	/**
	 * 转换为字节数组
	 * @param str
	 * @return
	 */
	public static byte[] getBytes(String str){
		if (str != null){
			try {
				return str.getBytes(CHARSET_NAME);
			} catch (UnsupportedEncodingException e) {
				return null;
			}
		}else{
			return null;
		}
	}
	/**
	 * 转换为字节数组
	 * @param str
	 * @return
	 */
	public static String toString(byte[] bytes){
		try {
			return new String(bytes, CHARSET_NAME);
		} catch (UnsupportedEncodingException e) {
			return EMPTY;
		}
	}

	public static String iso2utf8(String src) {
		try {
			if (isEmpty(src))
				return "";
			return new String(src.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			return "?";
		}
	}

	public static String iso2gbk(String src) {
		try {
			if (isEmpty(src))
				return "";
			return new String(src.getBytes("iso-8859-1"), "gbk");
		} catch (UnsupportedEncodingException e) {
			return "?";
		}
	}

	public static String utf2gbk(String src) {
		try {
			if (isEmpty(src))
				return "";
			return new String(src.getBytes("utf-8"), "gbk");
		} catch (UnsupportedEncodingException e) {
			return "?";
		}
	}
	public static String gbk2utf(String src) {
		try {
			if (isEmpty(src))
				return "";
			return new String(src.getBytes("gbk"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			return "?";
		}
	}

	public static String gbk2utf(byte[] gbk) {
		try {
			return new String(gbk, "gbk");
		} catch (UnsupportedEncodingException e) {
			return "?";
		}
	}
	/**
	 * 重复字符串 如 repeatString("a",3) ==> "aaa"
	 *
	 * @author uke
	 * @param src
	 * @param repeats
	 * @return
	 */
	public static String repeatString(String src, int repeats) {
		if (null == src || repeats <= 0) {
			return src;
		} else {
			StringBuffer bf = new StringBuffer();
			for (int i = 0; i < repeats; i++) {
				bf.append(src);
			}
			return bf.toString();
		}
	}

	/**
	 * 去除,分隔符，用于金额数值去格式化
	 *
	 * @param value
	 * @return
	 */
	public static String decimal(String value) {
		if (null == value || "".equals(value.trim())) {
			return "0";
		} else {
			return value.replaceAll(",", "");
		}
	}
	/**
	 * 在数组中查找字符串
	 *
	 * @param params
	 * @param name
	 * @param ignoreCase
	 * @return
	 */
	public static int indexOf(String[] params, String name, boolean ignoreCase) {
		if (params == null)
			return -1;
		for (int i = 0, j = params.length; i < j; i++) {
			if (ignoreCase && params[i].equalsIgnoreCase(name)) {
				return i;
			} else if (params[i].equals(name)) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * 将字符转数组
	 *
	 * @param str
	 * @return
	 */
	public static String[] toArr(String str) {
		String inStr = str;
		String a[] = null;
		try {
			if (null != inStr) {
				StringTokenizer st = new StringTokenizer(inStr, ",");
				if (st.countTokens() > 0) {
					a = new String[st.countTokens()];
					int i = 0;
					while (st.hasMoreTokens()) {
						a[i++] = st.nextToken();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	/**
	 * 字符串数组包装成字符串
	 *
	 * @param ary
	 * @param s
	 *            包装符号如 ' 或 "
	 * @return
	 */
	public static String toStr(String[] ary, String s) {
		if (ary == null || ary.length < 1)
			return "";
		StringBuffer bf = new StringBuffer();
		bf.append(s);
		bf.append(ary[0]);
		for (int i = 1; i < ary.length; i++) {
			bf.append(s).append(",").append(s);
			bf.append(ary[i]);
		}
		bf.append(s);
		return bf.toString();
	}

	/**
	 * 取整数值
	 *
	 * @param map
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static int getInt(Map map, String key, int defValue) {
		if (null != map && isNotEmpty(key)) {
			try {
				return Integer.parseInt((String) map.get(key));
			} catch (Exception e) {
			}
		}
		return defValue;
	}

	/**
	 * 取浮点值
	 *
	 * @param map
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static float getFloat(Map map, String key, int defValue) {
		if (null != map && isNotEmpty(key)) {
			try {
				return Float.parseFloat(map.get(key).toString());
			} catch (Exception e) {
			}
		}
		return defValue;
	}

	public static boolean isNumber(String s) {
		if (s == null || s.length() == 0)
			return false;
		String a = s;
		if(s.charAt(0) == '-')
			a = s.substring(1);
		return a.matches("[0-9\\.]+");
	}

	/**
	 * 转整数
	 *
	 * @param str
	 * @return
	 */
	public static int parseInt(String str) {
		if (!isNumber(str))
			return 0;
		return Integer.parseInt(str);
	}

	/**
	 *
	 * @param str
	 * @param def
	 * @return
	 */
	public static int parseInt(String str, int def) {
		int rst = parseInt(str);
		if (rst < 0) {
			return def;
		}
		return rst;
	}

	/**
	 * 带参字符串文本
	 *
	 * @param temp
	 * @param params
	 * @return
	 */
	public static String message(String temp, Object... params) {
		for (int i = 0; i < params.length; i++) {
			temp = temp.replaceAll("\\{" + i + "\\}", params[i].toString());
		}
		return temp;
	}

	/**
	 * 設置MESSAGE中的變量{0}...{N}
	 *
	 * @param msg
	 * @param vars
	 * @return
	 */
	public static String getMessage(String msg, String[] vars) {
		for (int i = 0; i < vars.length; i++) {
			msg = msg.replaceAll("\\{" + i + "\\}", vars[i]);
		}
		return msg;
	}
	/**
	 * 替换{var}中的变量
	 *
	 * @param msg
	 * @param vars 
	 * @return
	 */
	public static String formatMessage(String msg, String vars) {
		return msg.replaceAll("[{（][\\s\\S]*[)}]", vars);
	}
	/**
	 * @param msg
	 * @param var
	 * @return
	 */
	public static String getMessage(String msg, String var) {
		return getMessage(msg, new String[] { var });
	}

	/**
	 * @param msg
	 * @param var
	 * @param var2
	 * @return
	 */
	public static String getMessage(String msg, String var, String var2) {
		return getMessage(msg, new String[] { var, var2 });
	}

	public static void generyXmlEntry(StringBuffer bf, String entry,
									  Object value) {
		bf.append("<").append(entry).append(">");
		if (null != value)
			bf.append(value.toString().trim());
		bf.append("</").append(entry).append(">");
	}

	/**
	 * 从Map中取String类型值
	 *
	 * @param map
	 * @param key
	 * @return
	 */
	public static Object getMapValue(Map map, Object key) {
		if (null == map || null == key)
			return "";

		if ((key instanceof String)) {
			String keystr = (String) key;
			keystr = keystr.toUpperCase();
			key = keystr;
		}
		Object value = map.get(key);
		return null == value ? "" : value;
	}

	public static void generyXmlEntryCData(StringBuffer bf, String entry,
										   Object value) {
		bf.append("<").append(entry).append("><![CDATA[");
		if (null != value)
			bf.append(value);
		bf.append("]]></").append(entry).append(">");
	}
	public static String generyImgUrl(Object rootUrl, Object date,
									  Object imgId, Object imgInfo) {
		StringBuffer bf = new StringBuffer();
		try {
			String ext = StringUtils.getFileExtName((String) imgInfo);
			bf.append(rootUrl).append("/");
			bf.append(date).append("/");
			bf.append(imgId).append(ext);
		} catch (Exception e) {
			bf.append("");
		}
		return bf.toString();
	}

	/**
	 * 解析文件的扩展名
	 *
	 * @param oldName
	 * @return
	 */
	public static String getFileExtName(String oldName) {
		String ext = "";
		int lastIndex = oldName.lastIndexOf(".");
		if (lastIndex > 0) {
			ext = oldName.substring(lastIndex);
		}
		return ext;
	}

	public static boolean isChinese(char c) {

		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);

		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS

				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS

				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A

				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B

				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION

				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS

				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {

			return true;
		}
		return false;
	}

	/**
	 * 去除字符串总含有某些特定的字符串
	 *
	 * @param res
	 *            原参数
	 * @param params
	 *            需要替换的字符串
	 * @return
	 */
	public static String replaceString(String res,Object... params){
		for(int i=0;i<params.length;i++){
			System.out.println(params[i].toString());
			System.out.println(res.indexOf(params[i].toString()));
			res.replaceAll(params[i].toString(), "");
		}
		return res;
	}

	/**
	 *
	 * 随机生成数字
	 */
	public static String randomInt(int length) {
		StringBuffer randomCode = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			String strRand = String.valueOf(codeSequences[random.nextInt(10)]);
			randomCode.append(strRand);
		}
		return randomCode.toString();
	}

	public static String randomInt(int length, int min, int max) {
		Random random = new Random();
		String strRand = String.format("%0" + length + "X", random.nextInt(max - min) + min);
		if (strRand.length() > length) {
			strRand = strRand.substring(0, length);
		}

		return strRand;
	}

	public static int string2Int(String str) {
		return parseInt(str);
	}

	public static String lowerFirst(String str){
		if(StringUtils.isBlank(str)) {
			return "";
		} else {
			return str.substring(0,1).toLowerCase() + str.substring(1);
		}
	}
	
	public static String upperFirst(String str){
		if(StringUtils.isBlank(str)) {
			return "";
		} else {
			return str.substring(0,1).toUpperCase() + str.substring(1);
		}
	}

	/**
	 * 替换掉HTML标签方法
	 */
	public static String replaceHtml(String html) {
		if (isBlank(html)){
			return "";
		}
		String regEx = "<.+?>";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(html);
		String s = m.replaceAll("");
		return s;
	}

	/**
	 * 缩略字符串（不区分中英文字符）
	 * @param str 目标字符串
	 * @param length 截取长度
	 * @return
	 */
	public static String abbr(String str, int length) {
		if (str == null) {
			return "";
		}
		try {
			StringBuilder sb = new StringBuilder();
			int currentLength = 0;
			for (char c : replaceHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray()) {
				currentLength += String.valueOf(c).getBytes("GBK").length;
				if (currentLength <= length - 3) {
					sb.append(c);
				} else {
					sb.append("...");
					break;
				}
			}
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 缩略字符串（替换html）
	 * @param str 目标字符串
	 * @param length 截取长度
	 * @return
	 */
	public static String rabbr(String str, int length) {
        return abbr(replaceHtml(str), length);
	}
		
	
	/**
	 * 转换为Double类型
	 */
	public static Double toDouble(Object val){
		if (val == null){
			return 0D;
		}
		try {
			return Double.valueOf(trim(val.toString()));
		} catch (Exception e) {
			return 0D;
		}
	}

	/**
	 * 转换为Float类型
	 */
	public static Float toFloat(Object val){
		return toDouble(val).floatValue();
	}

	/**
	 * 转换为Long类型
	 */
	public static Long toLong(Object val){
		return toDouble(val).longValue();
	}

	/**
	 * 转换为Integer类型
	 */
	public static Integer toInteger(Object val){
		return toLong(val).intValue();
	}
	
	/**
	 * 获得用户远程地址
	 */
	public static String getRemoteAddr(HttpServletRequest request){
		String remoteAddr = request.getHeader("X-Real-IP");
        if (isNotBlank(remoteAddr)) {
        	remoteAddr = request.getHeader("X-Forwarded-For");
        }else if (isNotBlank(remoteAddr)) {
        	remoteAddr = request.getHeader("Proxy-Client-IP");
        }else if (isNotBlank(remoteAddr)) {
        	remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
	}

	/**
	 * 首字母，小写转大写
	 * @param str
	 * @return
	 */
	public static String uncapitalize(final String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return str;
		}

		char firstChar = str.charAt(0);
		if (Character.isLowerCase(firstChar)) {
			// already uncapitalized
			return str;
		}

		return new StringBuilder(strLen)
				.append(Character.toLowerCase(firstChar))
				.append(str.substring(1))
				.toString();
	}
	/**
	 *
	 * 随机生成字母
	 */
	public static String randomString(int length) {
		StringBuffer randomCode = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			String strRand = String.valueOf(charSequences[random.nextInt(26)]);
			randomCode.append(strRand);
		}
		return randomCode.toString();
	}

	public static String randomString16(int length) {
		StringBuffer randomCode = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			String strRand = String.valueOf(code16Sequences[random.nextInt(16)]);
			randomCode.append(strRand);
		}
		return randomCode.toString();
	}
	
	/**
	 * 将Object转化为String，可以指定null时的默认值
	 * @param obj
	 * @param defaultVal
	 * @return
	 */
	public static String toString(Object obj, String defaultVal) {
		return null == obj ? defaultVal : String.valueOf(obj);
	}


	public static boolean isEmpty(Object s) {
		return s == null || isEmpty(s.toString());
	}
	/**
	 * 内容不为空
	 *
	 * @param value
	 * @return
	 */
	public static boolean isNotEmpty(String value) {
		return null != value && !"".equals(value.trim());
	}
	/**
	 * 左对齐字符串 * lpadString("X",3); ==>" X" *
	 *
	 * @param src
	 * @param length
	 * @return
	 */
	public static String lpadString(String src, int length) {
		return lpadString(src, length, " ");
	}

	/**
	 * 以指定字符串填补空位，左对齐字符串 * lpadString("X",3,"0"); ==>"00X"
	 *
	 * @param src
	 * @param byteLength
	 * @param temp
	 * @return
	 */
	public static String lpadString(String src, int length, String single) {
		if (src == null || length <= src.getBytes().length) {
			return src;
		} else {
			return repeatString(single, length - src.getBytes().length) + src;
		}
	}

	/**
	 * 右对齐字符串 * rpadString("9",3)==>"9 "
	 *
	 * @param src
	 * @param byteLength
	 * @return
	 */
	public static String rpadString(String src, int byteLength) {
		return rpadString(src, byteLength, " ");
	}

	/**
	 * 以指定字符串填补空位，右对齐字符串 rpadString("9",3,"0")==>"900"
	 *
	 * @param src
	 * @param byteLength
	 * @param single
	 * @return
	 */
	public static String rpadString(String src, int length, String single) {
		if (src == null || length <= src.getBytes().length) {
			return src;
		} else {
			return src + repeatString(single, length - src.getBytes().length);
		}
	}
	/**
	 * 驼峰命名法工具
	 * @return
	 * 		toCamelCase("hello_world") == "helloWorld"
	 * 		toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 * 		toUnderScoreCase("helloWorld") = "hello_world"
	 */
	public static String toCamelCase(String s) {
		if (s == null) {
			return null;
		}

		s = s.toLowerCase();

		StringBuilder sb = new StringBuilder(s.length());
		boolean upperCase = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == SEPARATOR) {
				upperCase = true;
			} else if (upperCase) {
				sb.append(Character.toUpperCase(c));
				upperCase = false;
			} else {
				sb.append(c);
			}
		}

		return sb.toString();
	}

	/**
	 * 驼峰命名法工具
	 * @return
	 * 		toCamelCase("hello_world") == "helloWorld"
	 * 		toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 * 		toUnderScoreCase("helloWorld") = "hello_world"
	 */
	public static String toCapitalizeCamelCase(String s) {
		if (s == null) {
			return null;
		}
		s = toCamelCase(s);
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	/**
	 * 驼峰命名法工具
	 * @return
	 * 		toCamelCase("hello_world") == "helloWorld"
	 * 		toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 * 		toUnderScoreCase("helloWorld") = "hello_world"
	 */
	public static String toUnderScoreCase(String s) {
		if (s == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		boolean upperCase = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			boolean nextUpperCase = true;

			if (i < (s.length() - 1)) {
				nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
			}

			if ((i > 0) && Character.isUpperCase(c)) {
				if (!upperCase || !nextUpperCase) {
					sb.append(SEPARATOR);
				}
				upperCase = true;
			} else {
				upperCase = false;
			}

			sb.append(Character.toLowerCase(c));
		}

		return sb.toString();
	}

	/**
	 * 转换为JS获取对象值，生成三目运算返回结果
	 * @param objectString 对象串
	 *   例如：row.user.id
	 *   返回：!row?'':!row.user?'':!row.user.id?'':row.user.id
	 */
	public static String jsGetVal(String objectString){
		StringBuilder result = new StringBuilder();
		StringBuilder val = new StringBuilder();
		String[] vals = split(objectString, ".");
		for (int i=0; i<vals.length; i++){
			val.append("." + vals[i]);
			result.append("!"+(val.substring(1))+"?'':");
		}
		result.append(val.substring(1));
		return result.toString();
	}

	/**
	 * 给url添加参数时，添加分割符 // 张配忠添加 // 20161005
	 * @param url
	 * @return
	 */
	public static String addUrlParams(String url){
		if(isBlank(url))
			return url;
		int idx = url.indexOf("?");
		if( idx > 0){
			return url + "&";
		}else{
			return url + "?";
		}
	}
	/**
	 * 大写加下划线命名，转为驼峰式命名
	 * @param str
	 * @return
	 */
	public static String capitalizeAll(String str) {
		if (null == str || str.isEmpty()) {
			return str;
		}
		StringBuilder s = new StringBuilder(str.length());
		boolean isUpper = true;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ('_' == c) {
				isUpper = true;
				continue;
			}
			if (isUpper) {
				s.append(Character.toUpperCase(c));
				isUpper = false;
			} else {
				s.append(Character.toLowerCase(c));
			}
		}
		return s.toString();
	}

	/**
	 * 是否包含字符串
	 * @param str 验证字符串
	 * @param strs 字符串组
	 * @return 包含返回true
	 */
	public static boolean inString(String str, String... strs){
		if (str != null){
			for (String s : strs){
				if (str.equals(trim(s))){
					return true;
				}
			}
		}
		return false;
	}
}
