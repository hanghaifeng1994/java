package cn.com.weye.modules.sh.service;

import cn.com.weye.cons.WeyeCons;
import cn.com.weye.core.consts.ICons;
import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.impl.Criteria;
import cn.com.weye.core.persistence.mybatis.impl.CriteriaQuery;
import cn.com.weye.core.service.TimeExpiresService;
import cn.com.weye.core.utils.ConfigEnum;
import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.core.utils.overDue.OverDueUtils;
import cn.com.weye.modules.cfg.entity.CfgApplet;
import cn.com.weye.modules.cfg.service.CfgAppletService;
import cn.com.weye.modules.sh.dao.ShAppletSettingDao;
import cn.com.weye.modules.sh.entity.ShAppletSetting;
import cn.com.weye.modules.sh.entity.ShAppletSettingExt;
import cn.com.weye.modules.sh.entity.ShMerchantScheme;
import cn.com.weye.modules.sh.entity.ShMerchantSchemeExt;
import cn.com.weye.tools.common.MapUtil;
import cn.com.weye.tools.common.StringUtils;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zpzxskxsk@126.com
 */
@Service
public class ShAppletSettingService extends MybatisBaseService<ShAppletSetting> {

    @Resource
    private ShAppletSettingDao shAppletSettingDao;
    @Resource
    private CfgAppletService cfgAppletService;


    private TimeExpiresService timeExpiresService;

    @Override
    public String getTableName() {
        return ConfigUtils.getValue("schema.interPlat") + ".SH_APPLET_SETTING";
    }

    @Override
    public String getIdKey() {
        return "apltSetId";
    }

    @Override
    public MybatisBaseDao<ShAppletSetting> getDao() {
        return shAppletSettingDao;
    }
    
    @Override
    protected boolean isLogicDelete(){
        return true;
    }


    @Override
    protected DBQuery genSqlQuery(ShAppletSetting params, String mainTableAs) {
        String as = mainTableAs == null? "" : mainTableAs + ".";
        CriteriaQuery q = (CriteriaQuery)super.genSqlQuery(params, mainTableAs);
        if(null == params)
            return q;
        Criteria c = q.createAndCriteria();
        if(StringUtils.isNotBlank(params.getMchtSchmId())){
            c.equalTo(as+ShAppletSetting.TF.mchtSchmId,params.getMchtSchmId());
        }
        return q;
    }
    /**
     * 保存商户方案的小程序
     * @param list
     * @param mchtSchmId
     */
    public void saveList(List<ShAppletSetting> list, String mchtSchmId){
        // 先删除所有
        /*CriteriaQuery q = new CriteriaQuery();
        q.createAndCriteria().equalTo(ShAppletSetting.TF.mchtSchmId, mchtSchmId);
        shAppletSettingDao.deleteByCriteria(q);*/

        for(ShAppletSetting it : list){
            if(it == null || it.getAppId() == null)
                continue;
            if(ConfigEnum.DEL_FLAG_NORMAL.equals(it.getDelFlag())){
                super.save(it);
            }else{
                shAppletSettingDao.deleteById(it.getAppId());
            }
        }
    }
    public List<Map> queryCodeList(ShAppletSetting params){
        Map pp = new HashMap();
        MapUtil.newMap(
                ShAppletSetting.TF.apltId, params.getApltId()
                ,ShAppletSetting.TF.apltVerId, params.getApltVerId()
        );
        return shAppletSettingDao.queryCodeList(pp);
    }
    public Page<Map> queryCodePage(ShAppletSetting params, Page<Map> page){
        Map pp = MapUtil.newMap(
                "page", page
                ,ShAppletSetting.TF.apltId, params.getApltId()
                ,ShAppletSetting.TF.apltVerId, params.getApltVerId()
        );
        shAppletSettingDao.queryCodeList(pp);
        return page;
    }

    /**
     * 手动操作小程序代码
     * 修改代码状态
     * @param apltSetId
     * @param type
     * @return
     */
    @Transactional
    public int opApletCode(String apltSetId, String verId, ICons type){
        // 状态为手动操作
        if(type != WeyeCons.SH_APPLET_SETTING_CODE_UPLOAD.SSZ
                && type != WeyeCons.SH_APPLET_SETTING_CODE_AUDIT.TJZ
                && type != WeyeCons.SH_APPLET_SETTING_CODE_PUB.TJZ
                ){
            return 0;
        }
        ShAppletSetting shAppletSetting = new ShAppletSetting();
        shAppletSetting.setApltSetId(apltSetId);

        String status = type.getVal();

        String serviceType = null;
        String params = "0";
        if(type instanceof WeyeCons.SH_APPLET_SETTING_CODE_UPLOAD){
            shAppletSetting.setAppCodeUploadStatus(status);
            serviceType = "SH_APPLET_SETTING_CODE_UPLOAD";
            params += "," + verId;
        }else if(type instanceof WeyeCons.SH_APPLET_SETTING_CODE_AUDIT){
            shAppletSetting.setAppAuditStatus(status);
            serviceType = "SH_APPLET_SETTING_CODE_UPLOAD";
        }else if (type instanceof WeyeCons.SH_APPLET_SETTING_CODE_PUB){
            shAppletSetting.setAppPubStatus(status);
            serviceType = "SH_APPLET_SETTING_CODE_PUB";
        }else {
            return 0;
        }
        // 添加过期处理
        OverDueUtils.add(serviceType, params, apltSetId, null, UserUtils.getUser().getId());
        return shAppletSettingDao.updateByIdSelective(shAppletSetting);
    }

    /**
     * 将商户方案配置的小程序插入到商户小程序配置表中
     * @param entity
     */
    public  void insertIntoShAppSet(ShMerchantScheme entity){
        //根据方案版本id查询该方案关联的小程序
        List<CfgApplet> list=cfgAppletService.queryListBySchmEdtId(entity.getSchmEdtId());
        ShAppletSetting sh=new ShAppletSetting();
        sh.setMchtId(entity.getMchtId());
        sh.setMchtSchmId(entity.getMchtSchmId());
        //将小程序插入到商户小程序配置表中
        for (CfgApplet c:list){
            sh.setApltId(c.getApltId());
            sh.setApltVerId(c.getApltVerId());
            super.save(sh);
        }
    }
    public Page<ShAppletSettingExt> queryExtPage(ShAppletSetting params, Page<ShAppletSettingExt> page){
//        queryByCriteriaExt
        DBQuery q = genSqlQuery(params, "a");
        if(null != page)
            q.setPage(page);

        shAppletSettingDao.queryByCriteriaExt(q);

        return page;
    }

}
