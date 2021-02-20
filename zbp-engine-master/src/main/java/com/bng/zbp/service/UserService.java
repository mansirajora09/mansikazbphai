package com.bng.zbp.service;

import com.bng.zbp.model.request.EditOperatorOrVendorRequest;
import com.bng.zbp.model.response.OperatorResponse;

/**
 * @Author Mansi Rajora
 */
public interface UserService {




	public OperatorResponse getAllUserDetails(EditOperatorOrVendorRequest editOperatorOrVendorRequest, String user_type);


	public OperatorResponse getOperatorDetails(Long id, String user_type);

	}
