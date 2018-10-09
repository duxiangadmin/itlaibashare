package com.itlaiba.itlaibashare.myresource.service;

import java.util.List;

import com.itlaiba.itlaibashare.myresource.pojo.Myresource;
import com.itlaiba.itlaibashare.myresource.pojo.MyresourceExample;
import com.itlaiba.itlaibashare.myresource.pojo.MyresourceKey;
import com.itlaiba.itlaibashare.page.Page;

public interface MyresourceService {
	public List<Myresource> select(Page p, MyresourceExample example)throws Exception;
	public int insert(Myresource myresource)throws Exception;
	public int delete(MyresourceKey key)throws Exception;
	public Myresource selectByKey(MyresourceKey key)throws Exception;
	public int update(Myresource myresource);
}
