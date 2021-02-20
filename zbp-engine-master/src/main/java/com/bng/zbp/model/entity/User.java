package com.bng.zbp.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user",catalog = "zbp")
@Getter
@Setter
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	private String uid;
	private String email; 
	private String company_email ; 
	private String password; 
	private String permission;
	private String superuserid;
	private String superuser_name; 
	private String company_name ; 
	private boolean isactive; 
	private boolean issubuser; 
	private boolean superuser_operation ; 
	private String joined_date;  
	private String msisdn_length; 
	private String country_code; 
	private boolean append_countrycode ;
	private boolean retry;  
	private String mscip;  
	private String voicechannel; 
	private int tps;
	private String cli;
	private boolean blacklist;
	 @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "operator", insertable = true, updatable = false)
	    private Operator operatorId;

	private String country; 
	private int role ;
	private boolean verify_mail;
	private String userdata;
    private String current_pin;
    private boolean enterprise;
    private String mobile;
    private String currency;
    private int vendor_id;
    private String last_modified_on;
    private String last_modified_by;
    private String service_permission;
    private Long user_type ;
    private Long publisher_id ;
    private Long advertiser_id ;
    private Long agency_id;
    

	
    
	public User(int id, String name, String uid, String email, String company_email, String password,
			String permission, String superuserid, String superuser_name, String company_name, boolean isactive,
			boolean issubuser, boolean superuser_operation, String joined_date, String msisdn_length,
			String country_code, boolean append_countrycode, boolean retry, String mscip, String voicechannel, int tps,
			String cli, boolean blacklist, Operator operatorId, String country, int role, boolean verify_mail,
			String userdata, String current_pin, boolean enterprise, String mobile, String currency, int vendor_id,
			String last_modified_on, String last_modified_by, String service_permission) {
		super();
		this.id = id;
		this.name = name;
		this.uid = uid;
		this.email = email;
		this.company_email = company_email;
		this.password = password;
		this.permission = permission;
		this.superuserid = superuserid;
		this.superuser_name = superuser_name;
		this.company_name = company_name;
		this.isactive = isactive;
		this.issubuser = issubuser;
		this.superuser_operation = superuser_operation;
		this.joined_date = joined_date;
		this.msisdn_length = msisdn_length;
		this.country_code = country_code;
		this.append_countrycode = append_countrycode;
		this.retry = retry;
		this.mscip = mscip;
		this.voicechannel = voicechannel;
		this.tps = tps;
		this.cli = cli;
		this.blacklist = blacklist;
		this.operatorId = operatorId;
		this.country = country;
		this.role = role;
		this.verify_mail = verify_mail;
		this.userdata = userdata;
		this.current_pin = current_pin;
		this.enterprise = enterprise;
		this.mobile = mobile;
		this.currency = currency;
		this.vendor_id = vendor_id;
		this.last_modified_on = last_modified_on;
		this.last_modified_by = last_modified_by;
		this.service_permission = service_permission;
	}

	public User() {
    	super();
	}

		}
