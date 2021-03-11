package com.bng.zbp.model.entity;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "loan_options")
public class LoanOptions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
private String id;
private int loan_id;
private String loan_amount;
private String flow;


public String getLoan_amount() {
	return loan_amount;
}
public String getFlow() {
	return flow;
}

public void setLoan_amount(String loan_amount) {
	this.loan_amount = loan_amount;
}
public void setFlow(String flow) {
	this.flow = flow;
}

public int getLoan_id() {
	return loan_id;
}
public void setLoan_id(int loan_id) {
	this.loan_id = loan_id;
}



}
