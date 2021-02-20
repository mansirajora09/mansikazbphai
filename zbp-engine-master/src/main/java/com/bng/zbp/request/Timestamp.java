package com.bng.zbp.request;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Timestamp {
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date starttime;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date endtime;
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

}
