package com.itlaiba.itlaibashare.message.service;

import java.util.List;

import com.itlaiba.itlaibashare.message.pojo.Message;
import com.itlaiba.itlaibashare.message.pojo.MessageExample;
import com.itlaiba.itlaibashare.message.pojo.MessageKey;

public interface MessageService {
	public int insert(Message message)throws Exception;
	public List<Message> select(MessageExample example)throws Exception; 
	public int deleteByPrimaryKey(MessageKey key) throws Exception;
}
