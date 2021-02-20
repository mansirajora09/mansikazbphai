package com.bng.zbp.model.response;

import java.util.List;

public class OperatorResponse extends BaseResponse {

    private List<OperatorModel> userList;

	public List<OperatorModel> getUserList() {
		return userList;
	}

	public void setUserList(List<OperatorModel> userList) {
		this.userList = userList;
	}


    
}