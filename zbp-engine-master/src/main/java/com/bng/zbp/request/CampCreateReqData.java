package com.bng.zbp.request;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
public class CampCreateReqData {
	private Map<String, String> service_Data = new HashMap<>();
	private Map<String, String> timezone = new HashMap<>();
	private List<ContentInfo> contentInfo;
	private Map<String, int[]> blackoutdatetime = new HashMap<>();
	private String path;
	private String thumbnails;
	private String redirectURL;
	private String contentType;
	private String callbackURL;
	private String[] publisher;
	private String device;
	private String country;
	


	private String affilateId;
	private String folder;
	private String[] insertedhour;
	private int campfreq;
	private String kpi;
	private double freqcapping;
	private double campbudget;
	private double dailybudget;
	private double hourlybudget;
	private String description;
	private String runday;
	
	private String operator;
	private String agency;
	
	
	private String agencyname;
    private String advertiserName;
    private String[] publisherName;

    private List<Advertiser> advertiserList;
	private List<Agency> agencyList;
	private List<Publisher> publisherList;
	
	
	
	

	public List<Advertiser> getAdvertiserList() {
		return advertiserList;
	}
	public void setAdvertiserList(List<Advertiser> advertiserList) {
		this.advertiserList = advertiserList;
	}
	public List<Agency> getAgencyList() {
		return agencyList;
	}
	public void setAgencyList(List<Agency> agencyList) {
		this.agencyList = agencyList;
	}
	public List<Publisher> getPublisherList() {
		return publisherList;
	}
	public void setPublisherList(List<Publisher> publisherList) {
		this.publisherList = publisherList;
	}
	public String getAgencyname() {
		return agencyname;
	}
	public void setAgencyname(String agencyname) {
		this.agencyname = agencyname;
	}
	
	public String getAdvertiserName() {
		return advertiserName;
	}
	public void setAdvertiserName(String advertiserName) {
		this.advertiserName = advertiserName;
	}
	public String[] getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String[] publisherName) {
		this.publisherName = publisherName;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	public Map<String, int[]> getBlackoutdatetime() {
		return blackoutdatetime;
	}
	public void setBlackoutdatetime(Map<String, int[]> blackoutdatetime) {
		this.blackoutdatetime = blackoutdatetime;
	}
	public String getAffilateId() {
		return affilateId;
	}
	public void setAffilateId(String affilateId) {
		this.affilateId = affilateId;
	}
	
	
	
	
	public List<ContentInfo> getContentInfo() {
		return contentInfo;
	}
	public void setContentInfo(List<ContentInfo> contentInfo) {
		this.contentInfo = contentInfo;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String[] getPublisher() {
		return publisher;
	}
	public void setPublisher(String[] publisher) {
		this.publisher = publisher;
	}
	public String getCallbackURL() {
		return callbackURL;
	}
	public void setCallbackURL(String callbackURL) {
		this.callbackURL = callbackURL;
	}
	public Map<String, String> getService_Data() {
		return service_Data;
	}
	public void setService_Data(Map<String, String> service_Data) {
		this.service_Data = service_Data;
	}
	public Map<String, String> getTimezone() {
		return timezone;
	}
	public void setTimezone(Map<String, String> timezone) {
		this.timezone = timezone;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getThumbnails() {
		return thumbnails;
	}
	public void setThumbnails(String thumbnails) {
		this.thumbnails = thumbnails;
	}
	public String getRedirectURL() {
		return redirectURL;
	}
	public void setRedirectURL(String redirectURL) {
		this.redirectURL = redirectURL;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String[] getInsertedhour() {
		return insertedhour;
	}
	public void setInsertedhour(String[] insertedhour) {
		this.insertedhour = insertedhour;
	}
	public int getCampfreq() {
		return campfreq;
	}
	public void setCampfreq(int campfreq) {
		this.campfreq = campfreq;
	}
	
	public String getKpi() {
		return kpi;
	}
	public void setKpi(String kpi) {
		this.kpi = kpi;
	}
	public double getFreqcapping() {
		return freqcapping;
	}
	public void setFreqcapping(double freqcapping) {
		this.freqcapping = freqcapping;
	}
	public double getCampbudget() {
		return campbudget;
	}
	public void setCampbudget(double campbudget) {
		this.campbudget = campbudget;
	}
	public double getDailybudget() {
		return dailybudget;
	}
	public void setDailybudget(double dailybudget) {
		this.dailybudget = dailybudget;
	}
	public double getHourlybudget() {
		return hourlybudget;
	}
	public void setHourlybudget(double hourlybudget) {
		this.hourlybudget = hourlybudget;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRunday() {
		return runday;
	}
	public void setRunday(String runday) {
		this.runday = runday;
	}


	
}