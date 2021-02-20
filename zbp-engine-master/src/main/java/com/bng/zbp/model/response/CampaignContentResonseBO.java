package com.bng.zbp.model.response;

import com.bng.zbp.model.entity.CampaignContent;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CampaignContentResonseBO {

    private Integer height;
    private Integer width;
    private String redirectUrl;
    private String contentType;
    private Long cappingId;
    private Integer currentClickCount;
    private Integer currentImpressionCount;
    private Integer currentMou;
    @JsonProperty("path")
    private String contentPath;
    private Double percentage;
    private Long campaignId;
    private String id;
    private String info = "file";
    private String customerId;
    private String contentSizeType;
    private String contentId;
    private String priority;

    private List<LoanDataResponseObject> dataToGive;

    public CampaignContentResonseBO() {
    }

    public CampaignContentResonseBO(Integer height, Integer width, String redirectUrl, String contentType, Long cappingId,
                                    Integer currentClickCount, Integer currentImpressionCount, Integer currentMou,
                                    String contentPath, Double percentage, Long campaignId, String id,
                                    String info, String customerId, String contentSizeType, String contentId, String priority, List<LoanDataResponseObject> dataToGive) {
        this.height = height;
        this.width = width;
        this.redirectUrl = redirectUrl;
        this.contentType = contentType;
        this.cappingId = cappingId;
        this.currentClickCount = currentClickCount;
        this.currentImpressionCount = currentImpressionCount;
        this.currentMou = currentMou;
        this.contentPath = contentPath;
        this.percentage = percentage;
        this.campaignId = campaignId;
        this.id = id;
        this.info = info;
        this.customerId = customerId;
        this.contentSizeType = contentSizeType;
        this.contentId = contentId;
        this.priority = priority;
        this.dataToGive = dataToGive;

    }

    public CampaignContentResonseBO(CampaignContent campaignContent, List<LoanDataResponseObject> dataToGive) {
        this(campaignContent.getHeight(), campaignContent.getWidth(), campaignContent.getRedirectUrl(),
                campaignContent.getContentType().name(), campaignContent.getCappingId(),
                campaignContent.getCurrentClickCount(), campaignContent.getCurrentImpressionCount(),
                campaignContent.getCurrentMou(), campaignContent.getContentPath()
                , campaignContent.getPercentage(), campaignContent.getCampaignId().getId(), null, "file", null, null, null, null, dataToGive);
    }
}
