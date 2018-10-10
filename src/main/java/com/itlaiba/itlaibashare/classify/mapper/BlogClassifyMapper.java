package com.itlaiba.itlaibashare.classify.mapper;

import java.util.List;

import com.itlaiba.itlaibashare.classify.pojo.BlogClassify;

public interface BlogClassifyMapper {
	List<BlogClassify> selectify();
	BlogClassify selectbyblogid(String keyword);
}
