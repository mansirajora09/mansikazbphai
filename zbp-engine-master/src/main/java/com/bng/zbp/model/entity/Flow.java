package com.bng.zbp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flows", catalog = "zbp")
public class Flow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;
@Column(name = "flow_id")
private int flowId;
@Column(name = "serial_number")
private int serialNumber;
@Column(name = "action_id")
private String actionId;
@Column(name = "action_type")
private String actionType;
@Column(name = "`0`")
private String zero;
@Column(name = "`1`")
private String one;
@Column(name = "`2`")
private String two;
@Column(name = "`3`")
private String three;
@Column(name = "`4`")
private String four;
@Column(name = "`5`")
private String five;
@Column(name = "`6`")
private String six;
@Column(name = "`7`")
private String seven;
@Column(name = "`8`")
private String eight;
@Column(name = "`9`")
private String nine;
@Column(name = "url_success")
private String urlSuccess;
@Column(name = "url_fail")
private String urlFail;
@Column(name = "waittime")
private int waitTime;
@Column(name = "bargin")
private boolean bargin;
@Column(name = "audio")
private String audio;
@Column(name = "url")
private String url;
@Column(name = "value")
private String value;
@Column(name = "action_tag")
private String actionTag;
@Column(name = "nodtmf")
private String noDtmf;

public String getActionId() {
	return actionId;
}
public String getActionType() {
	return actionType;
}
public String getZero() {
	return zero;
}
public String getOne() {
	return one;
}
public String getTwo() {
	return two;
}
public String getThree() {
	return three;
}
public String getFour() {
	return four;
}
public String getFive() {
	return five;
}
public String getSix() {
	return six;
}
public String getSeven() {
	return seven;
}
public String getEight() {
	return eight;
}
public String getNine() {
	return nine;
}
public String getUrlSuccess() {
	return urlSuccess;
}
public String getUrlFail() {
	return urlFail;
}


public String getAudio() {
	return audio;
}
public String getUrl() {
	return url;
}

public void setActionId(String actionId) {
	this.actionId = actionId;
}
public void setActionType(String actionType) {
	this.actionType = actionType;
}
public void setZero(String zero) {
	this.zero = zero;
}
public void setOne(String one) {
	this.one = one;
}
public void setTwo(String two) {
	this.two = two;
}
public void setThree(String three) {
	this.three = three;
}
public void setFour(String four) {
	this.four = four;
}
public void setFive(String five) {
	this.five = five;
}
public void setSix(String six) {
	this.six = six;
}
public void setSeven(String seven) {
	this.seven = seven;
}
public void setEight(String eight) {
	this.eight = eight;
}
public void setNine(String nine) {
	this.nine = nine;
}
public void setUrlSuccess(String urlSuccess) {
	this.urlSuccess = urlSuccess;
}
public void setUrlFail(String urlFail) {
	this.urlFail = urlFail;
}


public void setAudio(String audio) {
	this.audio = audio;
}
public void setUrl(String url) {
	this.url = url;
}
public int getWaitTime() {
	return waitTime;
}
public boolean isBargin() {
	return bargin;
}
public String getValue() {
	return value;
}
public void setWaitTime(int waitTime) {
	this.waitTime = waitTime;
}
public void setBargin(boolean bargin) {
	this.bargin = bargin;
}
public void setValue(String value) {
	this.value = value;
}
public int getFlowId() {
	return flowId;
}
public void setFlowId(int flowId) {
	this.flowId = flowId;
}
public int getSerialNumber() {
	return serialNumber;
}
public void setSerialNumber(int serialNumber) {
	this.serialNumber = serialNumber;
}

public String getActionTag() {
	return actionTag;
}
public void setActionTag(String actionTag) {
	this.actionTag = actionTag;
}
public String getNoDtmf() {
	return noDtmf;
}
public void setNoDtmf(String noDtmf) {
	this.noDtmf = noDtmf;
}



}
