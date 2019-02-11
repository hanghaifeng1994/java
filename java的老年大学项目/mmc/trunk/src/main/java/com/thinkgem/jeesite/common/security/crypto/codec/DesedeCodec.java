package com.thinkgem.jeesite.common.security.crypto.codec;

import com.thinkgem.jeesite.common.security.codec.Hex;
import com.thinkgem.jeesite.common.security.crypto.ICodec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/**
 * 3Des加密解密实现
 * @author lc3
 */
public class DesedeCodec extends AbstractCodec implements ICodec {
    /**
     * 密钥算法
     */
    private static final String KEY_ALGORITHM = "DESede";
    private static final String DEFAULT_CIPHER_ALGORITHM = "DESede/ECB/NoPadding";

    private Cipher ec;
    private Cipher dc;

    public DesedeCodec(String key) throws Exception {
        byte[] keyData = Hex.decode(key);
        byte[] keyByte = keyData;
        if(keyData.length == 16) {
            keyByte = new byte[24];
            System.arraycopy(keyData, 0, keyByte, 0, 16);
            System.arraycopy(keyData, 0, keyByte, 16, 8);
        }
        DESedeKeySpec keySpec = new DESedeKeySpec(keyByte);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        SecretKey secretKey = keyFactory.generateSecret(keySpec);
        ec = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        ec.init(Cipher.ENCRYPT_MODE, secretKey);
        dc = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        dc.init(Cipher.DECRYPT_MODE, secretKey);
    }

    @Override
    protected Cipher getEncryptCipher() {
        return ec;
    }

    @Override
    protected Cipher getDecryptCipher() {
        return dc;
    }

    @Override
    public String encrypt(String data) {
        try {
            return Hex.encodeToString(getEncryptCipher().doFinal(Hex.decode(data)));
        } catch (Exception e) {
            throw new IllegalArgumentException("加密数据异常", e);
        }
    }

    @Override
    public String decrypt(String data) {
        try {
            return Hex.encodeToString(getDecryptCipher().doFinal(Hex.decode(data)));
        } catch (Exception e) {
            throw new IllegalArgumentException("解密数据异常", e);
        }
    }
}
