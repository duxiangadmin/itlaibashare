package com.itlaiba.itlaibashare.myresource.pojo;

public class MyresourceKey {
    private Integer orderBy;

    private String myresourceId;

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public String getMyresourceId() {
        return myresourceId;
    }

    public void setMyresourceId(String myresourceId) {
        this.myresourceId = myresourceId == null ? null : myresourceId.trim();
    }
}