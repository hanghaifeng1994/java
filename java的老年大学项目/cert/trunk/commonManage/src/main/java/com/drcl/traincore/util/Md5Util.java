package com.drcl.traincore.util;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * @author twang
 * @since 20150915
 */
public class Md5Util {
	private static MessageDigest MD5 = null;
	private static Logger logger = Logger.getLogger(MessageDigest.class);

	static {
		try {
			MD5 = MessageDigest.getInstance("Md5");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * @param str
	 * @param charset
	 * @return
	 */
	public static String md5Encode(String str, String charset) {
		MD5.reset();
		try {
			MD5.update(str.getBytes(charset));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte[] byteArray = MD5.digest();
		StringBuilder md5StrBuff = new StringBuilder();

		for (byte aByteArray : byteArray) {
			if (Integer.toHexString(0xFF & aByteArray).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & aByteArray));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & aByteArray));
		}

		return md5StrBuff.toString();
	}

	public static String md5Encode(String str) {
		return md5Encode(str, "UTF-8");
	}
	
	public static void main(String[] args) {
		System.out.println(Md5Util.md5Encode("111111"));
	}

}