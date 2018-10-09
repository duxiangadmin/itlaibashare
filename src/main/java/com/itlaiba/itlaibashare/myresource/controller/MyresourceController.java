package com.itlaiba.itlaibashare.myresource.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.itlaiba.itlaibashare.myresource.pojo.Myresource;
import com.itlaiba.itlaibashare.myresource.pojo.MyresourceExample;
import com.itlaiba.itlaibashare.myresource.pojo.MyresourceKey;
import com.itlaiba.itlaibashare.myresource.service.MyresourceService;
import com.itlaiba.itlaibashare.page.Page;
import com.itlaiba.itlaibashare.users.pojo.Users;

@Controller
@RequestMapping("/myresource")
public class MyresourceController {
	@Autowired
	private MyresourceService myresourceService;
	
	@RequestMapping("/insert")
//	此处上传的时候multipartfile的属性名必须和前台页面file的name值一样，否则null
	public @ResponseBody int insert(Myresource myresource,HttpServletRequest req,MultipartFile file){
		String parameter = req.getParameter("myresourceContent");
		int i=0;
//		获取上传的文件名称
		String name = file.getOriginalFilename();
//		根据上传时间创建文件夹
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String format = dateFormat.format(new Date());
		String path = req.getServletContext().getRealPath("/img/"+format+"/");
//		判断上传文件是否存在，存在就加入对应属性及获取文件
		if(file.getSize()>0){
//			为图片是名称加入uuid
			String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 4);
//			根据绝对路径创建文件对象			
			File f = new File(path+uuid+name);
//			判断文件据对路径下的文件夹是否都存在，不存在创建所有文件夹
			if(!f.getParentFile().exists()){
				f.getParentFile().mkdirs();
			}
			try {
//				保存文件数据到服务器
				file.transferTo(f);
//				为实体对象添加属性
				myresource.setMyresourceImg(format+"/"+uuid+name);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
//			判断是否登陆，登陆就为实体对象添加对应的角色属性
			Users users = (Users) req.getSession().getAttribute("users");
			myresource.setUserId(users.getUid());
//			调用service
			i = myresourceService.insert(myresource);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	@RequestMapping("/delete")
	public @ResponseBody int delete(MyresourceKey key,String img,HttpServletRequest req){
		int i = 0;
		String path = req.getServletContext().getRealPath("/img/"+img);		
		try {
			i=myresourceService.delete(key);
			File file = new File(path);
			if(file.exists()){
				file.delete();
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return i;
	}
	
	@RequestMapping("/update")
	public @ResponseBody int update(String myresourceTime1 ,Myresource myresource,MultipartFile file,HttpServletRequest req){		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH：mm：ss");
//		获取原存在数据库中的图片名称
		String origImg = myresource.getMyresourceImg();
//		获取型上传的图片名称
		String filename = file.getOriginalFilename();
//		如果有新上传的图片
		if(filename.length()>0){
//			根据时间创建文件夹
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dformat = dateFormat.format(new Date());
//			获取一个据对路径
			String path = req.getServletContext().getRealPath("/img/"+dformat+"/");
//			加入uuid
			String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 4);
//			根据绝对路径创建文件对象（绝对路径/img/时间/+uuid+新图片名）			
			File f = new File(path+uuid+filename);
//			判断文件绝对路径下的文件夹是否都存在，不存在创建所有文件夹
			if(!f.getParentFile().exists()){
				f.getParentFile().mkdirs();
			}
			try {
//				将放在服务器中的数据创建出来，创建图片
				file.transferTo(f);
//				为实体对象添加属性
				myresource.setMyresourceImg(dformat+"/"+uuid+filename);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			删除原始图片
//			获取保存图片文件夹的绝对路径（此处只需要获取到img文件夹就可以）
			String origPath = req.getServletContext().getRealPath("/img/");
			File deletfile = new File(origPath+origImg);
			deletfile.delete();
		}
		try {
			if("".equals(myresourceTime1)){
				myresource.setMyresourceTime(new Date());
			}else{
				Date date = format.parse(myresourceTime1);
				myresource.setMyresourceTime(date);
			}			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Users user = (Users) req.getSession().getAttribute("users");
		if(user!=null){
			myresource.setUserId(user.getUid());
		}
		int i = myresourceService.update(myresource);
		return i;
	}
	
	
//	easyui使用的列表页，需要分页
	@RequestMapping("/select")
	public @ResponseBody Map<String, Object> select(int page,int rows,Page p,MyresourceExample example){
		p.setStart((page-1)*rows);
		p.setCount(rows);
		try {
			List<Myresource> list = myresourceService.select(p,example);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("total", p.getRows());
			map.put("rows", list);
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
//	easyui使用的查询单个
	@RequestMapping("/selectByKey/{id}")
	public String selectByKey(@PathVariable String id,MyresourceKey key,HttpServletRequest req){
		try {
			key.setMyresourceId(id);
			Myresource myresource = myresourceService.selectByKey(key);
			req.setAttribute("myresource", myresource);
			return "myresource/update";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

}
