package com.itlaiba.itlaibashare.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itlaiba.itlaibashare.users.pojo.Users;
import com.itlaiba.itlaibashare.users.service.UsersService;

/**
 * user控制层
 * 这里是管理员登陆的控制层
 * @author 杜翔
 * @版本 V 1.0 
 * @date 2018年6月14日 上午12:15:41
 */
@Controller
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	/*
	 * 用户登陆的方法
	 * example主要用来作为条件查询
	 * 因为用户登录查询需要账号及密码，这里注册一个users对象保存登陆时调教的账号密码
	 * */
	@RequestMapping("/login")
	public String login(Users users,HttpServletRequest request){
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(users.getLoginId(), users.getLoginPwd());
		try {
			subject.login(token);
			request.getSession().setAttribute("users", users);			
			return "main/main";
		} catch (Exception e) {
			request.setAttribute("msg", "账号或密码错误");
			request.setAttribute("user", users);
			return "forward:/login.jsp";
		}	
	
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(Users user,HttpServletRequest req){
		int i = 0;
		try {
			Users dbuser = usersService.selectByPrimaryKey(user.getLoginId());		
			if(dbuser==null){
				i = usersService.insert(user);
				req.setAttribute("msg", "注册成功，可以登录，您的身份是普通管理员");
				return "forward:/login.jsp";
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		req.setAttribute("msg", "账号注册失败，请重新注册");
		req.setAttribute("user", user);
		return "forward:/addId.jsp";
	}
}
