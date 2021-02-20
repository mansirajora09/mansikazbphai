package com.bng.zbp.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


/**
 * @author Mansi Rajora
 */
@Entity
@Table(name = "zbp_log")
@Getter
@Setter
public class LogData implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name = "name")
	private String name;
	private String userid;
	private Date time;
	private String request;
	private String response;
	private String logdata;
	private String status;
	
	
	public LogData( String name, String userid, Date time, String request, String response, String logdata,
			String status) {
		super();
		this.name = name;
		this.userid = userid;
		this.time = time;
		this.request = request;
		this.response = response;
		this.logdata = logdata;
		this.status = status;
	}


	public LogData() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	
	
	
	

}
