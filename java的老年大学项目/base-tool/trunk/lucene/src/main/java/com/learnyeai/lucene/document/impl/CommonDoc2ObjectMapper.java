package com.learnyeai.lucene.document.impl;

import com.learnyeai.lucene.document.Doc2ObjectMapper;
import com.learnyeai.lucene.utils.LuceneUtils;
import org.apache.lucene.document.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zpz on 2018/9/10.
 */
public class CommonDoc2ObjectMapper implements Doc2ObjectMapper {
    @Override
    public List mapDocumentsToObject(List<Document> documents) {
        return LuceneUtils.docs2MapList(documents);
    }

    @Override
    public Object mapDocumentToObject(Document document) {
        List<Document> list = new ArrayList<>();
        list.add(document);

        return LuceneUtils.docs2MapList(list).get(0);
    }
}
