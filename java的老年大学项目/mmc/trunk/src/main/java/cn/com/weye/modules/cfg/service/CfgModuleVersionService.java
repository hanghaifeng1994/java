package cn.com.weye.modules.cfg.service;

import cn.com.weye.modules.cfg.dao.CfgModuleDao;
import cn.com.weye.modules.cfg.entity.CfgModule;
import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.impl.Criteria;
import cn.com.weye.core.persistence.mybatis.impl.CriteriaQuery;
import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.modules.cfg.dao.CfgModuleVersionDao;
import cn.com.weye.modules.cfg.entity.CfgModuleVersion;
import cn.com.weye.tools.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author zpzxskxsk@126.com
 */
@Service
public class CfgModuleVersionService extends MybatisBaseService<CfgModuleVersion> {

    @Resource
    private CfgModuleVersionDao cfgModuleVersionDao;

    @Autowired
    private CfgModuleDao cfgModuleDao;

    @Override
    public String getTableName() {
        return ConfigUtils.getValue("schema.interPlat") + ".CFG_MODULE_VERSION";
    }

    @Override
    public String getIdKey() {
        return "mdlVerId";
    }

    @Override
    public MybatisBaseDao<CfgModuleVersion> getDao() {
        return cfgModuleVersionDao;
    }
    
    @Override
    protected boolean isLogicDelete(){
        return false;
    }

    @Override
    protected DBQuery genSqlQuery(CfgModuleVersion params) {
        CriteriaQuery q = (CriteriaQuery)super.genSqlQuery(params);
        Criteria c = q.createAndCriteria();
        if(StringUtils.isNotBlank(params.getMdlId())){
            c.equalTo(CfgModuleVersion.TF.mdlId, params.getMdlId());
        }
        return q;
    }

    /**
     * 添加版本，修改模块的编码、及名称
     */
    public void addVersion(CfgModuleVersion entity){
        CfgModule mdl = cfgModuleDao.queryById(entity.getMdlId());
        long verCode = (mdl.getMdlVerCode()==null ? 0 : mdl.getMdlVerCode())+1l;

        entity.setMdlVerCode(verCode);
        entity.setMdlName(mdl.getMdlName());
        super.save(entity);

        CfgModule nMdl = new CfgModule();
        nMdl.setMdlId(entity.getMdlId());
        nMdl.setMdlVerCode(verCode);
        nMdl.setMdlVerName(entity.getMdlVerName());
        nMdl.setMdlVerId(entity.getMdlVerId());
        cfgModuleDao.updateByIdSelective(nMdl);
    }


}
