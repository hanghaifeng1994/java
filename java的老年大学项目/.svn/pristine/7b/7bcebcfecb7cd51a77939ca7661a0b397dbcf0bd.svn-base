package com.learnyeai.base.utils.applet;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

/**
 *  CBC 模式
 *
 * PKCS7Padding 填充模式
 *
 * CBC模式需要添加一个参数iv--对称解密算法初始向量 iv
 *
 * 介于java 不支持PKCS7Padding，只支持PKCS5Padding 但是PKCS7Padding 和 PKCS5Padding 没有什么区别
 * 要实现在java端用PKCS7Padding填充，需要用到bouncycastle组件来实现
 * Created by zpz on 2017/12/11.
 */
public class Pkcs7Encoder {
    // 算法名称
    static final String KEY_ALGORITHM = "AES";

    // 加解密算法/模式/填充方式
    static final String algorithmStr = "AES/CBC/PKCS7Padding";
    //默认对称解密算法初始向量 iv
    static byte[] iv = { 0x30, 0x31, 0x30, 0x32, 0x30, 0x33, 0x30, 0x34, 0x30, 0x35, 0x30, 0x36, 0x30, 0x37, 0x30, 0x38 };
    public static boolean initialized = false;
    public static void initialize(){
        if (initialized) return;
        Security.addProvider(new BouncyCastleProvider());
        initialized = true;

    }

    private static Key toKey(byte[] keyBytes){
        // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
        int base = 16;
        if (keyBytes.length % base != 0) {
            int groups = keyBytes.length / base + (keyBytes.length % base != 0 ? 1 : 0);
            byte[] temp = new byte[groups * base];
            Arrays.fill(temp, (byte) 0);
            System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
            keyBytes = temp;
        }
        // 转化成JAVA的密钥格式
        Key key = new SecretKeySpec(keyBytes, KEY_ALGORITHM);
        return key;
    }
    /**
     * 加密方法
     *      --使用默认iv时
     * @param content
     *            要加密的字符串
     * @param keyBytes
     *            加密密钥
     * @return
     */
    public static byte[] encrypt(byte[] content, byte[] keyBytes) {
        byte[] encryptedText =  encryptOfDiyIV(content,keyBytes,iv);
        return encryptedText;
    }
    /**
     * 加密方法
     *      ---自定义对称解密算法初始向量 iv
     * @param content
     *              要加密的字符串
     * @param keyBytes
     *              加密密钥
     * @param ivs
     *         自定义对称解密算法初始向量 iv
     * @return 加密的结果
     */
    public static byte[] encryptOfDiyIV(byte[] content, byte[] keyBytes, byte[] ivs) {
        initialize();
        byte[] encryptedText = null;
        try {
            // 初始化cipher
            Cipher cipher = Cipher.getInstance(algorithmStr, "BC");
            Key key = toKey(keyBytes);
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(ivs));
            encryptedText = cipher.doFinal(content);

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return encryptedText;
    }


    /**
     * 解密方法
     *      --使用默认iv时
     * @param encryptedData
     *            要解密的字符串
     * @param keyBytes
     *            解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] encryptedData, byte[] keyBytes) {
        byte[] encryptedText = decryptOfDiyIV(encryptedData,keyBytes,iv);
        return encryptedText;
    }
    /**
     * 解密方法
     *
     * @param encryptedData
     *            要解密的字符串
     * @param keyBytes
     *            解密密钥
     * @param ivs
     *         自定义对称解密算法初始向量 iv
     * @return
     */
    public static byte[] decryptOfDiyIV(byte[] encryptedData, byte[] keyBytes,byte[] ivs) {
        initialize();

        byte[] encryptedText = null;
        try {
            // 初始化cipher
            Cipher cipher = Cipher.getInstance(algorithmStr, "BC");
            Key key = toKey(keyBytes);
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(ivs));
            encryptedText = cipher.doFinal(encryptedData);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return encryptedText;
    }
    public static void main(String[] args) throws Exception {
        String  encryptedData = "CiyLU1Aw2KjvrjMdj8YKliAjtP4gsMZMQmRzooG2xrDcvSnxIMXFufNstNGTyaGS9uT5geRa0W4oTOb1WT7fJlAC+oNPdbB+3hVbJSRgv+4lGOETKUQz6OYStslQ142dNCuabNPGBzlooOmB231qMM85d2/fV6ChevvXvQP8Hkue1poOFtnEtpyxVLW1zAo6/1Xx1COxFvrc2d7UL/lmHInNlxuacJXwu0fjpXfz/YqYzBIBzD6WUfTIF9GRHpOn/Hz7saL8xz+W//FRAUid1OksQaQx4CMs8LOddcQhULW4ucetDf96JcR3g0gfRK4PC7E/r7Z6xNrXd2UIeorGj5Ef7b1pJAYB6Y5anaHqZ9J6nKEBvB4DnNLIVWSgARns/8wR2SiRS7MNACwTyrGvt9ts8p12PKFdlqYTopNHR1Vf7XjfhQlVsAJdNiKdYmYVoKlaRv85IfVunYzO0IKXsyl7JCUjCpoG20f0a04COwfneQAGGwd5oa+T8yO5hzuyDb/XcxxmK01EpqOyuxINew==";
        String iv="r7BXXKkLb8qrSNn05n0qiA==";
        String sessionKey = "tiihtNczf5v6AKRyjwEUhQ==";

        byte[] sessionKeyBy = Base64.decryptBASE64(sessionKey.getBytes());
        byte[] encryptedDataBy = Base64.decryptBASE64(encryptedData.getBytes());
        byte[] ivBy = Base64.decryptBASE64(iv.getBytes());
        byte[] dec = Pkcs7Encoder.decryptOfDiyIV(encryptedDataBy, sessionKeyBy,ivBy);
        String decSS = new String(dec);
        System.out.println(new String(dec));

        byte[] en = Pkcs7Encoder.encryptOfDiyIV(dec, sessionKeyBy, ivBy);
        String ss = new String(Base64.encryptBASE64(en));
        System.out.print(ss);;
    }
}
