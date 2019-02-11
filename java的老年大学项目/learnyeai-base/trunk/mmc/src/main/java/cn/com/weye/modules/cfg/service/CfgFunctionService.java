package cn.com.weye.modules.cfg.service;

import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.impl.Criteria;
import cn.com.weye.core.persistence.mybatis.impl.CriteriaQuery;
import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.modules.cfg.dao.CfgFunctionDao;
import cn.com.weye.modules.cfg.entity.CfgFunction;
import cn.com.weye.tools.common.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author zpzxskxsk@126.com
 */
@Service
public class CfgFunctionService extends MybatisBaseService<CfgFunction> {

    @Resource
    private CfgFunctionDao cfgFunctionDao;

    @Override
    public String getTableName() {
        return ConfigUtils.getValue("schema.interPlat") + ".CFG_FUNCTION";
    }

    @Override
    public String getIdKey() {
        return "funcId";
    }

    @Override
    public MybatisBaseDao<CfgFunction> getDao() {
        return cfgFunctionDao;
    }
    
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    @Override
    protected DBQuery genSqlQuery(CfgFunction params) {
        CriteriaQuery q = (CriteriaQuery) super.genSqlQuery(params);
        Criteria c = q.createAndCriteria();
        if(StringUtils.isNotBlank(params.getMdlId())){
            c.equalTo(CfgFunction.TF.mdlId, params.getMdlId());
        }
        if(StringUtils.isNotBlank(params.getFuncType())){
            c.equalTo(CfgFunction.TF.funcType, params.getFuncType());
        }

        if(StringUtils.isNotBlank(params.getParentIds())){
            c.like(CfgFunction.TF.parentIds, "%" + params.getParentIds() + "%");
        }

        q.addOrder(CfgFunction.TF.sort, true);
        return q;
    }

    @Override
    public int save(CfgFunction params) {
        CfgFunction parent = queryById(params.getParentId());
        String oldParentIds = null;
        if(StringUtils.isNotBlank(params.getFuncId())) {
            CfgFunction old = queryById(params.getFuncId());
            oldParentIds = old.getParentIds();
            if(StringUtils.isBlank(oldParentIds))
                oldParentIds = null;
        }
        String parentIds = (parent.getParentIds() == null ? "" : parent.getParentIds()) +params.getParentId()+",";
        params.setParentIds(parentIds);
        int ret = super.save(params);
        // 更新子节点
        if(null != oldParentIds && !oldParentIds.equals(parentIds)){
            CfgFunction pp = new CfgFunction();
            pp.setParentIds(oldParentIds);
            List<CfgFunction> children = queryList(pp);

            CfgFunction o = new CfgFunction();
            for(CfgFunction it: children){
                o.setFuncId(it.getFuncId());;
                o.setParentIds(it.getParentIds().replace(oldParentIds, parentIds));
                cfgFunctionDao.updateByIdSelective(o);
            }
        }

        return ret;
    }
    // 查询功能包功能
    public List<CfgFunction> queryPkgFunctionList(String pkgId){
        return cfgFunctionDao.queryPkgFunctionList(pkgId);
    }
}
