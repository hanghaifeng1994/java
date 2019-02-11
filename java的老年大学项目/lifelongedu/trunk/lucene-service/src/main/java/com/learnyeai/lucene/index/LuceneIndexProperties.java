package com.learnyeai.lucene.index;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zpz on 2018/9/10.
 */
@ConfigurationProperties("lucene.index")
public class LuceneIndexProperties {
    private final Map<String, String> prop = new HashMap();
    private String configs;

    public static LuceneIndexProperties instance;

    public LuceneIndexProperties() {
        instance = this;
    }

    public Map<String, String> getProp() {
        return prop;
    }

    public String getConfigs() {
        return configs;
    }

    public void setConfigs(String configs) {
        this.configs = configs;
    }
}
