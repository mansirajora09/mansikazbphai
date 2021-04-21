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
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bng.zbp.business.UserBusinessLayer;
import com.bng.zbp.controller.Mailer;
import com.bng.zbp.controller.UserActionEventController;
import com.bng.zbp.dao.UserRepository;
import com.bng.zbp.model.entity.Advertiser;
import com.bng.zbp.model.entity.Agency;
import com.bng.zbp.model.entity.CampListRequestData;
import com.bng.zbp.model.entity.LogData;
import com.bng.zbp.model.entity.Operator;
import com.bng.zbp.model.entity.Publisher;
import com.bng.zbp.model.entity.User;
import com.bng.zbp.model.entity.UserMongoBO;
import com.bng.zbp.model.entity.UserMysqlPerDAO;
import com.bng.zbp.model.request.RegisterRequest;
import com.bng.zbp.model.request.UserMongo;
import com.bng.zbp.model.response.UserResponse;
import com.bng.zbp.repository.AdvertiserRepository;
import com.bng.zbp.repository.AgencyRepository;
import com.bng.zbp.repository.OperatorRepository;
import com.bng.zbp.repository.PublisherRepository;
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
	@Autowired
	OperatorRepository operatorRepository;
	@Autowired
	PublisherRepository publisherRepository;

	@Autowired
	AgencyRepository agencyRepository;
	@Autowired 
	AdvertiserRepository advertiserRepository;
	
	@Override
	public String saveUser(RegisterRequest register_request) {

		String encrypted_password = encode(register_request.getPassword());
		register_request.setPassword(encrypted_password);

		User new_user_data;
		
		String userMongoDOO = gson.toJson(register_request);
		//mapping request to save the data as iobd_users
		new_user_data = Utility.mapUserMongoDAOListToUserMongoDOOList(userMongoDOO);

if(register_request.getUserdata().equalsIgnoreCase("operator"))	
    {
  //  public Operator(Date crdt, Long createdBy, Date lastModifiedOn, Long lastModifiedBy, Boolean isActive, String name, String description, String logoImageUrl, String bannerUrl, String country) {
//	public Operator(Date crdt, Boolean isActive, String name, String country) {

	Operator operator_data = new Operator(	new Date(),12L,true,register_request.getName(),register_request.getCountry());
	Operator operator=operatorRepository.save(operator_data);
	new_user_data.setOperator(operator.getId());
	}
else if(register_request.getUserdata().equalsIgnoreCase("publisher"))	
{
//  public Operator(Date crdt, Long createdBy, Date lastModifiedOn, Long lastModifiedBy, Boolean isActive, String name, String description, String logoImageUrl, String bannerUrl, String country) {
//public Operator(Date crdt, Boolean isActive, String name, String country) {

Publisher operator_data = new Publisher(	register_request.getName());
Publisher operator=publisherRepository.save(operator_data);
new_user_data.setPublisher_id(operator.getId());
} 
else if(register_request.getUserdata().equalsIgnoreCase("agency"))	
{
//  public Operator(Date crdt, Long createdBy, Date lastModifiedOn, Long lastModifiedBy, Boolean isActive, String name, String description, String logoImageUrl, String bannerUrl, String country) {
//public Operator(Date crdt, Boolean isActive, String name, String country) {

	Agency operator_data = new Agency(	register_request.getName());
	Agency operator=agencyRepository.save(operator_data);
new_user_data.setAgency_id(operator.getId());
}
else if(register_request.getUserdata().equalsIgnoreCase("advertiser"))	
{
//  public Operator(Date crdt, Long createdBy, Date lastModifiedOn, Long lastModifiedBy, Boolean isActive, String name, String description, String logoImageUrl, String bannerUrl, String country) {
//public Operator(Date crdt, Boolean isActive, String name, String country) {

	Advertiser operator_data = new Advertiser(	register_request.getName());
	Advertiser operator=advertiserRepository.save(operator_data);
new_user_data.setAdvertiser_id(operator.getId());
}

		
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

	private int UserType(String user_type) {
		// TODO Auto-generated method stub
		return 0;
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
