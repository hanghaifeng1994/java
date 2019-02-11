package cn.com.weye.utils.key;

/**
 * 主键生成
 * @author lc3
 */
public interface KeyGenerator {

    /**
     * 生成下一个主键
     * @return
     */
    String genNextKey();

}
