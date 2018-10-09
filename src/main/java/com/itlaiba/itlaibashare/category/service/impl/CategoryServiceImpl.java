package com.itlaiba.itlaibashare.category.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itlaiba.itlaibashare.category.mapper.CategoryMapper;
import com.itlaiba.itlaibashare.category.pojo.Category;
import com.itlaiba.itlaibashare.category.service.CategoryService;
@Service
@Transactional(rollbackFor=Exception.class)
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryMapper categoryMapper;
	
	public List<Category> selectList() throws Exception {
		List<Category> categories = categoryMapper.selectList();
		if(categories!=null && categories.size()!=0){
			return categories;
		}
		return null;
	}

}
