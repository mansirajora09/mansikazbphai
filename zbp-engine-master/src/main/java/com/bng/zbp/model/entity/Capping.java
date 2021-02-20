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
@Table(name = "capping", catalog = "zbp")
@Getter
@Setter
public class Capping extends BaseEntity {
  
    @Column(name = "max_click")
    private int maxClick;

    @Column(name = "current_click")
    private int currentClick;
    @Column(name = "max_impression")
    private int maxImpression;
    @Column(name = "current_impression")
    private int currentImpression;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_id", nullable = false)
    private Campaign campaignId;
    
    
	public Capping(int maxClick, int currentClick, int maxImpression, int currentImpression, Campaign campaignId) {
		super();
		this.maxClick = maxClick;
		this.currentClick = currentClick;
		this.maxImpression = maxImpression;
		this.currentImpression = currentImpression;
		this.campaignId = campaignId;
	}
	
    
    

    
    
}
