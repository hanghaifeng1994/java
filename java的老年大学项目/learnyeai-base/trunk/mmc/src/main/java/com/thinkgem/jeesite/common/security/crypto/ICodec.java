package com.thinkgem.jeesite.common.security.crypto;

/**
 * 通用加密解密接口
 * @author lc3
 */
public interface ICodec {

    /**
     * 加密
     * @param data 待加密的字节数据
     * @return 加密后的字节数据
     */
    public byte[] encrypt(byte[] data);

    /**
     * 加密
     * @param data 待加密的字符串
     * @return 加密后的字节数据
     */
    public String encrypt(String data);

    /**
     * 解密
     * @param data 待解密的字节数据
     * @return 解密后的字节数据
     */
    public byte[] decrypt(byte[] data);

    /**
     * 解决
     * @param data 待解密的字符串
     * @return 解密后的字符串
     */
    public String decrypt(String data);
}
