package com.itlaiba.itlaibashare.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itlaiba.itlaibashare.page.Page;
import com.itlaiba.itlaibashare.video.mapper.StudyvideoMapper;
import com.itlaiba.itlaibashare.video.pojo.Studyvideo;
import com.itlaiba.itlaibashare.video.service.StudyVideoService;

@Service
@Transactional(rollbackFor=Exception.class)
public class StudyVideoImpl implements StudyVideoService{

	@Autowired
	private StudyvideoMapper sdyMapper;
	
	public long count(Page page) {
		return sdyMapper.count(page);
	}

	public List<Studyvideo> selectAll(Page page) {
		PageHelper.offsetPage(page.getStart(), page.getCount());
		List<Studyvideo> sdyVideos = sdyMapper.selectAll(page);
		int total = (int) new PageInfo<Studyvideo>(sdyVideos).getTotal();
		page.setLast(total);
		page.setRows(total);
		page.setTp(total);
		page.caculateLast(total);
		return sdyVideos;
	}

	public Studyvideo selectById(Integer id) {
		Studyvideo studyvideo = sdyMapper.selectById(id);
		return studyvideo;
	}

	public int insert(Studyvideo studyvideo) {
		int i = sdyMapper.insert(studyvideo);
		return i;
	}

}
