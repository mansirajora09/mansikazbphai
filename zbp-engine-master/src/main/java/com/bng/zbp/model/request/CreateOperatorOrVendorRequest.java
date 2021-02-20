package com.bng.zbp.model.request;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author Mansi Rajora
 */

public class CreateOperatorOrVendorRequest extends BaseRequest {
	
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("logoImageUrl")
    private String logoImageUrl;
    @JsonProperty("bannerUrl")
    private String bannerUrl;
    @JsonProperty("operatorId")
    private Long operatorId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoImageUrl() {
        return logoImageUrl;
    }

    public void setLogoImageUrl(String logoImageUrl) {
        this.logoImageUrl = logoImageUrl;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }
}
