package cn.com.weye.modules.cfg.service;

import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.impl.Criteria;
import cn.com.weye.core.persistence.mybatis.impl.CriteriaQuery;
import cn.com.weye.core.utils.ConfigEnum;
import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.modules.cfg.dao.CfgFunctionPackageDao;
import cn.com.weye.modules.cfg.entity.CfgFunctionPackage;
import cn.com.weye.modules.cfg.entity.CfgFunctionPackageExt;
import cn.com.weye.tools.common.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zpzxskxsk@126.com
 */
@Service
public class CfgFunctionPackageService extends MybatisBaseService<CfgFunctionPackage> {

    @Resource
    private CfgFunctionPackageDao cfgFunctionPackageDao;



    @Override
    public String getTableName() {
        return ConfigUtils.getValue("schema.interPlat") + ".CFG_FUNCTION_PACKAGE";
    }

    @Override
    public String getIdKey() {
        return "pkgId";
    }

    @Override
    public MybatisBaseDao<CfgFunctionPackage> getDao() {
        return cfgFunctionPackageDao;
    }
    
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    @Override
    protected DBQuery genSqlQuery(CfgFunctionPackage params) {
        CriteriaQuery q = (CriteriaQuery)super.genSqlQuery(params);
        Criteria c = q.createAndCriteria();

        if (StringUtils.isNotBlank(params.getMdlId())){
            c.equalTo(CfgFunctionPackage.TF.mdlId, params.getMdlId());
        }
        if(StringUtils.isNotBlank(params.getPkgName())){
            c.like(CfgFunctionPackage.TF.pkgName, "%" + params.getPkgName() +"%");
        }
        return q;
    }

    /**
     * 查询功能包+模块
     * @param params
     * @param page
     * @return
     */
    public Page<CfgFunctionPackageExt> queryExtPage(CfgFunctionPackage params, Page<CfgFunctionPackageExt> page){

        CriteriaQuery q = new CriteriaQuery();
        Criteria c = q.createAndCriteria();
        if(isLogicDelete()){
            c.equalTo("p." + ConfigEnum.FIELD_DEL_FLAG, ConfigEnum.DEL_FLAG_NORMAL);
        }

        if (StringUtils.isNotBlank(params.getMdlId())){
            c.equalTo("p." + CfgFunctionPackage.TF.mdlId, params.getMdlId());
        }
        if(StringUtils.isNotBlank(params.getPkgName())){
            c.like("p." + CfgFunctionPackage.TF.pkgName, "%" + params.getPkgName() +"%");
        }
        if(null != page)
            q.setPage(page);

        cfgFunctionPackageDao.queryByCriteriaExt(q);
        return page;
    }

    /**
     * 保存功能包功能
     * @param pkgId
     * @param funcList
     */
    public void savePkgFunc(String pkgId, List<String> funcList){
        cfgFunctionPackageDao.deletePkgFunc(pkgId);
        Map pp = new HashMap();
        pp.put("pkgId", pkgId);
        pp.put("funcIds", funcList);
        cfgFunctionPackageDao.insertPkgFunc(pp);
    }

    public int updateStatus(String id, String status){
        CfgFunctionPackage pkg = new CfgFunctionPackage();
        pkg.setPkgId(id);
        pkg.setPkgStatus(status);
        return cfgFunctionPackageDao.updateByIdSelective(pkg);
    }
    public List<CfgFunctionPackageExt> getPkQueryByOrdId(String OrdId){
        CriteriaQuery q = new CriteriaQuery();
        Criteria c = q.createAndCriteria();
        if(StringUtils.isNotBlank(OrdId)){
            c.equalTo("s.ORD_ID",OrdId);
        }
        return cfgFunctionPackageDao.getPkQueryByOrdId(q);

    }


}
