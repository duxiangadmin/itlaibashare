package com.itlaiba.itlaibashare.resource.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itlaiba.itlaibashare.page.Page;
import com.itlaiba.itlaibashare.resource.mapper.ResourcesMapper;
import com.itlaiba.itlaibashare.resource.pojo.ResourcesExample;
import com.itlaiba.itlaibashare.resource.pojo.ResourcesExample.Criteria;
import com.itlaiba.itlaibashare.resource.pojo.ResourcesWithBLOBs;
import com.itlaiba.itlaibashare.resource.service.ResourceService;

/**
 * resource的业务层
 * @author 杜翔
 * @版本 V 1.0 
 * @date 2018年6月14日 上午12:11:13
 */

@Service
@Transactional(rollbackFor=Exception.class)
public class ResourceServiceImpl implements ResourceService{
	
	@Autowired
	private ResourcesMapper resourcesMapper;
	

	public List<ResourcesWithBLOBs> select(Page page,ResourcesExample example) {
		// TODO Auto-generated method stub
		PageHelper.offsetPage(page.getStart(), page.getCount());
		if(example!=null){
			Criteria criteria = example.createCriteria();			
			if(page.getKeyword()!=null){
				criteria.andResourceNameLike("%"+page.getKeyword()+"%");				
			}			
		}
		example.setOrderByClause("orde_by desc");
		List<ResourcesWithBLOBs> list = resourcesMapper.selectByExampleWithBLOBs(example);
		int total = (int) new PageInfo<ResourcesWithBLOBs>(list).getTotal();
		page.setTp(total);
		page.setRows(total);
		page.caculateLast(total);
		return list;
	}
	
	public long count(ResourcesExample example) {		
		long rows = resourcesMapper.countByExample(example);
		return rows;
	}

	public int deleteByPrimaryKey(String resourceId) {
		int i =0;
		i = resourcesMapper.deleteByPrimaryKey(resourceId);		
		return i;
	}
	
	/*
	 * 由于添加资源下载的时候某些内容不由用户输入
	 * 这里自行添加
	 * */
	public int insert(ResourcesWithBLOBs bloBs) {
		int i = 0;
		if(bloBs!=null){		 
			bloBs.setResourceId(UUID.randomUUID().toString().replace("-", ""));		
			bloBs.setResourceCreateTime(new Date());
			bloBs.setResourceNumber(0);
			i = resourcesMapper.insert(bloBs);
		}
		return i;
	}

	public ResourcesWithBLOBs selectByPrimaryKey(String resourceId) {
		// TODO Auto-generated method stub
		return resourcesMapper.selectByPrimaryKey(resourceId);
	}

	public int updateByPrimaryKeyWithBLOBs(ResourcesWithBLOBs record) {
		return resourcesMapper.updateByPrimaryKeyWithBLOBs(record);
	}
	
	

}
