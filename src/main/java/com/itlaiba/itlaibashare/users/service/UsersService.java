package com.itlaiba.itlaibashare.users.service;

import com.itlaiba.itlaibashare.users.pojo.Users;

public interface UsersService {
	public Users selectByPrimaryKey(String loginId);
	public int insert(Users user);
}
