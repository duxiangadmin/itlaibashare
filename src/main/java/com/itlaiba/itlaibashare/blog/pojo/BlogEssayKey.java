package com.itlaiba.itlaibashare.blog.pojo;

public class BlogEssayKey {
    private Integer orderBy;

    private String blogId;

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId == null ? null : blogId.trim();
    }
}