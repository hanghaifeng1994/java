package com.learnyeai.core.message.impl.socket;


import com.learnyeai.core.config.ConfigUtils;

/**
 * 初始化socket
 * Created by zpz on 2017/11/6.
 */
public class SocketSetting {

    private String multiHost = ConfigUtils.getValue("topic.multi.host");
    private int multiPort = ConfigUtils.getValue("topic.multi.port", 0);
    private String multiQHost = ConfigUtils.getValue("queue.multi.host");
    private int multiQPort = ConfigUtils.getValue("queue.multi.port", 0);

    private static SocketSetting socketSetting;
    private static SocketSetting getIns(){
        if(null == socketSetting)
            socketSetting = new SocketSetting();
        return socketSetting;
    }

    public static String getMultiHost() {
        return getIns().multiHost;
    }

    public static int getMultiPort() {
        return getIns().multiPort;
    }

    public static String getMultiQHost() {
        return getIns().multiQHost;
    }

    public static int getMultiQPort() {
        return getIns().multiQPort;
    }

    /*public void setMultiHost(String multiHost) {
        this.multiHost = multiHost;
    }

    public void setMultiPort(int multiPort) {
        this.multiPort = multiPort;
    }

    public void setMultiQHost(String multiQHost) {
        this.multiQHost = multiQHost;
    }

    public void setMultiQPort(int multiQPort) {
        this.multiQPort = multiQPort;
    }*/
}
