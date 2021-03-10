package com.bng.zbp.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "loan_configuration")
public class LoanConfiguration {
private int id;
private String check_eligiblity_url;
private String loan_land_url;
private String loan_provider_id;
private String operator_id;
private String getOption;
private  String loan_type;
public int getId() {
	return id;
}
public String getCheck_eligiblity_url() {
	return check_eligiblity_url;
}
public String getLoan_land_url() {
	return loan_land_url;
}
public String getLoan_provider_id() {
	return loan_provider_id;
}
public String getOperator_id() {
	return operator_id;
}
public void setId(int id) {
	this.id = id;
}
public void setCheck_eligiblity_url(String check_eligiblity_url) {
	this.check_eligiblity_url = check_eligiblity_url;
}
public void setLoan_land_url(String loan_land_url) {
	this.loan_land_url = loan_land_url;
}
public void setLoan_provider_id(String loan_provider_id) {
	this.loan_provider_id = loan_provider_id;
}
public void setOperator_id(String operator_id) {
	this.operator_id = operator_id;
}
public String getGetOption() {
	return getOption;
}
public void setGetOption(String getOption) {
	this.getOption = getOption;
}
public String getLoan_type() {
	return loan_type;
}
public void setLoan_type(String loan_type) {
	this.loan_type = loan_type;
}
}
