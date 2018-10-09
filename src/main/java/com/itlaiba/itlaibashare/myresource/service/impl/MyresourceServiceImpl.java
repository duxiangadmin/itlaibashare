package com.itlaiba.itlaibashare.myresource.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itlaiba.itlaibashare.myresource.mapper.MyresourceMapper;
import com.itlaiba.itlaibashare.myresource.pojo.Myresource;
import com.itlaiba.itlaibashare.myresource.pojo.MyresourceExample;
import com.itlaiba.itlaibashare.myresource.pojo.MyresourceExample.Criteria;
import com.itlaiba.itlaibashare.myresource.pojo.MyresourceKey;
import com.itlaiba.itlaibashare.myresource.service.MyresourceService;
import com.itlaiba.itlaibashare.page.Page;
@Service
@Transactional(rollbackFor=Exception.class)
public class MyresourceServiceImpl implements MyresourceService{
	@Autowired
	private MyresourceMapper myresourceMapper;

	/**
	 * 添加数据，由于mybatis中会把数据库中设计的默认值都覆盖为null
	 * 所以这里将无法由用户录入的值变为自己添加
	 */
	public int insert(Myresource myresource) throws Exception {
		if(myresource.getMyresourceId()==null && "".equals(myresource.getMyresourceId())){
			return 0;
		}
		String uuid = UUID.randomUUID().toString().replace("-", "");
		myresource.setMyresourceId(uuid);
		myresource.setMyresourceTime(new Date());
		myresource.setMyresourceNumber(0);
		return myresourceMapper.insert(myresource);
	}
//	单个删除
	public int delete(MyresourceKey key) throws Exception {
		int i=0;
		if(key!=null){
			if(key.getMyresourceId()!=null){
				i = myresourceMapper.deleteByPrimaryKey(key);
			}
		}
		return i;
	}
	
	public int update(Myresource myresource) {
		return myresourceMapper.updateByPrimaryKeyWithBLOBs(myresource);
	}

	/**
	 * easyui条件查所有
	 */
	public List<Myresource> select(Page p, MyresourceExample example) throws Exception {
		PageHelper.offsetPage(p.getStart(), p.getCount());		
		if(p.getKeyword()!=null){
			Criteria criteria = example.createCriteria();
			criteria.andMyresourceTitleEqualTo(p.getKeyword());			
		}		
		example.setOrderByClause("order_by desc");
		List<Myresource> list = myresourceMapper.selectByExample(example);
//		该方法需要注意，犯错了
		int total = (int) new PageInfo<Myresource>(list).getTotal();
		p.setLast(total);
		p.setPc(total);
		p.setRows(total);		
		return list;
	}

//	根据主键查单个对象
	public Myresource selectByKey(MyresourceKey key) throws Exception {
		if(key!=null){
			if(key.getMyresourceId()!=null && !"".equals(key.getMyresourceId())){
				return myresourceMapper.selectByPrimaryKey(key);
			}
		}
		return null;
	}
	

}
