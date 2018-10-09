package com.itlaiba.itlaibashare.category.mapper;

import java.util.List;

import com.itlaiba.itlaibashare.category.pojo.Category;

public interface CategoryMapper {
	public List<Category> selectList()throws Exception;
}
