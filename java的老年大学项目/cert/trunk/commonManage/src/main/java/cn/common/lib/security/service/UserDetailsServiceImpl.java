package cn.common.lib.security.service;

import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.drcl.traincore.contants.Switch;
import com.google.common.collect.Sets;

/**
 * 实现SpringSecurity的UserDetailsService接口,实现获取用户Detail信息的回调函数.
 * 
 * @author calvin
 */
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {
	public Set<GrantedAuthority> grantedAuths = null;

	/**
	 * 获取用户Details信息的回调函数.
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

		username = StringUtils.isNotEmpty(username) ? username.trim() : "";

		/*
		 * if (user == null) { throw new UsernameNotFoundException("用户" +
		 * username + " 不存在"); }
		 */

		grantedAuths = obtainGrantedAuthorities();

		// -- mini-web示例中无以下属性, 暂时全部设为true. --//
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		return new org.springframework.security.core.userdetails.User(username, "11111", enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);
	}

	/**
	 * 获得用户所有角色的权限集合.
	 */
	private Set<GrantedAuthority> obtainGrantedAuthorities() {
		Set<GrantedAuthority> authSet = Sets.newHashSet();
		authSet.add(new GrantedAuthorityImpl("ROLE_后台管理")); 
		return authSet;
	}
}
