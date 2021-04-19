package com.bng.zbp.model.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RegisterRequest  {
	private int id;
	private String name;
	private String uid;
	private String email; 
	private String company_email ; 
	private String password; 
	private String permission;
	private String superuserid;
	private String superuser_name; 
	private String company_name ; 
	private boolean isactive; 
	private boolean issubuser; 
	private boolean superuser_operation ; 
	private String joined_date;  
	private String msisdn_length; 
	private String country_code; 
	private boolean append_countrycode ;
	private boolean retry;  
	private String mscip;  
	private String voicechannel; 
	private int tps;
	private String cli;
	private boolean blacklist;
	//private int operator;
	private String country; 
	private String submenu_permission ;
	private boolean verify_mail;
	private String userid;
    private String current_pin;
    private boolean enterprise;
    private String mobile;
private String currency;
private int vendor_id;
private String last_modified_on;
private String last_modified_by;
private int role;
private String service_permission;


private String userdata;

  
public int getRole() {
	return role;
}
public void setRole(int role) {
	this.role = role;
}
public String getCurrency() {
	return currency;
}
public void setCurrency(String currency) {
	this.currency = currency;
}
List<HashMap<String, String>>blackouthours= new ArrayList<HashMap<String, String>>();

	
	
	public List<HashMap<String, String>> getBlackouthours() {
	return blackouthours;
}
public void setBlackouthours(List<HashMap<String, String>> blackouthours) {
	this.blackouthours = blackouthours;
}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public boolean isEnterprise() {
		return enterprise;
	}
	public String getCurrent_pin() {
		return current_pin;
	}
	public void setCurrent_pin(String current_pin) {
		this.current_pin = current_pin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompany_email() {
		return company_email;
	}
	public void setCompany_email(String company_email) {
		this.company_email = company_email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getSuperuserid() {
		return superuserid;
	}
	public void setSuperuserid(String superuserid) {
		this.superuserid = superuserid;
	}
	public String getSuperuser_name() {
		return superuser_name;
	}
	public void setSuperuser_name(String superuser_name) {
		this.superuser_name = superuser_name;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	public boolean isIssubuser() {
		return issubuser;
	}
	public void setIssubuser(boolean issubuser) {
		this.issubuser = issubuser;
	}
	public boolean isSuperuser_operation() {
		return superuser_operation;
	}
	public void setSuperuser_operation(boolean superuser_operation) {
		this.superuser_operation = superuser_operation;
	}
	public String getJoined_date() {
		return joined_date;
	}
	public void setJoined_date(String joined_date) {
		this.joined_date = joined_date;
	}
	public String getMsisdn_length() {
		return msisdn_length;
	}
	public void setMsisdn_length(String msisdn_length) {
		this.msisdn_length = msisdn_length;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public boolean isAppend_countrycode() {
		return append_countrycode;
	}
	public void setAppend_countrycode(boolean append_countrycode) {
		this.append_countrycode = append_countrycode;
	}
	public boolean isRetry() {
		return retry;
	}
	public void setRetry(boolean retry) {
		this.retry = retry;
	}
	public String getMscip() {
		return mscip;
	}
	public void setMscip(String mscip) {
		this.mscip = mscip;
	}
	public String getVoicechannel() {
		return voicechannel;
	}
	public void setVoicechannel(String voicechannel) {
		this.voicechannel = voicechannel;
	}
	public int getTps() {
		return tps;
	}
	public void setTps(int tps) {
		this.tps = tps;
	}
	public String getCli() {
		return cli;
	}
	public void setCli(String cli) {
		this.cli = cli;
	}
	public boolean isBlacklist() {
		return blacklist;
	}
	public void setBlacklist(boolean blacklist) {
		this.blacklist = blacklist;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getSubmenu_permission() {
		return submenu_permission;
	}
	public void setSubmenu_permission(String submenu_permission) {
		this.submenu_permission = submenu_permission;
	}
	public boolean isVerify_mail() {
		return verify_mail;
	}
	public void setVerify_mail(boolean verify_mail) {
		this.verify_mail = verify_mail;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setEnterprise(boolean enterprise) {
		this.enterprise = enterprise;
	}
//	public int getOperator() {
//		return operator;
//	}
//	public void setOperator(int operator) {
//		this.operator = operator;
//	}
	public int getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}
	public String getLast_modified_on() {
		return last_modified_on;
	}
	public void setLast_modified_on(String last_modified_on) {
		this.last_modified_on = last_modified_on;
	}
	public String getLast_modified_by() {
		return last_modified_by;
	}
	public void setLast_modified_by(String last_modified_by) {
		this.last_modified_by = last_modified_by;
	}
	public String getService_permission() {
		return service_permission;
	}
	public void setService_permission(String service_permission) {
		this.service_permission = service_permission;
	}
	public String getUserdata() {
		return userdata;
	}
	public void setUserdata(String userdata) {
		this.userdata = userdata;
	}
	
	
	
	
	
	}
