package com.itlaiba.itlaibashare.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itlaiba.itlaibashare.category.pojo.Category;
import com.itlaiba.itlaibashare.category.service.CategoryService;

@Controller
@RequestMapping("category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/selectList")
	public @ResponseBody Object show() throws Exception{
		List<Category> list = categoryService.selectList();
		return list;
	}
}
