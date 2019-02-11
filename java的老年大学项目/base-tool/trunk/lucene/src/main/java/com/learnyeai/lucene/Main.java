package com.learnyeai.lucene;

import com.learnyeai.lucene.conf.IndexConfParse;
import com.learnyeai.lucene.build.IndexBuilder;
import com.learnyeai.lucene.conf.IndexConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.*;

/**
 * 重建索引
 * Created by zpz on 2018/9/10.
 */
public class Main {
    private static Properties prop;
    private static Map<String, String> propMap = new HashMap();
    private static Logger logger = LoggerFactory.getLogger(Math.class);
    /**
     * 第一个参数为配置文件路径
     * @param args
     */
    public static void main(String args[]){
        Assert.isTrue(args.length > 0, "第一个参数为配置文件路径，请检查参数");
        try {
            iniProp(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // 读取配置文件
        String driverClassName = prop.getProperty("driverClassName");
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        List<IndexConfig> confList = IndexConfParse.parse(propMap);
        for (IndexConfig it : confList){
            IndexBuilder indexBuilder = it.getIndexBuilder();
            try {
                if(null != indexBuilder) {
                    indexBuilder.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void iniProp(String propFilePath) throws IOException {
        FileSystemResource resource = new FileSystemResource(propFilePath);
        prop = PropertiesLoaderUtils.loadProperties(resource);
        prop.forEach((k, v)->{
            if(null == v)
                return;
            propMap.put(k.toString(),v.toString());
        });
    }
}
