package com.bng.zbp.model.entity;

import com.bng.zbp.model.enums.CampaignType;
import com.bng.zbp.model.enums.FlowType;
import com.bng.zbp.model.enums.MediaType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * @author Mansi Rajora
 */
@Entity
@Table(name = "campaign_content", catalog = "zbp")
@Getter
@Setter
public class CampaignContent extends BaseEntity {


    @Column(name = "height")
    private Integer height;
    @Column(name = "width")
    private Integer width;
    @Column(name = "redirect_url")
    private String redirectUrl;
    @Enumerated(EnumType.STRING)
    @Column(name = "content_type")
    private MediaType contentType;
    @Column(name = "capping_id")
    private Long cappingId;
    @Column(name = "current_click_count")
    private Integer currentClickCount;
    @Column(name = "current_impression_count")
    private Integer currentImpressionCount;
    @Column(name = "current_mou")
    private Integer currentMou;
    @Column(name = "content_path")
    private String contentPath;
    @Column(name = "percentage")
    private Double percentage;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_id", nullable = false)
    private Campaign campaignId;
	public CampaignContent(Integer height, Integer width, String redirectUrl, MediaType contentType, Long cappingId,
			Integer currentClickCount, Integer currentImpressionCount, Integer currentMou, String contentPath,
			Double percentage, Campaign campaignId) {
		super();
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
	}
	public CampaignContent() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    
}
