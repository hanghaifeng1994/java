package com.learnyeai.tools.observe.suport;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 默认的 被观察者 标识 解析器
 * @author lc3@yitong.com.cn
 */
public class ObservableKeysResolver<K> {

    /**
     * 通过源标识解析为最终标识列表，默认只返回本身
     * @param sourceKeys 原始标识列表
     * @return
     */
    @SuppressWarnings("unchecked")
    public <E> List<K> getKeys(E sourceKeys) {
        if(sourceKeys instanceof List) {
            return (List<K>) sourceKeys;
        } else if(null != sourceKeys) {
            return Arrays.asList((K)sourceKeys);
        } else {
            return Collections.emptyList();
        }
    }
}
