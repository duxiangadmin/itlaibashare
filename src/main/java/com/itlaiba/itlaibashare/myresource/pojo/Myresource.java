package com.itlaiba.itlaibashare.myresource.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Myresource extends MyresourceKey {
    private String myresourceTitle;

    private String myresourceImg;

    private String myresourceSayurl;
    
    private String myresourceUrl;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat
    private Date myresourceTime;

    private Integer myresourceNumber;

    private String userId;

    private String myresourceContent;

    public String getMyresourceTitle() {
        return myresourceTitle;
    }

    public void setMyresourceTitle(String myresourceTitle) {
        this.myresourceTitle = myresourceTitle == null ? null : myresourceTitle.trim();
    }

    public String getMyresourceImg() {
        return myresourceImg;
    }

    public void setMyresourceImg(String myresourceImg) {
        this.myresourceImg = myresourceImg == null ? null : myresourceImg.trim();
    }

 

	public String getMyresourceSayurl() {
		return myresourceSayurl;
	}

	public void setMyresourceSayurl(String myresourceSayurl) {
		this.myresourceSayurl = myresourceSayurl;
	}

	public String getMyresourceUrl() {
        return myresourceUrl;
    }

    public void setMyresourceUrl(String myresourceUrl) {
        this.myresourceUrl = myresourceUrl == null ? null : myresourceUrl.trim();
    }

    public Date getMyresourceTime() {
        return myresourceTime;
    }

    public void setMyresourceTime(Date myresourceTime) {
        this.myresourceTime = myresourceTime;
    }

    public Integer getMyresourceNumber() {
        return myresourceNumber;
    }

    public void setMyresourceNumber(Integer myresourceNumber) {
        this.myresourceNumber = myresourceNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getMyresourceContent() {
        return myresourceContent;
    }

    public void setMyresourceContent(String myresourceContent) {
        this.myresourceContent = myresourceContent == null ? null : myresourceContent.trim();
    }

	@Override
	public String toString() {
		return "Myresource [myresourceTitle=" + myresourceTitle + ", myresourceImg=" + myresourceImg
				+ ", myresourceUrl=" + myresourceUrl + ", myresourceTime=" + myresourceTime + ", myresourceNumber="
				+ myresourceNumber + ", userId=" + userId + ", myresourceContent=" + myresourceContent + "]";
	}
    
}