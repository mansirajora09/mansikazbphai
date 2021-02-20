package com.bng.zbp.request;

import java.util.List;


public class AdDetail {
	private String customerId;
	private String contentFormat;
	private double contentSize;
	private String fetchType;
	private int durationInSec;
	private int maxPlayCount;
	private int maxCountPerUser;
	private int currentSec;
	private int currentCount;
	private int currentClickCount;

	private int maxMou;
	private int maxClickCount;
	private String createdby;
    private String[] publisher;
    private String affiliateId;
    private String operator;
    private String agency;
    private String agencyName;
    private String advertiserName;
    private String[] publisherName;
private String advertiser;


		public String getAdvertiser() {
	return advertiser;
}
public void setAdvertiser(String advertiser) {
	this.advertiser = advertiser;
}
		public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getAdvertiserName() {
		return advertiserName;
	}
	public void setAdvertiserName(String advertiserName) {
		this.advertiserName = advertiserName;
	}
	public String[] getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String[] publisherName) {
		this.publisherName = publisherName;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public int getCurrentClickCount() {
		return currentClickCount;
	}
	public void setCurrentClickCount(int currentClickCount) {
		this.currentClickCount = currentClickCount;
	}
	public String getAffiliateId() {
		return affiliateId;
	}
	public void setAffiliateId(String affiliateId) {
		this.affiliateId = affiliateId;
	}
	public String[] getPublisher() {
		return publisher;
	}
	public void setPublisher(String[] publisher) {
		this.publisher = publisher;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public int getMaxClickCount() {
		return maxClickCount;
	}
	public void setMaxClickCount(int maxClickCount) {
		this.maxClickCount = maxClickCount;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFetchType() {
		return fetchType;
	}
	public void setFetchType(String fetchType) {
		this.fetchType = fetchType;
	}
	public int getDurationInSec() {
		return durationInSec;
	}
	public void setDurationInSec(int durationInSec) {
		this.durationInSec = durationInSec;
	}
	public int getMaxPlayCount() {
		return maxPlayCount;
	}
	public void setMaxPlayCount(int maxPlayCount) {
		this.maxPlayCount = maxPlayCount;
	}
	public int getMaxCountPerUser() {
		return maxCountPerUser;
	}
	public void setMaxCountPerUser(int maxCountPerUser) {
		this.maxCountPerUser = maxCountPerUser;
	}
	public int getCurrentSec() {
		return currentSec;
	}
	public void setCurrentSec(int currentSec) {
		this.currentSec = currentSec;
	}
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	public int getMaxMou() {
		return maxMou;
	}
	public void setMaxMou(int maxMou) {
		this.maxMou = maxMou;
	}
	public String getContentFormat() {
		return contentFormat;
	}
	public void setContentFormat(String contentFormat) {
		this.contentFormat = contentFormat;
	}
	public double getContentSize() {
		return contentSize;
	}
	public void setContentSize(double contentSize) {
		this.contentSize = contentSize;
	}
	
}
