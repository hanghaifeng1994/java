package com.thinkgem.jeesite.common.security.crypto.codec;

import com.thinkgem.jeesite.common.security.codec.Base64;
import com.thinkgem.jeesite.common.security.codec.CodecException;
import com.thinkgem.jeesite.common.security.codec.CodecSupport;
import com.thinkgem.jeesite.common.security.crypto.ICodec;

import javax.crypto.Cipher;

/**
 * 加密解密抽象实现
 * @author lc3
 */
public abstract class AbstractCodec implements ICodec {

    /**
     * 得到加密Cipher
     * @return 加密Cipher
     */
    protected abstract Cipher getEncryptCipher() throws Exception;
    /**
     * 得到解密Cipher
     * @return 解密Cipher
     */
    protected abstract Cipher getDecryptCipher() throws Exception;

    @Override
    public byte[] encrypt(byte[] data) {
        try {
            return getEncryptCipher().doFinal(data);
        } catch (Exception e) {
            throw new CodecException("加密数据异常", e);
        }
    }

    @Override
    public String encrypt(String data) {
        try {
            return Base64.encodeToString(encrypt(CodecSupport.toBytes(data)));
        } catch (Exception e) {
            throw new CodecException("加密数据异常", e);
        }
    }

    @Override
    public byte[] decrypt(byte[] data) {
        try {
            return getDecryptCipher().doFinal(data);
        } catch (Exception e) {
            throw new CodecException("解密数据异常", e);
        }
    }

    @Override
    public String decrypt(String data) {
        try {
            return CodecSupport.toString(decrypt(Base64.decode(data)));
        } catch (Exception e) {
            throw new CodecException("解密数据异常", e);
        }
    }
}
