package com.itlaiba.itlaibashare.page;

/**
 * 作为pageHelper分页的类
 * @author 杜翔
 * @版本 V 1.0 
 * @date 2018年6月13日 下午11:47:44
 * 
 */
public class Page {

	int start=0;//开始位置
	int count = 10;//每页显示大小
	int last = 0;//最后一页
	int tp;//总页数
	int pc;//当前页
	int rows;//总数居大小
	String keyword;//搜索关键字
	String url;//获取url
	String ify;
	
	public String getIfy() {
		return ify;
	}
	public void setIfy(String ify) {
		this.ify = ify;
	}
	public int getPc() {
		pc =start==0?1:start/count+1;
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}	
	public int getTp() {
		return tp%count==0?tp/count:tp/count+1;
	}
	public void setTp(int tp) {
		this.tp = tp;
	}
	
	public void caculateLast(int total) {
	    // 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
	    if (0 == total % count)
	        last = total - count;
	    // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
	    else
	        last = total - total % count;		
	}

	
	
	
}
