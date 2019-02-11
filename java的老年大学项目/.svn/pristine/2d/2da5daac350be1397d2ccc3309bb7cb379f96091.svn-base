package cn.com.weye.modules.cfg.service;

import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.impl.Criteria;
import cn.com.weye.core.persistence.mybatis.impl.CriteriaQuery;
import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.modules.cfg.dao.CfgSchmEdtPackageHisDao;
import cn.com.weye.modules.cfg.entity.CfgSchmEdtPackageHis;
import cn.com.weye.tools.common.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author zpzxskxsk@126.com
 */
@Service
public class CfgSchmEdtPackageHisService extends MybatisBaseService<CfgSchmEdtPackageHis> {

    @Resource
    private CfgSchmEdtPackageHisDao cfgSchmEdtPackageHisDao;

    @Override
    public String getTableName() {
        return ConfigUtils.getValue("schema.interPlat") + ".CFG_SCHM_EDT_PACKAGE_HIS";
    }

    @Override
    public String getIdKey() {
        return "edtPkgHisId";
    }

    @Override
    public MybatisBaseDao<CfgSchmEdtPackageHis> getDao() {
        return cfgSchmEdtPackageHisDao;
    }
    
    @Override
    protected boolean isLogicDelete(){
        return false;
    }

    @Override
    protected DBQuery genSqlQuery(CfgSchmEdtPackageHis params) {
        CriteriaQuery q = (CriteriaQuery)super.genSqlQuery(params);
        if(null == params)
            return q;
        Criteria c = q.createAndCriteria();
        if(StringUtils.isNotBlank(params.getSchmEdtHisId())){
            c.equalTo(CfgSchmEdtPackageHis.TF.schmEdtHisId, params.getSchmEdtHisId());
        }
        return q;
    }
}
