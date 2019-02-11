package cn.com.weye.modules.sh.service;

import cn.com.weye.core.exception.CannotDeleteException;
import cn.com.weye.core.persistence.mybatis.impl.Criteria;
import cn.com.weye.core.persistence.mybatis.impl.CriteriaQuery;
import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.modules.cfg.entity.CfgAddedService;
import cn.com.weye.modules.cfg.service.CfgAddedServiceService;
import cn.com.weye.modules.sh.dao.ShOrderAddserviceRelDao;
import cn.com.weye.modules.sh.entity.ShMerchantScheme;
import cn.com.weye.modules.sh.entity.ShMerchantSchemeExt;
import cn.com.weye.modules.sh.entity.ShOrderAddserviceRel;
import cn.com.weye.modules.sh.entity.ShOrderPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author yl
 */
@Service
public class ShOrderAddserviceRelService extends MybatisBaseService<ShOrderAddserviceRel> {

    @Resource
    private ShOrderAddserviceRelDao shOrderAddserviceRelDao;

    @Override
    public String getTableName() {
        return ConfigUtils.getValue("schema.interPlat") + ".SH_ORDER_ADDSERVICE_REL";
    }

    @Override
    public String getIdKey() {
        return "asId";
    }
    @Autowired
    public   CfgAddedServiceService  cfgAddedServiceService;

    @Override
    public MybatisBaseDao<ShOrderAddserviceRel> getDao() {
        return shOrderAddserviceRelDao;
    }
    
    @Override
    protected boolean isLogicDelete(){
        return false;
    }

    public void saveOrderAdded(ShMerchantSchemeExt entity , String orderId) throws CannotDeleteException {
        ShOrderAddserviceRel s=new ShOrderAddserviceRel();
            s.setOrdId(orderId);
         if(entity.getAsId()!=null){
             String[] asIds=entity.getAsId().split(",");
             for (String asId:asIds){
                 s.setAsId(asId);
                 CfgAddedService cfgAddedService=cfgAddedServiceService.queryById(asId);
                 s.setAsPrice(cfgAddedService.getAsPrice());
                 super.save(s);
             }
         }
    }
}
