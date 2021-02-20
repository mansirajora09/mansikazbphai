package com.bng.zbp.model.response;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import com.bng.zbp.model.entity.Campaign;
import com.bng.zbp.model.entity.Operator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Mansi Rajora
 */
@Getter
@Setter
public class CampaignResponseBO  implements Serializable {
	@Id
	private long id;
	// private static final long serialVersionUID = 1L;
	// private Long campaignId;
	private String name;
	private Date startDate;
	private Date endDate;
	private Time dailyStartTime;
	private Time dailyEndTime;
	private String type;
	private String mediaType;
	private String flowType;
	private String timeZone;
	private String timeZoneName;
	private Boolean isCapping;
	private Boolean isTargeting;
	private String status;
	// private String flow;
	//private Long operatorId;
	
	

	public CampaignResponseBO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public CampaignResponseBO(Campaign campaignResponse) {
    	this(campaignResponse.getId(),campaignResponse.getName(),campaignResponse.getStartDate(),campaignResponse.getEndDate(),campaignResponse.getDailyStartTime(),campaignResponse.getDailyEndTime(),
    			campaignResponse.getType().toString(),campaignResponse.getMediaType().toString(),campaignResponse.getFlowType().toString(),campaignResponse.getTimeZone(),campaignResponse.getTimeZoneName(),
    			campaignResponse.getIsCapping(),campaignResponse.getIsTargeting(),campaignResponse.getStatus().toString());
    
    	// TODO Auto-generated constructor stub
	}


	


	public CampaignResponseBO(long id, String name, Date startDate, Date endDate, Time dailyStartTime,
			Time dailyEndTime, String type, String mediaType, String flowType, String timeZone, String timeZoneName,
			Boolean isCapping, Boolean isTargeting, String status) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dailyStartTime = dailyStartTime;
		this.dailyEndTime = dailyEndTime;
		this.type = type;
		this.mediaType = mediaType;
		this.flowType = flowType;
		this.timeZone = timeZone;
		this.timeZoneName = timeZoneName;
		this.isCapping = isCapping;
		this.isTargeting = isTargeting;
		this.status = status;
	}

	

	
	
}
