package com.bng.zbp.serviceImpl;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.bng.zbp.business.CampBusinessLayer;
import com.bng.zbp.businessImpl.CampBusinessLayerImpl;
import com.bng.zbp.cache.repository.RedisRepository;
import com.bng.zbp.model.entity.Campaign;
import com.bng.zbp.model.entity.CampaignContent;
import com.bng.zbp.model.entity.CampaignPublisherLink;
import com.bng.zbp.model.entity.Capping;
import com.bng.zbp.model.entity.LogData;
import com.bng.zbp.model.entity.Operator;
import com.bng.zbp.model.entity.Publisher;
import com.bng.zbp.model.entity.Tags;
import com.bng.zbp.model.enums.CampaignType;
import com.bng.zbp.model.enums.FlowType;
import com.bng.zbp.model.enums.MediaType;
import com.bng.zbp.model.enums.Status;
import com.bng.zbp.model.request.CampaignRequest;
import com.bng.zbp.model.response.BaseResponse;
import com.bng.zbp.model.response.CampaignResponseBO;
import com.bng.zbp.model.response.CampaignResponseList;
import com.bng.zbp.model.response.OperatorModel;
import com.bng.zbp.model.response.ResponseErrorKey;
import com.bng.zbp.model.response.ResponseStatus;
import com.bng.zbp.model.response.ServiceListResponse;
import com.bng.zbp.model.response.TagResponse;
import com.bng.zbp.repository.CampaignContentRepository;
import com.bng.zbp.repository.CampaignPublisherLinkRepository;
import com.bng.zbp.repository.CampaignRepository;
import com.bng.zbp.repository.CappingRepository;
import com.bng.zbp.repository.LogsRepository;
import com.bng.zbp.repository.OperatorRepository;
import com.bng.zbp.repository.PublisherRepository;
import com.bng.zbp.repository.ServiceRepository;
import com.bng.zbp.repository.TagRepository;
import com.bng.zbp.request.CampCreateReqData;
import com.bng.zbp.request.ServiceCampBO;
import com.bng.zbp.request.Timestamp;
import com.bng.zbp.service.CampaignService;
import com.bng.zbp.service.DateTimeConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Mansi Rajora
 */
@Service
public class CampaignServiceImpl implements CampaignService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final Gson gson = new GsonBuilder().serializeNulls().create();

	@Autowired
	private RedisRepository redisRepository;
	@Autowired
	private CampaignRepository campaignRepository;

	@Autowired
	private CampaignContentRepository campaignContentRepository;
	@Autowired
	CampaignPublisherLinkRepository CampaignPublisherLinkRepository;

	@Autowired
	CappingRepository cappingRepository;

	@Autowired
	PublisherRepository publisherRepository;

	@Autowired
	private CampBusinessLayer campBusinessLayer;
	@Autowired
	private OperatorRepository operatorRepository;
	@Autowired
	TagRepository tagRepository;
	@Autowired
	ServiceRepository serviceRepository;
	@Autowired
	LogsRepository logsRepository;

	private Map<ResponseErrorKey, String> errorMap;
	String success_status = "SUCCESS";
	String fail_status = "FAILED";

	@Override
	public CampaignResponseList getCampaignList(CampaignRequest request) {
		CampaignResponseList response = new CampaignResponseList();
		try {
			List<CampaignResponseBO> modelList = new ArrayList<>();

			List<Campaign> campaignResponseList = campaignRepository.findAll();

			if (campaignResponseList != null) {
				campaignResponseList.forEach(camp -> {
					CampaignResponseBO model = new CampaignResponseBO(camp);
					modelList.add(model);

				});
				response.setCampaignResponseList(modelList);
				response.setStatus(ResponseStatus.SUCCESS);

				response.setStatus(ResponseStatus.SUCCESS);
				logger.info(" campaign list fetched successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(" error occured while fetching Campaing list: ");
			response.setError(" error occured while fetching Campaing list: ");
			response.setStatus(ResponseStatus.FAILED);

		}
		return response;
	}

	@Override
	public BaseResponse createCamp(CampCreateReqData requestData) {
		// Create Camp Request
		BaseResponse response = new BaseResponse();
		errorMap = new HashMap<>();

		ServiceCampBO serviceCampBO = campBusinessLayer.getSeriveInfo(requestData);

		try {
			Campaign campExist = campaignRepository.findByName(serviceCampBO.getName());
			// use user authentication
			if (campExist == null) {

				Optional<Operator> operator = operatorRepository.findById(serviceCampBO.getOperator_id());

				/*
				 * Get Time from the Request
				 */
				Map<String, String> timezone = requestData.getTimezone();
				String getoperator = timezone.get("operator");
				String timezonevalue = timezone.get("timezonevalue");

				DateTimeConverter newdatetime = new DateTimeConverter();
				String startDateTime = newdatetime.convertdate(serviceCampBO.getStart_date(),
						serviceCampBO.getStart_time(), timezonevalue, getoperator);
				String[] startUnits = startDateTime.split("T");
				String endDateTime = newdatetime.convertdate(serviceCampBO.getEnd_date(), serviceCampBO.getEnd_time(),
						timezonevalue, getoperator);
				Timestamp timestamp = new Timestamp();
				// String randomid = UUID.randomUUID().toString();

				try {
					Date iSOstartDateTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(startDateTime);
					Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateTime);
					Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateTime);

					timestamp.setStarttime(iSOstartDateTime);
					Date iSOendDateTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(endDateTime);

					timestamp.setEndtime(iSOendDateTime);

					serviceCampBO.setTimestamp(timestamp);

					Date time = new java.util.Date();
					String tableTimeDate = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());

					Time startTime = Time.valueOf(serviceCampBO.getStart_time());

					Time endTime = Time.valueOf(serviceCampBO.getEnd_time());

					CampaignType type = CampaignType.valueOf(serviceCampBO.getType());
					MediaType mediaType = MediaType.valueOf(serviceCampBO.getMedia_type());
					FlowType flowType = FlowType.valueOf(serviceCampBO.getFlow());
					Status status=Status.valueOf("SCHEDULED");
					// Priority priority = Priority.valueOf(serviceCampBO.getPriority());
					int priority = serviceCampBO.getPriority();
					Operator operatorObject = operator.get();
					String scp_flow_name = serviceCampBO.getService_name();

					campExist = new Campaign(serviceCampBO.getName(), startDate, endDate, startTime, endTime, type,
							mediaType, flowType, serviceCampBO.getTime_zone(), serviceCampBO.getTime_zone_name(),
							serviceCampBO.getIs_capping(), serviceCampBO.getIs_targetting(), serviceCampBO.getFlow(),
							operatorObject, serviceCampBO.getMxgraph_id(), priority, scp_flow_name,status,serviceCampBO.getTotal_click_count(), 0,
							serviceCampBO.getTotal_impression_count(), 0);
					
					campExist = campaignRepository.save(campExist);

					if (requestData.getContentInfo() != null) {
						saveDataCampaignContent(requestData, campExist, mediaType);
						// saving in campiagn publisher link table
					}
					Optional<Publisher> id = publisherRepository.findById(serviceCampBO.getPublisher_id());
					CampaignPublisherLink campaignPublisherLink = new CampaignPublisherLink(campExist, id.get());
					CampaignPublisherLinkRepository.save(campaignPublisherLink);

					// saved in campiagn publisher link table

					// saving in capping table table

					Capping cappingData = new Capping(serviceCampBO.getTotal_click_count(), 0,
							serviceCampBO.getTotal_impression_count(), 0, campExist);

					cappingRepository.save(cappingData);

					// saved in capping table

				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				response.setStatus(ResponseStatus.SUCCESS);

				return response;
			} else {

				response.setStatus(ResponseStatus.FAILED);
				logger.error("Nothing Found");
				errorMap.put(ResponseErrorKey.ERROR, "Configuration with this operator and account name already exist");
				response.setErrorMessageMap(errorMap);
				return response;

			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(ResponseStatus.FAILED);
			logger.error("Error occurred while configuring sms");
			errorMap.put(ResponseErrorKey.ERROR,
					"Sms Config with this  account_name already exist  please use edit option to modify the sms config details or use different name");
			response.setErrorMessageMap(errorMap);
			return response;

		}
	}

	private void saveDataCampaignContent(CampCreateReqData requestData, Campaign campExist, MediaType mediaType) {
		requestData.getContentInfo().forEach(value -> {

			CampaignContent campaignContent = new CampaignContent(value.getHeight(), value.getWidth(),
					value.getRedirectUrl(), mediaType, 12L, 0, 0, 0, value.getContentPath(), value.getPercentage(),
					campExist);
			campaignContentRepository.save(campaignContent);
			// logger.info("value"+value.getActualheight()+"aaaaaaaa");
		});
	}

	@Override
	public TagResponse tagList(String user_id) {
		// TODO Auto-generated method stub
		TagResponse response = new TagResponse();
		List<OperatorModel> modelList = new ArrayList<>();
		errorMap = new HashMap<>();

		try {

			List<Tags> TagList = tagRepository.findAll();

			if (TagList != null) {
				// OperatorModel model = new OperatorModel(OptionalOperator);
				// modelList.add(model);
				// response.setUserList(modelList);
				response.setTagList(TagList);
				response.setStatus(ResponseStatus.SUCCESS);
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(ResponseStatus.FAILED);
			logger.error("Error occurred while fetching user using id");
			errorMap.put(ResponseErrorKey.ERROR, "Error occurred while fetching User using id");
			response.setErrorMessageMap(errorMap);
			return response;
		}
		return response;

	}

	@Override
	public ServiceListResponse serviceList(String user_id) {
		// TODO Auto-generated method stub
		ServiceListResponse response = new ServiceListResponse();
		List<OperatorModel> modelList = new ArrayList<>();
		errorMap = new HashMap<>();
		LogData log;
		try {

			List<com.bng.zbp.model.entity.Service> serviceList = serviceRepository.findAll();

			if (serviceList != null) {
				response.setServiceList(serviceList);
				response.setStatus(ResponseStatus.SUCCESS);

				log = new LogData("Service List", user_id, new Date(), user_id, gson.toJson(response),
						"Service List is uploaded successfully", success_status);
				logsRepository.save(log);

			}

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(ResponseStatus.FAILED);
			logger.error("Error occurred while fetching user using id");
			errorMap.put(ResponseErrorKey.ERROR, "Error occurred while fetching User using id");
			response.setErrorMessageMap(errorMap);

			log = new LogData("Service List", user_id, new Date(), user_id, gson.toJson(response), e.getMessage(),
					fail_status);
			logsRepository.save(log);

			return response;
		}
		return response;
	}

	@Override
	public CampaignResponseBO getCampaignById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CampaignResponseBO getCampaignByName(String name) {
		// TODO Auto-generated method stub

		return null;
	}
//edit the status of campaign

	private BaseResponse generate_url(String camp_id, String status, String url_format) {
		// TODO Auto-generated method stub
		String sub_url = url_format.replace("|camp_id|", camp_id).replace("|status|", status);

		CampBusinessLayerImpl campBusinessLayerImpl = new CampBusinessLayerImpl();
		logger.info("Generated url : " + sub_url);
		BaseResponse result = campBusinessLayer.fileConverter(sub_url, null);

		return result;
	}

	@Override
	public BaseResponse editCampStatus(String camp_id, String status, String url_format) {
		// TODO Auto-generated method stub
		BaseResponse response = new BaseResponse();
		try {
			BaseResponse url_response = generate_url(camp_id, status, url_format);

			if (url_response.getStatus().equals("unsuccessful")) {
				response.setStatus(ResponseStatus.FAILED);
			} else {
				response.setStatus(ResponseStatus.SUCCESS);

			}
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(ResponseStatus.FAILED);
			logger.error("Error occurred while changine the Status of camp ");

			return response;
		}

	}

	@Override
	public BaseResponse editCamp(CampCreateReqData requestData) {
		// TODO Auto-generated method stub
		BaseResponse response = new BaseResponse();
		ServiceCampBO serviceCampBO = campBusinessLayer.getSeriveInfo(requestData);

		try {
			Optional<Campaign> campExist = campaignRepository.findById(serviceCampBO.getId());
			// use user authentication
			if (campExist != null) {
				response.setStatus(ResponseStatus.SUCCESS);
				return response;

			} else {
				response.setStatus(ResponseStatus.FAILED);
				logger.error("No camp exist with this name ");
				response.setError("No Camp exist with this name");
				return response;

			}

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(ResponseStatus.FAILED);
			response.setError("Exception caught while editing the Campaign");

			return response;
		}

	}

}
