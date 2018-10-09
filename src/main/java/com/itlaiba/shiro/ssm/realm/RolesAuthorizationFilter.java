package com.itlaiba.shiro.ssm.realm;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

/**
 * 角色过滤器
 * 因为原本的shiro不具备or功能，此处处理
 * 照抄就行
 * @author 杜翔
 * @版本 V 1.0 
 * @date 2018年6月26日 上午2:11:55
 */
public class RolesAuthorizationFilter extends AuthorizationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		Subject subject = getSubject(request, response);
		String[] rolesArray = (String[]) mappedValue;
		if(rolesArray==null ||rolesArray.length==0){
			return true;
		}
		
		for (int i = 0; i < rolesArray.length; i++) {
			if(subject.hasRole(rolesArray[i])){
				return true;
			}
		}
		return false;
	}

}
