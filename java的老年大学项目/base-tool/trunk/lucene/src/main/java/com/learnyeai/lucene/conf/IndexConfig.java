package com.learnyeai.lucene.conf;

import com.learnyeai.lucene.build.IndexBuilder;
import com.learnyeai.lucene.document.BuildQuery;
import com.learnyeai.lucene.document.Doc2ObjectMapper;
import com.learnyeai.lucene.document.DocumentCreator;
import org.apache.lucene.analysis.Analyzer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zpz on 2018/9/14.
 */
public class IndexConfig {
    private String configName;
    private IndexConfigBean configBean;
    private IndexBuilder indexBuilder;
    private Analyzer analyzer;
    private DocumentCreator documentCreator;
    private Doc2ObjectMapper doc2ObjectMapper;
    private BuildQuery buildQuery;
    private List<IndexColumn> colList = new ArrayList<>();

    public IndexConfig(IndexConfigBean configBean) {
        this.configBean = configBean;
    }

    public IndexConfigBean getConfigBean() {
        return configBean;
    }

    public void setConfigBean(IndexConfigBean configBean) {
        this.configBean = configBean;
    }

    public IndexBuilder getIndexBuilder() {
        return indexBuilder;
    }

    public void setIndexBuilder(IndexBuilder indexBuilder) {
        this.indexBuilder = indexBuilder;
    }

    public Analyzer getAnalyzer() {
        return analyzer;
    }

    public void setAnalyzer(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    public DocumentCreator getDocumentCreator() {
        return documentCreator;
    }

    public void setDocumentCreator(DocumentCreator documentCreator) {
        this.documentCreator = documentCreator;
    }

    public List<IndexColumn> getColList() {
        return colList;
    }

    public void setColList(List<IndexColumn> colList) {
        this.colList = colList;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public Doc2ObjectMapper getDoc2ObjectMapper() {
        return doc2ObjectMapper;
    }

    public void setDoc2ObjectMapper(Doc2ObjectMapper doc2ObjectMapper) {
        this.doc2ObjectMapper = doc2ObjectMapper;
    }

    public BuildQuery getBuildQuery() {
        return buildQuery;
    }

    public void setBuildQuery(BuildQuery buildQuery) {
        this.buildQuery = buildQuery;
    }
}
