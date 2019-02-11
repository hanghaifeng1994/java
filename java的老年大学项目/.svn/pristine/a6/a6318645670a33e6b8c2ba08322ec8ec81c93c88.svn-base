package com.learnyeai.base.service;

import com.learnyeai.base.mapper.CustRoleFuncMapper;
import com.learnyeai.base.mapper.CustUserRoleMapper;
import com.learnyeai.base.model.CustRole;
import com.learnyeai.base.mapper.CustRoleMapper;
import com.learnyeai.base.model.CustRoleFunc;
import com.learnyeai.base.model.CustUserRole;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.consts.PtCons;
import com.learnyeai.learnai.mybatis.impl.Criteria;
import com.learnyeai.learnai.mybatis.impl.CriteriaQuery;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.IBusinessContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.c;

/**
 *
 * @author zhangpz
 */
@Service
public class CustRoleWyService extends WeyeBaseService<CustRole> {

    @Resource
    private CustRoleMapper custRoleMapper;
    @Autowired
    private CustRoleFuncMapper custRoleFuncMapper;

    @Override
    public BaseMapper<CustRole> getMapper() {
        return custRoleMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    @Override
    protected Weekend<CustRole> genSqlExample(CustRole custRole, Map params) {
        Weekend<CustRole> weekend = super.genSqlExample(custRole, params);
        WeekendCriteria<CustRole, Object> cc = weekend.createCriteriaAddOn();
        weekend.and(cc);
        if(StringUtils.isNotBlank(custRole.getRoleName())){
            cc.andLike(CustRole::getRoleName, "%"+custRole.getRoleName()+"%");
        }
        return weekend;
    }

    /**
     * 查询用户角色
     * @param custId
     * @return
     */
    public List<CustRole> queryUserRole(String custId){
        CriteriaQuery q = genSqlQuery("r");
        q.setFroms(getTableName() + " r");
        Criteria c = q.createAndCriteria();
        c.sql("exists(SELECT 1 from cust_user_role u where u.cust_id=?)", custId);
        List<CustRole> list = custRoleMapper.queryByCriteria(q);
        return list;
    }

    /**
     * 查询角色英文名称
     * @param custId
     * @return
     */
    public List<String> queryUserRoleEnames(String custId){

        List<CustRole> list = queryUserRole(custId);
        ArrayList<String> rstList = new ArrayList<String>();
        for(CustRole r : list){
            rstList.add(r.getRoleEname());
        }
        return rstList;
    }

    public List<String> queryUserRoleNames(String custId){

        List<CustRole> list = queryUserRole(custId);
        ArrayList<String> rstList = new ArrayList<String>();
        for(CustRole r : list){
            rstList.add(r.getRoleName());
        }
        return rstList;
    }

    /**
     * 启用禁用
     * @param ids 角色ids
     * @param enabled
     */
    @Transactional
    public void enable(String[] ids, boolean enabled){
        String val = enabled ? PtCons.ENABLE_DISABLE.E.getVal() : PtCons.ENABLE_DISABLE.D.getVal();
        CustRole o = new CustRole();
        o.setUserable(val);
        for(String id : ids){
            if(StringUtils.isBlank(id))
                continue;
            o.setRoleId(id);
            custRoleMapper.updateByPrimaryKeySelective(o);
        }
    }

    /**
     * 保存角色功能
     * @param ctx
     *  funcIds 角色包含的功能
     * @return
     */
    public String saveRoleFuncs(IBusinessContext ctx){
        CustRole role = convert2Bean(ctx.getParamMap());
        if(role.getRoleId() == null){
            role.setUserable(PtCons.ENABLE_DISABLE.D.getVal());
        }else {
            role.setUserable(null);
        }
        save(role);

        // 修改角色功能
        String funcIds = ctx.getParam("funcIds");
        String[] funcIdArr = funcIds.split(",");
        CustRoleFunc roleFunc = new CustRoleFunc();
        roleFunc.setRoleId(role.getRoleId());
        // 1 先删除
        custRoleFuncMapper.delete(roleFunc);
        // 2 添加
        for (String fid : funcIdArr){
            roleFunc.setFuncId(fid);
            custRoleFuncMapper.insert(roleFunc);
        }

        return role.getRoleId();
    }

    /**
     * 查询角色功能id列表
     * @param roleId
     * @return
     */
    public List<String> queryRoleFuncIdList(String roleId){
        CustRoleFunc roleFunc = new CustRoleFunc();
        roleFunc.setRoleId(roleId);
        List<CustRoleFunc> list = custRoleFuncMapper.select(roleFunc);
        List<String> rstList = new ArrayList<>();
        for(CustRoleFunc o : list){
            rstList.add(o.getFuncId());
        }
        return rstList;
    }
}
