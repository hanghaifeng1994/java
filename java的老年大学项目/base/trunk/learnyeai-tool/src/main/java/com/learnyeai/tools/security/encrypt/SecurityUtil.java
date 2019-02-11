package com.learnyeai.tools.security.encrypt;

import java.security.Key;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 解密处理类
 * 
 * @author yaoym
 * 
 */
public class SecurityUtil {
	private static Logger logger = LoggerFactory.getLogger(SecurityUtil.class);

    /**
     * @Title: getReqKey
     * @Description: 获取请求key
     * @param data
     *            请求数据
     * @return
     */
    public static String getReqKey(String data) {
        try {
            String[] array = data.split((char) (29) + "");
            if (array.length != 3) {
                if (logger.isDebugEnabled()) {
                    logger.debug("加密请求-内容结构非法!");
                }
                return "";
            }
            return RSACerPlus.getInstance().doDecrypt(array[2]);
        } catch (Exception e) {
            logger.error("加密请求-解密发生异常", e);
            return "";
        }
    }

    /**
     * 请求报文解密处理，解密成功将返回
     * 
     * @param data
     * @return
     */
	public static String deEncrypt(String data) {
		String resData = null;
		long startDate = System.currentTimeMillis();
		try {
			String[] array = data.split((char) (29) + "");
			if (array.length != 3) {
				if (logger.isDebugEnabled()) {
                    logger.debug("加密请求-内容结构非法!");
				}
				return null;
			}
            // 数据摘要
			String md5Str = array[0];
            // 加密数据
			resData = array[1];
            // 数字信封
			String keyStr = array[2];
            // 使用私钥解密数字信封
			keyStr = RSACerPlus.getInstance().doDecrypt(keyStr);
			Key k = AESCoder.toKey(keyStr.getBytes());
            // 交易报文解密
			byte[] dataArr = Converts.strToBase64(resData);
			byte[] encryptData = AESCoder.decrypt(dataArr, k);
			resData = new String(encryptData, "utf-8");

            // 对数据摘要生产的报文进行md5校验
			String strRemark = keyStr + resData;
			if (!md5Str.equals(MD5Encrypt.getMD5(strRemark.getBytes("utf-8")).toUpperCase())) {
				if (logger.isDebugEnabled()) {
                    logger.debug("加密请求-数据摘要不正确，报文非法!");
				}
				return null;
			}
			long endDate = System.currentTimeMillis();
			if (logger.isDebugEnabled()) {
                logger.debug("加密请求-解密耗时：" + (endDate - startDate));
			}
			return resData;
		} catch (Exception e) {
            logger.error("加密请求-解密发生异常", e);
			return null;
		}
	}
	
    /**
     * 解密处理，解密成功将返回
     * 
     * @param data
     * @return
     */
	public static String deEncryptLoginPwd(String data) {
		String resData = null;
        // 使用私钥解密登录密码
		try {
			resData = RSACerPlus.getInstance().doDecrypt(data);
			return resData;
		} catch (Exception e) {
            logger.error("解密登录密码发生异常", e);
			return null;
		}
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		/*Key k = AESCoder.toKey("AAAAAAAAAAAAAAAA".getBytes());
		String desData = "b/+ZG162r5eNAKyqpudxHHtaBFWRr9mia420ntvnNvrIh8h3IYa+iK+rt5Bo3j7YpyR5/GscozAJzJBszIPb2VHHoAkOKGLA21rJx+1AY83NJUU5kIXxoxdN+9sypzgy+vNZK3/zDmI8u7f8g0JbIGpEsLZ4RE+67uAWrri6ygo=";
		String oldStr = "{'username':'zhangsan','age':'23','sex':'1'}";
		byte[] encryptData = AESCoder.decrypt(Converts.strToBase64(desData), k);
		desData = new String(encryptData);
		System.out.println(desData);*/
	}

}
