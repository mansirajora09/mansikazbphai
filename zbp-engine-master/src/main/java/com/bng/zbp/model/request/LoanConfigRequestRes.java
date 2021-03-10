package com.bng.zbp.model.request;

import java.util.List;

public class LoanConfigRequestRes {
private String operatorId;
private String check_eligiblity;
private String loan_request;
private String getOption;
private String loan_provider;
private String loan_type;
private List<LoanOptionRequestRes> loanOption;
public String getOperatorId() {
	return operatorId;
}
public String getCheck_eligiblity() {
	return check_eligiblity;
}
public String getLoan_request() {
	return loan_request;
}
public String getGetOption() {
	return getOption;
}
public String getLoan_provider() {
	return loan_provider;
}
public void setOperatorId(String operatorId) {
	this.operatorId = operatorId;
}
public void setCheck_eligiblity(String check_eligiblity) {
	this.check_eligiblity = check_eligiblity;
}
public void setLoan_request(String loan_request) {
	this.loan_request = loan_request;
}
public void setGetOption(String getOption) {
	this.getOption = getOption;
}
public void setLoan_provider(String loan_provider) {
	this.loan_provider = loan_provider;
}
public List<LoanOptionRequestRes> getLoanOption() {
	return loanOption;
}
public void setLoanOption(List<LoanOptionRequestRes> loanOption) {
	this.loanOption = loanOption;
}
public String getLoan_type() {
	return loan_type;
}
public void setLoan_type(String loan_type) {
	this.loan_type = loan_type;
}


}
