package com.learnyeai.lucene.utils;

import org.apache.lucene.analysis.Analyzer;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户结束后，记得调用close
 * Created by zpz on 2018/9/9.
 */
public class LuceneManagerUtils {
    private static Map<String, LuceneManager> managerMap = new HashMap<>();
    public static LuceneManager getLuceneManager(String indexDir){
        return getLuceneManager(indexDir, null);
    }
    public static LuceneManager getLuceneManager(String indexDir, Analyzer analyzer){
        if(managerMap.containsKey(indexDir)){
            return managerMap.get(indexDir);
        }

        LuceneManager manager = new LuceneManager(indexDir, analyzer);
        managerMap.put(indexDir, manager);
        return manager;
    }

    public static void close(){
        managerMap.forEach((k,v)->{
            v.close();
        });
    }

    @Override
    protected void finalize() throws Throwable {
        close();
    }
}
