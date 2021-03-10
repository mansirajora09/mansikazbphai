package com.bng.zbp.model.request;

import java.util.HashMap;

public class LoanOptionRequestRes {
	private String loan_id;
	private String loan_amount;
	private HashMap<String, String> audio_file;
	private int waittime;
	public String getLoan_id() {
		return loan_id;
	}
	public String getLoan_amount() {
		return loan_amount;
	}
	public HashMap<String, String> getAudio_file() {
		return audio_file;
	}
	public void setLoan_id(String loan_id) {
		this.loan_id = loan_id;
	}
	public void setLoan_amount(String loan_amount) {
		this.loan_amount = loan_amount;
	}
	public void setAudio_file(HashMap<String, String> audio_file) {
		this.audio_file = audio_file;
	}
	public int getWaittime() {
		return waittime;
	}
	public void setWaittime(int waittime) {
		this.waittime = waittime;
	}
}
