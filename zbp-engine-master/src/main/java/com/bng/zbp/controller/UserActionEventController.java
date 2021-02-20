package com.bng.zbp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.bng.zbp.model.entity.LogData;
import com.bng.zbp.model.request.EditOperatorOrVendorRequest;
import com.bng.zbp.model.request.RegisterRequest;
import com.bng.zbp.model.request.UserMongo;
import com.bng.zbp.model.response.LoginResponce;
import com.bng.zbp.model.response.OperatorResponse;
import com.bng.zbp.model.response.UserResponse;
import com.bng.zbp.service.UserAuth;
import com.bng.zbp.service.UserService;
import com.bng.zbp.util.URIConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javassist.NotFoundException;

/**
 * @Author Mansi Rajora
 */

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping(value = "/bng/zbp")

public class UserActionEventController {
	private static final Gson gson = new GsonBuilder().serializeNulls().create();

	private final static Logger logger = LoggerFactory.getLogger(UserActionEventController.class);
	@Autowired
	UserService userService;
	@Autowired
	UserAuth userAuth;
	
	
	@RequestMapping(URIConstants.NEWREGISTER)
	@PostMapping
	public String RegisterUser(@RequestBody RegisterRequest register_request) {
		// Registration Request
		logger.info("==================New Registration==========");
		logger.info("New User Signup : " + gson.toJson(register_request));
		String res = userAuth.newRegister(register_request);
		UserResponse apiStatusRes = gson.fromJson(res, UserResponse.class);
		LogData logData = new LogData();
		logData.setName("Create User");
		logData.setRequest(gson.toJson(register_request));
		logData.setResponse(res);
		String userid = register_request.getSuperuserid();
		logData.setUserid(userid);
		if (apiStatusRes.getResponse().equals("success")) {
			logData.setLogdata("User succesfully Created.");
		} else {
			logData.setLogdata("User not Created.");
		}
		userAuth.addLog(logData);
		logger.info("Result of Register User" + res);
		return res;
	}

	
	@RequestMapping(value = "/user/get", method = RequestMethod.GET)
	public OperatorResponse fetchOperator(@RequestParam("id") Long id,
			@RequestParam(name = "user_type", required = false) String user_type) {
		EditOperatorOrVendorRequest editOperatorOrVendorRequest = new EditOperatorOrVendorRequest();

		editOperatorOrVendorRequest.setId(id);
		// editOperatorOrVendorRequest.setUserIdentityRequest(userSecurity.getUserIdentityRequestFromSecurity());

		return userService.getOperatorDetails(id, user_type);
	}

	@RequestMapping(value = "/user/getAll", method = RequestMethod.GET)
	public OperatorResponse fetchAllOperator(@RequestParam(name = "user_type", required = false) String user_type) {
		EditOperatorOrVendorRequest editOperatorOrVendorRequest = new EditOperatorOrVendorRequest();
		// editOperatorOrVendorRequest.setUserIdentityRequest(userSecurity.getUserIdentityRequestFromSecurity());

		OperatorResponse result = userService.getAllUserDetails(editOperatorOrVendorRequest, user_type);

		return result;
	}
	
	
	@RequestMapping(URIConstants.LOGINURI)
	@PostMapping
	public String Login(@RequestBody UserMongo login_req) {
		//Request to login
		logger.info("Request for Login : " + gson.toJson(login_req));
		LogData logData = new LogData();
		logData.setName("Login Request");
		logData.setRequest(gson.toJson(login_req));
		logData.setUserid(login_req.getEmail());
		String status = null;
		String res = null;
		try {
			// status = userAuth.getLoginRes(userMongo).getStatus();
			res = gson.toJson(userAuth.getLoginRes(login_req));
			logData.setResponse(res);
		
			logData.setLogdata("User is Logged In Successfully");

		} catch (NotFoundException e) {
			LoginResponce loginResponce = new LoginResponce();
			loginResponce.setStatus("fail");
			loginResponce.setReason("User not found");
			res = gson.toJson(loginResponce);
		}
		/*
		 * if(status.equals("success")) { logData.setLogdata("Login succesfully.");
		 * }else { logData.setLogdata("Login failure."); }
		 */
		userAuth.addLog(logData);
		return res;
	}
	
	
	

}