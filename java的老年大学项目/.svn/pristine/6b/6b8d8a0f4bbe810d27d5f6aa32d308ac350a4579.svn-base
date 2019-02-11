package com.learnyeai.lucene.conf;

import com.learnyeai.lucene.analyzer.PatternAnalyzer;
import com.learnyeai.lucene.analyzer.SplitAnalyzer;
import com.learnyeai.lucene.build.DBUtil;
import com.learnyeai.lucene.build.IndexBuilder;
import com.learnyeai.lucene.document.BuildQuery;
import com.learnyeai.lucene.document.Doc2ObjectMapper;
import com.learnyeai.lucene.document.DocumentCreator;
import com.learnyeai.lucene.document.impl.CommonBuildQuery;
import com.learnyeai.lucene.document.impl.CommonDoc2ObjectMapper;
import com.learnyeai.lucene.document.impl.CommonDocumentCreator;
import com.learnyeai.tools.common.BeanMapUtils;
import com.learnyeai.tools.common.MapUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zpz on 2018/9/14.
 */
public class IndexConfParse {
    private static Logger logger = LoggerFactory.getLogger(IndexConfParse.class);
    public static List<IndexConfig> parse(Map prop){
        List<IndexConfig> list = new ArrayList<>();
        String confArr[] = prop.get("configs").toString().split(",");
        for(String conf : confArr){
            if(StringUtils.isBlank(conf))
                continue;
            Map map = MapUtil.getMapWithkeyStart(prop,conf.toString());
            IndexConfigBean configBean = new IndexConfigBean();
            try {
                configBean = (IndexConfigBean) BeanMapUtils.convertMap(IndexConfigBean.class, map);
            } catch (Exception e) {
                logger.error("解析配置出错："+conf, e);
                e.printStackTrace();
                continue;
            }
            IndexConfig config = new IndexConfig(configBean);
            config.setConfigName(conf);
            buildConfig(config);
            list.add(config);
        }
        return list;
    }
    private static void buildConfig(IndexConfig config){
        IndexConfigBean it = config.getConfigBean();
        // 分词器
        Analyzer analyzer = IndexConfParse.getAnalyzer(it.getAnalyzerType());
        DBUtil dbUtil = null;
        if(it.getUrl() != null){
            dbUtil = new DBUtil(it.getUrl(), it.getUser(), it.getPassword());
        }
        // 解析字段
        List<IndexColumn> colList = new ArrayList<>();
        try{
            colList = IndexConfParse.parseColumn(it.getColumns());
        }catch (Exception e){
            logger.error("解析索引{}字段出错", it.getIndexName());
        }
        DocumentCreator documentCreator = new CommonDocumentCreator();
        try{
            if(it.getDocumentCreatorClassName() != null) {
                Class cs = Class.forName(it.getDocumentCreatorClassName());
                cs.getConstructor();
                Object o = cs.newInstance();
                if (o instanceof DocumentCreator) {
                    documentCreator = (DocumentCreator)o;
                }else {
                    logger.warn("documentCreatorClassName配置的{}, 不是DocumentCreator子类", it.getDocumentCreatorClassName());
                }
            }
        }catch (Exception e){
            logger.error("documentCreatorClassName 配置的类不存在{}", it.getDocumentCreatorClassName());
        }
        documentCreator.setIndexColumn(colList);

        IndexBuilder indexBuilder = null;
        if(dbUtil != null) {
            indexBuilder = new IndexBuilder(it.getIndexName(), analyzer);
            indexBuilder.setIndexDirUrl(it.getIndexDir());
            indexBuilder.setSql(it.getSql());
            indexBuilder.setDbUtil(dbUtil);
            indexBuilder.setOpenMode(it.getCreateIndexMode());
            indexBuilder.setDocumentCreator(documentCreator);
        }


        config.setAnalyzer(analyzer);
        config.setDocumentCreator(documentCreator);
        config.setIndexBuilder(indexBuilder);
        config.setColList(colList);

        BuildQuery buildQuery = new CommonBuildQuery();
        if(StringUtils.isNotBlank(it.getBuildQueryClassName())) {
            try {
                Class<?> cs = Class.forName(it.getBuildQueryClassName());
                Object o = cs.newInstance();
                if (o instanceof BuildQuery) {
                    buildQuery = (BuildQuery) o;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        buildQuery.setIndexColumn(colList, analyzer);
        config.setBuildQuery(buildQuery);

        Doc2ObjectMapper doc2ObjectMapper = new CommonDoc2ObjectMapper();
        if(StringUtils.isNotBlank(it.getDoc2ObjectClassName())) {
            try {
                Class<?> cs = Class.forName(it.getDoc2ObjectClassName());
                Object o = cs.newInstance();
                if (o instanceof CommonDoc2ObjectMapper) {
                    doc2ObjectMapper = (CommonDoc2ObjectMapper) o;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        config.setDoc2ObjectMapper(doc2ObjectMapper);
    }

    private static Analyzer getAnalyzer(String analyzerType){
        Analyzer analyzer = new SmartChineseAnalyzer(true);
        if(null == analyzerType){
            return analyzer;
        }
        String arr[] = analyzerType.split("_");
        String param = null;
        if(arr.length > 1){
            param = arr[1];
        }
        if("1".equals(arr[0])){ // split分词
            char c = StringUtils.isBlank(param)? ',' : param.charAt(0);
            analyzer = new SplitAnalyzer(c);
        }else if("2".equals(arr[0])){
            if(StringUtils.isBlank(param)){
                return null;
            }

            analyzer = new PatternAnalyzer(param);
        }
        return analyzer;
    }

    /**
     * 字段名&字段类型_排序
     * @param columns
     * @return
     */
    private static List<IndexColumn> parseColumn(String columns){
        List<IndexColumn> rstList = new ArrayList<>();
        if(StringUtils.isBlank(columns)){
            return rstList;
        }
        // cs_name&3_0_1,site_id&3_0_1,study_point&1_1,pub_date&3_1
        String[] columnArr = columns.split(",");
        for(String col : columnArr){
            if(StringUtils.isBlank(col)){
                continue;
            }
            String[] arr = col.split("&");
            if(arr.length <= 1 || StringUtils.isBlank(arr[0])){ // 只有字段名 // 没有字段名
                continue;
            }
            if(StringUtils.isBlank(arr[1])){ // 没有字段详细信息
                continue;
            }

            String fieldName = arr[0];
            // 字段类型_排序
            int fieldType = -1;
            boolean sort = false;
            boolean analy = false;
            arr = arr[1].split("_"); // 开始解析字段详细信息
            fieldType = Integer.parseInt(arr[0]);

            if (arr.length > 1) {
                sort = "1".equals(arr[1]);
            }
            if(arr.length > 2){
                analy = "1".equals(arr[2]);
            }

            fieldName = com.learnyeai.tools.common.StringUtils.toCamelCase(fieldName);
            IndexColumn indexColumn = new IndexColumn();
            indexColumn.setFieldName(fieldName);
            indexColumn.setFieldType(fieldType);
            indexColumn.setSort(sort);
            indexColumn.setAnaly(analy);
            rstList.add(indexColumn);
        }
        return rstList;
    }
}
