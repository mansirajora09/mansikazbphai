package com.bng.zbp.model.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


public class UserMongoBO {
	private int id;
	private String name;
    private String email;
    private String password;
    private String permission;
    private String company_email;
    private String superuserid;
    private String superuser_name;
    private String company_name;
    private boolean camplistexist;
    private boolean userexist;
    private boolean enterprise;
    private boolean isactive;
    private boolean issubuser;
    private boolean superuser_operation;
	private boolean retry;  
	private int tps;
	private boolean blacklist;
    private String uid;
    private String msisdn_length; 
	private String country_code; 
	private boolean append_countrycode ;
	private String cli;
	private String mscip;
	
	private String country; 
private String currency;
private int role;
private String service_permission;
private Operator operatorId;

    
	public String getCurrency() {
	return currency;
}
public void setCurrency(String currency) {
	this.currency = currency;
}

	public int getRole() {
	return role;
}
public void setRole(int role) {
	this.role = role;
}
	public boolean isRetry() {
		return retry;
	}
	public void setRetry(boolean retry) {
		this.retry = retry;
	}
	public int getTps() {
		return tps;
	}
	public void setTps(int tps) {
		this.tps = tps;
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
	public String getCli() {
		return cli;
	}
	public void setCli(String cli) {
		this.cli = cli;
	}
	public String getMscip() {
		return mscip;
	}
	public void setMscip(String mscip) {
		this.mscip = mscip;
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
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
	public String getCompany_email() {
		return company_email;
	}
	public void setCompany_email(String company_email) {
		this.company_email = company_email;
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
	public boolean isCamplistexist() {
		return camplistexist;
	}
	public void setCamplistexist(boolean camplistexist) {
		this.camplistexist = camplistexist;
	}
	public boolean isUserexist() {
		return userexist;
	}
	public void setUserexist(boolean userexist) {
		this.userexist = userexist;
	}
	public boolean isEnterprise() {
		return enterprise;
	}
	public void setEnterprise(boolean enterprise) {
		this.enterprise = enterprise;
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
	public String getService_permission() {
		return service_permission;
	}
	public void setService_permission(String service_permission) {
		this.service_permission = service_permission;
	}
	public Operator getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Operator operatorId) {
		this.operatorId = operatorId;
	}

    
  

}
