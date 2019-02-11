package cn.com.weye.modules.cfg.service;

import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.impl.Criteria;
import cn.com.weye.core.persistence.mybatis.impl.CriteriaQuery;
import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.modules.cfg.dao.CfgModuleDao;
import cn.com.weye.modules.cfg.entity.CfgModule;
import cn.com.weye.tools.common.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zpzxskxsk@126.com
 */
@Service
public class CfgModuleService extends MybatisBaseService<CfgModule> {

    @Resource
    private CfgModuleDao cfgModuleDao;

    @Override
    public String getTableName() {
        return ConfigUtils.getValue("schema.interPlat") + ".CFG_MODULE";
    }

    @Override
    public String getIdKey() {
        return "mdlId";
    }

    @Override
    public MybatisBaseDao<CfgModule> getDao() {
        return cfgModuleDao;
    }
    
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    @Override
    protected DBQuery genSqlQuery(CfgModule params) {
        CriteriaQuery q = (CriteriaQuery) super.genSqlQuery(params);
        Criteria c = q.createAndCriteria();

        if(StringUtils.isNotBlank(params.getMdlName())){
            c.like(CfgModule.TF.mdlName, "%" + params.getMdlName() + "%");
        }

        // 启用、禁用
        if(StringUtils.isNotBlank(params.getMdlStatus())){
            c.equalTo(CfgModule.TF.mdlStatus, params.getMdlStatus());
        }

        return q;
    }

    /**
     * 查询方案的模块
     * @param schmId
     * @return
     */
    public List<Map> queryBySchmId(String schmId){
        return cfgModuleDao.queryBySchmId(schmId);
    }

    /**
     * 查询行业方案未选中的模块
     * @param schmId
     * @return
     */
    public List<CfgModule> queryUnSelMdlBySchmId(String schmId){
        return cfgModuleDao.queryUnSelMdlBySchmId(schmId);
    }
}
