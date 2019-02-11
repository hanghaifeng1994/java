package com.learnyeai.tools.security;

import java.util.Random;

public class RandomUtil {

	private static final char[] codeSequences = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9' };

	/**
	 * 
	 * 随机生成6位数新密码
	 */
	public static String randomInt(int length) {
		StringBuffer randomCode = new StringBuffer(length);
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			String strRand = String.valueOf(codeSequences[random.nextInt(10)]);
			randomCode.append(strRand);
		}
		return randomCode.toString();
	}

	private static final char[] charSequences = { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
			'U', 'V', 'W', 'X', 'Y', 'Z' };

	/**
	 * 
	 * 随机生成6位短信前缀
	 */
	public static String randomString(int length) {
		StringBuffer randomCode = new StringBuffer(length);
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			String strRand = String.valueOf(charSequences[random.nextInt(20)]);
			randomCode.append(strRand);
		}
		return randomCode.toString();
	}
	
	private static final char[] allChar = {'0','1','2','3','4','5','6','7','8','9',
		'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
		'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	public static String generateRandom(int length){
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for(int i=0;i<length;i++){
			sb.append(allChar[random.nextInt(allChar.length)]);
		}
		return sb.toString();
	}
}
