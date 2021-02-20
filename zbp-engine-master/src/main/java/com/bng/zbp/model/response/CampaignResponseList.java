package com.bng.zbp.model.response;

import java.util.List;

import com.bng.zbp.model.entity.Campaign;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampaignResponseList extends  BaseResponse {

   // private String msisdn;
   // private Double mainBalance;
    @JsonProperty("bundleOptionList")
    private List<CampaignResponseBO> campaignResponseList;
}
