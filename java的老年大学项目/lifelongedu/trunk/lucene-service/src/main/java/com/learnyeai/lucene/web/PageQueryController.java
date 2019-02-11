package com.learnyeai.lucene.web;

import com.learnyeai.file.fastdfs.FastDFSUtil;
import com.learnyeai.learnai.consts.AppR;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.context.CtxReportUtil;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.IController;
import com.learnyeai.lucene.conf.IndexConfig;
import com.learnyeai.lucene.index.LuceneConfUtil;
import com.learnyeai.lucene.index.LuceneIndexPropUtils;
import com.learnyeai.lucene.utils.*;
import com.learnyeai.lucene.vo.IndexQueryPara;
import com.learnyeai.tools.common.BeanMapUtils;
import com.learnyeai.tools.common.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by zpz on 2018/9/10.
 */
@Component
public class PageQueryController implements IController{
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Object execute(IBusinessContext ctx) {
        IndexQueryPara indexQueryPara = null;
        try {
            indexQueryPara = (IndexQueryPara)BeanMapUtils.convertMap(IndexQueryPara.class, ctx.getParamMap());
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            throw new AresRuntimeException();
        }
        String indexName = indexQueryPara.getIndexName();
        Page<Object> page = new Page<>(indexQueryPara.getPageNo(), indexQueryPara.getPageSize());
        page.setTotal(indexQueryPara.getTotal());

        // 从参数中获取要查询的索引
        IndexConfig luceneConf = LuceneIndexPropUtils.getConf(indexName);
        if(null == luceneConf){
            throw AresRuntimeException.build(null).iniCauseMsg("索引不存在");
        }

        // 解析query
        Query query = null;
        try {
            query = luceneConf.getBuildQuery().buildQuery(indexQueryPara.getQueryType(),indexQueryPara.getQueryParams());
        } catch (ParseException e) {
            throw AresRuntimeException.build(null).iniCauseMsg(e.getMessage());
        }
//        query = new TermQuery(new Term("id", "57cf14eb7b94426f8f4fdbc7334e1e4e"));
        HighlighterParam highlighter = new HighlighterParam();
        highlighter.setHighlight(indexQueryPara.getHightLighter() == 1);
        highlighter.setPrefix(indexQueryPara.getHlPrefix());
        highlighter.setSuffix(indexQueryPara.getHlSuffix());
        highlighter.setFieldName(indexQueryPara.getHlFiledId());

        logger.debug("{} 开始查询", indexName);
        Sort sort = LuceneConfUtil.getSort(luceneConf.getConfigName(),indexQueryPara.getSorts(), indexQueryPara.getSortTypes());
        try{
            LuceneManager manage = LuceneManagerUtils.getLuceneManager(luceneConf.getConfigBean().getIndexDir());
            IndexSearcher search = manage.getIndexSearcher();
            LuceneUtils.pageQuery(search, sort, query, page, null);
            List<Document> list = page.getDocList();
            // 添加高亮
            LuceneUtils.addHighlighter2Docs(list,query,highlighter, luceneConf.getAnalyzer());
            List rst = luceneConf.getDoc2ObjectMapper().mapDocumentsToObject(list);
            addImgServerUrl(rst, luceneConf.getConfigBean().getImgColNames());
            logger.debug("{}查询成功", indexName);
            CtxHeadUtil.setReportDataDealType("1");

            Map extData = CtxReportUtil.getListExtResultMap();
            extData.put(AppR.RTN_TOTAL, page.getTotal());
            extData.put(AppR.RTN_PAGE_NO, page.getPageNo());
            extData.put(AppR.RTN_PAGE_SIZE, page.getPageSize());
            extData.put("afterDocId", page.getAfterDocId());
            return rst;
        }catch (Exception e){
            logger.error(indexName + "查询失败", e);
            throw AresRuntimeException.build("Query.searchFail", "查询失败").iniCauseMsg(e.getMessage());
        }
    }

    // 处理配置图片，指定默认字段为图片，配置photo、多图片imgs，并且只处理Map
    private void addImgServerUrl(List list, String colNames){
        if(null==list || list.size() == 0)
            return;
        if(StringUtils.isBlank(colNames))
            return;
        String[] arr = colNames.split(",");

        for (Object o : list){
            for(String col : arr) {
                Object val = BeanUtils.getProperty(o, col);
                String img = parseImg(val);
                BeanUtils.setProperty(o, col, img, false);
            }
        }
    }
    public String parseImg(Object val) {
        logger.debug("资源串{}", val);
        if(null == val)
            return "";
        String ss = val.toString();
        if(ss.length() == 0)
            return "";
        String imgs[] = val.toString().split(",");
        // 获取文件绝对路径，拼接到文件名中
        StringBuffer sb = new StringBuffer();
        for(String img : imgs) {
            if(logger.isDebugEnabled())
            {
                logger.debug("原图片串{}", img);
            }
            if(img == null || img.length() == 0) // 为空，
                continue;

            String url = null;
            if(img.indexOf("http") == 0)
                url = img;
            else
                url = FastDFSUtil.getFileUrl(img);

            if(url == null)
                url = img;
            if(logger.isDebugEnabled())
            {
                logger.debug("图片url{}", url);
            }
            // 获取路径
            sb.append(url).append(",");
        }
        if(imgs.length > 0)
            sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
