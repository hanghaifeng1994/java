package cn.com.weye.modules.cfg.service;

import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.impl.Criteria;
import cn.com.weye.core.persistence.mybatis.impl.CriteriaQuery;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.modules.cfg.dao.CfgSchemeDao;
import cn.com.weye.modules.cfg.entity.CfgScheme;
import cn.com.weye.tools.common.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zpzxskxsk@126.com
 */
@Service
public class CfgSchemeService extends MybatisBaseService<CfgScheme> {

    @Resource
    private CfgSchemeDao cfgSchemeDao;

    @Override
    public String getTableName() {
        return ConfigUtils.getValue("schema.interPlat") + ".CFG_SCHEME";
    }

    @Override
    public String getIdKey() {
        return "schmId";
    }

    @Override
    public MybatisBaseDao<CfgScheme> getDao() {
        return cfgSchemeDao;
    }
    
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    @Override
    protected DBQuery genSqlQuery(CfgScheme params, String mainTableAs) {
        String as = mainTableAs == null ? "" : mainTableAs + ".";
        CriteriaQuery c = new CriteriaQuery();
        if (this.isLogicDelete()) {
            c.createAndCriteria().equalTo(as + "DEL_FLAG", "0");
        }
        if(StringUtils.isNotBlank(params.getSchmStatus())){
            c.createAndCriteria().equalTo(CfgScheme.TF.schmStatus,params.getSchmStatus());
        }

        return c;
    }

    /**
     * 更新方案的模块
     * @param schmId
     * @param idList
     */
    public void updateSchmMdl(String schmId, List<String> idList){
        cfgSchemeDao.deleteSchmMdl(schmId);
        if(idList.size() == 0)
            return;

        Map pp = new HashMap();
        pp.put(CfgScheme.TF.schmId, schmId);
        pp.put("idList", idList);
        cfgSchemeDao.insertSchmMdl(pp);
    }
    /**
     * 添加方案的模块
     * @param schmId
     * @param idList
     */
    public void addSchmMdl(String schmId, List<String> idList){
        if(idList.size() == 0)
            return;
        Map pp = new HashMap();
        pp.put(CfgScheme.TF.schmId, schmId);
        pp.put("idList", idList);
        cfgSchemeDao.insertSchmMdl(pp);
    }

    @Override
    protected DBQuery genSqlQuery(CfgScheme params) {
        CriteriaQuery q = (CriteriaQuery)super.genSqlQuery(params);
        Criteria c = q.createAndCriteria();
        if(StringUtils.isNotBlank(params.getSchmIndustry())){
            c.equalTo(CfgScheme.TF.schmIndustry, params.getSchmIndustry());
        }
        if(StringUtils.isNotBlank(params.getSchmName())){
            c.like(CfgScheme.TF.schmName, "%" + params.getSchmName() + "%");
        }
        return q;
    }

    /**
     * 修改方案状态
     * @param id
     * @param status
     * @return
     */
    public int updateStatus(String id, String status){

        CfgScheme pp = new CfgScheme();
        pp.setSchmId(id);
        pp.setSchmStatus(status);
        return cfgSchemeDao.updateByIdSelective(pp);
    }

    /**
     * 更新的方案模块排序
     * @param mdlIds
     * @param sorts
     */
    public int updateSchemeMdlSorts(String schmId, String[] mdlIds, Integer[] sorts){
        List<Map> list = new ArrayList<Map>();
        int result = 0;
        CfgSchemeDao mapper = batchSqlSessionTemplate.getMapper(CfgSchemeDao.class);
        for (int i=0; i<mdlIds.length; i++){
            HashMap map = new HashMap();
            map.put("mdlId", mdlIds[i]);
            map.put("sort", sorts[i]);
            map.put("schmId", schmId);

            result += mapper.updateSchemeMdlSort(map);
        }

        return result;
    }

    /**
     * 删除方案模块
     * @param schmId
     * @param mdlId
     * @return
     */
    public int delSchemeMdl(String schmId, String mdlId){

        HashMap map = new HashMap();
        map.put("mdlId", mdlId);
        map.put("schmId", schmId);

        // 判断模块有没有被使用
        int cnt = cfgSchemeDao.countSchemeEdtMdl(map);
        if(cnt > 0)
            throw new RuntimeException("已经有方案版本使用");
        return cfgSchemeDao.delSchemeMdl(map);
    }


}
