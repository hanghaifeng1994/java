package cn.com.weye.utils.key.uuid;

import cn.com.weye.utils.key.KeyGenerator;

import java.util.UUID;

/**
 * UUID型的主键生成策略
 * @author lc3
 */
public class UUIDKeyGenerator implements KeyGenerator {
    @Override
    public String genNextKey() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
