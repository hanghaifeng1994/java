package com.thinkgem.jeesite.common.security.crypto.codec;

import com.thinkgem.jeesite.common.security.codec.CodecSupport;
import com.thinkgem.jeesite.common.security.crypto.ICodec;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加密解密实现
 * @author lc3
 */
public class AESCodec extends AbstractCodec implements ICodec {

    /**
     * 密钥算法
     */
    private static final String KEY_ALGORITHM = "AES";
    private static final int ALGORITHM_SIZE = 256;
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    private Cipher ec;
    private Cipher dc;

    @Override
    protected Cipher getEncryptCipher() {
        return ec;
    }

    @Override
    protected Cipher getDecryptCipher() {
        return dc;
    }

    public AESCodec(String key) throws Exception {
        if(ALGORITHM_SIZE / 8 < key.length()) {
            key = key.substring(0, ALGORITHM_SIZE / 8);
        }
        final byte[] keyData = CodecSupport.toBytes(key);
        final SecretKeySpec secretKey = new SecretKeySpec(keyData, KEY_ALGORITHM);

        ec = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        ec.init(Cipher.ENCRYPT_MODE, secretKey);
        dc = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        dc.init(Cipher.DECRYPT_MODE, secretKey);
    }
}
