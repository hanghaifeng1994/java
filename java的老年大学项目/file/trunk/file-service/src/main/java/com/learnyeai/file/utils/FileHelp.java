package com.learnyeai.file.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by zpz on 2018/8/30.
 */
public class FileHelp {
    private static Logger logger = LoggerFactory.getLogger(FileHelp.class);
    private static Properties props = genConfigProperties();
    private static Properties genConfigProperties() {
        try {
            Properties sysProps = new Properties(System.getProperties());
            PropertiesLoaderUtils.fillProperties(sysProps,
                    new EncodedResource(new ClassPathResource(
                            "fileType.properties"), "UTF-8"));
            return sysProps;
        } catch (IOException e) {
            logger.error("加载数据库配置文件失败失败", e);
            throw new RuntimeException(e);
        }
    }

    public static String getFileType(String suffix){
        if(!StringUtils.isEmpty(suffix)){
            Object contentType = props.get(suffix);
            if(contentType != null)
                return contentType.toString();
        }
        return "";
    }
    public static String[] getFileSuffixByType(String fileType){
        List<String> list = new ArrayList<>();
        props.forEach((k,v) -> {
            if(fileType.equals(v)){
                list.add(k.toString());
            }
        });
        return list.toArray(new String[list.size()]);
    }

    public static String calculateFileSize(long size){
        //字节数少于1024，直接以B为单位
        if (size < 1024) {
            return String.valueOf(size) + "B";
        } else {
            size = size / 1024;
        }
        //字节数除于1024之后，少于1024，则可直接以KB作为单位
        if (size < 1024) {
            return String.valueOf(size) + "KB";
        } else {
            size = size / 1024;
        }
        if (size < 1024) {
            //以MB为单位的话，保留最后1位小数
            size = size * 100;
            return String.valueOf((size / 100)) + "."
                    + String.valueOf((size % 100)) + "MB";
        } else {
            //以GB为单位
            size = size * 100 / 1024;
            return String.valueOf((size / 100)) + "."
                    + String.valueOf((size % 100)) + "GB";
        }

    }

}
