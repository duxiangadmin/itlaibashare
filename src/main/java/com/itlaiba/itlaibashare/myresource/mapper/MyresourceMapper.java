package com.itlaiba.itlaibashare.myresource.mapper;

import com.itlaiba.itlaibashare.myresource.pojo.Myresource;
import com.itlaiba.itlaibashare.myresource.pojo.MyresourceExample;
import com.itlaiba.itlaibashare.myresource.pojo.MyresourceKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyresourceMapper {
    long countByExample(MyresourceExample example);

    int deleteByExample(MyresourceExample example);

    int deleteByPrimaryKey(MyresourceKey key);

    int insert(Myresource record);

    int insertSelective(Myresource record);

    List<Myresource> selectByExampleWithBLOBs(MyresourceExample example);

    List<Myresource> selectByExample(MyresourceExample example);

    Myresource selectByPrimaryKey(MyresourceKey key);

    int updateByExampleSelective(@Param("record") Myresource record, @Param("example") MyresourceExample example);

    int updateByExampleWithBLOBs(@Param("record") Myresource record, @Param("example") MyresourceExample example);

    int updateByExample(@Param("record") Myresource record, @Param("example") MyresourceExample example);

    int updateByPrimaryKeySelective(Myresource record);

    int updateByPrimaryKeyWithBLOBs(Myresource record);

    int updateByPrimaryKey(Myresource record);
}