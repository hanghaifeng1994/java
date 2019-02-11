package com.thinkgem.jeesite.common.security.crypto;

import com.thinkgem.jeesite.common.security.crypto.codec.DesedeCodec;

/**
 * 3Des 加密解密工具类.
 * Created by lc3 on 2014/4/18.
 */
public class DesedeFactory extends AbstractCodecFactory {

    private static final DesedeFactory ins = new DesedeFactory();

    private DesedeFactory(){}

    @Override
    protected ICodec genCodec(String key) throws Exception {
        return new DesedeCodec(key);
    }

    public static DesedeFactory getInstance() {
        return ins;
    }

    public static void main(String[] args) {
        String key = "6B93CA2C6F2F41AAE1D6BBF84AB36342";
        String txt = "06114206efffffee";
        String data = "159DFB03941DB4A2";

        System.out.println("=============== 3DES 加密 ===============");

        System.out.println("明文：" + txt);
        try {
            System.out.println("加密后：" + getInstance().encrypt(txt, key));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("=============== 3DES 解密 ===============");
        // 密文：159DFB03941DB4A2 明文：111111 key:6B93CA2C6F2F41AAE1D6BBF84AB36342 账号：6223795317100000115
        System.out.println("密文：" + data);
        try {
            System.out.println("解密后：" + getInstance().decrypt(data, key));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
