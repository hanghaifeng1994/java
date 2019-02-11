package cn.com.weye.modules.cfg.service;

import cn.com.weye.cons.WeyeCons;
import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.impl.Criteria;
import cn.com.weye.core.persistence.mybatis.impl.CriteriaQuery;
import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.modules.cfg.dao.CfgAppletVersionDao;
import cn.com.weye.modules.cfg.dao.CfgSchemeEditionDao;
import cn.com.weye.modules.cfg.dao.CfgSchemeEditionHisDao;
import cn.com.weye.modules.cfg.dao.CfgSchemeEditionUpdateInfoDao;
import cn.com.weye.modules.cfg.entity.CfgAppletVersion;
import cn.com.weye.modules.cfg.entity.CfgSchemeEdition;
import cn.com.weye.modules.cfg.entity.CfgSchemeEditionHis;
import cn.com.weye.modules.cfg.entity.CfgSchemeEditionUpdateInfo;
import cn.com.weye.modules.cfg.vo.CfgSchemeEditionUpdateInfoVo;
import cn.com.weye.tools.common.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author zpzxskxsk@126.com
 */
@Service
public class CfgSchemeEditionUpdateInfoService extends MybatisBaseService<CfgSchemeEditionUpdateInfo> {

    @Resource
    private CfgSchemeEditionUpdateInfoDao cfgSchemeEditionUpdateInfoDao;

    @Resource
    private CfgSchemeEditionDao cfgSchemeEditionDao;
    @Resource
    private CfgSchemeEditionHisDao cfgSchemeEditionHisDao;

    @Resource
    private CfgAppletVersionDao cfgAppletVersionDao;

    @Override
    public String getTableName() {
        return ConfigUtils.getValue("schema.interPlat") + ".CFG_SCHEME_EDITION_UPDATE_INFO";
    }

    @Override
    public String getIdKey() {
        return "edtUpId";
    }

    @Override
    public MybatisBaseDao<CfgSchemeEditionUpdateInfo> getDao() {
        return cfgSchemeEditionUpdateInfoDao;
    }
    
    @Override
    protected boolean isLogicDelete(){
        return false;
    }

    public int add(CfgSchemeEditionUpdateInfo params, WeyeCons.CFG_SCHEME_EDITION_UPDATE_INFO_TYPE type){

        // 修改方案版本编码
        CfgSchemeEdition edt = new CfgSchemeEdition();
        edt.setSchmEdtId(params.getSchmEdtId());
        edt.setSchmEdtCode(params.getSchmEdtCode());
        cfgSchemeEditionDao.updateByIdSelective(edt);

        // 修改方案版本历史状态
        if(type == WeyeCons.CFG_SCHEME_EDITION_UPDATE_INFO_TYPE.BB){
            CfgSchemeEditionHis his = new CfgSchemeEditionHis();
            his.setSchmEdtHisId(params.getEdtUpObjId());
            his.setSchmEdtHisStatus("1");
            cfgSchemeEditionHisDao.updateByIdSelective(his);
        }else if(type == WeyeCons.CFG_SCHEME_EDITION_UPDATE_INFO_TYPE.XCY){
            CfgAppletVersion ver = new CfgAppletVersion();
            ver.setApltVerId(params.getEdtUpObjId());
            ver.setApltVerStatus("1");
            cfgAppletVersionDao.updateByIdSelective(ver);
        }
        return super.save(params);
    }

    @Override
    protected DBQuery genSqlQuery(CfgSchemeEditionUpdateInfo params, String mainTableAs) {
        CriteriaQuery q = (CriteriaQuery)super.genSqlQuery(params, mainTableAs);

        String as = mainTableAs == null? "" : mainTableAs + ".";
        q.addOrder(as + CfgSchemeEditionUpdateInfo.TF.createDate, false);
        if(params == null)
            return q;
        Criteria c = q.createAndCriteria();
        if(StringUtils.isNotBlank(params.getSchmEdtId())) {
            c.equalTo(as + CfgSchemeEditionUpdateInfo.TF.schmEdtId, params.getSchmEdtId());
        }
        if(StringUtils.isNotBlank(params.getEdtUpType())){
            c.equalTo(as + CfgSchemeEditionUpdateInfo.TF.edtUpType, params.getEdtUpType());
        }
        return q;
    }

    public Page<CfgSchemeEditionUpdateInfoVo> queryExtPage(CfgSchemeEditionUpdateInfo params, Page<CfgSchemeEditionUpdateInfoVo> page){
        DBQuery q = genSqlQuery(params, "u");
        if(null != page)
            q.setPage(page);

        cfgSchemeEditionUpdateInfoDao.queryByCriteriaExt(q);
        return page;
    }
}
