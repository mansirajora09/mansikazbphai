package com.bng.zbp.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bng.zbp.model.entity.Advertiser;
import com.bng.zbp.model.entity.Agency;
import com.bng.zbp.model.entity.Operator;
import com.bng.zbp.model.entity.Publisher;
import com.bng.zbp.model.request.EditOperatorOrVendorRequest;
import com.bng.zbp.model.response.OperatorModel;
import com.bng.zbp.model.response.OperatorResponse;
import com.bng.zbp.model.response.ResponseErrorKey;
import com.bng.zbp.model.response.ResponseStatus;
import com.bng.zbp.repository.AdvertiserRepository;
import com.bng.zbp.repository.AgencyRepository;
import com.bng.zbp.repository.OperatorRepository;
import com.bng.zbp.repository.PublisherRepository;
import com.bng.zbp.service.UserService;

/**
 * @Author Mansi Rajora
 */
@Service
public class UserServiceImpl implements UserService {

	private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private OperatorRepository operatorRepository;

	@Autowired
	AdvertiserRepository advertiserRepository;
	
	@Autowired
	PublisherRepository publisherRepository;
	
	@Autowired
	AgencyRepository agencyRepository;
	
	
	
	private Map<ResponseErrorKey, String> errorMap;

	/**
	 * This method create operator and persist the details in the operator table
	 *
	 * @param request
	 * @return OperatorResponse
	 */
	
	/**
	 * This method used to fetch the details of operators by id
	 *
	 * @param request
	 * @return
	 */
		/**
	 * This method update requested operator details.
	 *
	 * @param request
	 * @param operator
	 */
	private void updateOperator(EditOperatorOrVendorRequest request, Operator operator) {
		operator.setLastModifiedBy(request.getUserIdentityRequest().getUserId());
		operator.setLastModifiedOn(new Date());
		if (!StringUtils.isEmpty(request.getName())) {
			operator.setName(request.getName());
		}
		if (request.getActive() != null && request.getDeleted() != null && request.getActive() == true
				&& request.getDeleted() == false) {
			operator.setActive(true);
		}
		if (request.getActive() != null && request.getDeleted() != null && request.getActive() == false
				&& request.getDeleted() == true) {
			operator.setActive(false);
		}
		if (!StringUtils.isEmpty(request.getDescription())) {
			operator.setDescription(request.getDescription());
		}
		if (!StringUtils.isEmpty(request.getBannerUrl())) {
			operator.setDescription(request.getBannerUrl());
		}
		if (!StringUtils.isEmpty(request.getLogoImageUrl())) {
			operator.setDescription(request.getLogoImageUrl());
		}
	}

	@Override
	public OperatorResponse getAllUserDetails(EditOperatorOrVendorRequest editOperatorOrVendorRequest, String  user_type) {
		OperatorResponse response = new OperatorResponse();
		List<OperatorModel> modelList = new ArrayList<>();
		errorMap = new HashMap<>();
		
		try {
	
			if(user_type.equalsIgnoreCase("operator"))
			
				{
				List<Operator> OptionalOperator;

				OptionalOperator = operatorRepository.findAll();
			
				if (OptionalOperator != null) {
				OptionalOperator.forEach(operator -> {
				OperatorModel model = new OperatorModel(operator);
				modelList.add(model);

				});
				response.setUserList(modelList);
				response.setStatus(ResponseStatus.SUCCESS);

				
				}
				}
				else if(user_type.equalsIgnoreCase("advertiser"))
				{
					
					List<Advertiser> AdvertiserUser;

					AdvertiserUser = advertiserRepository.findAll();
				
					if (AdvertiserUser != null) {
						AdvertiserUser.forEach(operator -> {
					OperatorModel model = new OperatorModel(operator);
					modelList.add(model);

					});
					response.setUserList(modelList);
					response.setStatus(ResponseStatus.SUCCESS);

				}
				}
				
				else if(user_type.equalsIgnoreCase("publisher"))
				{
					
					
					List<Publisher> publisherUser;

					publisherUser = publisherRepository.findAll();
				
					if (publisherUser != null) {
						publisherUser.forEach(operator -> {
					OperatorModel model = new OperatorModel(operator);
					modelList.add(model);

					});
					response.setUserList(modelList);
					response.setStatus(ResponseStatus.SUCCESS);

				}
				}
				
				else if(user_type.equalsIgnoreCase("agency"))
				{
					
					List<Agency> agencyUser;

					agencyUser = agencyRepository.findAll();
				
					if (agencyUser != null) {
						agencyUser.forEach(operator -> {
					OperatorModel model = new OperatorModel(operator);
					modelList.add(model);

					});
					response.setUserList(modelList);
					response.setStatus(ResponseStatus.SUCCESS);

					
				}
				
				
			} else {
				response.setStatus(ResponseStatus.FAILED);
				errorMap.put(ResponseErrorKey.ERROR, "User with this id does not exist in bng ");
				response.setErrorMessageMap(errorMap);
			}
		
		}catch (Exception e) {
			response.setStatus(ResponseStatus.FAILED);
			logger.error("Error occurred while fetching user using id");
			errorMap.put(ResponseErrorKey.ERROR, "Error occurred while fetching User using id");
			response.setErrorMessageMap(errorMap);
			return response;
		}
		return response;
	}

	@Override
	public OperatorResponse getOperatorDetails(Long id, String user_type) {
		// TODO Auto-generated method stub
		OperatorResponse response = new OperatorResponse();
		List<OperatorModel> modelList = new ArrayList<>();
		errorMap = new HashMap<>();
		
		try {
	
			if(user_type.equalsIgnoreCase("operator"))
			
				{
				
				Optional<Operator> OptionalOperator = operatorRepository.findById(id);

				if (OptionalOperator != null) {
					Operator operator = OptionalOperator.get();
					OperatorModel model = new OperatorModel(operator);
					modelList.add(model);
					response.setUserList(modelList);
					response.setStatus(ResponseStatus.SUCCESS);
				}
				}
				else if(user_type.equalsIgnoreCase("advertiser"))
				{
					

			
					Optional<Advertiser> OptionalOperator = advertiserRepository.findById(id);

					if (OptionalOperator != null) {
						Advertiser operator = OptionalOperator.get();
						OperatorModel model = new OperatorModel(operator);
						modelList.add(model);
						response.setUserList(modelList);
						response.setStatus(ResponseStatus.SUCCESS);
					}
					
				}
				
				else if(user_type.equalsIgnoreCase("publisher"))
				{
					
			Optional<Publisher> OptionalOperator = publisherRepository.findById(id);

					if (OptionalOperator != null) {
						Publisher operator = OptionalOperator.get();
						OperatorModel model = new OperatorModel(operator);
						modelList.add(model);
						response.setUserList(modelList);
						response.setStatus(ResponseStatus.SUCCESS);
					}
				}
				
				else if(user_type.equalsIgnoreCase("agency"))
				{

					
					Optional<Agency> OptionalOperator = agencyRepository.findById(id);

					if (OptionalOperator != null) {
						Agency operator = OptionalOperator.get();
						OperatorModel model = new OperatorModel(operator);
						modelList.add(model);
						response.setUserList(modelList);
						response.setStatus(ResponseStatus.SUCCESS);
					}		
				}
				
			 else {
				response.setStatus(ResponseStatus.FAILED);
				errorMap.put(ResponseErrorKey.ERROR, "User with this id does not exist in bng ");
				response.setErrorMessageMap(errorMap);
			}
		
		
		}
		catch (Exception e) {
			response.setStatus(ResponseStatus.FAILED);
			logger.error("Error occurred while fetching user using id");
			errorMap.put(ResponseErrorKey.ERROR, "Error occurred while fetching User using id");
			response.setErrorMessageMap(errorMap);
			return response;
		}
		return response;
	}

	
	
}