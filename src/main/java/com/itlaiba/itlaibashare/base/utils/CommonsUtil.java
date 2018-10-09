package com.itlaiba.itlaibashare.base.utils;

import javax.servlet.http.HttpServletRequest;

public class CommonsUtil {
	public static String getRealPath(HttpServletRequest req,String img){
		String realPath = req.getServletContext().getRealPath("/"+img);
		return realPath;
	}
	
	public static String getUrl(HttpServletRequest req){
		String url = req.getRequestURI();
		String q = req.getQueryString();
		url = url+"?"+q;
		int index = url.indexOf("&start");
		if(index!=-1){
			url = url.substring(0, index);
		}
		return url;
	}
}
