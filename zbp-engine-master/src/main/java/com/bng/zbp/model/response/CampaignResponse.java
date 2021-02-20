package com.bng.zbp.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Mansi Rajora
 */

@Data
public class CampaignResponse{

    private Integer slNo;
    @JsonProperty("type")
    private String campaingType;


    @JsonProperty("optionList")
    private List<CampaignContentResonseBO> campaignContentList;

    public CampaignResponse() {
    }

    public CampaignResponse(Integer slNo, String campaingType, List<CampaignContentResonseBO> campaignContentList) {
        this.slNo = slNo;
        this.campaingType = campaingType;
        this.campaignContentList = campaignContentList;
    }

    public CampaignResponse(List<CampaignContentResonseBO> campaignContentList) {
        this(null, "SponsoredAd", campaignContentList);
    }
}
