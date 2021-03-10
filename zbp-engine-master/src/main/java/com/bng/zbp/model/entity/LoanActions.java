package com.bng.zbp.model.entity;

import java.util.HashMap;

public class LoanActions {
private String name;
private HashMap<String, String> path;
private boolean bargein;
private String actionId;
private String actionType;
private int waitTime;
public String getName() {
	return name;
}
public HashMap<String, String> getPath() {
	return path;
}
public boolean isBargein() {
	return bargein;
}
public String getActionId() {
	return actionId;
}
public String getActionType() {
	return actionType;
}

public void setName(String name) {
	this.name = name;
}
public void setPath(HashMap<String, String> path) {
	this.path = path;
}
public void setBargein(boolean bargein) {
	this.bargein = bargein;
}
public void setActionId(String actionId) {
	this.actionId = actionId;
}
public void setActionType(String actionType) {
	this.actionType = actionType;
}
public int getWaitTime() {
	return waitTime;
}
public void setWaitTime(int waitTime) {
	this.waitTime = waitTime;
}


}
