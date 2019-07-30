package com.lzh.shiro.config;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lzh.shiro.pojo.*;
import com.lzh.shiro.service.*;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/*
 * @author H
 *
 * @date 2019/7/30
 *
 */
public class ShiroRealm extends AuthorizingRealm {
	@Autowired
	IUserService userService;

	@Autowired
	IUserRoleService userRoleService;

	@Autowired
	IRoleService roleService;

	@Autowired
	IPermissionService permissionService;

	@Autowired
	IRolePermissionService rolePermissionService;

	/**
	 * 角色权限和对应权限添加
	 * @param principals
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取用户名
		String name = (String) principals.getPrimaryPrincipal();
		//获取用户对象
		User user = userService.findByName(name);

		//添加角色和权限
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

		List<Role> roles = getRoles(user.getId());

		for (Role role : roles) {
			//添加角色
			simpleAuthorizationInfo.addRole(role.getName());

			//添加权限
			List<Permission> permissions = getPermission(role.getId());
			for (Permission permission : permissions) {
				simpleAuthorizationInfo.addStringPermission(permission.getName());
			}
		}
		return simpleAuthorizationInfo;
	}

	private List<Role> getRoles(String userId){
		List<UserRole> userRoles = userRoleService.selectList(
				new EntityWrapper<UserRole>()
						.eq("user_id", userId));
		List<Role> list = new ArrayList<>();

		for (UserRole userRole : userRoles) {
			Role role = roleService.selectById(userRole.getRoleId());
			list.add(role);
		}
		return list;
	}

	private List<Permission> getPermission(String roleId){
		List<RolePermission> rolePermissions = rolePermissionService.selectList(
				new EntityWrapper<RolePermission>()
						.eq("role_id", roleId));
		List<Permission> list = new ArrayList<>();

		for (RolePermission rolePermission : rolePermissions) {
			Permission permission = permissionService.selectById(rolePermission.getPermissionId());
			list.add(permission);
		}

		return list;
	}

	/**
	 * 用户认证
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		if (token.getPrincipal() == null) {
			return null;
		}

		//获取用户名和密码
		String name = token.getPrincipal().toString();
		String password = new String((char[]) token.getCredentials());

		User user = userService.findByName(name);

		if (user == null || !password.equals(user.getPassword())) {
			throw new IncorrectCredentialsException("登陆失败，用户名或密码错误");
		}

		//验证authenticationToken和simpleAuthenticationInfo的信息
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, password, getName());

		//返回一个身份信息
		return simpleAuthenticationInfo;
	}
}
