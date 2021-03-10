package com.bng.zbp.model.request;

import java.util.HashMap;
import java.util.Map;

public class IvrCampCreateReq {
	private Map<String, String> service_Data = new HashMap<>();
	private Map<String, String> timezone = new HashMap<>();
	private Map<String, int[]> blackoutdatetime = new HashMap<>();
	private IvrFlow flow;
	private int flow_id;
	private String[] publisher;
	private String device;
	private String country;
	public Map<String, String> getService_Data() {
		return service_Data;
	}
	public Map<String, String> getTimezone() {
		return timezone;
	}
	public Map<String, int[]> getBlackoutdatetime() {
		return blackoutdatetime;
	}
	public IvrFlow getFlow() {
		return flow;
	}
	public String[] getPublisher() {
		return publisher;
	}
	public String getDevice() {
		return device;
	}
	public String getCountry() {
		return country;
	}
	public void setService_Data(Map<String, String> service_Data) {
		this.service_Data = service_Data;
	}
	public void setTimezone(Map<String, String> timezone) {
		this.timezone = timezone;
	}
	public void setBlackoutdatetime(Map<String, int[]> blackoutdatetime) {
		this.blackoutdatetime = blackoutdatetime;
	}
	public void setFlow(IvrFlow flow) {
		this.flow = flow;
	}
	public void setPublisher(String[] publisher) {
		this.publisher = publisher;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getFlow_id() {
		return flow_id;
	}
	public void setFlow_id(int flow_id) {
		this.flow_id = flow_id;
	}
	
}
