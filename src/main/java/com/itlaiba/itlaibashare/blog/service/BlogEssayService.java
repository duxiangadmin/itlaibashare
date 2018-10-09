package com.itlaiba.itlaibashare.blog.service;

import java.util.List;

import com.itlaiba.itlaibashare.blog.pojo.BlogEssay;
import com.itlaiba.itlaibashare.page.Page;

public interface BlogEssayService {
	public BlogEssay selectByPrimaryKey(String id);
	public int insert(BlogEssay blogEssay);
	 public List<BlogEssay> selectList(Page p);
	 public List<BlogEssay> select(Page page);
	 public int deleteList(String[] id);
	 public int update(BlogEssay blogEssay);
	 
}
