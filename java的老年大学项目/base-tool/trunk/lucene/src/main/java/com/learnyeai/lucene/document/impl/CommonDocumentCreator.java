package com.learnyeai.lucene.document.impl;

import com.learnyeai.lucene.conf.IndexColumn;
import com.learnyeai.lucene.document.DocumentCreator;
import com.learnyeai.lucene.utils.JavaTypeResolverUtil;
import com.learnyeai.tools.common.StringUtils;
import com.learnyeai.tools.common.TypeHelper;
import org.apache.lucene.document.*;
import org.apache.lucene.util.BytesRef;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;

/**
 * ResultSet转成doc，通用转换，所有字段都是text
 *  子类可以覆盖convert2Doc，实现自定义field
 * Created by zpz on 2018/9/6.
 */
public class CommonDocumentCreator implements DocumentCreator {
    private Map<String, IndexColumn> columnMap = new HashMap<>();

    @Override
    public void setIndexColumn(List<IndexColumn> columnList) {
        columnMap.clear();
        if(null != columnList){
            for(IndexColumn o : columnList){
                columnMap.put(o.getFieldName(),o);
            }
        }
    }

    @Override
    public Document createDocument(Map datMap) throws Exception {
        Document document = new Document();
        for(Iterator<Map.Entry> it = datMap.entrySet().iterator(); it.hasNext();){
            Map.Entry o = it.next();
            String key = o.getKey().toString();
            Object val = o.getValue();
            if(null == val) // 没有值不要继续
                continue;

            IndexColumn indexColumn = columnMap.get(key);
            if(indexColumn == null) {
                addField2Doc(document, key, val);
            }else {
                addField2Doc(document,key,val, indexColumn);
            }
        }
        return document;
    }

    /*@Override
    public Document createDocument(ResultSet rs) throws Exception {
        Document document = new Document();
        ResultSetMetaData md = rs.getMetaData();
//        Map<String, Object> dataMap = new HashedMap();
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

            IndexColumn indexColumn = columnMap.get(colName);
            if(indexColumn == null) {
                addField2Doc(document, colName, val);
            }else {
                addField2Doc(document,colName,val, indexColumn);
            }
//            dataMap.put(colName, val);
        }
*//*
        List<Field> fieldList = convert2Doc(dataMap);
        for(Field field : fieldList){
            document.add(field);
        }*//*
        return document;
    }*/
    protected void addField2Doc(Document document, String key, Object val, IndexColumn column){
        int type = column.getFieldType();
        switch (type){
            case 1: // long
                long a = 0;
                if(val instanceof Long){
                    a = (Long) val;
                }else if(val instanceof String){
                    try{
                        a = Long.valueOf(((String) val).toLowerCase());
                    }catch (Exception e){}
                }else if(val instanceof Date){
                    a = ((Date)val).getTime();
                }
                document.add(new LongPoint(key, a));
                document.add(new StoredField(key, a));
                if(column.isSort()){
                    document.add(new NumericDocValuesField(key, a));
                }
                break;
            case 2: // double
                double d = 0;
                if(val instanceof Double){
                    d = (Double) val;
                }else if(val instanceof String){
                    try{
                        d = Double.valueOf(((String) val).toLowerCase());
                    }catch (Exception e){}
                }
                document.add(new DoublePoint(key, d));
                document.add(new StoredField(key, d));
                if(column.isSort()){
                    document.add(new DoubleDocValuesField(key, d));
                }
                break;
            case 3: // string 字符串，判断是否分词
            default:
                String ss = null;
                if(type == 3) {
                    ss = TypeHelper.toString(val);
                }else {
                    ss = TypeHelper.toString(val);
                }
                if(column.isAnaly()) {
                    document.add(new TextField(key, ss, Field.Store.YES));
                }else {
                    document.add(new StringField(key,ss,Field.Store.YES));
                }
                if(column.isSort()){
                    document.add(new SortedDocValuesField(key, new BytesRef(ss)));
                }
        }
    }

    // 不分词不排序
    protected void addField2Doc(Document document, String key, Object val){
        Field field = null;
        Field field1 = null;
        if(val instanceof Integer){
            Integer a = (Integer)val;
            field = new LongPoint(key, a.longValue());
            field1 = new StoredField(key, a.longValue());
        } else if(val instanceof Short){
            Short a = ((Short)val);
            field = new LongPoint(key, a.longValue());
            field1 = new StoredField(key, a.longValue());
        }else if(val instanceof Long){
            long a = (Long) val;
            field = new LongPoint(key, a);
            field1 = new StoredField(key, a);
        }else if(val instanceof Float){
            double a = (Float)val;
            field = new DoublePoint(key, a);
            field1 = new StoredField(key, a);
        }else if(val instanceof Double){
            double a = (Double)val;
            field = new DoublePoint(key, a);
            field1 = new StoredField(key, a);
        }else {
            field = new StringField(key, TypeHelper.toString(val), Field.Store.YES);
        }
        document.add(field);
        if(null != field1){
            document.add(field1);
        }
    }

    protected List<Field> convert2Doc(Map<String, Object> dataMap){
        List<Field> list = new ArrayList<>();
        dataMap.forEach((k, v)->{
            Field field = null;
            Field field1 = null;
            if(v instanceof Integer){
                Integer a = (Integer)v;
                field = new LongPoint(k, a.longValue());
                field1 = new StoredField(k, a.longValue());
            } else if(v instanceof Short){
                Short a = ((Short)v);
                field = new LongPoint(k, a.longValue());
                field1 = new StoredField(k, a.longValue());
            }else if(v instanceof Long){
                long a = (Long) v;
                field = new LongPoint(k, a);
                field1 = new StoredField(k, a);
            }else if(v instanceof Float){
                double a = (Float)v;
                field = new DoublePoint(k, a);
                field1 = new StoredField(k, a);
            }else if(v instanceof Double){
                double a = (Double)v;
                field = new DoublePoint(k, a);
                field1 = new StoredField(k, a);
            }else {
                field = new TextField(k, TypeHelper.toString(v), Field.Store.YES);
            }

            list.add(field);
            if(null != field1){
                list.add(field1);
            }
        });
        return list;
    }

}
