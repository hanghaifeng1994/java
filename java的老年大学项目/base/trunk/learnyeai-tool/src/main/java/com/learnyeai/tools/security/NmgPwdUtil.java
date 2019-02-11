package com.learnyeai.tools.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 调用加密平台
 * 
 * @author xxx
 * 
 */
public class NmgPwdUtil {
	private Logger logger = LoggerFactory.getLogger(getClass());
	/*//连接密码平台IP地址
	private static final String passsowdHost = Properties.getString("passsowdHost");
	//接密码平台的端口号
	private static final int passowdPort = Properties.getInt("passowdPort");
	//连接密码平台的超时时间
	private static final int passowdTimeout = Properties.getInt("passowdTimeout");
	//连接密码平台生成的日志
	private static final String passowdLog = Properties.getString("passowdLog");
	//交易密码连接密码平台所需节点
	private static final String passowdHybrid = Properties.getString("passowdHybrid");
	//登录密码连接密码平台所需节点
	private static final String passowdLogonHybrid = Properties.getString("passowdLogonHybrid");
	//连接密码平台密码控件指定RSA公私钥
	private static final String passowdRsaDuad = Properties.getString("passowdRsaDuad");
	//连接密码平台JS指定的RSA公私钥
	private static final String RSAType = Properties.getString("passowdRsaDuadJS");*/

	private static NmgPwdUtil huarunEncrypt = null;


	private NmgPwdUtil() {
		logger.info("新建密码平台连接对象......");
	}

	public static NmgPwdUtil getInstance() {
		if (null == huarunEncrypt) {
			huarunEncrypt = new NmgPwdUtil();
		}
		return huarunEncrypt;
	}

	/**
	 * 
	 * 
	 * @param pinByPK   密文
	 * @param clientId  客户号
	 * @throws Exception 
	 * 
	 */
	public static String doEncrypt(String pinByPK,String clientId) throws Exception {
	/*	String encryptStr="";
		byte[] pinByHrDenglu = new byte[128];
		byte[] pczTermKey = new byte[128];
		UnionAPI unionApi = new UnionAPI(passsowdHost, passowdPort,passowdTimeout, passowdLog);
		int i = unionApi.UnionTranslatePinByHrWyDenglu(passowdRsaDuad,passowdLogonHybrid, clientId, pinByPK,pinByHrDenglu, pczTermKey);
		encryptStr = new String(pinByHrDenglu).trim();
		return encryptStr;*/
		return null;
	}
	
	/**
	 * 
	 * 卡密码解密转pin
	 * @param pinByPK   密文
	 * @throws Exception 
	 * 
	 */
	public static String doEncryptByCard(String pinByPK) throws Exception {
		/*String encryptStr="";
		String acctNo="0000000000000000";
		byte[] pinBlockByZPK = new byte[128];
		byte[] variable = new byte[128];
		int[] variableLen = new int[20];
		UnionAPI unionApi = new UnionAPI(passsowdHost, passowdPort,passowdTimeout, passowdLog);
		int i = unionApi.UnionDerivePinBlockFromPinByPKWithVariable(passowdRsaDuad,pinByPK,passowdHybrid, acctNo, pinBlockByZPK,variableLen, variable);
		encryptStr = new String(pinBlockByZPK).trim();
		return encryptStr;*/
		return null;
	}
	
	
}
