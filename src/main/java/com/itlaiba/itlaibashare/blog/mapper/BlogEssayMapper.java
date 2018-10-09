package com.itlaiba.itlaibashare.blog.mapper;

import java.util.List;

import com.itlaiba.itlaibashare.blog.pojo.BlogEssay;
import com.itlaiba.itlaibashare.page.Page;

public interface BlogEssayMapper {
   public BlogEssay selectByPrimaryKey(String id);
   public int insert(BlogEssay blogEssay);
   public List<BlogEssay> selectList();
   public List<BlogEssay> select(Page page);
   public int deleteList(String[] id);
   public int update(BlogEssay blogEssay);
}