package com.itlaiba.itlaibashare.users.mapper;

import com.itlaiba.itlaibashare.users.pojo.Users;

public interface UsersMapper {
    public Users selectByPrimaryKey(String loginId);
    public int insert(Users user);
}