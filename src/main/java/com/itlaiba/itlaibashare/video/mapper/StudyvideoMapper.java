package com.itlaiba.itlaibashare.video.mapper;

import java.util.List;

import com.itlaiba.itlaibashare.page.Page;
import com.itlaiba.itlaibashare.video.pojo.Studyvideo;

public interface StudyvideoMapper {
   long count(Page page);
   List<Studyvideo> selectAll(Page page);
   Studyvideo selectById(Integer id);
   int insert(Studyvideo studyvideo);
}