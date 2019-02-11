package com.learnyeai.base.service;

import com.learnyeai.base.mapper.RolePermissionMapper;
import com.learnyeai.base.model.CustInfo;
import com.learnyeai.base.model.CustRole;
import com.learnyeai.common.utils.WeyeThreadContextUtils;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.support.CurrentUserHelp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zpz on 2018/9/15.
 */
@Service
public class RolePermissionWyService {
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private CustInfoWyService custInfoWyService;
    @Autowired
    private CustRoleWyService roleWyService;

    /**
     * 根据权限查询用户
     * @param perm
     * @return
     */
    public List<CustInfo> queryCustInfoListByPerm(String perm){
        List<CustInfo> rstList = new ArrayList<>();
        if(StringUtils.isBlank(CurrentUserHelp.getId())) {
            throw AresRuntimeException.build((String) null).iniCauseMsg("用户未登录");
        }
        Map pp = new HashMap();
        pp.put("perm", "%"+perm+"%");
        pp.put("mchtId", WeyeThreadContextUtils.getMerchantId());
        pp.put("mchtSchmId", WeyeThreadContextUtils.getMerchantSchemeId());
        List<Map> list = rolePermissionMapper.queryCustIdByPerm(pp);
        for(Map it : list){
            String id = it.get("CUST_ID").toString();
            CustInfo o = custInfoWyService.queryById(id);
            rstList.add(o);
        }
        return rstList;
    }

    /**
     * 根据权限查询角色列表
     * @param perm
     * @return
     */
    public List<CustRole> queryRoleListByPerm(String perm){
        List<CustRole> rstList = new ArrayList<>();
        if(StringUtils.isBlank(CurrentUserHelp.getId())) {
            throw AresRuntimeException.build((String) null).iniCauseMsg("用户未登录");
        }
        Map pp = new HashMap();
        pp.put("perm", "%"+perm+"%");
        pp.put("mchtId", WeyeThreadContextUtils.getMerchantId());
        pp.put("mchtSchmId", WeyeThreadContextUtils.getMerchantSchemeId());
        List<Map> list = rolePermissionMapper.queryRoleIdByPerm(pp);
        for(Map it : list){
            String id = it.get("ROLE_ID").toString();
            CustRole o = roleWyService.queryById(id);
            rstList.add(o);
        }
        return rstList;
    }
}
