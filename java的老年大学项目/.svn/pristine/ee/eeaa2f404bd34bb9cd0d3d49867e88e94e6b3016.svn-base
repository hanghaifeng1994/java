package cn.com.weye.modules.cfg.service;

import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.persistence.mybatis.impl.Criteria;
import cn.com.weye.core.persistence.mybatis.impl.CriteriaQuery;
import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.modules.cfg.dao.CfgAddedServiceDao;
import cn.com.weye.modules.cfg.entity.CfgAddedService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yl
 */
@Service
public class CfgAddedServiceService extends MybatisBaseService<CfgAddedService> {

    @Resource
    private CfgAddedServiceDao cfgAddedServiceDao;

    @Override
    public String getTableName() {
        return ConfigUtils.getValue("schema.interPlat") + ".CFG_ADDED_SERVICE";
    }

    @Override
    public String getIdKey() {
        return "asId";
    }

    @Override
    public MybatisBaseDao<CfgAddedService> getDao() {
        return cfgAddedServiceDao;
    }
    
    @Override
    protected boolean isLogicDelete(){
        return false;
    }

    public Page<CfgAddedService> queryExtPage(CfgAddedService params, Page<CfgAddedService> page){

        CriteriaQuery q = new CriteriaQuery();
        Criteria c = q.createAndCriteria();
        if(StringUtils.isNotBlank(params.getAsName())){
            c.like(CfgAddedService.TF.asName,params.getAsName());
        }
        if(StringUtils.isNotBlank(params.getAsStatus())){
            c.equalTo(CfgAddedService.TF.asStatus,params.getAsStatus());
        }
        if(params.getBeginDate()!=null){
            c.greaterThanOrEqualTo(CfgAddedService.TF.createDate,params.getBeginDate());
        }
        if(params.getEndDate()!=null){
            c.lessThanOrEqualTo(CfgAddedService.TF.createDate,params.getEndDate());
        }
        if(null != page){
            q.setPage(page);
        }
        cfgAddedServiceDao.queryByCriteriaExt(q);
        return page;
    }
    /**
     * 根据id查询出增值包的价格
     */
    public BigDecimal asPrice(Map<String,Object> map){

        return cfgAddedServiceDao.asPrice(map);
    }
    public List<CfgAddedService> queryByOrdId(String OrdId){
        CriteriaQuery q = new CriteriaQuery();
        Criteria c = q.createAndCriteria();
        if(StringUtils.isNotBlank(OrdId)){
            c.equalTo("s.ORD_ID",OrdId);
        }
        return cfgAddedServiceDao.queryByOrdId(q);
    }
}
