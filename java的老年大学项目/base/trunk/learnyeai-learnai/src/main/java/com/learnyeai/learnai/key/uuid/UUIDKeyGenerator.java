package com.learnyeai.learnai.key.uuid;



import com.learnyeai.learnai.key.KeyGenerator;

import java.util.UUID;

/**
 * UUID型的主键生成策略
 * @author lc3@yitong.com.cn
 */
public class UUIDKeyGenerator implements KeyGenerator {
    @Override
    public String genNextKey() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
