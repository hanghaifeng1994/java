package com.learnyeai.lucene.index;

import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zpz on 2018/9/11.
 */
public class LuceneConfUtil {
    private static Map<String, Sort> sortMap = new HashMap<>();

    public static Sort getSort(String indexAsName, String sorts, String sortTypes){
        if(null == sorts || sorts.length() == 0 || sortTypes ==null || sortTypes.length() == 0){
            return null;
        }

        String key = indexAsName + "_" + sorts + "_" + sortTypes;
        if(sortMap.containsKey(key)){
            return sortMap.get(key);
        }
        Sort sort = buildSort(indexAsName, sorts, sortTypes);
        sortMap.put(key, sort);
        return sort;
    }
    /**
     *
     * @param sorts
     *  a=1&b=0,说明1：升序、0倒序
     * @param sortTypes 排序类型，与sorts一一对应(SortField.Type)
     * @return
     */
    private static Sort buildSort(String indexAsName, String sorts, String sortTypes) {
        if(null == sorts || sorts.length() == 0 || sortTypes ==null || sortTypes.length() == 0){
            return null;
        }
        List<SortField> list = parseSorts(sorts, sortTypes);
        if(list.size() == 0){
            return null;
        }
        return new Sort(list.toArray(new SortField[list.size()]));
    }
    private static List<SortField> parseSorts(String sorts, String sortTypes){
        List<SortField> list = new ArrayList<>();
        if(null == sorts || sorts.length() == 0 || sortTypes ==null || sortTypes.length() == 0){
            return list;
        }
        String sortArr[] = sorts.split("&");
        String sortTypeArr[] = sortTypes.split(",");
        if(sortArr.length != sortTypeArr.length){
            return list;
        }

        for(int i=0; i<sortArr.length; i++){
            Assert.isTrue(StringUtils.isNotBlank(sortArr[i]), "排序字段有误");
            String arr[] = sortArr[i].split("=");
            Assert.isTrue(StringUtils.isNotBlank(arr[0]), "排序字段有误");
            String field = arr[0];
            boolean asc = arr.length==1 || "1".equals(arr[1]) ? true : false;
            boolean reverse = !asc;

            SortField.Type type = SortField.Type.valueOf(sortTypeArr[i]);
            Assert.isTrue(type!=null, "排序字段有误");

            SortField sortField = new SortField(field, type, reverse);
            list.add(sortField);
        }

        return list;
    }

}
