package com.learnyeai.audit.api.service;

import com.learnyeai.audit.api.vo.AdtAuditLogVo;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author yl
 */
@Service
public class AdtAuditLogService extends WeyeBaseService<AdtAuditLogVo> {
   /* @Autowired
    private AdtAuditLogClient adtAuditLogClient;*/

    /*@Override
    public BaseFeignClient<AdtAuditLogVo> getFeignClient() {
        return adtAuditLogClient;
    }

    @Override
    public Object getId(Map params) {
        String idKey = "adId";
        if(params.containsKey(idKey)){
        return params.get(idKey);
        }
        return null;
    }*/

    /**
     * 根据条件查询出所有审核列表的id
     * @param
     * @return
     */
/*    public Map<String,Object> queryPageByIds(IBusinessContext ctx){
        Map<String,Object> result=new HashedMap();
       String asIds= adtAuditLogClient.queryPageByIds(ctx.getParamMap());
        result.put("adIds",asIds);
        return  result;
    }*/

    @Override
    public BaseMapper<AdtAuditLogVo> getMapper() {
        return null;
    }
}
