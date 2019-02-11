package com.learnyeai.lucene.conf;

/**
 * Created by zpz on 2018/9/10.
 */
public class IndexConfigBean {
    private String indexName;
    private String indexDir;
    private String columns; // 字段 // 定义:字段名&字段类型_排序_分词
    private String analyzerType; // 分词类型，1_xxx split拆分、2_xx正则分词,其它默认

    private String url;
    private String user;
    private String password;
    private String sql;
    private String createIndexMode;
    private String documentCreatorClassName;

    private String doc2ObjectClassName;
    private String buildQueryClassName;

    private String imgColNames; // 指定图片字段名称，用来把图片服务器的地址拼上


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getIndexDir() {
        return indexDir;
    }

    public void setIndexDir(String indexDir) {
        this.indexDir = indexDir;
    }

    public String getCreateIndexMode() {
        return createIndexMode;
    }

    public void setCreateIndexMode(String createIndexMode) {
        this.createIndexMode = createIndexMode;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getDocumentCreatorClassName() {
        return documentCreatorClassName;
    }

    public void setDocumentCreatorClassName(String documentCreatorClassName) {
        this.documentCreatorClassName = documentCreatorClassName;
    }

    public String getColumns() {
        return columns;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }

    public String getAnalyzerType() {
        return analyzerType;
    }

    public void setAnalyzerType(String analyzerType) {
        this.analyzerType = analyzerType;
    }

    public String getDoc2ObjectClassName() {
        return doc2ObjectClassName;
    }

    public void setDoc2ObjectClassName(String doc2ObjectClassName) {
        this.doc2ObjectClassName = doc2ObjectClassName;
    }

    public String getBuildQueryClassName() {
        return buildQueryClassName;
    }

    public void setBuildQueryClassName(String buildQueryClassName) {
        this.buildQueryClassName = buildQueryClassName;
    }

    public String getImgColNames() {
        return imgColNames;
    }

    public void setImgColNames(String imgColNames) {
        this.imgColNames = imgColNames;
    }
}
