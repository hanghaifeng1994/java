package com.learnyeai.tools.security.encrypt;

import java.security.Key;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.learnyeai.tools.common.StringUtils;
/**
 * 请求返回报文自定义加密
 *
 * @author 徐明明
 *
 */
public class Encrypt {

    private Logger logger = LoggerFactory.getLogger(Encrypt.class);


    /* *************** 加解密常量 *************** */
    // 自定义加密版本
    public static final String VERSION = "1";
    //自定义加密填充约束
    public static final String FILL_CODE = "13";
    // 混淆规则 0：无混淆；1：首尾对换；2、奇偶对换；
    public static final Integer CONFUSE_STATUS = 2;


    private static Encrypt instance = new Encrypt();

    public static Encrypt getInstance() {
        return instance;
    }

    /**
     * @Title: getEncryptKey
     * @Description: 动态获取加密key
     * @param keyStr
     * @return
     */
    public Key getEncryptKey(String keyStr) {
        return AESCoder.toKey(keyStr.getBytes());
    }

    /**
     * 响应报文加密
     * @Title: encrypt
     * @Description: 加密处理
     * @param data
     * @param key
     *            动态key值
     * @return
     */
    public String encrypt(String data, String key) {
        try {
            Integer confuseRule = CONFUSE_STATUS;

            /**
             * 版本
             */
            StringBuffer controlCode = new StringBuffer();
            controlCode.append(String.format("%X", Integer.valueOf(VERSION)));

            /**
             * 加密 TODO AES 加解密，可换成其他加密方法
             */
            String encryptData = Converts.bytesToHexString(AESCoder.encrypt(data.getBytes("UTF-8"), getEncryptKey(key)));

            /**
             * 填充
             */
            Integer dataLen = encryptData.length(); // 原长度
            // 填充约束为 （2 ~ 数据体长度） 之间的随机数
            String fillPos = StringUtils.randomInt(2, 2, 20);

            controlCode.append(fillPos);
            Integer fillPosNum = Integer.parseInt(fillPos, 16);
            encryptData += StringUtils.randomString16(fillPosNum - (fillPosNum > 0 ? dataLen % fillPosNum : 0));// 填充

            /**
             * 混淆
             */
            if (dataLen == 0) {
                confuseRule = 0; // 数据体为空，无混淆
            }

            // 混淆长度为 （2 ~ 数据体长度 ） 之间的随机数
            String confuseLen = StringUtils.randomInt(2, 2, encryptData.length());
            Integer confuseLenNum = Integer.parseInt(confuseLen, 16);

            // 混淆起始值为 （0 ~ 数据体长度 ） 之间的随机数
            String confuseStartPos = StringUtils.randomInt(2, 0, encryptData.length() - confuseLenNum);
            Integer confuseStartPosNum = Integer.parseInt(confuseStartPos, 16);

            controlCode.append(confuseStartPos);
            controlCode.append(confuseLen);
            controlCode.append(String.format("%X", confuseRule));

            StringBuffer confuseData = new StringBuffer();
            String confuseStr = encryptData.substring(confuseStartPosNum, confuseStartPosNum + confuseLenNum);
            Integer confuseStrLen = confuseStr.length(); // 混淆内容长度

            confuseData.append(encryptData.substring(0, confuseStartPosNum));// 追加未混淆部分

            switch (confuseRule) {
                case 1: // 首尾对换
                    confuseData.append(confuseStr.charAt(confuseStrLen - 1));
                    confuseData.append(confuseStr.substring(1, confuseStrLen - 1));
                    confuseData.append(confuseStr.charAt(0));
                    break;
                case 2: // 基偶对换
                    for (int j = 2; j <= confuseStrLen; j++) {
                        if (j % 2 == 0) {
                            confuseData.append(confuseStr.charAt(j - 1));
                            confuseData.append(confuseStr.charAt(j - 2));
                        }
                    }
                    if (confuseStrLen % 2 != 0 && confuseStrLen > 0) {
                        confuseData.append(confuseStr.charAt(confuseStrLen - 1));
                    }
                    break;
                default:
                    break;
            }

            if (0 != confuseRule) {
                confuseData.append(encryptData.substring(confuseStartPosNum + confuseLenNum));
                encryptData = confuseData.toString();
            }

            controlCode.append(String.format("%06X", dataLen));

            /**
             * 组合控制码与数据体
             */
            controlCode.append(encryptData);

            return controlCode.toString();
        } catch (Exception e) {
            logger.error("加密请求-解密发生异常", e);
            return null;
        }
    }

    /**
     * @Title: decrypt
     * @Description: 解密处理
     * @param data
     * @param key
     *            动态key
     * @return
     */
    public String decrypt(String data, String key) {
        try {
            String encryptData = data.substring(14); // 取得数据体

            /**
             * 拆分控制码
             */
            Integer confuseStartPos = Integer.parseInt(data.substring(3, 5), 16);// 混淆起始点
            Integer confuseLen = Integer.parseInt(data.substring(5, 7), 16); // 混淆长度
            Integer confuseRule = Integer.parseInt(data.substring(7, 8), 16); // 混淆规则
            Integer originalLen = Integer.parseInt(data.substring(8, 14), 16); // 数据原长度

            /**
             * 反混淆
             */
            StringBuffer confuseData = new StringBuffer();
            String confuseStr = encryptData.substring(confuseStartPos, confuseStartPos + confuseLen); // 混淆内容
            Integer confuseStrLen = confuseStr.length(); // 混淆内容长度

            confuseData.append(encryptData.substring(0, confuseStartPos)); // 追加未混淆部分

            switch (confuseRule) {
                case 1: // 首尾对换
                    confuseData.append(confuseStr.charAt(confuseStrLen - 1));
                    confuseData.append(confuseStr.substring(1, confuseStrLen - 1));
                    confuseData.append(confuseStr.charAt(0));
                    break;
                case 2: // 基偶对换
                    for (int j = 2; j <= confuseStrLen; j++) {
                        if (j % 2 == 0) {
                            confuseData.append(confuseStr.charAt(j - 1));
                            confuseData.append(confuseStr.charAt(j - 2));
                        }
                    }
                    if (confuseStrLen % 2 != 0 && confuseStrLen > 0) {
                        confuseData.append(confuseStr.charAt(confuseStrLen - 1));
                    }
                    break;
                default:
                    break;
            }

            if (0 != confuseRule) {
                confuseData.append(encryptData.substring(confuseStartPos + confuseLen));
                encryptData = confuseData.toString();
            }

            /**
             * 反填充
             */
            encryptData = encryptData.substring(0, originalLen);

            /**
             * 解密 TODO AES 加解密，可换成其他加密方法
             */
            byte[] decryptDate = AESCoder.decrypt(Converts.hexStringToByte(encryptData), getEncryptKey(key));

            return new String(decryptDate);
        } catch (Exception e) {
            logger.error("加密请求-解密发生异常", e);
            return null;
        }
    }

    public void testDycKey() {

        long start = System.currentTimeMillis();

        try {
            String data = "shanghaiyitong1234";

            String key = "1234567890123456";

            logger.debug("自定义加密前的数据： " + data);
            logger.debug("加密前的数据长度: " + data.length());

            Encrypt en = new Encrypt();

            String encryptData = en.encrypt(data, key);
            logger.debug("自定义加密后的数据：" + encryptData);
            logger.debug("加密后的数据长度：" + encryptData.length());

            String decryptData = en.decrypt(encryptData, key);
            logger.debug("自定义解密后的数据：" + decryptData);

            if (data.equals(decryptData)) {
                logger.debug("结果：-----------true");
            } else {
                logger.debug("结果：-----------false");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("error");
            System.exit(0);
        }

        long end = System.currentTimeMillis();
        logger.debug("时间:{}", end - start);

    }

    public static void main(String[] args) {
        //Encrypt.getInstance().testOne();
        //        Encrypt.getInstance().testMore();
        Encrypt.getInstance().testDycKey();
    }
}
