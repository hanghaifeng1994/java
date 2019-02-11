package com.learnyeai.audit.service;

import com.learnyeai.audit.mapper.AdtAuditLogMapper;
import com.learnyeai.audit.model.AdtAuditLog;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.iml.CurrentUserInfoIml;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yl
 */
@Service
public class AdtAuditLogWyService extends WeyeBaseService<AdtAuditLog> {
    @Resource
    private AdtAuditLogMapper adtAuditLogMapper;
    @Resource
    private CurrentUserInfoIml currentUserInfoIml;

    @Override
    public BaseMapper<AdtAuditLog> getMapper() {
        return adtAuditLogMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Override
    protected Weekend<AdtAuditLog> genSqlExample(AdtAuditLog t, Map params) {
        Weekend<AdtAuditLog> weekend = super.genSqlExample(t, params);
        WeekendCriteria<AdtAuditLog, Object> c = weekend.createCriteriaAddOn();
        if(StringUtils.isNotBlank(t.getServiceType())){
            c.andEqualTo(AdtAuditLog::getServiceType,t.getServiceType());
        }
        if(StringUtils.isNotBlank(t.getObjId())){
            c.andEqualTo(AdtAuditLog::getObjId,t.getObjId());
        }
        if(StringUtils.isNotBlank(t.getAdUserName())){
            c.andLike(AdtAuditLog::getAdUserName,"%"+t.getObjId()+"%");
        }
        weekend.and(c);
        return weekend;
    }

    public Map<String,Object> queryPageByIds(IBusinessContext ctx){
       AdtAuditLog adtAuditLog = super.convert2Bean(ctx.getParamMap());
        String userId= currentUserInfoIml.getId();
        adtAuditLog.setAdUserId(userId);
        String[] ids=(adtAuditLog.getObjId()).split(",");
         Map<String ,Object> map=new HashMap<>() ;
        map.put("ids",ids);
        map.put("t",adtAuditLog);
        String asIds=adtAuditLogMapper.queryPageByIds(map);
        map.put("adIds",asIds);
       return map;

    }
}
