package cn.com.weye.modules.sh.service;

import cn.com.weye.core.exception.CannotDeleteException;
import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.impl.Criteria;
import cn.com.weye.core.persistence.mybatis.impl.CriteriaQuery;
import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.modules.cfg.entity.CfgFunctionPackage;
import cn.com.weye.modules.cfg.entity.CfgSchmEdtPackageHis;
import cn.com.weye.modules.cfg.service.CfgFunctionPackageService;
import cn.com.weye.modules.cfg.service.CfgSchmEdtPackageHisService;
import cn.com.weye.modules.sh.dao.ShOrderPackageDao;
import cn.com.weye.modules.sh.entity.ShMerchantScheme;
import cn.com.weye.modules.sh.entity.ShMerchantSchemeExt;
import cn.com.weye.modules.sh.entity.ShOrderPackage;
import com.thinkgem.jeesite.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author yl
 */
@Service
public class ShOrderPackageService extends MybatisBaseService<ShOrderPackage> {

    @Resource
    private ShOrderPackageDao shOrderPackageDao;

    @Autowired
    CfgFunctionPackageService cfgFunctionPackageService;
    @Autowired
    CfgSchmEdtPackageHisService cfgSchmEdtPackageHisService;

    @Override
    public String getTableName() {
        return ConfigUtils.getValue("schema.interPlat") + ".SH_ORDER_PACKAGE";
    }

    @Override
    public String getIdKey() {
        return "ordPkgId";
    }

    @Override
    public MybatisBaseDao<ShOrderPackage> getDao() {
        return shOrderPackageDao;
    }
    
    @Override
    protected boolean isLogicDelete(){
        return false;
    }

    public void saveOrderPackage(ShMerchantSchemeExt entity, String orderId) throws CannotDeleteException {
        if(entity.getPkgId()!=null){
            String[] pkgIds=entity.getPkgId().split(",");
            ShOrderPackage sp=new ShOrderPackage();
            CfgSchmEdtPackageHis cp=new CfgSchmEdtPackageHis();
            for(String pkgId :pkgIds){
                sp.setOrdId(orderId);
                sp.setEdtPkgHisId(pkgId);
                //根据功能包id查询功能包名称
                CfgFunctionPackage cfgFunctionPackage=cfgFunctionPackageService.queryById(pkgId);
                sp.setPkgName(cfgFunctionPackage.getPkgName());
                super.save(sp);
            }
        }
    }
}
