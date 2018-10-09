package com.itlaiba.itlaibashare.video.pojo;

public class Studyvideo {
    private Integer id;

    private String videoName;

    private String videoSummary;

    private String videoUrl;

    private Integer videoIfy;

    private String videoContent;
    
    private Integer videoMoney;

    public Integer getVideoMoney() {
		return videoMoney;
	}

	public void setVideoMoney(Integer videoMoney) {
		this.videoMoney = videoMoney;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName == null ? null : videoName.trim();
    }

    public String getVideoSummary() {
        return videoSummary;
    }

    public void setVideoSummary(String videoSummary) {
        this.videoSummary = videoSummary == null ? null : videoSummary.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public Integer getVideoIfy() {
        return videoIfy;
    }

    public void setVideoIfy(Integer videoIfy) {
        this.videoIfy = videoIfy;
    }

    public String getVideoContent() {
        return videoContent;
    }

    public void setVideoContent(String videoContent) {
        this.videoContent = videoContent == null ? null : videoContent.trim();
    }
}