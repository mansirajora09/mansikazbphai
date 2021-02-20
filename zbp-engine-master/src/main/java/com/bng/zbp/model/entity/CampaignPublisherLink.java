package com.bng.zbp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Mansi Rajora
 */
@Entity
@Table(name = "campaign_publisher_link", catalog = "zbp")
@Getter
@Setter
public class    CampaignPublisherLink extends BaseEntity {

  
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_id", nullable = false)
    private Campaign campaignId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisherId;
	
	public CampaignPublisherLink(Campaign campaignId, Publisher publisherId) {
		// TODO Auto-generated constructor stub
		super();
		this.campaignId = campaignId;
		this.publisherId = publisherId;
	}
    
    

}
