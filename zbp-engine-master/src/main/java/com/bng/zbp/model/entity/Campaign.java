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
	
	@Column(name = "flow_id	")
	private int flow_id;
	
	@Column(name = "max_click")
	private int maxClick;
	
	@Column(name = "current_impression")
	private int currentImpression;
	
	@Column(name = "max_impression")
	private int maxImpression;
	
	@Column(name = "current_click")
	private int currentClick ;
	
	@Column(name = "service")
	private String service;
	
	



	public Campaign(String name, Date startDate, Date endDate, Time dailyStartTime, Time dailyEndTime,
			CampaignType type, MediaType mediaType, FlowType flowType, String timeZone, String timeZoneName,
			Boolean isCapping, Boolean isTargeting, String flow, Operator operatorId, Integer mxgraphId, int priority, String scp_flow_name,Status status ,Integer maxClick ,Integer currentClick  ,
			Integer maxImpression, Integer currentImpression,int flow_id,String serviceId,String service ) {
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
		this.flow_id=flow_id;
		this.serviceId=serviceId;
		this.service=service;

	}


	public Campaign(String name, Date startDate, Date endDate, Time dailyStartTime, Time dailyEndTime,
			CampaignType type, MediaType mediaType, FlowType flowType, String timeZone, String timeZoneName,
			Boolean isCapping, Boolean isTargeting, String flow, Operator operatorId, Integer mxgraphId, int priority, String scp_flow_name,Status status ,Integer maxClick ,Integer currentClick  ,
			Integer maxImpression, Integer currentImpression,int flow_id ) {
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
		this.flow_id=flow_id;

	}


	public Campaign() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}


	public Date getStartDate() {
		return startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public Time getDailyStartTime() {
		return dailyStartTime;
	}


	public Time getDailyEndTime() {
		return dailyEndTime;
	}


	public CampaignType getType() {
		return type;
	}


	public MediaType getMediaType() {
		return mediaType;
	}


	public FlowType getFlowType() {
		return flowType;
	}


	public String getTimeZone() {
		return timeZone;
	}


	public String getTimeZoneName() {
		return timeZoneName;
	}


	public Boolean getIsCapping() {
		return isCapping;
	}


	public Boolean getIsTargeting() {
		return isTargeting;
	}


	public String getFlow() {
		return flow;
	}


	public Operator getOperatorId() {
		return operatorId;
	}


	public Integer getMxgraphId() {
		return mxgraphId;
	}


	public int getPriority() {
		return priority;
	}


	public String getScp_flow_name() {
		return scp_flow_name;
	}


	public Status getStatus() {
		return status;
	}


	public String getServiceId() {
		return serviceId;
	}


	public String getSubServiceId() {
		return subServiceId;
	}


	public int getFlow_id() {
		return flow_id;
	}


	public int getMaxClick() {
		return maxClick;
	}


	public int getCurrentImpression() {
		return currentImpression;
	}


	public int getMaxImpression() {
		return maxImpression;
	}


	public int getCurrentClick() {
		return currentClick;
	}


	public String getService() {
		return service;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public void setDailyStartTime(Time dailyStartTime) {
		this.dailyStartTime = dailyStartTime;
	}


	public void setDailyEndTime(Time dailyEndTime) {
		this.dailyEndTime = dailyEndTime;
	}


	public void setType(CampaignType type) {
		this.type = type;
	}


	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}


	public void setFlowType(FlowType flowType) {
		this.flowType = flowType;
	}


	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}


	public void setTimeZoneName(String timeZoneName) {
		this.timeZoneName = timeZoneName;
	}


	public void setIsCapping(Boolean isCapping) {
		this.isCapping = isCapping;
	}


	public void setIsTargeting(Boolean isTargeting) {
		this.isTargeting = isTargeting;
	}


	public void setFlow(String flow) {
		this.flow = flow;
	}


	public void setOperatorId(Operator operatorId) {
		this.operatorId = operatorId;
	}


	public void setMxgraphId(Integer mxgraphId) {
		this.mxgraphId = mxgraphId;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}


	public void setScp_flow_name(String scp_flow_name) {
		this.scp_flow_name = scp_flow_name;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}


	public void setSubServiceId(String subServiceId) {
		this.subServiceId = subServiceId;
	}


	public void setFlow_id(int flow_id) {
		this.flow_id = flow_id;
	}


	public void setMaxClick(int maxClick) {
		this.maxClick = maxClick;
	}


	public void setCurrentImpression(int currentImpression) {
		this.currentImpression = currentImpression;
	}


	public void setMaxImpression(int maxImpression) {
		this.maxImpression = maxImpression;
	}


	public void setCurrentClick(int currentClick) {
		this.currentClick = currentClick;
	}


	public void setService(String service) {
		this.service = service;
	}
	

}
