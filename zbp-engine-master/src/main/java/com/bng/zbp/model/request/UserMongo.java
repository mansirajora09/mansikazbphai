package com.bng.zbp.model.request;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserMongo {
	
	
	private String email;
	private String id;
	private String name;
    private String password;
    private String pin;
    private String encrypted_password;
    private boolean changepassword;
	

}
