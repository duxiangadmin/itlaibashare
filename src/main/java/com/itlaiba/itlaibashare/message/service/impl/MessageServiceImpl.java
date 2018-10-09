package com.itlaiba.itlaibashare.message.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itlaiba.itlaibashare.message.mapper.MessageMapper;
import com.itlaiba.itlaibashare.message.pojo.Message;
import com.itlaiba.itlaibashare.message.pojo.MessageExample;
import com.itlaiba.itlaibashare.message.pojo.MessageExample.Criteria;
import com.itlaiba.itlaibashare.message.pojo.MessageKey;
import com.itlaiba.itlaibashare.message.service.MessageService;

/**
 * 留言业务层
 * @author 杜翔
 * @版本 V 1.0 
 * @date 2018年6月14日 上午9:16:45
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageMapper messageMapper;
	
	public int insert(Message message) throws Exception {
		int i = 0 ; 
		try {
			if(message!=null && message.getMessageContent()!=null){
				message.setMessageId(UUID.randomUUID().toString().replace("-", ""));
				if(message.getMessageUser().equals("") || message.getMessageUser()==null){
					message.setMessageUser("游客"+UUID.randomUUID().toString().replace("-", "").substring(0, 4));
				}	
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String date = dateFormat.format(new Date());
				message.setMessageTime(date);
				i = messageMapper.insert(message);
			}
		} catch (Exception e) {
			throw new Exception("添加留言失败");
		}		
		return i;
	}

	/**
	 * easyui查询所有数据
	 */
	public List<Message> select(MessageExample example) throws Exception {
		example.setOrderByClause("order_by desc");
		Criteria criteria = example.createCriteria();		
		List<Message> list = messageMapper.selectByExample(example);
		return list;
	}

	public int deleteByPrimaryKey(MessageKey key) throws Exception {
		int i =0;
			i = messageMapper.deleteByPrimaryKey(key);
		return i;
	}

}
