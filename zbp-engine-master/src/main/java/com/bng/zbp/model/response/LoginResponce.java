package com.bng.zbp.model.response;

import java.util.List;

import com.bng.zbp.model.entity.User;
import com.bng.zbp.model.entity.UserMysqlPerDAO;
public class LoginResponce {
	private String status;
	private String reason;
	private String token;
	private boolean camplistexist;
	private User user_Info;
	private List<UserMysqlPerDAO> permission;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public User getUser_Info() {
		return user_Info;
	}
	public void setUser_Info(User user_Info) {
		this.user_Info = user_Info;
	}
	
	public List<UserMysqlPerDAO> getPermission() {
		return permission;
	}
	public void setPermission(List<UserMysqlPerDAO> permission) {
		this.permission = permission;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public boolean isCamplistexist() {
		return camplistexist;
	}
	public void setCamplistexist(boolean camplistexist) {
		this.camplistexist = camplistexist;
	}

	

}
