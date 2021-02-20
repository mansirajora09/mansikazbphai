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

}