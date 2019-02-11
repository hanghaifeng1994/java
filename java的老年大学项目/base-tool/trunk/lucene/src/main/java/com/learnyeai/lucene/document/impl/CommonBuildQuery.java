package com.learnyeai.lucene.document.impl;

import com.learnyeai.lucene.conf.IndexColumn;
import com.learnyeai.lucene.document.BuildQuery;
import com.learnyeai.lucene.utils.LuceneUtils;
import com.learnyeai.tools.common.JsonMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zpz on 2018/9/10.
 */
public class CommonBuildQuery implements BuildQuery {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private Map<String, IndexColumn> columnMap = new HashMap<>();
    private Analyzer analyzer;

    @Override
    public void setIndexColumn(List<IndexColumn> columnList, Analyzer analyzer) {
        columnMap.clear();
        if(null != columnList){
            for(IndexColumn o : columnList){
                columnMap.put(o.getFieldName(),o);
            }
        }
        this.analyzer = analyzer;
    }

    @Override
    public Query buildQuery(int queryType,String prop) throws ParseException {
        Query query = new MatchAllDocsQuery();

        Map pp = JsonMapper.jsonToMap(prop);
        // 1多条件查询、2多字段查询
        if(queryType == 1){
            query = LuceneUtils.getMulitConditionQuery(pp, columnMap, analyzer);
        }else {
            Object oFields = pp.get("fields");
            Object param = pp.get("param");
            if(oFields == null || param == null){
                logger.warn("多字段查询，参数为空");
                return query;
            }
            String ssfileds = oFields.toString();
            String ssParam = param.toString();
            List<String> fieldList = new ArrayList<>();
            for (String field : ssfileds.split(",")){
                if(StringUtils.isBlank(field))
                    continue;
                fieldList.add(field);
            }
            if(fieldList.size() == 0 || StringUtils.isEmpty(ssParam)){
                logger.warn("多字段查询，参数为空");
                return query;
            }

            //用户输入内容
            query = LuceneUtils.createMultiFieldQuery(fieldList.toArray(new String[fieldList.size()]), ssParam,analyzer);
        }
        return query;
    }
}
