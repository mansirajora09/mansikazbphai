package com.bng.zbp.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bng.zbp.business.UserBusinessLayer;
import com.bng.zbp.model.entity.User;
import com.bng.zbp.model.entity.LogData;
import com.bng.zbp.model.entity.UserMongoBO;
import com.bng.zbp.model.entity.UserMysqlPerDAO;
import com.bng.zbp.model.request.RegisterRequest;
import com.bng.zbp.model.request.UserMongo;
import com.bng.zbp.model.response.LoginResponce;
import com.bng.zbp.repository.OperatorRepository;
import com.bng.zbp.repository.PublisherRepository;
import com.bng.zbp.service.UserAuth;
import com.bng.zbp.util.Utility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class UserAuthImpl implements UserAuth {
	private final static Logger logger = LoggerFactory.getLogger(UserAuth.class);
	private static final Gson gson = new GsonBuilder().serializeNulls().create();
	@Autowired
	UserBusinessLayer userBusinessLayer;
	
	@Override
	public String newRegister(RegisterRequest register_request) {
		String saveuser = userBusinessLayer.saveUser(register_request);
		return saveuser;
	}
	@Override
	public void addLog(LogData logData) {
		userBusinessLayer.addLog(logData);
	}

	public LoginResponce getLoginRes(UserMongo userMongo) {
		UserMongoBO userMongoBO = userBusinessLayer.userlogin(userMongo);

		logger.info("Login  resp from business Layer userlogin : " + gson.toJson(userMongo));
		LoginResponce loginResponce = new LoginResponce();
		if (userMongoBO == null) {
			loginResponce.setStatus("Fail");
			loginResponce.setReason("Sorry ,User not found");
			loginResponce.setToken("null");
			return loginResponce;
		}
		
		User userMongoDAO = Utility.mapUserBOToLoginResponce(userMongoBO);

		try {
			if (userMongo.getId() != "") {
				loginResponce.setStatus("success");
				String nstatus = loginResponce.getStatus();
				loginResponce.setReason("null");
	//			List<UserMongoPerBO> userMongoPerBO = userBusinessLayer.getPermissionMenu(userMongoDAO);
//				List<UserMysqlPerDAO> userMongoPerDAO = Utility.mapUserMongoPerToLoginResponce(userMongoPerBO);
				List<UserMysqlPerDAO> userMongoPerDAO = userBusinessLayer.getPermissionMenub(userMongoDAO);


				logger.info("get permission menu"+ gson.toJson(userMongoPerDAO) + "New status : " + nstatus + "mapping the response in correct way" + userMongoPerDAO);

				loginResponce.setUser_Info(userMongoDAO);
				String dataf = gson.toJson(userMongoPerDAO);
				logger.info("Menu Data : " + dataf);
				loginResponce.setPermission(userMongoPerDAO);
				return loginResponce;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		String db_password = userMongoDAO.getPassword();
		String encrypted_password = userMongo.getEncrypted_password();
		try {
			byte[] bytes = db_password.getBytes("UTF-8");
			String dbnewpassword = new String(bytes, "UTF-8");
			logger.info("Db encrypted password : " + dbnewpassword + "Given password" + encrypted_password);
			if (dbnewpassword.equals(encrypted_password)) {

				//String userToken = jwtGenerator.generate(userMongo);
				//String userToken = userSecurityHelper.generateTokenByEmail(userMongo.getEmail());
				loginResponce.setStatus("success");
				String nstatus = loginResponce.getStatus();
				logger.info("New status : " + nstatus);
				loginResponce.setReason("null");
				//loginResponce.setToken(userToken);
				List<UserMysqlPerDAO> userMongoPerDAO = userBusinessLayer.getPermissionMenub(userMongoDAO);

				
				logger.info("menu permission :" + gson.toJson(userMongoPerDAO));
				loginResponce.setUser_Info(userMongoDAO);
				String dataf = gson.toJson(userMongoPerDAO);
				loginResponce.setPermission(userMongoPerDAO);
				logger.info("login_response :" + gson.toJson(loginResponce));
			} else {
				loginResponce.setStatus("Fail");
				loginResponce.setReason("Incorrect Password");
				loginResponce.setToken("null");
			}
		} catch (Exception e) {
			e.printStackTrace();
			loginResponce.setStatus("Fail");
			loginResponce.setReason("exception");
		}
		return loginResponce;
	}

}
