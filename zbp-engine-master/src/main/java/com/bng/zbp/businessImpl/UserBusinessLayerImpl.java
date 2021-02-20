package com.bng.zbp.businessImpl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bng.zbp.business.UserBusinessLayer;
import com.bng.zbp.controller.Mailer;
import com.bng.zbp.controller.UserActionEventController;
import com.bng.zbp.dao.UserRepository;
import com.bng.zbp.model.entity.CampListRequestData;
import com.bng.zbp.model.entity.LogData;
import com.bng.zbp.model.entity.User;
import com.bng.zbp.model.entity.UserMongoBO;
import com.bng.zbp.model.entity.UserMysqlPerDAO;
import com.bng.zbp.model.request.RegisterRequest;
import com.bng.zbp.model.request.UserMongo;
import com.bng.zbp.model.response.UserResponse;
import com.bng.zbp.util.URIConstants;
import com.bng.zbp.util.Utility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class UserBusinessLayerImpl implements UserBusinessLayer {
	private final static Logger logger = LoggerFactory.getLogger(UserActionEventController.class);
	private static final Gson gson = new GsonBuilder().serializeNulls().create();
	
	@Autowired
	Mailer mailer;
	@Autowired
	UserRepository userRepository;
	
	@Override
	public String saveUser(RegisterRequest register_request) {

		String encrypted_password = encode(register_request.getPassword());
		register_request.setPassword(encrypted_password);

		User new_user_data;
		
		String userMongoDOO = gson.toJson(register_request);
		//mapping request to save the data as iobd_users
		new_user_data = Utility.mapUserMongoDAOListToUserMongoDOOList(userMongoDOO);

		UserResponse apiStatusRes = userRepository.saveuser(new_user_data, register_request);
		String res = apiStatusRes.getResponse();
		if (res.equals("success")) {
			String encodedurl = encodeUrl(apiStatusRes.getKey());
			String name = register_request.getName();
			String activateUrl = URIConstants.BASEURL + URIConstants.ACTIVATEACCOUNT + "/" + encodedurl + "/email";
			String template = "verify";
			if (register_request.isVerify_mail()) {
				logger.info("Sending mail to verify and activate the user" + activateUrl + "Receiver" + apiStatusRes.getKey());

				mailer.sendEmail("karaniamr@gmail.com", register_request.getEmail(), "Activate Your Account", activateUrl,
						name, template);

			}
		}
		String result = gson.toJson(apiStatusRes);
		return result;
	}

	public static String encodeUrl(String url) {
		try {
			String encodeURL = URLEncoder.encode(url, "UTF-8");
			return encodeURL;
		} catch (UnsupportedEncodingException e) {
			return "Issue while encoding" + e.getMessage();
		}
	}
	public static String encode(final String password) {
		try {
			return new String(Base64.getEncoder()
					.encode(MessageDigest.getInstance("SHA-256").digest(password.getBytes(StandardCharsets.UTF_8))));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			String res = "Error";
			return res;
		}
	}

	@Override
	public void addLog(LogData logData) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		// System.out.println("date"+dateFormat.format(cal.getTime()));
	//	logData.setTime(dateFormat.format(cal.getTime()));
	//	campRepository.saveLog(logData);
	}

	@SuppressWarnings("null")
	public UserMongoBO userlogin(UserMongo userMongo) {
		String reqdataf = gson.toJson(userMongo);
		logger.info("Request Data : " + gson.toJson(userMongo));
		if (userMongo.getId() == "") {
			String given_password = userMongo.getPassword();
			String encrypted_password = encode(given_password);
			userMongo.setEncrypted_password(encrypted_password);
			logger.info("Given Password : " + given_password + "  Encrypted Password:" + encrypted_password);
		}
		User userMongoDAO;

		UserMongoBO userMongoBO = new UserMongoBO();
		try {
			String userMongoDOO = userRepository.getUserDetails(userMongo);
			userMongoDAO = Utility.mapUserMongoDAOListToUserMongoDOOList(userMongoDOO);

			if (userMongoDAO == null) {
				userMongoBO.setUserexist(false);
				return null;
			}
			logger.info("Response from getUserDetails : " + gson.toJson(userMongoDAO) );

			userMongoBO = Utility.mapUserMongoDAOListToUserMongoBOList(userMongoDAO);
			CampListRequestData camp_Request_Data = new CampListRequestData();
			camp_Request_Data.setCampstatus("all");
			camp_Request_Data.setUserid(userMongoBO.getId());
			//code comment for africell sl
			/*
			int count = campRepository.getTotalRow(camp_Request_Data);
			if (count > 0) {
				userMongoBO.setCamplistexist(true);
			} else {
				userMongoBO.setCamplistexist(false);
			}
			*/
			userMongoBO.setCamplistexist(true);

			return userMongoBO;
		} catch (Exception e) {
			e.printStackTrace();
			userMongoBO.setUserexist(false);
			return userMongoBO;
		}
	}

	public List<UserMysqlPerDAO> getPermissionMenub(User userMongoDAO) {
		int rolegot=userMongoDAO.getRole();
		List<UserMysqlPerDAO> userMongoPerDAO = userRepository.getPermissionMenuDB(rolegot);
		//List<UserMongoPerBO> userMongoPerBO = Utility.mapUserMongoPerDAOListToUserMongoPerBOList(userMongoPerDAO);
		logger.info("mapUserMongoPerDAOListToUserMongoPerBOList" + gson.toJson(userMongoPerDAO)
		);
		return userMongoPerDAO;
	}




}
