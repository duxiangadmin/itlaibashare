package com.itlaiba.itlaibashare.blog.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.itlaiba.itlaibashare.base.utils.CommonsUtil;
import com.itlaiba.itlaibashare.base.utils.GetDate;
import com.itlaiba.itlaibashare.base.utils.GetUUID;
import com.itlaiba.itlaibashare.blog.pojo.BlogEssay;
import com.itlaiba.itlaibashare.blog.service.BlogEssayService;
import com.itlaiba.itlaibashare.page.Page;

@Controller
@RequestMapping("/blog")
public class BlogEssayController {

	@Autowired
	private BlogEssayService blogEssayService;
	
	/**
	 * easyui添加单篇文章
	 */
	@RequestMapping("/insert")
	public @ResponseBody int insert(BlogEssay blogEssay,MultipartFile file,HttpServletRequest req){
		int i = 0;
		if(blogEssay!=null){
			if(file!=null && file.getSize()>0){
				String originalFilename = file.getOriginalFilename();				
				String day = GetDate.GetsimpleDateDay();
				String realPath = req.getServletContext().getRealPath("/img/"+day+"/");	
				String newFileName = GetUUID.getUUID().substring(0, 4)+originalFilename;
				File serverFile = new File(realPath+newFileName);
				if(!serverFile.getParentFile().exists()){
					serverFile.mkdirs();
				}
				try {
					file.transferTo(serverFile);
					blogEssay.setBlogImg("/img/"+day+"/"+newFileName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			i = blogEssayService.insert(blogEssay);
		}
		return i;
	}
	
	/**
	 * 批量删除文章
	 * @param id
	 * @param imgs
	 * @param req
	 * @return
	 */
	@RequestMapping(value="deleteList",method=RequestMethod.POST)	
	public @ResponseBody int deleteList(String[] id,String imgs[],HttpServletRequest req){
		int i =0;
		try {
			i = blogEssayService.deleteList(id);
			for(int n =0;n<id.length && i!=0;n++){
//				得到每一个文件的绝对路径
				if(!"".equals(imgs[n])){
					String realPath = CommonsUtil.getRealPath(req, imgs[n]);
					File file = new File(realPath);
					file.delete();
				}
			}
		} catch (Exception e) {
			
		}		
		return i;
	}
	
	/**
	 * 修改文章
	 * @param blogEssay 表单提交的值
	 * @param file
	 * @param req
	 * @return
	 */
	@RequestMapping("/update")
	public @ResponseBody int update(BlogEssay blogEssay,MultipartFile file,HttpServletRequest req){
		int i = 0;
		if(file!=null && file.getSize()>0){
			String originalFileName = file.getOriginalFilename();
			String day = GetDate.GetsimpleDateDay();
			String newFileName = "/img/"+day+"/"+GetUUID.getUUID().substring(0, 4)+originalFileName;
			String realPath = CommonsUtil.getRealPath(req, newFileName);
			File serverFile = new File(realPath);
			if(!serverFile.getParentFile().exists()){
				serverFile.mkdirs();
			}
			try {
				file.transferTo(serverFile);
				/*此处如果项保留原始图片，可以不删除原图,需求而定
				 * 
				 */
				String orginalBlogImg = blogEssay.getBlogImg();
				String orginalPath = CommonsUtil.getRealPath(req, orginalBlogImg);
				new File(orginalPath).delete();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			blogEssay.setBlogImg(newFileName);
		}
		i = blogEssayService.update(blogEssay);
		return i ;
	}
	
	/**
	 * easyui使用的列表页，
	 * @param page
	 * @param rows
	 * @param p
	 * @return
	 */
	@RequestMapping("/selectList")
	public @ResponseBody Map<String, Object> selectList(int page,int rows,Page p){
		Map<String, Object> map = new HashMap<String, Object>();
		p.setStart((page-1)*rows);
		p.setCount(rows);
		List<BlogEssay> blogList = blogEssayService.selectList(p);
		map.put("total",p.getRows());
		map.put("rows", blogList);
		return map;
	}
	
	/**
	 * 前台查询所有
	 * @param page
	 * @param req
	 * @return
	 */
	@RequestMapping("/select")
	public String select(Page page,HttpServletRequest req){
		page.setUrl(CommonsUtil.getUrl(req));
//		List<BlogEssay> blogEssays = new ArrayList<BlogEssay>();
		List<BlogEssay> list = blogEssayService.select(page);
		req.setAttribute("blogEssays", list);
		return "forward:/main/blog.jsp";
	}
	
	/**
	 * 前台查询文章详细
	 * @param id 根据id查询文章
	 * @param req 
	 * @return
	 */
	@RequestMapping("/selectByKey/{id}")
	public String selectByKey(@PathVariable String id,HttpServletRequest req){
		BlogEssay blogEssay = null;
		blogEssay = blogEssayService.selectByPrimaryKey(id);
		if(blogEssay!=null){
			req.setAttribute("blogEssay", blogEssay);
		}else{
			req.setAttribute("msg", "查无此文");
		}
		return "forward:/main/blogDetail.jsp";
	}
	
	
	/**
	 * easyui使用的查询文章详细
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping("/selectById/{id}")
	public String selectById(@PathVariable String id,HttpServletRequest req){
		BlogEssay blogEssay = null;
		blogEssay = blogEssayService.selectByPrimaryKey(id);
		if(blogEssay!=null){
			req.setAttribute("blogEssay", blogEssay);
		}else{
			req.setAttribute("msg", "查无此文");
		}
		return "blog/update";
	}
	
	
	
}
