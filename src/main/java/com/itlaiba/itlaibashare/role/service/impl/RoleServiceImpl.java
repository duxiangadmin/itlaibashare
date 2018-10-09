package com.itlaiba.itlaibashare.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itlaiba.itlaibashare.role.mapper.RoleMapper;
import com.itlaiba.itlaibashare.role.pojo.Role;
import com.itlaiba.itlaibashare.role.service.RoleService;

@Service
@Transactional(rollbackFor=Exception.class)
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper roleMapper;
	
	public Role selectByUserId(String id) {
		return roleMapper.selectByUserId(id);
	}

	public int insert(Role role) {
		int i=0;
		if("".equals(role.getRolename()) || role.getRolename()==null){
			role.setRolename("普通管理员");
		}
		i = roleMapper.insert(role);
		return i;
	}

}
