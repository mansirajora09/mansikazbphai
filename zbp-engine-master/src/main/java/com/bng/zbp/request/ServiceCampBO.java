package com.bng.zbp.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceCampBO {
	private Long id;
	private String name;
	private String validity;
	private String detail;
	private int priority;
	private String path;
	private String thumbnails;
	private int total_click_count;
	private int moulimit;
	private String userid;
	private String start_date;
	private String start_time;
	private String end_date;
	private String end_time;
	private String media_type;
	private DataToGive dataToGive;
	private Timestamp timestamp;
	private AdDetail adDetail;
	private DataPack dataPack;
	private Content content;
	private blackoutDateTime blackoutdatetime;
	private boolean status;
	private String type;
	private int total_impression_count;
	private String advertiserId;
	private String affilateId;
	private String folder;
	private String time_zone_name;
	private String time_zone;
	private String flow;
	private Boolean is_targetting;
	private String operator;
	private String agency;
	private String agencyname;
	private String affiliateName;
	private String[] publisherName;
	private String description;
	private String kpi;
	private List<Advertiser> advertiserList;
	private List<Agency> agencyList;
	private List<Publisher> publisherList;
	private Boolean is_capping;
	private Long operator_id;
	private int mxgraph_id;
	private Long publisher_id;
	private String service_name;
	private String service_id;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getValidity() {
		return validity;
	}
	public String getDetail() {
		return detail;
	}
	public int getPriority() {
		return priority;
	}
	public String getPath() {
		return path;
	}
	public String getThumbnails() {
		return thumbnails;
	}
	public int getTotal_click_count() {
		return total_click_count;
	}
	public int getMoulimit() {
		return moulimit;
	}
	public String getUserid() {
		return userid;
	}
	public String getStart_date() {
		return start_date;
	}
	public String getStart_time() {
		return start_time;
	}
	public String getEnd_date() {
		return end_date;
	}
	public String getEnd_time() {
		return end_time;
	}
	public String getMedia_type() {
		return media_type;
	}
	public DataToGive getDataToGive() {
		return dataToGive;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public AdDetail getAdDetail() {
		return adDetail;
	}
	public DataPack getDataPack() {
		return dataPack;
	}
	public Content getContent() {
		return content;
	}
	public blackoutDateTime getBlackoutdatetime() {
		return blackoutdatetime;
	}
	public boolean isStatus() {
		return status;
	}
	public String getType() {
		return type;
	}
	public int getTotal_impression_count() {
		return total_impression_count;
	}
	public String getAdvertiserId() {
		return advertiserId;
	}
	public String getAffilateId() {
		return affilateId;
	}
	public String getFolder() {
		return folder;
	}
	public String getTime_zone_name() {
		return time_zone_name;
	}
	public String getTime_zone() {
		return time_zone;
	}
	public String getFlow() {
		return flow;
	}
	public Boolean getIs_targetting() {
		return is_targetting;
	}
	public String getOperator() {
		return operator;
	}
	public String getAgency() {
		return agency;
	}
	public String getAgencyname() {
		return agencyname;
	}
	public String getAffiliateName() {
		return affiliateName;
	}
	public String[] getPublisherName() {
		return publisherName;
	}
	public String getDescription() {
		return description;
	}
	public String getKpi() {
		return kpi;
	}
	public List<Advertiser> getAdvertiserList() {
		return advertiserList;
	}
	public List<Agency> getAgencyList() {
		return agencyList;
	}
	public List<Publisher> getPublisherList() {
		return publisherList;
	}
	public Boolean getIs_capping() {
		return is_capping;
	}
	public Long getOperator_id() {
		return operator_id;
	}
	public int getMxgraph_id() {
		return mxgraph_id;
	}
	public Long getPublisher_id() {
		return publisher_id;
	}
	public String getService_name() {
		return service_name;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setThumbnails(String thumbnails) {
		this.thumbnails = thumbnails;
	}
	public void setTotal_click_count(int total_click_count) {
		this.total_click_count = total_click_count;
	}
	public void setMoulimit(int moulimit) {
		this.moulimit = moulimit;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}
	public void setDataToGive(DataToGive dataToGive) {
		this.dataToGive = dataToGive;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public void setAdDetail(AdDetail adDetail) {
		this.adDetail = adDetail;
	}
	public void setDataPack(DataPack dataPack) {
		this.dataPack = dataPack;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	public void setBlackoutdatetime(blackoutDateTime blackoutdatetime) {
		this.blackoutdatetime = blackoutdatetime;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setTotal_impression_count(int total_impression_count) {
		this.total_impression_count = total_impression_count;
	}
	public void setAdvertiserId(String advertiserId) {
		this.advertiserId = advertiserId;
	}
	public void setAffilateId(String affilateId) {
		this.affilateId = affilateId;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	public void setTime_zone_name(String time_zone_name) {
		this.time_zone_name = time_zone_name;
	}
	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}
	public void setFlow(String flow) {
		this.flow = flow;
	}
	public void setIs_targetting(Boolean is_targetting) {
		this.is_targetting = is_targetting;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public void setAgencyname(String agencyname) {
		this.agencyname = agencyname;
	}
	public void setAffiliateName(String affiliateName) {
		this.affiliateName = affiliateName;
	}
	public void setPublisherName(String[] publisherName) {
		this.publisherName = publisherName;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setKpi(String kpi) {
		this.kpi = kpi;
	}
	public void setAdvertiserList(List<Advertiser> advertiserList) {
		this.advertiserList = advertiserList;
	}
	public void setAgencyList(List<Agency> agencyList) {
		this.agencyList = agencyList;
	}
	public void setPublisherList(List<Publisher> publisherList) {
		this.publisherList = publisherList;
	}
	public void setIs_capping(Boolean is_capping) {
		this.is_capping = is_capping;
	}
	public void setOperator_id(Long operator_id) {
		this.operator_id = operator_id;
	}
	public void setMxgraph_id(int mxgraph_id) {
		this.mxgraph_id = mxgraph_id;
	}
	public void setPublisher_id(Long publisher_id) {
		this.publisher_id = publisher_id;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

}