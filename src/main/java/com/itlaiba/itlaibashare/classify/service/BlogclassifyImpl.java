package com.itlaiba.itlaibashare.classify.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itlaiba.itlaibashare.classify.mapper.BlogClassifyMapper;
import com.itlaiba.itlaibashare.classify.pojo.BlogClassify;
@Service
@Transactional(rollbackFor=Exception.class)
public class BlogclassifyImpl {
	@Autowired
	private BlogClassifyMapper mapper;
	public List<BlogClassify> selectify(){
		List<BlogClassify> list = mapper.selectify();
		return list;
	}
}
