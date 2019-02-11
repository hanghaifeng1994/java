package cn.com.weyeyun.commoncert.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.weyeyun.commoncert.model.CertTemplate;
import cn.common.lib.springside.orm.BaseDao;
import cn.common.lib.springside.orm.BaseHibernateDao;

/**
 * 
 * 证书模板数据访问类
 * 
 * @author fangyong
 * @version 1.0
 * @since 2012-9-3
 */
@Component
public class CertTemplateDao extends BaseHibernateDao<CertTemplate, Long> implements BaseDao<CertTemplate, Long>
{
    // 批量取消启用
    private static final String CANCLE_USE = "update CertTemplate set status = false where id in (:ids)";

    // 批量启用
    private static final String BATCH_USE  = "update CertTemplate set status = true where id in (:ids)";

    /**
     * 
     * 批量取消启用
     * 
     * @since 2013-1-30
     * @author fangyong
     * @param idsList
     * @return
     */
    public int cancleUse(List<Long> idsList)
    {
        Map<String, List<Long>> values = Collections.singletonMap("ids",
                idsList);
        return batchExecute(CANCLE_USE, values);
    }

    /**
     * 
     * 批量启用
     * 
     * @since 2013-1-30
     * @author fangyong
     * @param idsList
     * @return
     */
    public int batchUse(List<Long> idsList)
    {
        Map<String, List<Long>> values = Collections.singletonMap("ids",
                idsList);
        return batchExecute(BATCH_USE, values);
    }
    
    /**
     * 搜索是否开启的证书模板
     * @param status
     * @return
     */
    public List<CertTemplate> getCertTemplates(boolean status)
    {
    	 List<CertTemplate> list = this
         .find("from CertTemplate where status=? order by id desc",
                 status);
    	 return list;
    }
}
