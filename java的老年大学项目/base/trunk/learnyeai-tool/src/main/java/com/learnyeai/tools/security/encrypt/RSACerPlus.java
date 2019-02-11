package com.learnyeai.tools.security.encrypt;

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.lang3.ArrayUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 用户服务器端对客户端提交的加密数据使用私钥进行解密 公钥加密--客户端 私钥解密--服务端
 * <p>
 * 前提
 * </p>
 * <ul>
 * <li>：JDK已安装且正确配置环境变量</li>
 * <li>首先在C盘建立目录 MyKeyStore，用来存放证书库以及导出的证书文件，然后在命令行执行下列2句</li>
 * <li>下句含义：在当前目录创建 TestStore 密钥库，库密码 aaaaaa ，创建证书 TestKey2 ：非对称密钥，RSA 算法，key密码为
 * bbbbbb ，存于 TestStore cmd> keytool -genkey -alias TestKey2 -dname "CN=test222"
 * -keyalg RSA -keystore d:/TestStore -storepass aaaaaa -keypass bbbbbb</li>
 * <li>下句含义：将 TestStore 库中的 TestKey2 导出为证书文件 TestKey2.cer ，这里可能需要将 export 修改为
 * exportcert cmd> keytool -export -alias TestKey2 -file TestKey2.cer -keystore
 * TestStore -storepass aaaaaa</li>
 * <li>证书库证书保存证书的公私钥，导出的证书文件只携带公钥</li>
 * 
 * 
 * <p>
 * C:\Program Files\Java\jdk1.6.0_35\bin>keytool -genkey -alias ibs -keyalg RSA
 * -ke ystore e:/temp/ibanking.jks -storepass pncjks -keypass ibanking
 * 您的名字与姓氏是什么？ [Unknown]： shang hai yi tong 您的组织单位名称是什么？ [Unknown]： yitong
 * 您的组织名称是什么？ [Unknown]： yitong 您所在的城市或区域名称是什么？ [Unknown]： shanghai
 * 您所在的州或省份名称是什么？ [Unknown]： shanghai 该单位的两字母国家代码是什么 [Unknown]： cn CN=shang hai
 * yi tong, OU=yitong, O=yitong, L=shanghai, ST=shanghai, C=cn 正确吗 ？ [否]： y
 * 
 * C:\Program Files\Java\jdk1.6.0_35\bin>keytool -export -alias ibs -file
 * ibanking. cer -keystore e:/temp/ibanking.jks -storepass pncjks 保存在文件中的认证
 * <ibanking.cer>
 * </p>
 * 
 * @author yym
 * 
 */
public class RSACerPlus {
	private static Logger logger = LoggerFactory.getLogger(RSACerPlus.class);
	private Cipher cipher;
	// 数字证书
	private final String keystoreFilePath = "ibanking.jks";
	// 公钥--客户端加密码时使用
	private final String publickeyFilePath = "ibanking.cer";
	// 证书密码
	private final String storepass = "pncjks";
	// 私钥密码
	private final String keypass = "ibanking";
	// 私钥别名
	private final String keyalias = "ibs";

	private static RSACerPlus rsaPlus = null;
	private PrivateKey pk2;

	String rootpath = null;

	private RSACerPlus() {
		rootpath = RSACerPlus.class.getResource("RSACerPlus.class").getPath();
		rootpath = rootpath.substring(0, rootpath.indexOf("WEB-INF") + 8);
	}

	public static RSACerPlus getInstance() {
		if (null == rsaPlus) {
			rsaPlus = new RSACerPlus();
			try {
				rsaPlus.initCer();
			} catch (Exception e) {
				logger.error("init the cer ERROR!", e);
			}
		}
		return rsaPlus;
	}

	/**
	 * 初始化加载cer证书
	 * 
	 * @throws Exception
	 */
	private void initCer() throws Exception {
		String filePath = rootpath + "lib/" + keystoreFilePath;
		// String filePath = "c:/" + keystoreFilePath;
		FileInputStream fis2 = new FileInputStream(filePath);
		KeyStore ks = KeyStore.getInstance("JKS"); // 加载证书库
		char[] kspwd = storepass.toCharArray(); // 证书库密码
		char[] keypwd = keypass.toCharArray(); // 证书密码
		ks.load(fis2, kspwd); // 加载证书
		pk2 = (PrivateKey) ks.getKey(keyalias, keypwd); // 获取证书私钥
		fis2.close();
	}

	/**
	 * 使用初始化的公钥对数据加密
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 *             : IllegalBlockSizeException, BadPaddingException,
	 *             UnsupportedEncodingException
	 */
	public String doEncrypt(String str) throws Exception {
		CertificateFactory cff = CertificateFactory.getInstance("X.509");
		String filePath = rootpath + "conf/" + publickeyFilePath;
		InputStream in = new FileInputStream(filePath);// 证书文件
		Certificate cf = cff.generateCertificate(in);
		PublicKey pk1 = cf.getPublicKey(); // 得到证书文件携带的公钥
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding"); // 定义算法：RSA
		// 加密模式
		cipher.init(Cipher.ENCRYPT_MODE, pk1);
		byte[] msg1 = cipher.doFinal(str.getBytes("UTF-8")); // 加密后的数据
		return new BASE64Encoder().encode(msg1);
	}

	/**
	 * 使用公钥对数据加密
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 *             : IllegalBlockSizeException, BadPaddingException,
	 *             UnsupportedEncodingException
	 */
	public String doNmgCardPwdEncrypt(String keyStr, String pwdStr) throws Exception {
		pwdStr = "000000";
		Key pk1 = getPubKey(keyStr); //
		Cipher cipher = Cipher.getInstance("RSA"); // 定义算法：RSA
		// 加密模式
		cipher.init(Cipher.ENCRYPT_MODE, pk1);
		byte[] msg1 = cipher.doFinal(pwdStr.getBytes()); // 加密后的数据
		return Converts.bytesToHexString(msg1);
	}

	public static String stringToAscii(String value) {
		StringBuffer sbu = new StringBuffer();
		char[] chars = value.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (i != chars.length - 1) {
				sbu.append((int) chars[i]).append(",");
			} else {
				sbu.append((int) chars[i]);
			}
		}
		return sbu.toString();
	}

	/**
	 * 使用初始化的公钥对数据加密
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public RSAPublicKey getPubKey(String str) throws Exception {
		RSAPublicKey pubKey = buildRSAPublicKey(str, "01");
		return pubKey;
	}

	public RSAPublicKey buildRSAPublicKey(String modulus, String publicExponent) {
		return buildRSAPublicKey(new BigInteger(modulus, 16), new BigInteger(publicExponent, 16));
	}

	public static RSAPublicKey buildRSAPublicKey(BigInteger modulus, BigInteger publicExponent) {
		try {
			Provider DEFAULT_PROVIDER = new BouncyCastleProvider();
			KeyFactory kf = KeyFactory.getInstance("RSA", DEFAULT_PROVIDER);
			RSAPublicKeySpec spec = new RSAPublicKeySpec(modulus, publicExponent);
			return (RSAPublicKey) kf.generatePublic(spec);
		} catch (Exception e) {
			throw new IllegalStateException("cannot build public key by modulus and exponent", e);
		}
	}

	/**
	 * 解密字符串
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 *             :IllegalStateException, IllegalBlockSizeException,
	 *             BadPaddingException, IOException
	 */
	public String doDecrypt(String str) throws Exception {
		byte[] msg = new BASE64Decoder().decodeBuffer(str);
		StringBuffer sb = new StringBuffer();
		try {
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			// 解密模式
			cipher.init(Cipher.DECRYPT_MODE, pk2);
			for (int i = 0; i < msg.length; i += 128) {
				byte[] doFinal = cipher.doFinal(ArrayUtils.subarray(msg, i, i + 128));
				sb.append(new String(doFinal, "UTF-8"));
			}
		} catch (Exception e) {
			initCer();
			logger.debug("解密数据失败!", e);
			throw e;
		}
		return sb.toString();
	}

	public static byte[] encrypt(Key key, byte data[]) throws Exception {
		Provider DEFAULT_PROVIDER = new BouncyCastleProvider();
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(1, key);
		return cipher.doFinal(data);
	}

	public static void main(String[] args) throws Exception {
	}
}
