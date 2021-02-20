package com.bng.zbp.model.response;

import java.util.ArrayList;
import java.util.List;

public class ApiStatusRes {
	private String response;
	private int value;
	private String reason;
	private String key;
	ArrayList<String> heading=new ArrayList<String>();
	ArrayList<String> firstrow=new ArrayList<String>();
	
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public ArrayList<String> getHeading() {
		return heading;
	}
	public void setHeading(ArrayList<String> heading) {
		this.heading = heading;
	}
	public ArrayList<String> getFirstrow() {
		return firstrow;
	}
	public void setFirstrow(ArrayList<String> firstrow) {
		this.firstrow = firstrow;
	}

}
