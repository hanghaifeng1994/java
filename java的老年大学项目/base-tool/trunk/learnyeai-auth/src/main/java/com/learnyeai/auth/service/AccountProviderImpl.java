/*
 * Copyright 2017-2018 the original author(https://github.com/wj596)
 * 
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */
package com.learnyeai.auth.service;


import java.util.Set;

import com.learnyeai.auth.domain.UserAccount;
import org.apache.shiro.authc.AuthenticationException;
import com.learnyeai.auth.domain.entity.UserEntity;
import org.jsets.shiro.model.Account;
import org.jsets.shiro.service.ShiroAccountProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.Sets;
/**
 * 账号信息提供者实现
 * 
 * @author wangjie (https://github.com/wj596) 
 * @date 2016年6月24日 下午2:55:15
 */ 
@Service
public class AccountProviderImpl implements ShiroAccountProvider {

	/*@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;
	private final String guestAcout = "guest_guest";*/
	@Autowired
	private BaseClient baseClient;

	@Override
	public Account loadAccount(String account) throws AuthenticationException {
		/*UserEntity user = userService.getByAccount(account);
		// 用户不存在
		if(null == user){
			throw new AuthenticationException("账号或密码错误");
		}
		// 对账号做检查
		// 当账号异常，如账号被锁定、被禁用等等需要限制登陆，直接抛出AuthenticationException即可
		if(UserEntity.USER_STATUS_LOCKED == user.getStatus()){
			throw new AuthenticationException("账号已被锁定，请联系系统管理员");
		}*/

		return new UserAccount(account, "111");
	}
	
	
	/** 
	 * 加载用户持有的角色
	 */
	@Override
	public Set<String> loadRoles(String account) {
//		return Sets.newHashSet(userRoleService.listUserRoles(account));
		return Sets.newHashSet(baseClient.queryUserRoleNames(account));
	}
	
	
	/**
	 * 
	 * 系统采用  基于角色的权限访问控制(RBAC)策略
	 * 所谓的权限通常可以理解为用户所能操作的资源，如（user:add、user:delete）
	 * 此方法未实现
	 */ 
	@Override
	public Set<String> loadPermissions(String account) {

		return Sets.newHashSet(baseClient.queryUserPermNames(account));
	}
}