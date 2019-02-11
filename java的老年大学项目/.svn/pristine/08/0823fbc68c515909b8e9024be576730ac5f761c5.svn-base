package com.learnyeai.lifelongedu.gateway.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * token时长要小于过期时间
 * Created by zpz on 2018/8/14.
 */
@ConfigurationProperties(prefix = "learnai.gateway")
public class LearnAiGateWayProperties {

    private long period = 60000; // token时长，
    private long timeOut = 1800000; // 过期时间默认30分钟
    private List<String> loginurls;
    private String jwtSecretKey = "ofaffadfev1234567--090swctewst";
    private boolean debugAbled=false;

    public LearnAiGateWayProperties(){
    }


    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    public List<String> getLoginurls() {
        return loginurls;
    }

    public void setLoginurls(List<String> loginurls) {
        this.loginurls = loginurls;
    }

    public String getJwtSecretKey() {
        return jwtSecretKey;
    }

    public void setJwtSecretKey(String jwtSecretKey) {
        this.jwtSecretKey = jwtSecretKey;
    }

    public boolean isDebugAbled() {
        return debugAbled;
    }

    public void setDebugAbled(boolean debugAbled) {
        this.debugAbled = debugAbled;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }
}
