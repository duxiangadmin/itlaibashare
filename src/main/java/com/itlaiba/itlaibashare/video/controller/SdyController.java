package com.itlaiba.itlaibashare.video.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itlaiba.itlaibashare.base.utils.CommonsUtil;
import com.itlaiba.itlaibashare.blog.pojo.BlogEssay;
import com.itlaiba.itlaibashare.page.Page;
import com.itlaiba.itlaibashare.video.pojo.Studyvideo;
import com.itlaiba.itlaibashare.video.service.StudyVideoService;

@Controller
@RequestMapping("/sdy")
public class SdyController {

	@Autowired
	private StudyVideoService sdyService;
	
	@GetMapping("/count")
	public @ResponseBody int count(Page page){
		return (int) sdyService.count(page);
	}
	
	/*
	 *前台分页查所有
	 */
	@GetMapping("/selectAll")
	public String selectAll(Page page,HttpServletRequest req){
		page.setUrl(CommonsUtil.getUrl(req));
		List<Studyvideo> list = sdyService.selectAll(page);
		req.setAttribute("studyVideos", list);
		return "forward:/main/videoResources.jsp";
	}
	
	/*
	 * 查详细
	 */
	@GetMapping("/selectById/{id}")
	public String selectById(@PathVariable Integer id,HttpServletRequest req){
		Studyvideo studyvideo = sdyService.selectById(id);
		if(studyvideo!=null){
			req.setAttribute("studyvideo", studyvideo);
		}
		return "forward:/main/videoDetail.jsp";
	}
	/*
	 * 后台查所有
	 */
	
	@PostMapping("/selectList")
	public @ResponseBody Map<String, Object> selectList(int page,int rows,Page p){
		Map<String, Object> map = new HashMap<String, Object>();
		p.setStart((page-1)*rows);
		p.setCount(rows);
		List<Studyvideo> sdylist = sdyService.selectAll(p);
		map.put("total",p.getRows());
		map.put("rows", sdylist);
		return map;
	}
	
	/*
	 * 添加资源
	 */
	@RequestMapping("/insert")
	public @ResponseBody int insert(Studyvideo sdy){
		int i =0;
		 i = sdyService.insert(sdy);
		return i;
	}
}
