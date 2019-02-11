package com.learnyeai.lucene.document;

import com.learnyeai.lucene.conf.IndexColumn;
import org.apache.lucene.document.Document;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 * 创建doc 接口协议
 * Created by zpz on 2018/9/6.
 */
public interface DocumentCreator {
//    Document createDocument(ResultSet resultSet) throws Exception;
    Document createDocument(Map datMap) throws Exception;
    void setIndexColumn(List<IndexColumn> columnList);
}
