package cn.com.weye.modules.cfg.service;

import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.impl.Criteria;
import cn.com.weye.core.persistence.mybatis.impl.CriteriaQuery;
import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.modules.cfg.dao.CfgAppletDao;
import cn.com.weye.modules.cfg.entity.CfgApplet;
import cn.com.weye.modules.cfg.vo.CfgAppletVo;
import cn.com.weye.tools.common.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author zpzxskxsk@126.com
 */
@Service
public class CfgAppletService extends MybatisBaseService<CfgApplet> {

    @Resource
    private CfgAppletDao cfgAppletDao;

    @Override
    public String getTableName() {
        return ConfigUtils.getValue("schema.interPlat") + ".CFG_APPLET";
    }

    @Override
    public String getIdKey() {
        return "apltId";
    }

    @Override
    public MybatisBaseDao<CfgApplet> getDao() {
        return cfgAppletDao;
    }
    
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    @Override
    protected DBQuery genSqlQuery(CfgApplet params, String mainTableAs) {
        String as = mainTableAs == null? "" : mainTableAs + ".";
        CriteriaQuery q = (CriteriaQuery)super.genSqlQuery(params, mainTableAs);

        if(null == params)
            return q;
        Criteria c = q.createAndCriteria();
        if(StringUtils.isNotBlank(params.getSchmId())){
            c.equalTo(as + CfgApplet.TF.schmId, params.getSchmId());
        }

        if(StringUtils.isNotBlank(params.getApltAppId())){
            c.equalTo(as + CfgApplet.TF.apltAppId, params.getApltAppId());
        }

        return q;
    }

    public Page<CfgAppletVo> queryExtPage(CfgApplet params, Page<CfgAppletVo> page){
        DBQuery q = genSqlQuery(params, "a");
        if(null != page)
            q.setPage(page);

        cfgAppletDao.queryByCriteriaExt(q);
        return page;
    }

    /**
     * 查询版本选择的小程序列表
     * @param schmEdtId
     * @return
     */
    public List<CfgApplet> queryListBySchmEdtId(String schmEdtId){
        return cfgAppletDao.queryListBySchmEdtId(schmEdtId);
    }
}
