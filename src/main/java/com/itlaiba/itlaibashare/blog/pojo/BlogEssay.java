package com.itlaiba.itlaibashare.blog.pojo;

public class BlogEssay extends BlogEssayKey {
    private String blogTitle;

    private String blogImg;

    private String blogCreateTime;

    private Integer blogClassify;

    private Integer blogRedNum;

    private String blogContent;

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    public String getBlogImg() {
        return blogImg;
    }

    public void setBlogImg(String blogImg) {
        this.blogImg = blogImg == null ? null : blogImg.trim();
    }

    public String getBlogCreateTime() {
        return blogCreateTime;
    }

    public void setBlogCreateTime(String blogCreateTime) {
        this.blogCreateTime = blogCreateTime == null ? null : blogCreateTime.trim();
    }

    public Integer getBlogClassify() {
        return blogClassify;
    }

    public void setBlogClassify(Integer blogClassify) {
        this.blogClassify = blogClassify;
    }

    public Integer getBlogRedNum() {
        return blogRedNum;
    }

    public void setBlogRedNum(Integer blogRedNum) {
        this.blogRedNum = blogRedNum;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent == null ? null : blogContent.trim();
    }
}