package com.learnyeai.auth.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by zpz on 2018/8/20.
 */
@FeignClient(name = "${BASE-SERVICE-NAME}", path="${BASE-SERVICE-CONTEXT-PATH}")
public interface BaseClient {

    /**
     * 查询所有的资源权限，url与权限都不为空
     * @return
     */
    @RequestMapping("/CfgFunction/queryAllUrl2Perms")
    Map<String,String> queryAllUrl2Perms();
    /**
     * 查询用户权限
     * @param custId
     * @return
     */
    @RequestMapping("/CfgFunction/queryUserPermNames/{custId}")
    Collection<String> queryUserPermNames(@PathVariable(name = "custId") String custId);

    /**
     * 查询用户角色
     * @param custId
     * @return
     */
    @RequestMapping("/CustRole/queryUserRoleNames/{custId}")
    List<String> queryUserRoleNames(@PathVariable(name = "custId") String custId);
}
