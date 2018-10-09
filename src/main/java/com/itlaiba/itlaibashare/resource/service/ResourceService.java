package com.itlaiba.itlaibashare.resource.service;

import java.util.List;

import com.itlaiba.itlaibashare.page.Page;
import com.itlaiba.itlaibashare.resource.pojo.ResourcesExample;
import com.itlaiba.itlaibashare.resource.pojo.ResourcesWithBLOBs;

public interface ResourceService {
	public List<ResourcesWithBLOBs> select(Page page,ResourcesExample example);
	public long count(ResourcesExample example);
	public int deleteByPrimaryKey(String resourceId);
	public int insert(ResourcesWithBLOBs record);
	public ResourcesWithBLOBs selectByPrimaryKey(String resourceId);
	public int updateByPrimaryKeyWithBLOBs(ResourcesWithBLOBs record);
}
