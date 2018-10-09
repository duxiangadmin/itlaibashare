package com.itlaiba.itlaibashare.syscontroller;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/** 用作页面条状的控制层handler
 * 主要用来抽取某些页面跳转地址类型一样
 * 使用resutful风格url
 * @author 杜翔
 * @版本 V 1.0 
 * @date 2018年6月14日 上午12:13:31
 * 
 */
@Controller
@RequestMapping("/base")
public class BaseController {

	@Resource
	public ServletContext application;
	
	@RequestMapping("/gourl/{folder}/{file}")
	public String gourl(@PathVariable String folder,@PathVariable String file){		
		return "forward:/"+folder+"/"+file+".jsp";
	}
	
	@RequestMapping("/adminurl/{folder}/{file}")
	public String goadminurl(@PathVariable String folder,@PathVariable String file){		
		return "forward:/WEB-INF/jsp/"+folder+"/"+file+".jsp";
	}
	
}
