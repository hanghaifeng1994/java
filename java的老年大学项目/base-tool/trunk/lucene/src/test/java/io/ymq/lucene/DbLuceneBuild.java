package io.ymq.lucene;

import com.learnyeai.lucene.build.DBUtil;
import com.learnyeai.lucene.build.IndexBuilder;
import com.learnyeai.lucene.utils.LuceneManager;
import com.learnyeai.lucene.utils.LuceneManagerUtils;
import com.learnyeai.lucene.utils.LuceneUtils;
import com.learnyeai.lucene.utils.Page;
import com.learnyeai.tools.common.JsonMapper;
import org.apache.lucene.document.Document;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Sort;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zpz on 2018/9/6.
 */
public class DbLuceneBuild {

    @Test
    public void searchTopTest(){
        LuceneManager lucemanage = LuceneManagerUtils.getLuceneManager("d:/temp/index/js_sys_area");
        IndexSearcher search = lucemanage.getIndexSearcher();
        Map pp = new HashMap<>();
//        pp.put("treeNames", "北京市");

        try {
            List<Document> docs = LuceneUtils.multConTopQeury(pp, search, null, 10);
            List<Map<String, String>> result = LuceneUtils.docs2MapList(docs);
            System.out.println(JsonMapper.toJsonString(result));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            LuceneManagerUtils.close();
        }
    }

    @Test
    public void searchPageTest(){
        LuceneManager lucemanage = LuceneManagerUtils.getLuceneManager("d:/temp/index/js_sys_area");
        IndexSearcher search = lucemanage.getIndexSearcher();
        Map pp = new HashMap<>();
        pp.put("treeNames", "北京市*");
        try {
            Page page = new Page<>(1, 5);
            int totalPage = 1;
            for(int i=0; i<totalPage; i++) {
                page.setPageNo(i+1);
                LuceneUtils.multConPageQeury(pp, search, null, page, null);
                List<Map<String, String>> result = LuceneUtils.docs2MapList(page.getDocList());
                page.setList(result);
                System.out.println("获取记录数：" + result.size());
                System.out.println("获取记录数：" + JsonMapper.toJsonString(result.get(result.size()-1)));
                totalPage = page.getTotalPage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
//            LuceneManagerUtils.close();
        }

        search = lucemanage.getIndexSearcher();
        pp.put("treeNames", "山东*");
        // 每次都设置上次取值为空
        try {
            Page page = new Page<>(1, 5);
            int totalPage = 1;
            for(int i=0; i<totalPage; i++) {
                page.setPageNo(i+1);
                page.setAfterDocId(-1);
                LuceneUtils.multConPageQeury(pp, search, null, page, null);
                List<Map<String, String>> result = LuceneUtils.docs2MapList(page.getDocList());
                page.setList(result);
                System.out.println("获取记录数：" + result.size());
                System.out.println("获取记录数：" + JsonMapper.toJsonString(result.get(result.size()-1)));
                totalPage = page.getTotalPage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            LuceneManagerUtils.close();
        }
    }
}
