package com.bng.zbp.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bng.zbp.controller.ZbpCampaignController;
import com.bng.zbp.model.entity.User;
import com.bng.zbp.model.entity.UserMongoBO;
import com.bng.zbp.request.ServiceCampBO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
public class Utility {
	private final static Logger logger = LoggerFactory.getLogger(ZbpCampaignController.class);
	private static final Gson gson = new GsonBuilder().serializeNulls().create();
	private static final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

	public static ServiceCampBO mapCampDAOToCampBO(String serviceData)
	{
		// TODO Auto-generated method stub
		if (serviceData == null)
			return null;
		ServiceCampBO serviceCampBO=gson.fromJson(serviceData,ServiceCampBO.class);
		String serviceCampBOd=gson.toJson(serviceCampBO);
		logger.info("UTILITY Data : "+serviceCampBOd);
		return serviceCampBO;
		}
	

	public static User mapUserMongoDAOListToUserMongoDOOList(String userMongoDOO) {
		// TODO Auto-generated method stub
		if (userMongoDOO == null)
			return null;
		User serviceCampBO=gson.fromJson(userMongoDOO,User.class);
		String serviceCampBOd=gson.toJson(serviceCampBO);
		logger.info("UTILITY Data for mapping register request: "+serviceCampBOd);
		return serviceCampBO;	}


	public static UserMongoBO mapUserMongoDAOListToUserMongoBOList(User userMongoDAO) {

		if (userMongoDAO == null)
			return null;
		mapperFactory.classMap(User.class,UserMongoBO.class);
		MapperFacade mapper = mapperFactory.getMapperFacade();
		UserMongoBO userMongoBO = mapper.map(userMongoDAO, UserMongoBO.class);

		return userMongoBO;
	}


	public static  User mapUserBOToLoginResponce(UserMongoBO userMongoBO) {
		if (userMongoBO == null)
			return null;
		mapperFactory.classMap(UserMongoBO.class, User.class);
		MapperFacade mapper = mapperFactory.getMapperFacade();
		User userMongoDAO = mapper.map(userMongoBO, User.class);
		return userMongoDAO;
	}
	
	
	
	
}
