package com.learnyeai.file.fastdfs;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zpz on 2018/9/3.
 */
@ConfigurationProperties("fastdfs")
public class FastDfsProperties {
    private final Map<String, String> properties = new HashMap<>();
    private String fileDownloadUrl; // 文件下载地址
    private String fileTemDir;  // 文件临时目录
    private String fileSeriveUrl; // 文件服务器地址
    private int mainServer = 0; // 0 不启用、1主服务、2从服务
    private long refreshSetting = 1*60*60*1000l; // 1小时刷新一次配置

    public String getFileDownloadUrl() {
        return fileDownloadUrl;
    }

    public void setFileDownloadUrl(String fileDownloadUrl) {
        this.fileDownloadUrl = fileDownloadUrl;
    }

    public String getFileTemDir() {
        return fileTemDir;
    }

    public void setFileTemDir(String fileTemDir) {
        this.fileTemDir = fileTemDir;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public String getFileSeriveUrl() {
        return fileSeriveUrl;
    }

    public void setFileSeriveUrl(String fileSeriveUrl) {
        this.fileSeriveUrl = fileSeriveUrl;
    }

    public int getMainServer() {
        return mainServer;
    }

    public void setMainServer(int mainServer) {
        this.mainServer = mainServer;
    }

    public long getRefreshSetting() {
        return refreshSetting;
    }

    public void setRefreshSetting(long refreshSetting) {
        this.refreshSetting = refreshSetting;
    }
}
