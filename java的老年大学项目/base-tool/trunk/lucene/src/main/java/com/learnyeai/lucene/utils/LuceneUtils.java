package com.learnyeai.lucene.utils;

import com.google.common.collect.Maps;
import com.learnyeai.lucene.conf.IndexColumn;
import com.learnyeai.tools.common.TypeHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Scorer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.util.*;

/**
 * Created by zpz on 2018/9/9.
 */
public class LuceneUtils {
    private static Analyzer defAnalyzer = new SmartChineseAnalyzer(true);
    private static Logger logger = LoggerFactory.getLogger(LuceneUtils.class);

    /**
     * 创建QueryParser对象
     * @param field
     * @return
     */
    public static QueryParser createQueryParser(String field) {
        return createQueryParser(field, null);
    }
    public static QueryParser createQueryParser(String field, Analyzer analyzer) {
        return new QueryParser(field, analyzer == null?defAnalyzer:analyzer);
    }

    public static Query createMultiFieldQuery(String fieldNames[], String param) throws ParseException {
        return createMultiFieldQuery(fieldNames, param, null);
    }
    public static Query createMultiFieldQuery(String fieldNames[], String param, Analyzer analyzer) throws ParseException {
        //指定搜索字段和分析器
        QueryParser queryParser = new MultiFieldQueryParser(fieldNames, analyzer == null?defAnalyzer: analyzer);

        //用户输入内容
        Query query = queryParser.parse(param);
        return query;
    }

    /**
     * 删除索引[注意：请自己关闭IndexWriter对象]
     * @param writer
     * @param field
     * @param value
     */
    public static void deleteIndex(IndexWriter writer, String field, String value) {
        try {
            writer.deleteDocuments(new Term[] {new Term(field,value)});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除索引[注意：请自己关闭IndexWriter对象]
     * @param writer
     * @param query
     */
    public static void deleteIndex(IndexWriter writer, Query query) throws IOException {
        writer.deleteDocuments(query);
    }

    /**
     * 批量删除索引[注意：请自己关闭IndexWriter对象]
     * @param writer
     * @param terms
     */
    public static void deleteIndexs(IndexWriter writer,Term[] terms) throws IOException {
        writer.deleteDocuments(terms);
    }

    /**
     * 批量删除索引[注意：请自己关闭IndexWriter对象]
     * @param writer
     * @param querys
     */
    public static void deleteIndexs(IndexWriter writer,Query[] querys) throws IOException {
        writer.deleteDocuments(querys);
    }

    /**
     * 删除所有索引文档
     * @param writer
     */
    public static void deleteAllIndex(IndexWriter writer) throws IOException {
        writer.deleteAll();
    }

    /**
     * 更新索引文档
     * @param writer
     * @param term
     * @param document
     */
    public static void updateIndex(IndexWriter writer,Term term,Document document) throws IOException {
        writer.updateDocument(term, document);
    }

    /**
     * 更新索引文档
     * @param writer
     * @param field
     * @param value
     * @param document
     */
    public static void updateIndex(IndexWriter writer,String field,String value,Document document) throws IOException {
        updateIndex(writer, new Term(field, value), document);
    }

    /**
     * 添加索引文档
     * @param writer
     * @param document
     */
    public static void addIndex(IndexWriter writer, Document document) throws IOException {
        updateIndex(writer, null, document);
    }

    /**
     * 索引文档查询
     * @param searcher
     * @param query
     * @return
     */
    public static List<Document> query(IndexSearcher searcher, Query query) throws IOException {
        TopDocs topDocs = null;
        topDocs = searcher.search(query, Integer.MAX_VALUE);
        ScoreDoc[] scores = topDocs.scoreDocs;
        int length = scores.length;
        if (length <= 0) {
            return Collections.emptyList();
        }
        List<Document> docList = new ArrayList<Document>();
        try {
            for (int i = 0; i < length; i++) {
                Document doc = searcher.doc(scores[i].doc);
                docList.add(doc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return docList;
    }

    /**
     * 返回索引文档的总数[注意：请自己手动关闭IndexReader]
     * @param reader
     * @return
     */
    public static int getIndexTotalCount(IndexReader reader) {
        return reader.numDocs();
    }

    /**
     * 返回索引文档中最大文档ID[注意：请自己手动关闭IndexReader]
     * @param reader
     * @return
     */
    public static int getMaxDocId(IndexReader reader) {
        return reader.maxDoc();
    }

    /**
     * 返回已经删除尚未提交的文档总数[注意：请自己手动关闭IndexReader]
     * @param reader
     * @return
     */
    public static int getDeletedDocNum(IndexReader reader) {
        return getMaxDocId(reader) - getIndexTotalCount(reader);
    }

    /**
     * 根据docId查询索引文档
     * @param reader         IndexReader对象
     * @param docID          documentId
     * @param fieldsToLoad   需要返回的field
     * @return
     */
    public static Document findDocumentByDocId(IndexReader reader,int docID, Set<String> fieldsToLoad) {
        try {
            return reader.document(docID, fieldsToLoad);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * 根据docId查询索引文档
     * @param reader         IndexReader对象
     * @param docID          documentId
     * @return
     */
    public static Document findDocumentByDocId(IndexReader reader,int docID) {
        return findDocumentByDocId(reader, docID, null);
    }

    /**
     * @Title: createHighlighter
     * @Description: 创建高亮器
     * @param query             索引查询对象
     * @param prefix            高亮前缀字符串
     * @param stuffix           高亮后缀字符串
     * @param fragmenterLength  摘要最大长度
     * @return
     */
    public static Highlighter createHighlighter(Query query, String prefix, String stuffix, int fragmenterLength) {
        Formatter formatter = new SimpleHTMLFormatter((prefix == null || prefix.trim().length() == 0) ?
                "<font color=\"red\">" : prefix, (stuffix == null || stuffix.trim().length() == 0)?"</font>" : stuffix);
        Scorer fragmentScorer = new QueryScorer(query);
        Highlighter highlighter = new Highlighter(formatter, fragmentScorer);
        Fragmenter fragmenter = new SimpleFragmenter(fragmenterLength <= 0 ? 50 : fragmenterLength);
        highlighter.setTextFragmenter(fragmenter);
        return highlighter;
    }

    /**
     * @Title: highlight
     * @Description: 生成高亮文本
     * @param document          索引文档对象
     * @param highlighter       高亮器
     * @param analyzer          索引分词器
     * @param field             高亮字段
     * @return
     * @throws IOException
     * @throws InvalidTokenOffsetsException
     */
    public static String highlight(Document document,Highlighter highlighter,Analyzer analyzer,String field) throws IOException {

        List<IndexableField> list = document.getFields();
        for (IndexableField fieldable : list) {
            String fieldValue = fieldable.stringValue();
            if(fieldable.name().equals(field)) {
                try {
                    fieldValue = highlighter.getBestFragment(analyzer, field, fieldValue);
                } catch (InvalidTokenOffsetsException e) {
                    fieldValue = fieldable.stringValue();
                }
                return (fieldValue == null || fieldValue.trim().length() == 0)? fieldable.stringValue() : fieldValue;
            }
        }
        return null;
    }

    /**
     * @Title: getCount
     * @Description: 获取符合条件的总记录数
     * @param query
     * @return
     * @throws IOException
     */
    public static int getCount(IndexSearcher search, Query query) throws IOException {
        logger.debug("统计总数开始");
        int count = search.count(query);
        logger.debug("统计总数结束");
        return count;
    }

    public static List<Document> topQuery(IndexSearcher searcher, Sort sort, Query query, int topN) throws IOException {

        TopDocs topDocs = null;
        if(sort == null) {
            topDocs = searcher.search(query, topN);
        }else {
            topDocs = searcher.search(query, topN, sort);
        }

        ScoreDoc[] docs = topDocs.scoreDocs;
        List<Document> docList = new ArrayList<Document>();
        for (ScoreDoc scoreDoc : docs) {
            docList.add(searcher.doc(scoreDoc.doc));
        }
        return docList;
    }

    /**
     * @Title: pageQuery
     * @Description: Lucene分页查询
     * @param searcher
     * @param query
     * @param page
     * @throws IOException
     */
    public static void pageQuery(IndexSearcher searcher, Sort sort, Query query, Page page) throws IOException {
        pageQuery(searcher, sort, query, page, null);
    }

    /**
     * @Title: pageQuery
     * @Description: 分页查询[如果设置了高亮,则会更新索引文档]
     * @param searcher
     * @param query
     * @param page
     * @param highlighterParam
     * @throws IOException
     */
    public static void pageQuery(IndexSearcher searcher, Sort sort, Query query, Page page, HighlighterParam highlighterParam) throws IOException {

        int totalRecord = 0;
        totalRecord = getCount(searcher,query);
        logger.debug("totalRecord:{}", totalRecord);
        //设置总记录数
        page.setTotal(totalRecord);

        logger.debug("查询开始");
        TopDocs topDocs = null;
        ScoreDoc[] docs = null;
        if(page.getPageNo() == 1)// 第一页
        {
            if(sort == null) {
                topDocs = searcher.search(query, page.getPageSize());
            }else {
                topDocs = searcher.search(query, page.getPageSize(), sort);
            }
            docs = topDocs.scoreDocs;
        }
        else {
            if(null == page.getAfterDoc()){ // 没有
                docs = getScoreDocDataRange(searcher,query,sort,(page.getPageNo()-1)*page.getPageSize(),page.getPageSize());
            }else {
                if (sort == null) {
                    topDocs = searcher.searchAfter(page.getAfterDoc(), query, page.getPageSize());
                } else {
                    topDocs = searcher.searchAfter(page.getAfterDoc(), query, page.getPageSize(), sort);
                }
                docs = topDocs.scoreDocs;
            }
        }
        logger.debug("查询结束");
        /*if(topDocs == null){
            totalRecord = getCount(searcher,query);
        }else {
            totalRecord = new Long(topDocs.totalHits).intValue();
        }
        //设置总记录数
        page.setTotal(totalRecord);*/

        List<Document> docList = new ArrayList<Document>();
        int index = 0;
        for (ScoreDoc scoreDoc : docs) {
            int docID = scoreDoc.doc;
            Document document = searcher.doc(docID);
            if(index == docs.length - 1) {
                page.setAfterDoc(scoreDoc);
                page.setAfterDocId(docID);
            }
            docList.add(document);
            index++;
        }

        if(null != highlighterParam && highlighterParam.isHighlight()) {
            addHighlighter2Docs(docList, query, highlighterParam, defAnalyzer);
        }
        page.setDocList(docList);
    }

    /**
     * 多条件topN查询
     * @param params
     * @param searcher
     * @param sort
     * @param topN
     * @return
     * @throws IOException
     */
    public static List<Document> multConTopQeury(Map<String, Object> params, IndexSearcher searcher, Sort sort, int topN) throws IOException, ParseException {
        Query query = getMulitConditionQuery(params);
        return topQuery(searcher,sort,query,topN);
    }
        /**
         * 多条件分页查询
         * @param params
         * @param searcher
         * @param sort
         * @param page
         * @param highlighterParam
         * @throws IOException
         */
    public static void multConPageQeury(Map<String, Object> params, IndexSearcher searcher, Sort sort, Page page, HighlighterParam highlighterParam) throws IOException, ParseException {

        //用户输入内容
        Query query = getMulitConditionQuery(params);

        pageQuery(searcher, sort, query,page, highlighterParam);
    }

    /**
     * 获取数据，可用于分页、top
     * @param query
     * @param sort
     * @param offset 开始位置
     * @param count 取的数据个数，最大10000条
     * @return
     * @throws Exception
     */
    private static ScoreDoc[] getScoreDocDataRange(IndexSearcher indexSearcher,Query query, Sort sort, int offset, int count) throws IOException {
        Assert.isTrue(count>0, "参数错误");
        Assert.isTrue(offset>=0, "参数错误");

        TopDocs topDocs = null;
        TopDocs lastTopDocs = null; // 上一次取的值
        ScoreDoc lastScoreDoc = null;

        List<ScoreDoc> rstList = new ArrayList<>();
        int getTotal = offset + count; // 本次获取总数
        int batchNum = 1; // 取的次数
        // 要确信分页信息正确，这里不做检查
        int bachSize = 10000;
        int getNum = bachSize; // 本次获取的数量
        // 重新计算，尽量一次取出
        if(getTotal <= bachSize){
            bachSize = getTotal;
            getNum = bachSize;
        }else if(getTotal-bachSize < bachSize/2){ // 1.5以下
            bachSize = getTotal;
            getNum = bachSize;
        }else { // 1.5以上，暂不优化
        }

        while (topDocs == null || (topDocs.scoreDocs.length == bachSize && getNum < Integer.MAX_VALUE)){

            int lastTotal = 0; // 已经取得的数

            // 第一次
            if(topDocs == null){
                if(null == sort)
                    topDocs = indexSearcher.search(query, getNum);
                else
                    topDocs = indexSearcher.search(query, getNum, sort);
                /*if(topDocs.scoreDocs.length == 0){ // 没取到数据直接跳出
                    break;
                }*/
            }else {
                // 如果走到这，以前取的个数肯定是批次数
                lastTotal = (batchNum-1)*bachSize;
                // 是否还需要取值，和实际值比较
                if(getTotal == lastTotal){
                    break;
                }

                lastTopDocs = topDocs;// 保存上次
                // 取上次的最后一个
                lastScoreDoc = topDocs.scoreDocs[bachSize -1];

                if(null == sort)
                    topDocs = indexSearcher.searchAfter(lastScoreDoc,query, getNum);
                else
                    topDocs = indexSearcher.searchAfter(lastScoreDoc,query, getNum, sort);
            }

            // 准备一下次取数
            // 取完值次数+1
            batchNum++;

            // 计算下次要取的数
            if(lastTotal + topDocs.scoreDocs.length >= getTotal ) {
                getNum = 0;
                break;
            }else if(lastTotal + topDocs.scoreDocs.length  + bachSize > getTotal){
                getNum = lastTotal + topDocs.scoreDocs.length + bachSize - getTotal;
            }else {
                getNum = bachSize;
            }
        }

        if(lastTopDocs != null){
            for(int i=offset-(batchNum-2) * bachSize; i<bachSize; i++){
                rstList.add(lastTopDocs.scoreDocs[i]);
            }
            for(ScoreDoc o : topDocs.scoreDocs){
                rstList.add(o);
            }
        }else {
            for(int i=offset; i<topDocs.scoreDocs.length; i++){
                ScoreDoc o = topDocs.scoreDocs[i];
                rstList.add(o);
            }
        }


        return rstList.toArray(new ScoreDoc[rstList.size()]);
    }

    public static void addHighlighter2Docs(List<Document> docList, Query query, HighlighterParam highlighterParam, Analyzer analyzer) throws IOException {
        if(null == highlighterParam || !highlighterParam.isHighlight()){
            return;
        }
        //创建高亮器
        Highlighter highlighter = LuceneUtils.createHighlighter(query,
                highlighterParam.getPrefix(), highlighterParam.getSuffix(),
                highlighterParam.getFragmenterLength());
        String lighterFiledName = highlighterParam.getFieldName();

        for(Document document : docList){
            String content = document.get(lighterFiledName);
            if(null != content && content.trim().length() > 0) {
                String text = highlight(document, highlighter, analyzer, lighterFiledName);
                document.removeField(lighterFiledName);
                document.add(new TextField(lighterFiledName, text, Field.Store.YES));
                //若高亮后跟原始文本不相同，表示高亮成功 // 不保存到索引中 // 张配忠修改
                    /*if(!text.equals(content)) {
                        Document tempdocument = new Document();
                        List<IndexableField> indexableFieldList = document.getFields();
                        if(null != indexableFieldList && indexableFieldList.size() > 0) {
                            for(IndexableField field : indexableFieldList) {
                                if(field.name().equals(highlighterParam.getFieldName())) {
                                    tempdocument.add(new TextField(field.name(), text, Field.Store.YES));
                                } else {
                                    tempdocument.add(field);
                                }
                            }
                        }
                        updateIndex(writer, new Term(highlighterParam.getFieldName(),content), tempdocument);
                        document = tempdocument;
                    }*/
            }
        }
    }
    /**
     * 获取多条件查询
     * @param params
     * @return
     */
    public static Query getMulitConditionQuery(Map<String, Object> params) throws ParseException {
        return getMulitConditionQuery(params, null, null);
    }
    public static Query getMulitConditionQuery(Map<String, Object> params, Map<String, IndexColumn> columnMap, Analyzer analyzer) throws ParseException {
        // 没有参数，查询所有
        if(params == null) {
            return new MatchAllDocsQuery();
        }
        if(columnMap == null){
            columnMap = new HashMap<>();
        }
        if(analyzer == null){
            analyzer = defAnalyzer;
        }
        BooleanQuery.Builder builder = new BooleanQuery.Builder();

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if(StringUtils.isEmpty(entry.getKey())){
                continue;
            }
            String key = entry.getKey();
            Object value = entry.getValue();
            if(null == value){
                continue;
            }
            Query query = null;
            boolean isAnaly = false;
            // 判断字段是否分词
            if(columnMap.containsKey(key))
            {
                IndexColumn col = columnMap.get(key);
                isAnaly = col.isAnaly();
                switch (col.getFieldType()){
                    case 1: // long
                        long a = TypeHelper.toLong(value);
                        query = LongPoint.newExactQuery(key,a);
                        break;
                    case 2: // double
                        double d = TypeHelper.toDouble(value);
                        query = DoublePoint.newExactQuery(key,d);
                        break;
                    case 3: default:
                        String ss = TypeHelper.toString(value);
                        if(isAnaly){
                            QueryParser parse = new QueryParser(key, analyzer);
                            query = parse.parse(ss);
                        }else {
                            query = new TermQuery(new Term(key,ss));
                        }
                }

            }else {
                if (value.getClass() == String.class) {
                    if(StringUtils.isEmpty(value.toString())){
                        continue;
                    }
                    query = new TermQuery(new Term(key, value.toString()));

                } else if (value.getClass() == Integer.class) {
                    query = LongPoint.newExactQuery(key,(Integer)value);
                }else if(value.getClass() == Long.class){
                    query = LongPoint.newExactQuery(key,(Long)value);
                }else {
                    String ss = TypeHelper.toString(value);
                    query = new TermQuery(new Term(entry.getKey(), ss));
                }
            }

            builder.add(query, BooleanClause.Occur.MUST);
        }
        BooleanQuery booleanQuery = builder.build();
        if(booleanQuery.clauses().size() == 0){
            return new MatchAllDocsQuery();
        }

        return booleanQuery;
    }

    public static List<Map<String, String>> docs2MapList(Collection<Document> documentList) {
        List<Map<String, String>> result=new ArrayList<>();
        for(Document doc:documentList){
            Map<String, String> rec = Maps.newHashMap();

            for(IndexableField o :doc.getFields()){
                rec.put(o.name(), o.stringValue());
            }
            result.add(rec);
        }
        return result;
    }
}
