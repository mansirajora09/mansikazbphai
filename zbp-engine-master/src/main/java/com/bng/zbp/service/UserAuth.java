package com.bng.zbp.service;

import java.util.List;

import com.bng.zbp.model.entity.LogData;
import com.bng.zbp.model.request.RegisterRequest;
import com.bng.zbp.model.request.UserMongo;
import com.bng.zbp.model.response.ApiStatusRes;
import com.bng.zbp.model.response.LoginResponce;
import com.google.gson.JsonElement;

import javassist.NotFoundException;

public interface UserAuth {

	public String newRegister(RegisterRequest userMongoDAO);

	public void addLog(LogData logData);

	public LoginResponce getLoginRes(UserMongo userMongo) throws NotFoundException;

	}
