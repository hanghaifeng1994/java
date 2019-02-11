package cn.com.weye.modules.cfg.service;

import cn.com.weye.cons.WeyeCons;
import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.impl.Criteria;
import cn.com.weye.core.persistence.mybatis.impl.CriteriaQuery;
import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.modules.cfg.dao.CfgSchemeEditionDao;
import cn.com.weye.modules.cfg.dao.CfgSchmEdtPackageDao;
import cn.com.weye.modules.cfg.entity.CfgSchemeEdition;
import cn.com.weye.modules.cfg.entity.CfgSchemeEditionExt;
import cn.com.weye.modules.cfg.entity.CfgSchmEdtPackage;
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
public class CfgSchemeEditionService extends MybatisBaseService<CfgSchemeEdition> {

    @Resource
    private CfgSchemeEditionDao cfgSchemeEditionDao;
    @Resource
    private CfgSchmEdtPackageService cfgSchmEdtPackageService;

    @Override
    public String getTableName() {
        return ConfigUtils.getValue("schema.interPlat") + ".CFG_SCHEME_EDITION";
    }

    @Override
    public String getIdKey() {
        return "schmEdtId";
    }

    @Override
    public MybatisBaseDao<CfgSchemeEdition> getDao() {
        return cfgSchemeEditionDao;
    }
    
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    @Override
    protected DBQuery genSqlQuery(CfgSchemeEdition params) {
        CriteriaQuery q = (CriteriaQuery)super.genSqlQuery(params);
        Criteria c = q.createAndCriteria();

        if(StringUtils.isNotBlank(params.getSchmId())) {
            c.equalTo(CfgSchemeEdition.TF.schmId, params.getSchmId());
        }
        if(StringUtils.isNotBlank(params.getSchmEdtName())){
            c.like(CfgSchemeEdition.TF.schmEdtName, "%" + params.getSchmEdtName() + "%");
        }
        if(StringUtils.isNotBlank(params.getSchmEnableStatus())){
            c.equalTo(CfgSchemeEdition.TF.schmEnableStatus, params.getSchmEnableStatus());
        }if(StringUtils.isNotBlank(params.getSchmEdtStatus())){
            c.equalTo(CfgSchemeEdition.TF.schmEdtStatus,params.getSchmEdtStatus());
        }
        q.addOrder(CfgSchemeEdition.TF.updateDate, false);

        return q;
    }

    /**
     * 更新方案版本状态
     * @param id
     * @param status
     * @return
     */
    public int updateStatus(String id, String status){
        CfgSchemeEdition o = new CfgSchemeEdition();
        o.setSchmEdtId(id);
        o.setSchmEdtStatus(status);
        return cfgSchemeEditionDao.updateByIdSelective(o);
    }

    /**
     * 更新可用状态
     * @param id
     * @param status
     * @return
     */
    public int updateEnableStatus(String id, String status){
        CfgSchemeEdition o = new CfgSchemeEdition();
        o.setSchmEdtId(id);
        o.setSchmEnableStatus(status);
        return cfgSchemeEditionDao.updateByIdSelective(o);
    }

    /**
     * 添加功能
     * @param id
     * @param pkgList
     * @return
     */
    public int addPkg(String id, List<CfgSchmEdtPackage> pkgList){
        return cfgSchmEdtPackageService.addEditPkg4Batch(pkgList);
    }

    /**
     * 查询全用小程序的版本列表
     * @param apltId
     * @return
     */
    public List<CfgSchemeEdition> queryApletEditionList(String apltId){
        return cfgSchemeEditionDao.queryApletEditionList(apltId);
    }

    /**
     * 保存选择的小程序
     * @return
     */
    public int addApltList(String schmEdtId, String apltIds[]){
        // 删除选择的小程序
        cfgSchemeEditionDao.deleteAplt(schmEdtId);
        // 添加选择的小程序
        Map params = new HashMap();
        params.put("schmEdtId", schmEdtId);
        params.put("apltIds", apltIds);
        return cfgSchemeEditionDao.insertAplt(params);
    }
    public List<CfgSchemeEditionExt> queryAllSchemeByCriteriaExt(){
        return cfgSchemeEditionDao.queryAllSchemeByCriteriaExt();
    }

}
