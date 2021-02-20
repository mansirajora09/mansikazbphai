package com.bng.zbp.business;

import java.util.List;

import com.bng.zbp.model.entity.User;
import com.bng.zbp.model.entity.LogData;
import com.bng.zbp.model.entity.UserMongoBO;
import com.bng.zbp.model.entity.UserMysqlPerDAO;
import com.bng.zbp.model.request.RegisterRequest;
import com.bng.zbp.model.request.UserMongo;

public interface UserBusinessLayer {

	String saveUser(RegisterRequest newuserData);

	void addLog(LogData logData);

	UserMongoBO userlogin(UserMongo userMongo);

	List<UserMysqlPerDAO> getPermissionMenub(User userMongoDAO);


}
