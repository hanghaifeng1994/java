package cn.com.weye.modules.cfg.service;

import cn.com.weye.cons.WeyeCons;
import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.core.utils.overDue.OverDueUtils;
import cn.com.weye.modules.cfg.dao.CfgAppletDao;
import cn.com.weye.modules.cfg.dao.CfgAppletVersionDao;
import cn.com.weye.modules.cfg.entity.CfgApplet;
import cn.com.weye.modules.cfg.entity.CfgAppletVersion;
import cn.com.weye.modules.cfg.vo.CfgAppletVersionVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author zpzxskxsk@126.com
 */
@Service
public class CfgAppletVersionService extends MybatisBaseService<CfgAppletVersion> {

    @Resource
    private CfgAppletVersionDao cfgAppletVersionDao;

    @Resource
    private CfgAppletDao cfgAppletDao;

    @Override
    public String getTableName() {
        return ConfigUtils.getValue("schema.interPlat") + ".CFG_APPLET_VERSION";
    }

    @Override
    public String getIdKey() {
        return "apltVerId";
    }

    @Override
    public MybatisBaseDao<CfgAppletVersion> getDao() {
        return cfgAppletVersionDao;
    }
    
    @Override
    protected boolean isLogicDelete(){
        return false;
    }

    @Override
    protected DBQuery genSqlQuery(CfgAppletVersion params, String mainTableAs) {
        return super.genSqlQuery(params, mainTableAs);
    }

    public int add(CfgAppletVersion param){

        super.save(param);

        // 添加定时任务
        OverDueUtils.add("CFG_APPLET_VERSION_ONLINE"
                , param.getApltVerAutoOnline().equals("1")? "1" : "0"
                , param.getApltVerId());

        // 修改小程序的版本编码、最新版本id
        CfgApplet aplet = new CfgApplet();
        aplet.setApltId(param.getApltId());;
        aplet.setApltVerCode(param.getApltVerCode());
        aplet.setApltVerId(param.getApltVerId());

        cfgAppletDao.updateByIdSelective(aplet);
        return 1;
    }

    public Page<CfgAppletVersionVo> queryExtPage(CfgAppletVersion params, Page<CfgAppletVersionVo> page){
        DBQuery q = genSqlQuery(params, "a");
        if(null != page)
            q.setPage(page);

        cfgAppletVersionDao.queryByCriteriaExt(q);
        return page;
    }
}
