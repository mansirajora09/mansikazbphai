package com.bng.zbp.dao;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bng.zbp.model.entity.User;
import com.bng.zbp.model.entity.UserMysqlPerDAO;
import com.bng.zbp.model.entity.UserRole;
import com.bng.zbp.model.request.RegisterRequest;
import com.bng.zbp.model.request.UserMongo;
import com.bng.zbp.model.response.ApiStatusRes;
import com.bng.zbp.model.response.UserResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Transactional
@Repository
@Service
public class UserRepository {
	private final static Logger logger = LoggerFactory.getLogger(UserRepository.class);
	private static Gson gson = new GsonBuilder().serializeNulls().create();
@PersistenceContext
	private EntityManager entityManager;
	//@Autowired
	//CreateTable createTable;
	


	public UserResponse saveuser(User userMongoDAO, RegisterRequest uiRequestProcess) {
		// to save the data in the table
		UserResponse apiStatusRes = new UserResponse();
		try {
			String email = userMongoDAO.getEmail();
			Query query = entityManager.createQuery("From User User WHERE User.email=:email");
			query.setParameter("email", email);
			Object serviceCampDAOData = query.getSingleResult();

		} catch (NoResultException not_found_exc) {
			// not_found_exc.printStackTrace();
			apiStatusRes.setResponse("fail");
			apiStatusRes.setReason("The user not exist");
			entityManager.close();
			try {
				String userid = UUID.randomUUID().toString();
				userMongoDAO.setUserdata(userid);
				userMongoDAO.setUid(userid);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateString = format.format(new Date());
				userMongoDAO.setJoined_date(dateString);
				userMongoDAO.setLast_modified_on(dateString);
				userMongoDAO.setLast_modified_by(uiRequestProcess.getLast_modified_by());
				String email = userMongoDAO.getEmail();
				entityManager.persist(userMongoDAO);

				Query query = entityManager.createQuery("From User User WHERE User.email=:email");
				query.setParameter("email", email);
				Object serviceCampDAOData = query.getSingleResult();

				User serviceCampDAODATA = gson.fromJson(gson.toJson(serviceCampDAOData), User.class);

				String tableName = "user_blackout_hours";
				Iterator<HashMap<String, String>> iterator = uiRequestProcess.getBlackouthours().iterator();
				int regionIndex = 1;
				String user_id = serviceCampDAODATA.getEmail();
				int id = serviceCampDAODATA.getId();
				while (iterator.hasNext()) {
					HashMap<String, String> region = iterator.next();
					String blackout_hour_startdate = region.get("startdate");
					String blackout_hour_endtdate = region.get("enddate");
					logger.info("blackout hour start date" + blackout_hour_startdate + "blackout hour end date"
							+ blackout_hour_endtdate);

					entityManager
							.createNativeQuery(
									"insert into " + tableName + "(userid,blackout_start,blackout_end)VALUES('" + id
											+ "','" + blackout_hour_startdate + "','" + blackout_hour_endtdate + "');")
							.executeUpdate();

					regionIndex++;
				}

				/*
				if (uiRequestProcess.isBlacklist() == true) {
					logger.info("Creating User BlackList Table ");
					String blacklist_table = "user_" + id + "_ivr_blacklist";
					createTable.createBlackout(blacklist_table);
				}*/
				apiStatusRes.setKey(serviceCampDAODATA.getEmail());
				apiStatusRes.setResponse("success");
				apiStatusRes.setReason("null");
			} catch (Exception e) {
				e.printStackTrace();
				apiStatusRes.setResponse("fail");
				apiStatusRes.setReason("Exception Caught");
				entityManager.close();
				return apiStatusRes;

			}
			entityManager.close();
			return apiStatusRes;

		} catch (NonUniqueResultException non_unique_exc) {
			non_unique_exc.printStackTrace();
			apiStatusRes.setResponse("fail");
			apiStatusRes.setReason("The user is Already registered");
			entityManager.close();
			return apiStatusRes;
		} catch (Exception other_exc) {
			other_exc.printStackTrace();
			apiStatusRes.setResponse("fail");
			apiStatusRes.setReason("Something went wrong");
			entityManager.close();
			return apiStatusRes;
		}
		apiStatusRes.setResponse("fail");
		apiStatusRes.setReason("The User is Already Registered");
		entityManager.close();
		return apiStatusRes;

	}

	public List<User> getUserList(User userMongoDAO) {
		String superuserid = userMongoDAO.getSuperuserid();

		Query query = entityManager
				.createQuery("From User User WHERE User.superuserid=:superuserid order by id desc");

		query.setParameter("superuserid", superuserid);
		// query.setFirstResult(0);
		// query.setMaxResults(1);

		List<User> serviceCampDAO = query.getResultList();

		// TODO Auto-generated method stub
		return serviceCampDAO;
	}

	public String getUserDetails(UserMongo userMongo) {
		// TODO Auto-generated method stub
		if (userMongo.getId() != "") {
			logger.info("Getting user details of id" + userMongo.getId());
			String uid = userMongo.getId();
			try {
				Query query = entityManager.createQuery("From User User WHERE User.uid=:uid");

				query.setParameter("uid", uid);
				User serviceCampDAOData = (User) query.getSingleResult();
				return gson.toJson(serviceCampDAOData);
			} catch (Exception e) {
				return null;
			}
		}
		String email = userMongo.getEmail();
		String password = userMongo.getEncrypted_password();
		logger.info("Inside Password Login of mail " + email);
		try {
			Query query = entityManager.createQuery("From User User WHERE User.email=:email");

			query.setParameter("email", email);
			User serviceCampDAOData = (User) query.getSingleResult();
			/// ServiceCampDAO serviceCampDAODATA=
			/// gson.fromJson(gson.toJson(serviceCampDAOData), ServiceCampDAO.class);
			logger.info("Response from db :" + gson.toJson(serviceCampDAOData));
			entityManager.close();
			return gson.toJson(serviceCampDAOData);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<UserMysqlPerDAO> getPermissionMenuDB(int id) {
		// get menu permission
//logger.info("rolllllllllllllllllleeeeeee"+id);
		// String menu_id=gson.toJson(menu_idd);
	/*	List<String> menuList = Arrays.asList(menu_idd);

		logger.info("menu permission" + gson.toJson(menuList));
		Query query = entityManager.createQuery(
				"From UserMysqlPerDAO UserMysqlPerDAO WHERE UserMysqlPerDAO.menu_id in(:menu_id)  order by UserMysqlPerDAO.menu_id asc");
		List<String> menu_id = Arrays.asList(menu_idd);

		query.setParameter("menu_id", menu_id);
		List<UserMysqlPerDAO> serviceCampDAOListm = query.getResultList();
        //cs
         * 
         */
	//	int id=1;
		Query query2 = entityManager.createQuery(
				"From UserRole userrole WHERE userrole.id =:id");
		query2.setParameter("id", id);
		UserRole user = (UserRole) query2.getSingleResult();

		List<UserMysqlPerDAO> serviceCampDAOList=user.getPermission();
		//end
		logger.info(
				"	Get menu permission from db :" + gson.toJson(user) + "menu list :" + gson.toJson(serviceCampDAOList));

		return serviceCampDAOList;
	}

	public UserResponse forgetPassword(UserMongo userMongo) {

		logger.error("Request to forget Password :" + gson.toJson(userMongo));
		String email = userMongo.getEmail();
		Random r = new Random();
		int low = 1000;
		int high = 9999;
		int pin = r.nextInt(high - low) + low;
		String result = Integer.toString(pin);
		UserResponse apiStatusRes = new UserResponse();
		Query query;
		query = entityManager.createQuery("From User User WHERE User.email=:email");
		query.setParameter("email", email);

		try {
			User userMongoDAODATAUSER = (User) query.getSingleResult();

			if (userMongoDAODATAUSER.isIsactive()) {
				try {
					if (userMongo.isChangepassword()) {
						if (userMongo.getPin().equals(userMongoDAODATAUSER.getCurrent_pin())) {
							userMongoDAODATAUSER.setPassword(userMongo.getEncrypted_password());
							apiStatusRes.setResponse("success");
							apiStatusRes.setReason("null");
						} else {
							apiStatusRes.setResponse("fail");
							apiStatusRes.setReason("Incorrect OTP");
						}
					} else {
						userMongoDAODATAUSER.setCurrent_pin(result);
						apiStatusRes.setValue(pin);
						apiStatusRes.setResponse("success");
						apiStatusRes.setReason("null");
					}
					entityManager.persist(userMongoDAODATAUSER);
					// String id=userMongoDAODATAUSER.getId();

				} catch (Exception e) {
					apiStatusRes.setResponse("fail");
					apiStatusRes.setReason("Not Allowed");
				}
			} else {
				apiStatusRes.setResponse("fail");
				apiStatusRes.setReason("This User not active with us");
			}
		} catch (Exception e) {
			apiStatusRes.setResponse("fail");
			apiStatusRes.setReason("User not found");
		}

		return apiStatusRes;
	}

	public ApiStatusRes converttoenterprise(User userMongoDAO) {
		// TODO Auto-generated method stub
		ApiStatusRes apiStatusRes = new ApiStatusRes();
		String email = userMongoDAO.getEmail();
		Query query;
		query = entityManager.createQuery("From User User WHERE User.email=:email");
		query.setParameter("email", email);
		User userMongoDAODATA = (User) query.getSingleResult();
		logger.error("under mysql" + gson.toJson(userMongoDAODATA) + "===" + userMongoDAODATA.isIsactive() + "enter"
				+ userMongoDAODATA.isEnterprise());
		if (!userMongoDAODATA.isIssubuser()) {
			userMongoDAODATA.setCompany_email(userMongoDAO.getCompany_email());
			userMongoDAODATA.setCompany_name(userMongoDAO.getCompany_name());
			String arrayData = userMongoDAODATA.getPermission();
			arrayData = arrayData + ",4";
			// ArrayList<String> myList = new ArrayList<String>(Arrays.asList(arrayData));
			// myList.add("4");
			// arrayData = myList.toArray(arrayData);

			userMongoDAODATA.setPermission(arrayData);
			userMongoDAODATA.setIsactive(false);
			userMongoDAODATA.setEnterprise(true);
			logger.error("under mysql" + gson.toJson(userMongoDAODATA) + "===" + userMongoDAODATA.isIsactive() + "enter"
					+ userMongoDAODATA.isEnterprise());

			try {
				entityManager.persist(userMongoDAODATA);
				apiStatusRes.setResponse("success");
				apiStatusRes.setReason("null");
				apiStatusRes.setKey(userMongoDAODATA.getUserdata());
			} catch (Exception e) {
				System.out.println("inside exception");
				apiStatusRes.setResponse("fail");
				apiStatusRes.setReason("error");
			}

		} else {
			apiStatusRes.setResponse("fail");
			apiStatusRes.setReason("Not Allowed");
		}
		return apiStatusRes;
	}


	
	public UserResponse editProfile(User userMongoDAO) {
		// Updating the user info from Database 
		UserResponse apiStatusRes = new UserResponse();
		String email = userMongoDAO.getEmail();
		String pin = userMongoDAO.getCurrent_pin();
		Query query;
		query = entityManager.createQuery("From User User WHERE User.email=:email");
		query.setParameter("email", email);
		User userMongoDAODATA = (User) query.getSingleResult();

		logger.info("Getting the User Info from DB :" + gson.toJson(userMongoDAODATA));
		if (userMongoDAODATA.isIsactive()) {
			if (userMongoDAO.getPassword() == null || userMongoDAO.getPassword().isEmpty()) {
				logger.info("Inside if Password is Empty");
				userMongoDAODATA.setMobile(userMongoDAO.getMobile());

			} else {
				logger.info("Inside Else in updating the User");
				userMongoDAODATA.setPassword(userMongoDAO.getPassword());
				userMongoDAODATA.setMobile(userMongoDAO.getMobile());
				userMongoDAODATA.setName(userMongoDAO.getName());
				userMongoDAODATA.setCompany_name(userMongoDAO.getCompany_name());
				userMongoDAODATA.setCountry(userMongoDAO.getCountry());
				userMongoDAODATA.setPermission(userMongoDAO.getPermission());
				userMongoDAODATA.setCli(userMongoDAO.getCli());
				userMongoDAODATA.setMscip(userMongoDAO.getMscip());
				userMongoDAODATA.setTps(userMongoDAO.getTps());
				userMongoDAODATA.setRetry(userMongoDAO.isRetry());
				userMongoDAODATA.setBlacklist(userMongoDAO.isBlacklist());
				userMongoDAODATA.setCountry_code(userMongoDAO.getCountry_code());
				userMongoDAODATA.setAppend_countrycode(userMongoDAO.isAppend_countrycode());
				userMongoDAODATA.setMsisdn_length(userMongoDAO.getMsisdn_length());
				userMongoDAODATA.setCurrency(userMongoDAO.getCurrency());
				userMongoDAODATA.setRole(userMongoDAO.getRole());
				userMongoDAODATA.setService_permission(userMongoDAO.getPermission());
			}
			try {
				entityManager.persist(userMongoDAODATA);

				apiStatusRes.setResponse("success");
				apiStatusRes.setReason("null");
			} catch (Exception e) {
				logger.error("Exception occur in Edit Profiling ");
				apiStatusRes.setResponse("fail");
				apiStatusRes.setReason("error");
			}
		} else {
			apiStatusRes.setResponse("fail");
			apiStatusRes.setReason("Not Allowed");
		}
		return apiStatusRes;
	}

	
	
	public UserResponse changestatus(User userMongoDAO) {
		// changing the user status i.e., active status
		logger.info("Request to change status :" + gson.toJson(userMongoDAO));
		UserResponse apiStatusRes = new UserResponse();
		Boolean isactive = userMongoDAO.isIsactive();
		String email = userMongoDAO.getEmail();
		String superuserid = userMongoDAO.getSuperuserid();
		Query query;
		query = entityManager.createQuery(
				"From User User WHERE User.email=:email and User.superuserid=:superuserid");
		query.setParameter("email", email);
		query.setParameter("superuserid", superuserid);

		User userMongoDAODATA = (User) query.getSingleResult();
		userMongoDAODATA.setIsactive(userMongoDAO.isIsactive());
		try {
			logger.info("DAO User Data to  change user status :" + gson.toJson(userMongoDAODATA));

			entityManager.persist(userMongoDAODATA);

			apiStatusRes.setResponse("success");
			apiStatusRes.setReason("Status is changed Successfully ");
		} catch (Exception e) {
			e.printStackTrace();
			apiStatusRes.setResponse("fail");
			apiStatusRes.setReason("Exception Caught");
		}
		entityManager.close();

		return apiStatusRes;
	}

	public List<UserRole> getrole_list() {
		// TODO Auto-generated method stub
		
		Query query2 = entityManager.createQuery(
				"From UserRole userrole WHERE userrole.is_active =:isactive");
		query2.setParameter("isactive", true);
		List<UserRole> user = query2.getResultList();

		//end
		logger.info(
				"================Role list Response from db :" + gson.toJson(user) );

		return user;

	}

	
}