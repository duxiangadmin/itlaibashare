package com.itlaiba.itlaibashare.blog.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itlaiba.itlaibashare.base.utils.GetDate;
import com.itlaiba.itlaibashare.blog.mapper.BlogEssayMapper;
import com.itlaiba.itlaibashare.blog.pojo.BlogEssay;
import com.itlaiba.itlaibashare.blog.service.BlogEssayService;
import com.itlaiba.itlaibashare.page.Page;
@Service
@Transactional(rollbackFor=Exception.class)
public class BlogEssayServiceImpl implements BlogEssayService {

	@Autowired
	private BlogEssayMapper blogEssayMapper;
	
	/**
	 * easyui添加博客文章
	 */
	public int insert(BlogEssay blogEssay) {
		int i =0;
		if(blogEssay!=null){
			blogEssay.setBlogId(UUID.randomUUID().toString().replace("-", ""));
			blogEssay.setBlogCreateTime(GetDate.GetsimpleDate());
			i = blogEssayMapper.insert(blogEssay);
		}
		return i;
	}
	
	/**
	 * 删除多个
	 */
	
	public int deleteList(String[] id) {
		int i =0;
		i = blogEssayMapper.deleteList(id);
		return i;
	}

	

	/**
	 * easyui修改文章
	 */
	public int update(BlogEssay blogEssay){
		int i =0;
		i = blogEssayMapper.update(blogEssay);
		return i;
	}

	/**
	 * 前台查询单个文章
	 */
	public BlogEssay selectByPrimaryKey(String id) {
		BlogEssay  blogEssay = null;
		if(id!=null && !"".equals(id)){
			blogEssay = blogEssayMapper.selectByPrimaryKey(id);		
		}
		return blogEssay;
	}

	/**
	 * easyui查询所有
	 */
	public List<BlogEssay> selectList(Page p) {
		PageHelper.offsetPage(p.getStart(), p.getCount());
		List<BlogEssay> blogList = blogEssayMapper.selectList();
		int total = (int) new PageInfo<BlogEssay>(blogList).getTotal();
		p.setPc(total);
		p.setRows(total);
		p.setLast(total);
		if(blogList.size()>0){
			return blogList;
		}
		return null;
	}

	public List<BlogEssay> select(Page page) {
		PageHelper.offsetPage(page.getStart(), page.getCount());
		List<BlogEssay> list = blogEssayMapper.select(page);
		int total = (int) new PageInfo<BlogEssay>(list).getTotal();
		page.setLast(total);
		page.setRows(total);
		page.setTp(total);
		page.caculateLast(total);
		return list;
	}
}
