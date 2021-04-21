package com.bng.zbp.model.request;

public class CreateFlowReq {
private String id;
private String flowName;
private String tag;
private int userId;
public String getFlowName() {
	return flowName;
}
public String getTag() {
	return tag;
}
public void setFlowName(String flowName) {
	this.flowName = flowName;
}
public void setTag(String tag) {
	this.tag = tag;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}

}
