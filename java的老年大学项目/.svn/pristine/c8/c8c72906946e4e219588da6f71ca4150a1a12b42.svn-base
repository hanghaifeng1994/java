package cn.com.weye.modules.cfg.service;

import cn.com.weye.cons.WeyeCons;
import cn.com.weye.core.exception.CannotDeleteException;
import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.impl.Criteria;
import cn.com.weye.core.persistence.mybatis.impl.CriteriaQuery;
import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.modules.cfg.dao.CfgSchemeEditionDao;
import cn.com.weye.modules.cfg.dao.CfgSchmEdtPackageDao;
import cn.com.weye.modules.cfg.entity.CfgSchemeEdition;
import cn.com.weye.modules.cfg.entity.CfgSchemeEditionPrice;
import cn.com.weye.modules.cfg.entity.CfgSchmEdtPackage;
import cn.com.weye.modules.cfg.entity.CfgSchmEdtPackageExt;
import cn.com.weye.tools.common.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zpzxskxsk@126.com
 */
@Service
public class CfgSchmEdtPackageService extends MybatisBaseService<CfgSchmEdtPackage> {

    @Resource
    private CfgSchmEdtPackageDao cfgSchmEdtPackageDao;

    @Resource
    private CfgSchemeEditionDao cfgSchemeEditionDao;

    @Override
    public String getTableName() {
        return ConfigUtils.getValue("schema.interPlat") + ".CFG_SCHM_EDT_PACKAGE";
    }

    @Override
    public String getIdKey() {
        return "edtPkgId";
    }

    @Override
    public MybatisBaseDao<CfgSchmEdtPackage> getDao() {
        return cfgSchmEdtPackageDao;
    }
    
    @Override
    protected boolean isLogicDelete(){
        return false;
    }

    @Override
    protected DBQuery genSqlQuery(CfgSchmEdtPackage params, String mainTableAs) {
        CriteriaQuery q = (CriteriaQuery)super.genSqlQuery(params, mainTableAs);

        String as = mainTableAs == null? "" : mainTableAs + ".";
        Criteria c = q.createAndCriteria();
        if(StringUtils.isNotBlank(params.getSchmEdtId())){
            c.equalTo(as + CfgSchmEdtPackage.TF.schmEdtId, params.getSchmEdtId());
        }
        if(StringUtils.isNotBlank(params.getPkgId())){
            c.equalTo(as + CfgSchmEdtPackage.TF.pkgId, params.getPkgId());
        }if(StringUtils.isNotBlank(params.getSchmEdtId())){
            c.equalTo(as +CfgSchmEdtPackage.TF.schmEdtId,params.getSchmEdtId());
            c.equalTo(as +CfgSchmEdtPackage.TF.edtPkgType,"1");
        }

        return q;
    }

    public List<CfgSchmEdtPackageExt> queryExtList(CfgSchmEdtPackage params) {
        CriteriaQuery q = (CriteriaQuery)genSqlQuery(params, "p");
//        Criteria c = q.createAndCriteria();
//        c.equalTo()
        return cfgSchmEdtPackageDao.queryByCriteriaExt(q);
    }
    /**
     * 查询方案版本对应模块所有功能包
     * @param schmEdtId
     * @return
     */
    public List<CfgSchmEdtPackageExt> querySchmEditFuncPkg(String schmEdtId){
        return cfgSchmEdtPackageDao.querySchmEditFuncPkg(schmEdtId);
    }

    /**
     * 查询方案版本未选的功能包
     * @param schmId
     * @param schmEdtId
     * @return
     */
    public List<CfgSchmEdtPackageExt> querySchmEdtUnSelPkg(String schmId, String schmEdtId){
        Map params = new HashMap();
        params.put("schmId", schmId);
        params.put("schmEdtId", schmEdtId);
        return cfgSchmEdtPackageDao.querySchmEdtUnSelPkg(params);
    }

    /**
     * 保存功能包，更新方案版本修改状态
     * @param cfgSchmEdtPackage
     * 版本id必须存在
     * @return
     */
    public int savePkg_upEditStatus(CfgSchmEdtPackage cfgSchmEdtPackage, boolean upEditStatus){
        if(upEditStatus){
            // 修改方案版本的修改状态
            CfgSchemeEdition schm = cfgSchemeEditionDao.queryById(cfgSchmEdtPackage.getSchmEdtId());
            String ss = schm.getSchmEdtModStatus();
            String editStatus = WeyeCons.CFG_SCHEME_EDITION_MOD_STATUS.PKG.getVal();
            if(StringUtils.isNumber(ss)){
                int dd = Integer.parseInt(ss);
                dd = dd | 2;
                editStatus = String.valueOf(dd);
            }

            CfgSchemeEdition edit = new CfgSchemeEdition();
            edit.setSchmEdtId(schm.getSchmEdtId());
            edit.setSchmEdtModStatus(editStatus);
            cfgSchemeEditionDao.updateByIdSelective(edit);
        }
        return super.save(cfgSchmEdtPackage);
    }

    /**
     * 批量添加功能包
     * @param pkgList
     * @return
     */
    public int addEditPkg4Batch(List<CfgSchmEdtPackage> pkgList){
        int n = 0;
//        CfgSchmEdtPackageDao edtPkgDao = batchSqlSessionTemplate.getMapper(CfgSchmEdtPackageDao.class);
        for (int i=0; i<pkgList.size(); i++){
            /*Date nowDate = new Date();
            String curUserCode = null;
            try{// 没有登录会有异常 // zhangpz 20171124
                if(null != currentUserInfo) {
                    curUserCode = currentUserInfo.getId();
                }
            }catch (Exception e){}
            updateUpdateEntity(pkg,nowDate, curUserCode);

            String id = genId();
            pkg.setEdtPkgId(id);
            updateCreateEntity(pkg, nowDate, curUserCode);

            n += edtPkgDao.insert(pkg);*/
            CfgSchmEdtPackage pkg = pkgList.get(i);
            n += savePkg_upEditStatus(pkg, false);
        }
        return n;
    }

    @Override
    public int deleteById(Object params) throws CannotDeleteException {
        /*CfgSchmEdtPackage entity = queryById(params);

        // 修改方案版本的修改状态
        CfgSchemeEdition schm = cfgSchemeEditionDao.queryById(entity.getSchmEdtId());
        String ss = schm.getSchmEdtModStatus();
        String editStatus = WeyeCons.CFG_SCHEME_EDITION_MOD_STATUS.PKG.getVal();
        if(StringUtils.isNumber(ss)){
            int dd = Integer.parseInt(ss);
            dd = dd | 2;
            editStatus = String.valueOf(dd);
        }
        CfgSchemeEdition edit = new CfgSchemeEdition();
        edit.setSchmEdtId(schm.getSchmEdtId());
        edit.setSchmEdtModStatus(editStatus);
        cfgSchemeEditionDao.updateByIdSelective(edit);*/

        return super.deleteById(params);
    }

    public int updateStatus(String edtPkgId, String status){
        CfgSchmEdtPackage entity = queryById(edtPkgId);

        // 修改方案版本的修改状态
        CfgSchemeEdition schm = cfgSchemeEditionDao.queryById(entity.getSchmEdtId());
        String ss = schm.getSchmEdtModStatus();
        String editStatus = WeyeCons.CFG_SCHEME_EDITION_MOD_STATUS.PKG.getVal();
        if(StringUtils.isNumber(ss)){
            int dd = Integer.parseInt(ss);
            dd = dd | 2;
            editStatus = String.valueOf(dd);
        }
        CfgSchemeEdition edit = new CfgSchemeEdition();
        edit.setSchmEdtId(schm.getSchmEdtId());
        edit.setSchmEdtModStatus(editStatus);
        cfgSchemeEditionDao.updateByIdSelective(edit);

        CfgSchmEdtPackage pkg = new CfgSchmEdtPackage();
        pkg.setEdtPkgId(edtPkgId);
        pkg.setEdtPkgStatus(status);
        return cfgSchmEdtPackageDao.updateByIdSelective(pkg);
    }

    /**
     * 根据方案版本id 查询增值包
     * @param
     * @return
     */
    public List<CfgSchmEdtPackageExt> queryPkNameByCriteriaExt(String schmEdtId){
        CfgSchmEdtPackage c=new CfgSchmEdtPackage();
        c.setSchmEdtId(schmEdtId);
        DBQuery q = genSqlQuery(c, "p");
       return cfgSchmEdtPackageDao.queryByCriteriaExt(q);
    }
    /**
     * 根据pkgId数组查询增值包费用
     */
    public BigDecimal getPkPrice(Map<String,Object> map){

        return cfgSchmEdtPackageDao.getPkPrice(map);
    }
}
