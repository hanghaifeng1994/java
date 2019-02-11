package com.learnyeai.dynamics.service;

import com.learnyeai.dynamics.mapper.DynDynamicsCustRelMapper;
import com.learnyeai.dynamics.model.DynDynamics;
import com.learnyeai.dynamics.mapper.DynDynamicsMapper;
import com.learnyeai.dynamics.model.DynDynamicsCustRel;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yl
 */
@Service
public class DynDynamicsWyService extends WeyeBaseService<DynDynamics> {

    @Resource
    private DynDynamicsMapper dynDynamicsMapper;
    @Resource
    private  DynDynamicsCustRelWyService dynDynamicsCustRelWyService;
    @Resource
    private DynDynamicsCustRelMapper dynDynamicsCustRelMapper;

    @Override
    public BaseMapper<DynDynamics> getMapper() {
        return dynDynamicsMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    @Override
    protected Weekend genSqlExample(DynDynamics t, Map params) {
        Weekend w=super.genSqlExample(t,params);
        WeekendCriteria<DynDynamics,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(t.getDynId())){
            String dynId=t.getDynId();
            List<String> list=Arrays.asList(dynId.split(","));
            c.andIn(DynDynamics::getDynId,list);
        }
        if(StringUtils.isNotBlank(t.getType())){
            c.andEqualTo(DynDynamics::getDynId,t.getDynId());
        }
        w.and(c);
        w.setOrderByClause("CREATE_DATE desc");
        return  w;
    }
    @Transactional
    public Map<String,Object>  saveData(DynDynamics dyn) {
        super.save(dyn);
        if(StringUtils.isNotBlank(dyn.getRcvUserIds())){
            String[] recUserIds=(dyn.getRcvUserIds()).split(",");
            DynDynamicsCustRel d=new DynDynamicsCustRel();
            d.setDynId(dyn.getDynId());
            for (String userId:recUserIds){
                d.setRcvUserId(userId);
                dynDynamicsCustRelMapper.insertSelective(d);
            }
        }
        return MapUtil.newMap("dynId",dyn.getDynId());
    }
}
