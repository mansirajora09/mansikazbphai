package com.bng.zbp.model.entity;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "loan_options")
public class LoanOptions {
private String loan_id;
private String loan_amount;
private String flow;
private String loan_type;
public String getLoan_id() {
	return loan_id;
}
public String getLoan_amount() {
	return loan_amount;
}
public String getFlow() {
	return flow;
}
public String getLoan_type() {
	return loan_type;
}
public void setLoan_id(String loan_id) {
	this.loan_id = loan_id;
}
public void setLoan_amount(String loan_amount) {
	this.loan_amount = loan_amount;
}
public void setFlow(String flow) {
	this.flow = flow;
}
public void setLoan_type(String loan_type) {
	this.loan_type = loan_type;
}


}
