package com.thinkgem.jeesite.common.security.crypto;

import com.thinkgem.jeesite.common.security.crypto.codec.AESCodec;

/**
 * AES 加解密工具类.
 * @author lc3
 */
public class AESFactory extends AbstractCodecFactory {

    private static final AESFactory ins = new AESFactory();

    private AESFactory() {}

    public static AESFactory getInstance() {
        return ins;
    }

    @Override
    protected ICodec genCodec(String key) throws Exception {
        return new AESCodec(key);
    }

    public static void main(String[] args) {
        String key = "12345678901234567890123456789012";
        key = "20141212112740.27c521a72-0817-45";
        String txt = "12345678901234561234567890123456{\"m\":\"测试\",\"u\":\"username\",\"p\":\"password123456\"}";
        String data = "zyFIAqnq8fihaJFqgH9gVM8hSAKp6vH4oWiRaoB/YFR8mtg0yMYDa+ChcBFIhCi/56satn3ITCoG1gNSzxmmT8imJyy+Nr4miLt3mh2xRBWxDls2fevX+eXnin4JB7iJ";
        data = "o7hDt9eiLguX4lmnw3fU3inHb1/U3EBd4Y0YLLoOms+5o945eoecNQcUl0dbtTFZG3mcZirFFfiT/OHkShdu3iIl4sloqHM7TsIcUnTTkLGTZy/GkalmD8lq5DHO4gLagyR3Rdac96L8dmAnNwaPl4AXUROAPa3dZiwy2qjf876fgXvq9JWmlm/6ElZTuKSRtltX6V1N8cl2AIllOOgYi0hWmmlx5JjrXpbEK/n8nZHUbIwSLsHMyzwD5oLWGnKl4NCoR5kRRQtCUk+YenAGqdBlKLUOxNoC5C0n+Yvds9oaX86upkxR2O3IHAbXFzGnnP8QRJc9DieDbh+5DjBgPvdhQvPy5wSEjNReOwR721xiuLUj7NPFQ34Uv37LMS2UxdI4flmyU48cWtrgAR/hy5tK4wrG/UXj4n1IeOG5WY7SoDXp+EsNsBsdx93sIVWIasgNdTESdIuoQpG9e2nMxw==";

        System.out.println("=============== AES 加密 ===============");

        System.out.println("明文：" + txt + "(" + txt.length() + ")");
        try {
            final String encrypt = getInstance().encrypt(txt, key);
            System.out.println("加密后：" + encrypt + "(" + encrypt.length() + ")");
//            data = encrypt;
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("=============== AES 解密 ===============");
        System.out.println("密文：" + data + "(" + data.length() + ")");
        try {
            final String decrypt = getInstance().decrypt(data, key);
            System.out.println("解密后：" + decrypt + "(" + decrypt.length() + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
