package cn.com.weye.modules.cfg.service;

import cn.com.weye.cons.WeyeCons;
import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.impl.Criteria;
import cn.com.weye.core.persistence.mybatis.impl.CriteriaQuery;
import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.modules.cfg.dao.CfgSchemeEditionDao;
import cn.com.weye.modules.cfg.dao.CfgSchemeEditionHisDao;
import cn.com.weye.modules.cfg.entity.*;
import cn.com.weye.modules.sh.entity.ShMerchantScheme;
import cn.com.weye.tools.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zpzxskxsk@126.com
 */
@Service
public class CfgSchemeEditionHisService extends MybatisBaseService<CfgSchemeEditionHis> {

    @Resource
    private CfgSchemeEditionHisDao cfgSchemeEditionHisDao;

    @Resource
    private CfgSchemeEditionDao cfgSchemeEditionDao;

    @Autowired
    private CfgSchmEdtPackageService cfgSchmEdtPackageService;
    @Autowired
    private CfgSchmEdtPackageHisService cfgSchmEdtPackageHisService;

    @Override
    public String getTableName() {
        return ConfigUtils.getValue("schema.interPlat") + ".CFG_SCHEME_EDITION_HIS";
    }

    @Override
    public String getIdKey() {
        return "schmEdtHisId";
    }

    @Override
    public MybatisBaseDao<CfgSchemeEditionHis> getDao() {
        return cfgSchemeEditionHisDao;
    }
    
    @Override
    protected boolean isLogicDelete(){
        return false;
    }

    @Override
    protected DBQuery genSqlQuery(CfgSchemeEditionHis params) {
        CriteriaQuery q = (CriteriaQuery)super.genSqlQuery(params);
        Criteria c = q.createAndCriteria();
        if(StringUtils.isNotBlank(params.getSchmEdtId())){
            c.equalTo(CfgSchemeEditionHis.TF.schmEdtId, params.getSchmEdtId());
        }
        if(StringUtils.isNotBlank(params.getSchmEdtName())){
            c.like(CfgSchemeEditionHis.TF.schmEdtName, "%" + params.getSchmEdtName()+
                    "%");
        }
        q.addOrder(CfgSchemeEditionHis.TF.createDate, false);
        return q;
    }

    /**
     * 添加版本历史
     * @param entity
     */
    public void addHis(CfgSchemeEditionHis entity){
        CfgSchemeEdition edition = cfgSchemeEditionDao.queryById(entity.getSchmEdtId());
        // 记得增加级别
        Long grade = edition.getSchmEdtGrade();
        CfgSchemeEdition edt = new CfgSchemeEdition();
        edt.setSchmEdtId(edition.getSchmEdtId());
        edt.setSchmEdtGrade(grade==null?0l:++grade);
        edt.setSchmEdtModStatus("0");

        entity.setSchmEdtGrade(edt.getSchmEdtGrade());
        entity.setSchmEdtName(edition.getSchmEdtName());
        entity.setSchmEdtDesc(edition.getSchmEdtDesc());
        entity.setSchmEdtPhoto(edition.getSchmEdtPhoto());
        entity.setSchmId(edition.getSchmId());
        entity.setSchmEdtModStatus(edition.getSchmEdtModStatus());
        entity.setSchmEdtHisStatus("0");
        save(entity);

        // 添加历史id
        edt.setSchmEdtHisId(entity.getSchmEdtHisId());
        cfgSchemeEditionDao.updateByIdSelective(edt);

        // 功能包也要添加到历史表中
        // 查询方案版本功能包
        List<CfgSchmEdtPackageExt> pkgList = cfgSchmEdtPackageService.querySchmEditFuncPkg(edition.getSchmEdtId());
        for (CfgSchmEdtPackageExt it : pkgList){
            if(!WeyeCons.CFG_SCHM_EDT_PACKAGE_STATUS.ENABLE.getVal().equals(it.getEdtPkgStatus()))
                continue;

            CfgSchmEdtPackageHis h = new CfgSchmEdtPackageHis();
            h.setEdtPkgId(it.getEdtPkgId());
            h.setPkgId(it.getPkgId());
            h.setPkgName(it.getPkgName());
            h.setSchmEdtHisId(entity.getSchmEdtHisId());
            h.setEdtPkgType(it.getEdtPkgType());
            h.setEdtPkgYearPrice(it.getEdtPkgYearPrice());
            h.setEdtPkgMonthPrice(it.getEdtPkgMonthPrice());
            h.setMdlId(it.getMdlId());
            h.setMdlName(it.getMdlName());
            cfgSchmEdtPackageHisService.save(h);
        }

    }

    /**
     * 根据商户方案id 查询出商户历史方案id 及历史价格id
     * @param entity
     * @return
     */
    public Map<String,Object> queryByHisId(ShMerchantScheme entity){
        return cfgSchemeEditionHisDao.queryByHisId(entity);
    }
}
