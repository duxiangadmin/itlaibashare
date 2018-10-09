package com.itlaiba.itlaibashare.role.service;

import com.itlaiba.itlaibashare.role.pojo.Role;

public interface RoleService {
	 public Role selectByUserId(String id);
	 public int insert(Role role);
}
