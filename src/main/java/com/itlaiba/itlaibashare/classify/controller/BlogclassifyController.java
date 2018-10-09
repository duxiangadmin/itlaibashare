package com.itlaiba.itlaibashare.classify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itlaiba.itlaibashare.classify.pojo.BlogClassify;
import com.itlaiba.itlaibashare.classify.service.BlogclassifyImpl;

@Controller
@RequestMapping("/blogify")
public class BlogclassifyController {

	@Autowired
	private BlogclassifyImpl impl;
	
	@RequestMapping("/selectify")
	public @ResponseBody List<BlogClassify> selectify(){
		return impl.selectify();
	}
}
