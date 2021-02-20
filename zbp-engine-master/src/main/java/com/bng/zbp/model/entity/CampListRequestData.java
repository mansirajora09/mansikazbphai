package com.bng.zbp.model.entity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class CampListRequestData {
	private int  userid;
	private String campstatus;
	private String camptype;
	private int pageStart;
	private int pageEnd;
	private Map<String, String> timezone = new HashMap<>();
	private int serviceid;
	private boolean requirecount;
	private String jobname;
	private Boolean copy;
	private List<String> allserviceid;
	HashMap<String, String> spent = new HashMap<>();

	
	

	
	public Boolean getCopy() {
		return copy;
	}
	public void setCopy(Boolean copy) {
		this.copy = copy;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public boolean isRequirecount() {
		return requirecount;
	}
	public void setRequirecount(boolean requirecount) {
		this.requirecount = requirecount;
	}
	public int getServiceid() {
		return serviceid;
	}
	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}
	public int getPageStart() {
		return pageStart;
	}
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}
	public int getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getCampstatus() {
		return campstatus;
	}
	public void setCampstatus(String campstatus) {
		this.campstatus = campstatus;
	}
	public String getCamptype() {
		return camptype;
	}
	public void setCamptype(String camptype) {
		this.camptype = camptype;
	}
	public Map<String, String> getTimezone() {
		return timezone;
	}
	public void setTimezone(Map<String, String> timezone) {
		this.timezone = timezone;
	}
	public List<String> getAllserviceid() {
		return allserviceid;
	}
	public void setAllserviceid(List<String> allserviceid) {
		this.allserviceid = allserviceid;
	}
	public HashMap<String, String> getSpent() {
		return spent;
	}
	public void setSpent(HashMap<String, String> spent) {
		this.spent = spent;
	}
	
	
	
}
