package com.learnyeai.lucene.build;

import com.learnyeai.lucene.conf.IndexColumn;
import com.learnyeai.lucene.document.DocumentCreator;
import com.learnyeai.lucene.document.impl.CommonDocumentCreator;
import com.learnyeai.lucene.utils.JavaTypeResolverUtil;
import com.learnyeai.tools.common.StringUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * sql创建索引
 *      数据库链接信息
 *      sql语句
 *      创建doc
 *
 * Created by zhangpz on 20180906
 */
public class IndexBuilder {
    private String indexName; // 索引名称
    private String indexDirUrl;
    private String sql;
    private DBUtil dbUtil;
    private IndexWriterConfig.OpenMode openMode = IndexWriterConfig.OpenMode.CREATE_OR_APPEND;

    private Analyzer analyzer=new IKAnalyzer();
    private DocumentCreator documentCreator; // 创建索引

    private static Logger logger = LoggerFactory.getLogger(IndexBuilder.class);

    public void setAnalyzer(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    public void setDbUtil(DBUtil dbUtil) {
        this.dbUtil = dbUtil;
    }

    public void setOpenMode(String openMode) {
        if("1".equals(openMode)){
            this.openMode = IndexWriterConfig.OpenMode.CREATE;
        }
    }

    public void setDocumentCreator(DocumentCreator documentCreator) {
        this.documentCreator = documentCreator;
    }

    public void setIndexDirUrl(String indexDirUrl) {
        this.indexDirUrl = indexDirUrl;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public IndexBuilder(String indexName){
        this.indexName = indexName;
    }
    public IndexBuilder(String indexName, Analyzer analyzer){
        this.indexName = indexName;
        if(null != analyzer)
            this.analyzer = analyzer;
    }

    /**
     * 从数据库查询获取结果集
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    protected ResultSet getResultSet() throws ClassNotFoundException, SQLException {

        Connection conn=dbUtil.getConnection();
        Statement statement=conn.createStatement();
        return statement.executeQuery(sql);
    }

    /**
     * 结束工作
     */
    protected void complete(){
        if(dbUtil!=null)
            dbUtil.closeConnection();
        dbUtil=null;
    }

    /**
     * 启动建立索引
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    public boolean start(){
        return start(null);
    }
    public boolean start(IndexWriterConfig.OpenMode openMode){
        long startTime=System.currentTimeMillis();
        if(null == openMode)
            openMode = this.openMode;
        String msg = openMode == null || IndexWriterConfig.OpenMode.CREATE == openMode? "重建索引" : "追加索引";
        logger.info("{} {} IndexBuilder start! {}", indexName, msg, startTime);
        logger.info("sql : {}", sql);
        IndexWriter indexWriter = null;
        ResultSet rs = null;
        Directory directory = null;
        try{
            rs = getResultSet();

            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
            indexWriterConfig.setOpenMode(openMode == null ? IndexWriterConfig.OpenMode.CREATE : openMode);
            directory= FSDirectory.open(Paths.get(indexDirUrl));

            indexWriter=new IndexWriter(directory,indexWriterConfig);
            /*if(IndexWriterConfig.OpenMode.CREATE == openMode) {
                indexWriter.deleteAll();
            }*/
            Document doc=null;
            long count = 0;
            while(rs.next()){
                Map<String, Object> data = resultSet2Map(rs);
                doc=documentCreator.createDocument(data);
                indexWriter.addDocument(doc);
                count++;
            }

            long endTime=System.currentTimeMillis();
            logger.info("{} {}成功 完成{}条 花费时间{}s", indexName, msg, count, (endTime-startTime)/1000);

            return true;
        }catch (Exception e){
            logger.error(indexName + msg + "失败{}", e);
            return false;
        }finally {
            if(null != indexWriter) {
                try {
                    indexWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != rs){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null != directory){
                try {
                    directory.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            complete();
        }
    }

    private Map<String ,Object> resultSet2Map(ResultSet rs){
        try{
            ResultSetMetaData md = rs.getMetaData();
            Map<String, Object> dataMap = new HashedMap();
            int colCount = md.getColumnCount();
            for(int i=1; i<=colCount; i++){
//            String colName = md.getColumnName(i);
                String colName = md.getColumnLabel(i);
                colName = StringUtils.toCamelCase(colName);
                Object val = rs.getObject(i);

                int scale = md.getScale(i);
                int type = md.getColumnType(i);
                int length = md.getColumnDisplaySize(i);

                Class javaType = JavaTypeResolverUtil.calculateJavaType(type, scale, length);
                // 转换类型long double 其它
                if (javaType == Integer.class || javaType == Long.class || javaType == Short.class) {
                    if(val instanceof BigDecimal){
                        val = ((BigDecimal)val).longValue();
                    }else if(val instanceof Integer){
                        val = ((Integer)val).longValue();
                    }else if(val instanceof Short){
                        val = ((Short)val).longValue();
                    }
                } else if (javaType == BigDecimal.class) {
                    val = ((BigDecimal)val).doubleValue();
                }

                if(null == val) // 没有值不要继续
                    continue;

                dataMap.put(colName, val);
            }
            return dataMap;
        }catch (Exception e){
            logger.error("读取数据异常", e);
        }
        return null;
    }

}