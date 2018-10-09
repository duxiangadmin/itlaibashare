package com.itlaiba.itlaibashare.resource.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Resources {
    private String resourceId;

    private String resourceName;
    
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date resourceCreateTime;

    private Integer resourceNumber;

    private Integer ordeBy;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public Date getResourceCreateTime() {
        return resourceCreateTime;
    }

    public void setResourceCreateTime(Date resourceCreateTime) {
        this.resourceCreateTime = resourceCreateTime;
    }

    public Integer getResourceNumber() {
        return resourceNumber;
    }

    public void setResourceNumber(Integer resourceNumber) {
        this.resourceNumber = resourceNumber;
    }

    public Integer getOrdeBy() {
        return ordeBy;
    }

    public void setOrdeBy(Integer ordeBy) {
        this.ordeBy = ordeBy;
    }

	@Override
	public String toString() {
		return "Resources [resourceId=" + resourceId + ", resourceName=" + resourceName + ", resourceCreateTime="
				+ resourceCreateTime + ", resourceNumber=" + resourceNumber + ", ordeBy=" + ordeBy + "]";
	}
    
}