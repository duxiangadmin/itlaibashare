package com.itlaiba.itlaibashare.message.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itlaiba.itlaibashare.message.pojo.Message;
import com.itlaiba.itlaibashare.message.pojo.MessageExample;
import com.itlaiba.itlaibashare.message.pojo.MessageKey;
import com.itlaiba.itlaibashare.message.service.MessageService;
import com.itlaiba.itlaibashare.page.Page;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
//	前台留言提交
	@RequestMapping("/insert")
	public String insert(Page page,MessageExample example,Message message,HttpServletRequest req){
		try {
			messageService.insert(message);
//			return "redirect:/index.jsp#problem";
//			return "redirect:/main/message.jsp#problem";
			return selectpage(page,example, req);
		} catch (Exception e) {			
			String msg = e.getMessage();
			req.setAttribute("msg", msg);
			return "forward:/msg.jsp";
		}
	}
	
//	easyui根据主键删除
	@RequestMapping("/delete")
	public @ResponseBody int delete(MessageKey key){
		int i =0;
		try {
			i = messageService.deleteByPrimaryKey(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
//	后台easyui显示所有
	@RequestMapping("/select")
	public @ResponseBody Map<String, Object> select(int page,int rows,MessageExample example){
		try {
			PageHelper.offsetPage((page-1)*rows, rows);
			List<Message> list = messageService.select(example);
			int total = (int) new PageInfo<Message>(list).getTotal();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("total", total);
			map.put("rows", list);
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
//	前台显示所有问答
	@RequestMapping("/selectpage")
	public String selectpage(Page page,MessageExample example,HttpServletRequest req){
		try {
			PageHelper.offsetPage((page.getStart()), page.getCount());
			List<Message> list = messageService.select(example);
			int total = (int) new PageInfo<Message>(list).getTotal();
			page.setRows(total);
			page.setTp(total);
			req.setAttribute("messags", list);
			return "forward:/main/message.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
