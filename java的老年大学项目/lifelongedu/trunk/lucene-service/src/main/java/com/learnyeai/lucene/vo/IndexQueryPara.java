package com.learnyeai.lucene.vo;

/**
 * Created by zpz on 2018/9/11.
 */
public class IndexQueryPara {
    /**当前第几页(从1开始计算)*/
    private int pageNo;
    /**每页显示几条*/
    private int pageSize;
    /**总记录数*/
    private int total;
    /**上一页最后一个ScoreDoc对象的Document对象ID*/
    private int afterDocId = -1; // 默认值-1，没有



    private String indexName;   // 索引名称
    private int queryType; // 1多条件查询、2多字段查询
    private String queryParams; // 索引参数
    private String sorts; // 排序，多个字段排序用逗号分割 a=1&b=0,说明1：升序、0倒序
    private String sortTypes; // 排序类型，与sorts一一对应(SortField.Type)

    private int hightLighter; // 高这显示 1 高亮、0不高亮
    private String hlPrefix;
    private String hlSuffix;
    private String hlFiledId;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAfterDocId() {
        return afterDocId;
    }

    public void setAfterDocId(int afterDocId) {
        this.afterDocId = afterDocId;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(String queryParams) {
        this.queryParams = queryParams;
    }

    public String getSorts() {
        return sorts;
    }

    public void setSorts(String sorts) {
        this.sorts = sorts;
    }

    public String getSortTypes() {
        return sortTypes;
    }

    public void setSortTypes(String sortTypes) {
        this.sortTypes = sortTypes;
    }

    public int getQueryType() {
        return queryType;
    }

    public void setQueryType(int queryType) {
        this.queryType = queryType;
    }

    public int getHightLighter() {
        return hightLighter;
    }

    public void setHightLighter(int hightLighter) {
        this.hightLighter = hightLighter;
    }

    public String getHlPrefix() {
        return hlPrefix;
    }

    public void setHlPrefix(String hlPrefix) {
        this.hlPrefix = hlPrefix;
    }

    public String getHlSuffix() {
        return hlSuffix;
    }

    public void setHlSuffix(String hlSuffix) {
        this.hlSuffix = hlSuffix;
    }

    public String getHlFiledId() {
        return hlFiledId;
    }

    public void setHlFiledId(String hlFiledId) {
        this.hlFiledId = hlFiledId;
    }
}
