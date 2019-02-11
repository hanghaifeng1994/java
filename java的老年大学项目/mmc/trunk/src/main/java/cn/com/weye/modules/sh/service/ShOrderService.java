package cn.com.weye.modules.sh.service;

import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.impl.Criteria;
import cn.com.weye.core.persistence.mybatis.impl.CriteriaQuery;
import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.modules.sh.dao.ShOrderDao;
import cn.com.weye.modules.sh.entity.ShOrder;
import cn.com.weye.modules.sh.entity.ShOrderExt;
import com.thinkgem.jeesite.common.utils.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author yl
 */
@Service
public class ShOrderService extends MybatisBaseService<ShOrder> {

    @Resource
    private ShOrderDao shOrderDao;

    @Override
    public String getTableName() {
        return ConfigUtils.getValue("schema.interPlat") + ".SH_ORDER";
    }

    @Override
    public String getIdKey() {
        return "ordId";
    }

    @Override
    public MybatisBaseDao<ShOrder> getDao() {
        return shOrderDao;
    }

    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Override
    protected DBQuery genSqlQuery(ShOrder params,String  mainTableAs){
        String as = mainTableAs == null ? "" : mainTableAs + ".";
        CriteriaQuery q = (CriteriaQuery)super.genSqlQuery(params, mainTableAs);
        if(null == params)
            return q;
        Criteria c = q.createAndCriteria();
        if (StringUtils.isNotBlank(params.getOrdId())) {
            c.like("s."+ShOrder.TF.ordId,"%"+params.getOrdId()+"%");
        }
        if(StringUtils.isNotBlank(params.getMchtName())){
            c.like("m.MCHT_NAME","%"+params.getMchtName() );
        }
        if(StringUtils.isNotBlank(params.getSchmEdtHisId())){
            c.like("s."+ShOrder.TF.schmEdtHisId,"%"+params.getSchmEdtHisId()+"%");
        }
        if(StringUtils.isNotBlank(params.getOrdPayStatus())){
            c.equalTo("s."+ShOrder.TF.ordPayStatus,params.getOrdPayStatus());
        }
        if(StringUtils.isNotBlank(params.getClientManagerId())){
            c.equalTo("s."+ShOrder.TF.clientManagerId,params.getClientManagerId());
        }
        return q;
    }

    public Page<ShOrderExt> queryCriteriaExt(ShOrder params,Page<ShOrderExt> page){
        DBQuery q = genSqlQuery(params, "e");
        if(page!=null){
            q.setPage(page);
        }
        shOrderDao.queryByCriteriaExt(q);
        return  page;
    }
}
