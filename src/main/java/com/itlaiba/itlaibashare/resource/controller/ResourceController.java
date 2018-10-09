package com.itlaiba.itlaibashare.resource.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itlaiba.itlaibashare.myresource.pojo.Myresource;
import com.itlaiba.itlaibashare.myresource.pojo.MyresourceExample;
import com.itlaiba.itlaibashare.myresource.service.MyresourceService;
import com.itlaiba.itlaibashare.page.Page;
import com.itlaiba.itlaibashare.pagesize.ShowPage;
import com.itlaiba.itlaibashare.resource.pojo.ResourcesExample;
import com.itlaiba.itlaibashare.resource.pojo.ResourcesWithBLOBs;
import com.itlaiba.itlaibashare.resource.service.ResourceService;
import com.itlaiba.itlaibashare.syscontroller.BaseController;

/**
 * resource资源的控制层 
 * 公共资源的handler
 * @author 杜翔
 * @版本 V 1.0 
 * @date 2018年6月13日 下午11:49:10
 */

@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseController{

	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private MyresourceService myresourceService;

	/**
	 * 用来添加资源的方法
	 * @param bloBs 实体类
	 * @return int i (前台接受json数据查看是否添加成功)
	 */
	@RequestMapping("/insert")
	public @ResponseBody int insert(ResourcesWithBLOBs bloBs){		
		int i = resourceService.insert(bloBs);
		return i;
	}
	
	//删除方法
	@RequestMapping("delete")
	public @ResponseBody int delete(String resourceId){
		int i = 0 ;
		i = resourceService.deleteByPrimaryKey(resourceId);
		return i;
	}
//	修改方法（只支持单个修改）
	@RequestMapping("/update")
	public @ResponseBody int update(ResourcesWithBLOBs bloBs){
		int i =0;
		i = resourceService.updateByPrimaryKeyWithBLOBs(bloBs);
		return i;
	}
	
//	easyui使用的查询所有的方法，返回的是列表页
	@RequestMapping("/select")
	public @ResponseBody Map<String, Object> select(int page,int rows,ResourcesExample example,Page p){
//		分页查询数据从哪儿开始，查几条
		p.setStart((page-1)*rows);
		p.setCount(rows);
		PageHelper.offsetPage(p.getStart(), p.getRows());
//		查询出所有信息
		List<ResourcesWithBLOBs> list = resourceService.select(p,example);
//		总记录数
		int total = (int) new PageInfo<ResourcesWithBLOBs>(list).getTotal();
//		因为easyui需要的数据格式是json且分页必须包含两个信息total，和rows
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
	
//	easyui使用的主键查询单个对象，用做修改前查询信息的使用
	@RequestMapping("/selectId/{resouceId}")
	public @ResponseBody ResourcesWithBLOBs selectId(@PathVariable("resouceId") String resourceId){
		ResourcesWithBLOBs bloBs = resourceService.selectByPrimaryKey(resourceId);
		return bloBs;
	}
	
//	这个方法好像是测试的时候用的，忘了，暂时放着
//	这里使用的是pagehelper的分页插件，当时还是需要一个pagebean作为分页数据的存放地点
	@RequestMapping("/selectpage")
	public @ResponseBody List<ResourcesWithBLOBs> selectpage(Page page, ResourcesExample example){
//		分页查询数据从哪儿开始，查几条
		PageHelper.offsetPage(page.getStart(), 2);
//		查寻所有数据
		List<ResourcesWithBLOBs> list = resourceService.select(page,example);
//		总记录数
		int total = (int) new PageInfo<ResourcesWithBLOBs>(list).getTotal();
//		这个方法用来计算最后一页的页标
		page.caculateLast(total);
		return list;
	}
	
	/*
	 * 前台页面使用的
	 * 首页仅仅查询5条数据，所以这里固定写死
	 * 
	 * */	
//	@RequestMapping("sys")
//	public String selectpage(Page page,HttpServletRequest req,MyresourceExample mexample,ResourcesExample rexample){
//		page.setCount(ShowPage.SIZE);//如果首页要控制显示的数目，就在这里重新赋值即可
//		List<ResourcesWithBLOBs> list = resourceService.select(page,rexample);
//		req.setAttribute("blobs", list);
//		try {
//			List<Myresource> myresources = myresourceService.select(page, mexample);
//			req.setAttribute("myresources", myresources);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "forward:/index.jsp";
//	}
	
	/*
	 * 查询八条共享资料
	 */
	@RequestMapping("selectblob")
	public @ResponseBody List<ResourcesWithBLOBs> selectblob(Page page,HttpServletRequest req,MyresourceExample mexample,ResourcesExample rexample){
		page.setCount(ShowPage.SIZE);//如果首页要控制显示的数目，就在这里重新赋值即可
		List<ResourcesWithBLOBs> list = resourceService.select(page,rexample);		
		return list;
	}
	
	/*
	 * 查询八条共享项目
	 */
	@RequestMapping("selectmyresource")
	public @ResponseBody List<Myresource> selectmyresource(Page page,HttpServletRequest req,MyresourceExample mexample,ResourcesExample rexample){
		page.setCount(ShowPage.SIZE);//如果首页要控制显示的数目，就在这里重新赋值即可
		List<Myresource> myresources = null;
		try {
			myresources = myresourceService.select(page, mexample);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return myresources;
	}
	
	
	
	@SuppressWarnings("all")
	private  String geturl(HttpServletRequest req){
		String url = req.getRequestURI();
		String q = req.getQueryString();
		url = url+"?"+q;
		int index = url.indexOf("&start");
		if(index!=-1){
			url = url.substring(0, index);
		}
		return url;
	}
	
	/*
	 * 这是更多资源下载页面的分页方法
	 * 
	 * */
	@RequestMapping("/syspage")
	public String syspage(Page page,ResourcesExample example,HttpServletRequest req){
		/*String url = req.getRequestURI();
		page.setUrl(url);
		String q = req.getQueryString();
		url = url+"?"+q;
		int index = url.indexOf("&start");
		url = url.substring(0, index);*/		
		page.setUrl(this.geturl(req));
//		从page中读取每次从哪一条数据开始到哪一条数据结束
//		PageHelper.offsetPage(page.getStart(), page.getCount());
//		查询所有数据		
		List<ResourcesWithBLOBs> list = resourceService.select(page,example);		
//		查询总记录数
//		int total = (int) new PageInfo<ResourcesWithBLOBs>(list).getTotal();
//		最后一页的页码
//		page.caculateLast(total);
////		该方法内部计算出总共有多少页，用作页面展示用
//		page.setTp(total);
////		总共的记录数
//		page.setRows(total);
//		传输到页面，这个域方位优点大。_。
		application.setAttribute("blobs", list);
		return "forward:/main/resources.jsp";
//		return list;
	}
	
	/**
	 * 资源分类查找
	 */
	@RequestMapping("/selectByClassify/{classify}")
	public String selectByClassify(@PathVariable String classify,HttpServletRequest req,Page page){
		
		return "";
	}
}
