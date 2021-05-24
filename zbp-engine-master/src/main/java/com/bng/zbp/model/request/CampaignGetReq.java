package com.bng.zbp.model.request;

public class CampaignGetReq {
private String userId;
private Long campaignId;
public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public Long getCampaignId() {
	return campaignId;
}

public void setCampaignId(Long campaignId) {
	this.campaignId = campaignId;
}

}
