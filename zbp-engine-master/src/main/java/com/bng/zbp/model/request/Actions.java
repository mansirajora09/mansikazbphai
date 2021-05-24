package com.bng.zbp.model.request;

import java.util.HashMap;
import java.util.List;

import com.bng.zbp.model.enums.ActionType;
import com.bng.zbp.model.enums.UrlActions;

public class Actions {
private int dtmf_key;
private String actionId;
private UrlActions url_key;
private HashMap<String, String> audio_file;
private ActionType type;
private int level;
private String url;
private List<Actions> url_actions;
private List<Actions> actions;
private String action_tag;
private  HashMap<String, Object>  repeat;

public int getDtmf_key() {
	return dtmf_key;
}
public HashMap<String, String> getAudio_file() {
	return audio_file;
}

public int getLevel() {
	return level;
}
public void setDtmf_key(int dtmf_key) {
	this.dtmf_key = dtmf_key;
}
public void setAudio_file(HashMap<String, String> audio_file) {
	this.audio_file = audio_file;
}

public void setLevel(int level) {
	this.level = level;
}
public ActionType getType() {
	return type;
}
public void setType(ActionType type) {
	this.type = type;
}
public List<Actions> getActions() {
	return actions;
}
public void setActions(List<Actions> actions) {
	this.actions = actions;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public UrlActions getUrl_key() {
	return url_key;
}
public void setUrl_key(UrlActions url_key) {
	this.url_key = url_key;
}
public List<Actions> getUrl_actions() {
	return url_actions;
}
public void setUrl_actions(List<Actions> url_actions) {
	this.url_actions = url_actions;
}
public String getAction_tag() {
	return action_tag;
}
public void setAction_tag(String action_tag) {
	this.action_tag = action_tag;
}
public HashMap<String, Object> getRepeat() {
	return repeat;
}
public void setRepeat(HashMap<String, Object> repeat) {
	this.repeat = repeat;
}


public String getActionId() {
	return actionId;
}
public void setActionId(String actionId) {
	this.actionId = actionId;
}
}
