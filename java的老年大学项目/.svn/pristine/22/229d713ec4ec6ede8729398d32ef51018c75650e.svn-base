package com.learnyeai.base.service;

import com.learnyeai.base.api.vo.CfgFunctionVo;
import com.learnyeai.base.model.CfgFunction;
import com.learnyeai.base.mapper.CfgFunctionMapper;
import com.learnyeai.base.model.CustInfo;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.common.utils.WeyeThreadContextUtils;
import com.learnyeai.core.consts.ConfigEnum;
import com.learnyeai.learnai.consts.PtCons;
import com.learnyeai.learnai.mybatis.impl.Criteria;
import com.learnyeai.learnai.mybatis.impl.CriteriaQuery;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.CurrentUserHelp;
import com.learnyeai.tools.common.BeanMapUtils;
import com.learnyeai.tools.common.MapUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.*;

/**
 *
 * @author zhangpz
 */
@Service
public class CfgFunctionWyService extends WeyeBaseService<CfgFunction> {

    @Resource
    private CfgFunctionMapper cfgFunctionMapper;
    @Autowired
    private CustInfoWyService custInfoWyService;

    @Override
    public BaseMapper<CfgFunction> getMapper() {
        return cfgFunctionMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    @Override
    protected Weekend<CfgFunction> genSqlExample(CfgFunction cfgFunction, Map params) {
        Weekend<CfgFunction> weekend = super.genSqlExample(cfgFunction, params);
        WeekendCriteria<CfgFunction, Object> c = weekend.createCriteriaAddOn();
        weekend.and(c);
        c.andEqualTo(CfgFunction::getFuncStatus, PtCons.ENABLE_DISABLE.E.getVal());

        // 前端、后管
        if(StringUtils.isNotBlank(cfgFunction.getFuncType())){
            c.andEqualTo(CfgFunction::getFuncType, cfgFunction.getFuncType());
        }
        // 是否是html
        if(StringUtils.isNotBlank(cfgFunction.getFuncMngType())){
            c.andEqualTo(CfgFunction::getFuncMngType, cfgFunction.getFuncMngType());
        }
        return weekend;
    }

    /**
     * 查询所有的资源权限，url与权限都不为空
     * @return
     */
    public Map<String,String> queryAllUrl2Perms(){
        Weekend<CfgFunction> weekend = genSqlExample(null);
        WeekendCriteria<CfgFunction, Object> c = weekend.createCriteriaAddOn();
        c.andIsNotNull(CfgFunction::getFuncUrl)
                .andIsNotNull(CfgFunction::getFuncPermission)
                .andEqualTo(CfgFunction::getFuncStatus, ConfigEnum.ENABLE)
        ;
        weekend.and(c);
        List<CfgFunction> list = cfgFunctionMapper.selectByExample(weekend);

        Map<String,String> url2Perms = new HashMap<>();

        list.forEach(o ->{
            String url = o.getFuncUrl();
            if(url == null || url.length() == 0)
                return;

            String perm = o.getFuncPermission();
            if(null == perm || perm.length() == 0)
                return;

            // 已经存在
            if(url2Perms.containsKey(url)){
                String tt = url2Perms.get(url) + "," + perm;
                url2Perms.put(url, tt);
                return;
            }

            // 新加入的
            url2Perms.put(url, perm);
        });
        return url2Perms;
    }
    // 查询所有资源角色
    public List<Map<String, String>> queryAllUrl2Roles(){
        // 暂时未用到
        return null;
    }

    /**
     * 查询用户权限
     * @param custId
     * @return
     */
    public Collection<String> queryUserPermNames(String custId){
        CustInfo custInfo = custInfoWyService.queryById(custId);

        CriteriaQuery q = genSqlQuery("f");
        q.setFroms(getTableName() + " f");
        Criteria c = q.createAndCriteria();
        // 用户
        c.sql("exists(SELECT 1 from cust_user_role u, cust_role_func rf where u.cust_id=? and rf.ROLE_ID=u.ROLE_ID and rf.FUNC_ID=f.FUNC_ID)", custId);
        // 添加用户方案
        c.sql("exists(SELECT 1  from CFG_MODULE m" +
                "  INNER JOIN CFG_SCHM_MDL_REL rm on rm.MDL_ID=m.MDL_ID" +
                " INNER JOIN CFG_SCHEME_EDITION e on e.SCHM_ID=rm.SCHM_ID" +
                " INNER JOIN SH_MERCHANT_SCHEME ms on ms.SCHM_EDT_ID=e.SCHM_EDT_ID AND ms.MCHT_SCHM_ID=?" +
                " where m.MDL_ID = f.MDL_ID)", custInfo.getMchtSchmId());

        List<CfgFunction> list = cfgFunctionMapper.queryByCriteria(q);
        Set<String> permSet = new HashSet<>();
        for(CfgFunction o : list){
            String perm = o.getFuncPermission();
            if(perm == null || perm.length() == 0)
                continue;
            String[] arr = perm.split(",");
            for (String ss : arr){
                if(ss == null || ss.length() == 0)
                    continue;
                permSet.add(ss);
            }
        }
        return permSet;
    }

    /**
     * 查询当前用户功能树
     * @param function
     * @return
     */
    public List<Map> querySortTree(CfgFunction function){
        CriteriaQuery q = genSqlQuery("f");
        q.setFroms(getTableName() + " f");
        Criteria c = q.createAndCriteria();
        // 前端、后管
        if(StringUtils.isNotBlank(function.getFuncType())){
            c.equalTo(CfgFunction.TF.funcType, function.getFuncType());
        }

        // 用户的权限
//        c.sql("exists(SELECT 1 from cust_user_role u, cust_role_func rf where u.cust_id=? and rf.ROLE_ID=u.ROLE_ID and rf.FUNC_ID=f.FUNC_ID)", CurrentUserHelp.getId());
        // 添加用户方案
        c.sql("exists(SELECT 1  from CFG_MODULE m" +
                "  INNER JOIN CFG_SCHM_MDL_REL rm on rm.MDL_ID=m.MDL_ID" +
                " INNER JOIN CFG_SCHEME_EDITION e on e.SCHM_ID=rm.SCHM_ID" +
                " INNER JOIN SH_MERCHANT_SCHEME ms on ms.SCHM_EDT_ID=e.SCHM_EDT_ID AND ms.MCHT_SCHM_ID=?" +
                " where m.MDL_ID = f.MDL_ID)", WeyeThreadContextUtils.getMerchantSchemeId());

        List<CfgFunction> list = cfgFunctionMapper.queryByCriteria(q);

//        List<CfgFunction> list = super.queryList(function, null);
        List<Map> rstList = sortList(list, "1", true);
        return rstList;
    }

    /**
     * 查询用户后管功能菜单树
     * @param userId
     * @return
     */
    public List<Map> queryUserMngMenuTree(String userId){
        CustInfo custInfo = custInfoWyService.queryById(userId);
        String as = "f";
        CriteriaQuery q = genSqlQuery("f");
        q.setFroms(getTableName() + " f");
        Criteria c = q.createAndCriteria();
        c.equalTo(CfgFunction.TF.funcType, "1");// 后管
        c.equalTo(CfgFunction.TF.funcMngType, "2");// 菜单

        // 用户的权限
        c.sql("exists(SELECT 1 from cust_user_role u, cust_role_func rf where u.cust_id=? and rf.ROLE_ID=u.ROLE_ID and rf.FUNC_ID=f.FUNC_ID)", userId);
        // 添加用户方案
        c.sql("exists(SELECT 1  from CFG_MODULE m" +
                "  INNER JOIN CFG_SCHM_MDL_REL rm on rm.MDL_ID=m.MDL_ID" +
                " INNER JOIN CFG_SCHEME_EDITION e on e.SCHM_ID=rm.SCHM_ID" +
                " INNER JOIN SH_MERCHANT_SCHEME ms on ms.SCHM_EDT_ID=e.SCHM_EDT_ID AND ms.MCHT_SCHM_ID=?" +
                " where m.MDL_ID = f.MDL_ID)", custInfo.getMchtSchmId());

        List<CfgFunction> list = cfgFunctionMapper.queryByCriteria(q);

        /*CfgFunction func = new CfgFunction();

        func.setFuncType("1"); // 后管
        func.setFuncMngType("2");// 菜单
        Weekend<CfgFunction> weekend = genSqlExample(func, null);
        WeekendCriteria<CfgFunction, Object> c = weekend.createCriteriaAddOn();
        weekend.and(c);
//        ArrayList<Object> ppList = new ArrayList<>();
//        ppList.add(userId);
        // 用户管理的
        c.andCondition("exists(SELECT 1 from cust_user_role u, cust_role_func rf where u.cust_id='" + userId +
                "' and rf.ROLE_ID=u.ROLE_ID and rf.FUNC_ID=cfg_function.FUNC_ID)");
        // 添加当前方案
        c.andCondition("SELECT 1  from CFG_MODULE m" +
                "  INNER JOIN CFG_SCHM_MDL_REL rm on rm.MDL_ID=m.MDL_ID" +
                " INNER JOIN CFG_SCHEME_EDITION e on e.SCHM_ID=rm.SCHM_ID" +
                " INNER JOIN SH_MERCHANT_SCHEME ms on ms.SCHM_EDT_ID=e.SCHM_EDT_ID AND ms.MCHT_SCHM_ID='" + "" +"'" +
                " where m.MDL_ID = cfg_function.MDL_ID");
        List<CfgFunction> list = cfgFunctionMapper.selectByExample(weekend);*/
        return sortList(list, "1", true);
    }


    private  List<Map> sortList(List<CfgFunction> sourcelist, String parentId, boolean cascade){
        List<Map> list = new ArrayList<>();

        for (int i=0; i<sourcelist.size(); i++){
            CfgFunction e = sourcelist.get(i);
            if (e.getParentId()!=null && e.getParentId().equals(parentId)){
                Map o = null;
                try {
                    o = BeanMapUtils.convertBean(e);
                } catch (Exception e1) {
                    logger.error(e1.getMessage());
                    continue;
                }
                list.add(o);
                if (cascade){
                    List<Map> subList = sortList(sourcelist, e.getFuncId(), cascade);
                    o.put("children", subList);
                }
            }
        }
        // 对list排序
        list.sort((a, b)->{
            int an = MapUtil.getMapValue(a, CfgFunctionVo.CF.sort, 0);
            int bn = MapUtil.getMapValue(b,CfgFunctionVo.CF.sort, 0);
            return an - bn;
        });
        return list;
    }

}
