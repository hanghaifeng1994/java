package com.learnyeai.tools.observe.suport;


import com.learnyeai.tools.common.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * String类型Key解析器，通过分号、逗号、冒号和换行、制表符拆分
 * @author lc3@yitong.com.cn
 */
public class StringObservableKeysResolver extends ObservableKeysResolver<String> {

    @Override
    public List<String> getKeys(Object sourceKeys) {
        if(null == sourceKeys) {
            return Collections.emptyList();
        }
        String keys = sourceKeys.toString().trim();
        String[] keyArr = keys.split("[;:,\n\r\t]");
        List<String> keyList = new ArrayList<String>(keyArr.length);
        for (String key : keyArr) {
            key = key.trim();
            if(StringUtils.isNotEmpty(key) && !keyList.contains(key)) {
                keyList.add(key);
            }
        }
        return keyList;
    }
}
