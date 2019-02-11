package com.learnyeai.lucene.document;

import com.learnyeai.lucene.conf.IndexColumn;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;

import java.util.List;
import java.util.Map;

/**
 * 创建查询query
 * Created by zpz on 2018/9/10.
 */
public interface BuildQuery {
    /**
     * 多条件查询时:为查询字段、查询参数的map，多字段查询固定为：{fields:'field1,field2...',param:'xx'}
     * @param queryType 1多条件查询、2多字段查询
     * @param params
     * @return
     * @throws ParseException
     */
    Query buildQuery(int queryType,String params) throws ParseException;
    void setIndexColumn(List<IndexColumn> columnList, Analyzer analyzer);
}
