package com.learnyeai.lucene.index;

import com.learnyeai.lucene.conf.IndexConfParse;
import com.learnyeai.lucene.conf.IndexConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zpz on 2018/9/10.
 */
public class LuceneIndexPropUtils {
    private static Map<String, IndexConfig> confMap = null;

    public static IndexConfig getConf(String asName){
        return get(asName);
    }
    private static IndexConfig get(String asName){
        if(getConfMap().containsKey(asName)){
            return getConfMap().get(asName);
        }

        return null;
    }

    private static Map<String, IndexConfig> getConfMap(){
        if(confMap != null)
            return confMap;

        // 解析conf
        confMap = new HashMap<>();

        String confs = LuceneIndexProperties.instance.getConfigs();
        Map<String,String> propMap =new HashMap<>();
        propMap.putAll(LuceneIndexProperties.instance.getProp());
        propMap.put("configs", confs);

        List<IndexConfig> list = IndexConfParse.parse(propMap);
        for(IndexConfig cfg : list){
            confMap.put(cfg.getConfigName(), cfg);
        }
        return confMap;
    }

}
