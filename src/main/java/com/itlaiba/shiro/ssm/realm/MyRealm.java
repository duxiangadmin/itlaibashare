package com.itlaiba.shiro.ssm.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.itlaiba.itlaibashare.role.service.RoleService;
import com.itlaiba.itlaibashare.users.pojo.Users;
import com.itlaiba.itlaibashare.users.service.UsersService;

public class MyRealm extends AuthorizingRealm{
	
	@Autowired
	private UsersService userService;
	@Autowired
	private RoleService roleService;
	
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		这里从页面拿到账号
		String loginId = (String) principals.getPrimaryPrincipal();
		Users users = userService.selectByPrimaryKey(loginId);
//		查询该账号的角色信息
		String rolename = roleService.selectByUserId(users.getUid()).getRolename();		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Set<String> set = new HashSet<String>();
		set.add(rolename);
//		赋值匹配是否具备，没有角色直接异常
		authorizationInfo.setRoles(set);
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		String username = token.getPrincipal().toString();
		
		Users users = userService.selectByPrimaryKey(username);
		if(users==null){
			throw new AuthenticationException();
		}
		
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(users.getLoginId(),users.getLoginPwd(),getName());
		
		return authenticationInfo;
	}

}
