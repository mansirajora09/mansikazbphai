package com.bng.zbp.model.request;

import java.util.HashMap;
import java.util.Map;

public class IvrCampCreateReq {
	private Map<String, String> service_Data = new HashMap<>();
	private Map<String, String> timezone = new HashMap<>();
	
	private String[] blackouthour;

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
	public String[] getBlackouthour() {
		return blackouthour;
	}
	public void setBlackouthour(String[] blackouthour) {
		this.blackouthour = blackouthour;
	}
	
	
	
}
