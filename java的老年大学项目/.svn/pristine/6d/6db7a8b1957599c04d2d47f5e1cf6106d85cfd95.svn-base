package com.learnyeai.learnai.engine;

import java.util.Map;

/**
 * Created by zpz on 2016/4/19.
 */
public class ChannelEngineFactory {
    private String defaultEngine = "common";
    private Map<String, AbstractChannelEngine> engines;

    public ChannelEngineFactory(Map<String, AbstractChannelEngine> engines, String defaultEngine) {
        this.defaultEngine = defaultEngine;
        this.engines = engines;
    }

    public boolean isEngine(String channel){
        return engines.containsKey(channel);
    }
    public AbstractChannelEngine getChannelEngine(String channel){
        if(engines.containsKey(channel))
            return engines.get(channel);
        else
            return engines.get(defaultEngine);
    }

    public String getDefaultEngine() {
        return defaultEngine;
    }
}
