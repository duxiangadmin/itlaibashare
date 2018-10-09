package com.itlaiba.itlaibashare.resource.pojo;

public class ResourcesWithBLOBs extends Resources {
	
    @Override
	public String toString() {
		return "ResourcesWithBLOBs [resourceIntroduce=" + resourceIntroduce + ", resourceUrl=" + resourceUrl + "]";
	}

	private String resourceIntroduce;

    private String resourceUrl;

    public String getResourceIntroduce() {
        return resourceIntroduce;
    }

    public void setResourceIntroduce(String resourceIntroduce) {
        this.resourceIntroduce = resourceIntroduce == null ? null : resourceIntroduce.trim();
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }
}