package com.bng.zbp.request;

import com.bng.zbp.model.entity.Campaign;
import com.bng.zbp.model.enums.MediaType;

public class ContentInfo {
	private String id;
	private int height;
	private int width;
	private int currentPlayCount;
	private int currentClickCount;
	private int currentMOU;
	private String contentPath;
	private String redirectUrl;
	private String name;
	private boolean status;
	private String auditstatus;
	private Double percentage;
	//private int actualheight;
	//private int actualwidth;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getCurrentPlayCount() {
		return currentPlayCount;
	}
	public void setCurrentPlayCount(int currentPlayCount) {
		this.currentPlayCount = currentPlayCount;
	}
	public int getCurrentClickCount() {
		return currentClickCount;
	}
	public void setCurrentClickCount(int currentClickCount) {
		this.currentClickCount = currentClickCount;
	}
	public int getCurrentMOU() {
		return currentMOU;
	}
	public void setCurrentMOU(int currentMOU) {
		this.currentMOU = currentMOU;
	}
	public String getContentPath() {
		return contentPath;
	}
	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getAuditstatus() {
		return auditstatus;
	}
	public void setAuditstatus(String auditstatus) {
		this.auditstatus = auditstatus;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
	
	}
