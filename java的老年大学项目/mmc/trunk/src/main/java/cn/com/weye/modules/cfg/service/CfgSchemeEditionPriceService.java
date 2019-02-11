package cn.com.weye.modules.cfg.service;

import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.mybatis.MybatisBaseDao;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.modules.cfg.dao.CfgSchemeEditionPriceDao;
import cn.com.weye.modules.cfg.entity.CfgSchemeEditionPrice;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yl.com
 */
@Service
public class CfgSchemeEditionPriceService extends MybatisBaseService<CfgSchemeEditionPrice> {

    @Resource
    private CfgSchemeEditionPriceDao cfgSchemeEditionPriceDao;

    @Override
    public String getTableName() {
        return ConfigUtils.getValue("schema.interPlat") + ".CFG_SCHEME_EDITION_PRICE";
    }

    @Override
    public String getIdKey() {
        return "edtPrcId";
    }

    @Override
    public MybatisBaseDao<CfgSchemeEditionPrice> getDao() {
        return cfgSchemeEditionPriceDao;
    }
    
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    public List<CfgSchemeEditionPrice> queryPriceListById(String schmEdtId){

        return cfgSchemeEditionPriceDao.queryPriceListById(schmEdtId);
    }

    public Integer getIsUsing(String schmEdtId){
        Map<String ,Object> map=new HashMap<String, Object>();
        map.put("schmEdtId",schmEdtId);
        return cfgSchemeEditionPriceDao.getIsUsing(map);
    }
    /**
     * 禁用或者启用数据
     * @param entity
     * @return
     */
    public Map<String,Object> startOrForbiddenUse(CfgSchemeEditionPrice entity){
        String edtPrcId=entity.getEdtPrcId();
        String schmEdtId=entity.getSchmEdtId();
        String edtPrcStatus=entity.getEdtPrcStatus();
        Map<String,Object> map =new HashMap<String, Object>();
        map.put("schmEdtId" ,schmEdtId);
        map.put("edtPrcId" ,edtPrcId);
        map.put("edtPrcStatus",edtPrcStatus);
        //是否存在一起用的数据，若是存在则不进行操作，不存在进行禁用
        if("1".equals(edtPrcStatus)){
            cfgSchemeEditionPriceDao.forbidden(map);
        }else{
            cfgSchemeEditionPriceDao.startUse(map);
        }
        return map;
    }
    /**
     *
     */
    public BigDecimal getEdtPrice(Map<String,Object> map){

        return  cfgSchemeEditionPriceDao.getEdtPrice(map);
    }
}
