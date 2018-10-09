package com.itlaiba.itlaibashare.message.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itlaiba.itlaibashare.message.pojo.Message;
import com.itlaiba.itlaibashare.message.pojo.MessageExample;
import com.itlaiba.itlaibashare.message.pojo.MessageKey;

public interface MessageMapper {
    long countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(MessageKey key);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(MessageKey key);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}