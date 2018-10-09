package com.itlaiba.itlaibashare.base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 工具类，用来操作时间的一些简单方法
 * @author 杜翔
 * @版本 V 1.0 
 * @date 2018年6月25日 下午2:29:28
 */
public class GetDate {
	
	/**
	 * 获取系统时间转换为年月日时分秒的格式字符串
	 * @return
	 */
	public static String GetsimpleDate(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = dateFormat.format(new Date());
		return date;
	}
	
	/**
	 * 获取系统时间，但是只获取年月日
	 * @return
	 */
	public static String GetsimpleDateDay(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateFormat.format(new Date());
		return date;
	}
	
	/**
	 * 本来准备用来截断时间的，但是这里暂时废弃
	 * @param date
	 * @return
	 */
	public static String conversionDate(String date){
		date=date.substring(0, 10);
		return date;
	}	
}
