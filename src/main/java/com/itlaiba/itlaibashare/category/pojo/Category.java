package com.itlaiba.itlaibashare.category.pojo;

import java.io.Serializable;

/**
 * 导航栏实体类
 * @author 杜翔
 * @版本 V 1.0 
 * @date 2018年6月22日 下午1:23:16
 */
public class Category implements Serializable{
	private static final long serialVersionUID = -3752709689105874635L;
	
	private Integer categoryId;
	private String categoryName;
	private String categoryUrl;
	private Integer categoryPid;
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryUrl() {
		return categoryUrl;
	}
	public void setCategoryUrl(String categoryUrl) {
		this.categoryUrl = categoryUrl;
	}
	public Integer getCategoryPid() {
		return categoryPid;
	}
	public void setCategoryPid(Integer categoryPid) {
		this.categoryPid = categoryPid;
	}
}
