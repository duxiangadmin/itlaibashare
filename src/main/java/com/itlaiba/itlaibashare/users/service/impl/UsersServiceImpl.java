package com.itlaiba.itlaibashare.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itlaiba.itlaibashare.base.utils.CommonsUtil;
import com.itlaiba.itlaibashare.base.utils.GetUUID;
import com.itlaiba.itlaibashare.role.pojo.Role;
import com.itlaiba.itlaibashare.role.service.RoleService;
import com.itlaiba.itlaibashare.users.mapper.UsersMapper;
import com.itlaiba.itlaibashare.users.pojo.Users;
import com.itlaiba.itlaibashare.users.service.UsersService;

/**
 * 业务层 * 
 * @author 杜翔
 * @版本 V 1.0 
 * @date 2018年6月14日 上午12:19:07
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersMapper usersMapper;
	@Autowired
	private RoleService roleService;

	/**
	 * 登陆方法根据账号查找密码
	 */
	
	public Users selectByPrimaryKey(String loginId) {
		Users users = null;
		if(loginId!=null && !"".contentEquals(loginId)){
			users = usersMapper.selectByPrimaryKey(loginId);
		}
		return users;
	}


	public int insert(Users user) {
		int i =0;
		try {	
			if(user!=null){
				String uid = GetUUID.getUUID().substring(0, 8);
				user.setUid(uid);
				i = usersMapper.insert(user);
				Role role = new Role();
				role.setUid(uid);
				i = roleService.insert(role);
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return i;
	}
	
	
	

}
