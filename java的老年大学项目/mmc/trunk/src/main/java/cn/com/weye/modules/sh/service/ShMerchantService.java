package cn.com.weye.modules.sh.service;

import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.impl.Criteria;
import cn.com.weye.core.persistence.mybatis.impl.CriteriaQuery;
import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.modules.sh.dao.ShMerchantDao;
import cn.com.weye.modules.sh.entity.ShMerchant;
import com.thinkgem.jeesite.common.utils.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author yl
 */
@Service
public class ShMerchantService extends MybatisBaseService<ShMerchant> {

    @Resource
    private ShMerchantDao shMerchantDao;

    @Override
    public String getTableName() {
        return ConfigUtils.getValue("schema.interPlat") + ".SH_MERCHANT";
    }

    @Override
    public String getIdKey() {
        return "mchtId";
    }

    @Override
    public MybatisBaseDao<ShMerchant> getDao() {
        return shMerchantDao;
    }
    
    @Override
    protected boolean isLogicDelete(){
        return true;
    }
    @Override
    protected DBQuery genSqlQuery(ShMerchant params, String mainTableAs) {
        String as = mainTableAs == null ? "" : mainTableAs + ".";
        CriteriaQuery c = new CriteriaQuery();
        if (this.isLogicDelete()) {
            c.createAndCriteria().equalTo(as + "DEL_FLAG", "0");
        }
        if(StringUtils.isNotBlank(params.getMchtStatus())){
            c.createAndCriteria().equalTo(ShMerchant.TF.mchtStatus,params.getMchtStatus());
        }
        return c;
    }

    public int startOrForbiddenUse(ShMerchant entry){
        //若是禁用状态执行启用语句，若是启用状态执行禁用语句
        return shMerchantDao.startOrForbiddenUse(entry);
    }

    public Page<ShMerchant> queryExtPage(ShMerchant params, Page<ShMerchant> page){

        CriteriaQuery q = new CriteriaQuery();
        Criteria c = q.createAndCriteria();
        if(StringUtils.isNotBlank(params.getMchtName())){
            c.like(ShMerchant.TF.mchtName,params.getMchtName());
        }
        if(StringUtils.isNotBlank(params.getClientManagerId())){
            c.equalTo(ShMerchant.TF.clientManagerId,params.getClientManagerId());
        }
        if(null != page){
            q.setPage(page);
        }
        shMerchantDao.queryByCriteriaExt(q);
        return page;
    }

}
