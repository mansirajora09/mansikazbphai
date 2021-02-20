package com.bng.zbp.model.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bng.zbp.model.enums.CampaignType;
import com.bng.zbp.model.enums.FlowType;
import com.bng.zbp.model.enums.MediaType;
import com.bng.zbp.model.enums.Status;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Mansi Rajora
 */

@Entity
@Table(name = "campaign", catalog = "zbp")
@Getter
@Setter
public class Campaign extends BaseEntity {

	@Column(name = "name")
	private String name;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
	@Column(name = "daily_start_time")
	private Time dailyStartTime;
	@Column(name = "daily_end_time")
	private Time dailyEndTime;
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private CampaignType type;
	@Enumerated(EnumType.STRING)
	@Column(name = "media_type")
	private MediaType mediaType;
	@Enumerated(EnumType.STRING)
	@Column(name = "flow_type")
	private FlowType flowType;
	@Column(name = "time_zone")
	private String timeZone;
	@Column(name = "time_zone_name")
	private String timeZoneName;
	@Column(name = "is_capping")
	private Boolean isCapping;
	@Column(name = "is_targeting")
	private Boolean isTargeting;
	@Column(name = "flow")
	private String flow;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "operator_id", nullable = false)
	private transient Operator operatorId;
	@Column(name = "mxgraph_id")
	private Integer mxgraphId;	
	@Column(name = "priority")
	private int priority;
	@Column(name = "scp_flow_name")
	private String scp_flow_name;
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status =Status.SCHEDULED;
	@Column(name = "service_id")

	private String serviceId;
	@Column(name = "sub_service_id")
	private String subServiceId;
	
	@Column(name = "max_click")
	private int maxClick;
	
	@Column(name = "current_impression")
	private int currentImpression;
	
	@Column(name = "max_impression")
	private int maxImpression;
	
	@Column(name = "current_click")
	private int currentClick ;
	
	


	



	public Campaign(String name, Date startDate, Date endDate, Time dailyStartTime, Time dailyEndTime,
			CampaignType type, MediaType mediaType, FlowType flowType, String timeZone, String timeZoneName,
			Boolean isCapping, Boolean isTargeting, String flow, Operator operatorId, Integer mxgraphId, int priority, String scp_flow_name,Status status ,Integer maxClick ,Integer currentClick  ,
			Integer maxImpression, Integer currentImpression ) {
		super();
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
		this.flow = flow;
		this.operatorId = operatorId;
		this.mxgraphId = mxgraphId;		
		this.priority = priority;
		this.scp_flow_name = scp_flow_name;
		this.status = status;
		this.maxClick=maxClick;
		this.currentClick=currentClick;
		this.maxImpression=maxImpression;
		this.currentImpression=currentImpression;

	}




	public Campaign() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
