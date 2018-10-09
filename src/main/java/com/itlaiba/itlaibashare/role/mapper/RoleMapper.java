package com.itlaiba.itlaibashare.role.mapper;

import com.itlaiba.itlaibashare.role.pojo.Role;

public interface RoleMapper {
    public Role selectByUserId(String id);
    public int insert(Role role);
}