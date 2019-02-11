package com.learnyeai.lucene.document;

import org.apache.lucene.document.Document;

import java.util.List;

/**
 * doc转成对象
 * Created by zpz on 2018/9/6.
 */
public interface Doc2ObjectMapper {
    /**
     * 多个Document
     * @param documents
     * @return
     */
    List mapDocumentsToObject(List<Document> documents);

    /**
     * 将单个Document映射成一个对象
     * @param document
     * @return
     */
    Object mapDocumentToObject(Document document);
}
