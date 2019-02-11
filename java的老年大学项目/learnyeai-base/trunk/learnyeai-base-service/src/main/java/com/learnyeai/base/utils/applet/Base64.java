package com.learnyeai.base.utils.applet;


/**
 * Created by zpz on 2017/12/11.
 */
public class Base64 {
    /** * BASE64解密 * @param key * @return * @throws Exception */
    public static byte[] decryptBASE64(byte[] key) throws Exception {
        return (new org.apache.commons.codec.binary.Base64()).decode(key);
    }

    /** * BASE64加密 * @param key * @return * @throws Exception */
    public static byte[] encryptBASE64(byte[] key) throws Exception {
        return (new org.apache.commons.codec.binary.Base64()).encode(key);
    }

    public static void main(String[] args) throws Exception {
        byte[] data = Base64.encryptBASE64("http://aub.iteye.com/".getBytes());
        System.out.println("加密前：" + new String(data));
        byte[] byteArray = Base64.decryptBASE64(data);
        System.out.println("解密后：" + new String(byteArray));
    }
}
