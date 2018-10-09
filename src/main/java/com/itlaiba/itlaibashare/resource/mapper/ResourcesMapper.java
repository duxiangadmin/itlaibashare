package com.itlaiba.itlaibashare.resource.mapper;

import com.itlaiba.itlaibashare.resource.pojo.Resources;
import com.itlaiba.itlaibashare.resource.pojo.ResourcesExample;
import com.itlaiba.itlaibashare.resource.pojo.ResourcesWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourcesMapper {
    long countByExample(ResourcesExample example);

    int deleteByExample(ResourcesExample example);

    int deleteByPrimaryKey(String resourceId);

    int insert(ResourcesWithBLOBs record);

    int insertSelective(ResourcesWithBLOBs record);

    List<ResourcesWithBLOBs> selectByExampleWithBLOBs(ResourcesExample example);

    List<Resources> selectByExample(ResourcesExample example);

    ResourcesWithBLOBs selectByPrimaryKey(String resourceId);

    int updateByExampleSelective(@Param("record") ResourcesWithBLOBs record, @Param("example") ResourcesExample example);

    int updateByExampleWithBLOBs(@Param("record") ResourcesWithBLOBs record, @Param("example") ResourcesExample example);

    int updateByExample(@Param("record") Resources record, @Param("example") ResourcesExample example);

    int updateByPrimaryKeySelective(ResourcesWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ResourcesWithBLOBs record);

    int updateByPrimaryKey(Resources record);
}