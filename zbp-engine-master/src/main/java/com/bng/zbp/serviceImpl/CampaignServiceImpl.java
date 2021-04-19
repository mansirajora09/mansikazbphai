package com.bng.zbp.serviceImpl;

import java.security.SecureRandom;
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
import com.bng.zbp.controller.FileUpload;
import com.bng.zbp.model.entity.Campaign;
import com.bng.zbp.model.entity.CampaignContent;
import com.bng.zbp.model.entity.CampaignPublisherLink;
import com.bng.zbp.model.entity.Capping;
import com.bng.zbp.model.entity.Flow;
import com.bng.zbp.model.entity.LoanActions;
import com.bng.zbp.model.entity.LoanConfiguration;
import com.bng.zbp.model.entity.LoanOptions;
import com.bng.zbp.model.entity.LogData;
import com.bng.zbp.model.entity.Operator;
import com.bng.zbp.model.entity.Publisher;
import com.bng.zbp.model.entity.Tags;
import com.bng.zbp.model.enums.ActionType;
import com.bng.zbp.model.enums.CampaignType;
import com.bng.zbp.model.enums.FlowType;
import com.bng.zbp.model.enums.MediaType;
import com.bng.zbp.model.enums.Status;
import com.bng.zbp.model.request.Actions;
import com.bng.zbp.model.request.CampaignGetReq;
import com.bng.zbp.model.request.CampaignRequest;
import com.bng.zbp.model.request.IvrCampCreateReq;
import com.bng.zbp.model.request.IvrFlow;
import com.bng.zbp.model.request.LoanConfigRequestRes;
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
import com.bng.zbp.repository.FlowRepository;
import com.bng.zbp.repository.Loan_configuration_Repo;
import com.bng.zbp.repository.Loan_options_Repo;
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
import com.bng.zbp.util.Utility;
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
	private FlowRepository flowRepository;
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
	@Autowired
	private Loan_configuration_Repo loanConfigRepository;
	@Autowired
	private Loan_options_Repo loan_optionsgRepository;
	private Map<ResponseErrorKey, String> errorMap;
	String success_status = "SUCCESS";
	String fail_status = "FAILED";

	@Override
	public CampaignResponseList getCampaignList(CampaignRequest request) {
		CampaignResponseList response = new CampaignResponseList();
		try {
			List<CampaignResponseBO> modelList = new ArrayList<>();
			List<Campaign> campaignResponseList=new ArrayList<>();


			if(request.getCamptype().equalsIgnoreCase("ivr"))
			{
			 campaignResponseList = campaignRepository.findByType("IVR");

			}
			else if(request.getCamptype().equalsIgnoreCase("wap"))
			{
				 campaignResponseList = campaignRepository.findByType("WAP");

			}
			else
			{
			 campaignResponseList = campaignRepository.findAll();
			}
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

			logger.info("Going to save camapgin 1"+gson.toJson(campExist));
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
							serviceCampBO.getTotal_impression_count(), 0,requestData.getFlow_id());


					logger.info("Going to save camapgin"+gson.toJson(campExist));
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

	@Override
	public BaseResponse getFlow(Long flowId) {
		System.out.println("SERICE:"+flowId);
		Optional<Flow> flow=flowRepository.findById(flowId);
		System.out.println("FLOW:"+gson.toJson(flow));
		return null;
	}

	@Override
	public BaseResponse createIvrCamp(IvrCampCreateReq requestData) {

		logger.info("Camapign Req"+gson.toJson(requestData));
		// Create Camp Request
		BaseResponse response = new BaseResponse();
		errorMap = new HashMap<>();
		CampCreateReqData createCamp=new CampCreateReqData();
		createCamp.setService_Data(requestData.getService_Data());
		int flowId=requestData.getFlow_id();
		Flow flow=new Flow();
		IvrFlow IvrFlowReq=requestData.getFlow();
		String actionId=flowId+"1";
		flow.setActionId(actionId);
		flow.setActionType(IvrFlowReq.getType().name());
		flow.setAudio(IvrFlowReq.getMain_audio_file().get(IvrFlowReq.getLanguage()[0]));
		flow.setFlowId(flowId);

		flow=setSubActions(flow,IvrFlowReq.getActions());
		flowRepository.saveAndFlush(flow);
		logger.info("FLOW DATA"+gson.toJson(flow));
		dtmfSubActions(flow,IvrFlowReq.getLanguage(),IvrFlowReq.getActions());
		//logger.info("FLOW DATA"+gson.toJson(flow));

		ServiceCampBO serviceCampBO = campBusinessLayer.getSeriveInfo(createCamp);

		try {
			Campaign campExist = campaignRepository.findByName(serviceCampBO.getName());
			// use user authentication
			if (campExist == null) {

				Optional<Operator> operator = operatorRepository.findById(serviceCampBO.getOperator_id());


				//* Get Time from the Request

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
							serviceCampBO.getTotal_impression_count(), 0,flowId);


					logger.info("Going to save camapgin"+gson.toJson(campExist));
					campExist = campaignRepository.save(campExist);

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

	private Flow dtmfSubActions(Flow parentFlow, String[] language,List<Actions> actionsList) {	
		for(Actions actions: actionsList) {
			String withoutflowId=parentFlow.getActionId().substring(1);
			String actionId=parentFlow.getFlowId()+"+"+withoutflowId+"*"+actions.getLevel()+"*"+actions.getDtmf_key();
			Flow flowOne=new Flow();
			flowOne.setFlowId(parentFlow.getFlowId());
			flowOne.setActionId(actionId);
			if(actions.getType().name().equals("PLAY")){
				flowOne.setAudio(actions.getAudio_file().get(language[0]));
			}
			flowOne.setActionType(actions.getType().name());

			if(actions.getActions()!=null && actions.getActions().size()>0) {
				flowOne=setSubActions(flowOne,actions.getActions());
				flowOne.setBargin(true);
				flowOne.setWaitTime(5);
			}
			if(actions.getUrl()!=null && ! actions.getUrl().isEmpty() ) {
				flowOne.setUrl(actions.getUrl());
				if(actions.getUrl_actions().size()>0) {
					String withoutflowIdUrl=flowOne.getActionId().substring(1);
					String actionSuccesId=flowOne.getFlowId()+"+"+withoutflowIdUrl+"*"+actions.getUrl_actions().get(0).getLevel()+"*"+actions.getUrl_actions().get(0).getUrl_key().name();
					String actionFailId=flowOne.getFlowId()+"+"+withoutflowIdUrl+"*"+actions.getUrl_actions().get(0).getLevel()+"*"+actions.getUrl_actions().get(1).getUrl_key().name();
					flowOne.setUrlSuccess(actionSuccesId);
					flowOne.setUrlFail(actionFailId);
				}
				dtmfSubActions(flowOne,language,actions.getUrl_actions());

			}
			logger.info("Nested flow:"+gson.toJson(flowOne));
			flowRepository.saveAndFlush(flowOne);
			if(actions.getActions()!=null && actions.getActions().size()>0) {
				dtmfSubActions(flowOne,language,actions.getActions());
			}
		}
		/*	for(Actions actions:actionsList) {
			if(actions.getDtmf_key()!=0) {
				String actionId=actions.getLevel()+"*"+actions.getDtmf_key();
			  if(actions.getDtmf_key()==1) {
				  flow.setOne(actionId);
				  Flow flowOne=new Flow();
				  setSubActions(flowOne,actions.getActions());
			  }
			  if(actions.getDtmf_key()==2) {
				  flow.setTwo(actionId);
				  Flow flowOne=new Flow();
				  setSubActions(flowOne,actions.getActions());
			  }

			  if(actions.getDtmf_key()==3) {
				  flow.setThree(actionId);
				  Flow flowOne=new Flow();
				  setSubActions(flowOne,actions.getActions());
			  }

			  if(actions.getDtmf_key()==4) {
				  flow.setFour(actionId);
				  Flow flowOne=new Flow();
				  setSubActions(flowOne,actions.getActions());
			  }

			  if(actions.getDtmf_key()==5) {
				  flow.setFive(actionId);
				  Flow flowOne=new Flow();
				  setSubActions(flowOne,actions.getActions());
			  }

			  if(actions.getDtmf_key()==6) {
				  flow.setSix(actionId);
				  Flow flowOne=new Flow();
				  setSubActions(flowOne,actions.getActions());
			  }

			  if(actions.getDtmf_key()==7) {
				  flow.setSeven(actionId);
				  Flow flowOne=new Flow();
				  setSubActions(flowOne,actions.getActions());
			  }

			  if(actions.getDtmf_key()==8) {
				  flow.setEight(actionId);
				  Flow flowOne=new Flow();
				  setSubActions(flowOne,actions.getActions());
			  }

			  if(actions.getDtmf_key()==9) {
				  flow.setNine(actionId);
				  Flow flowNine=new Flow();
				  flowNine=setSubActions(flowNine,actions.getActions());
				 // c
			  }


			}

		}*/
		return null;
	}

	private Flow setSubActions(Flow flow,List<Actions> actionsList) {	
		for(Actions actions:actionsList) {
			if(actions.getDtmf_key()!=0) {
				String withoutflowId=flow.getActionId().substring(1);
				String actionId=flow.getFlowId()+"+"+withoutflowId+"*"+actions.getLevel()+"*"+actions.getDtmf_key();
				if(actions.getDtmf_key()==1) {
					flow.setOne(actionId);
				}
				if(actions.getDtmf_key()==2) {
					flow.setTwo(actionId);
				}

				if(actions.getDtmf_key()==3) {
					flow.setThree(actionId);
				}

				if(actions.getDtmf_key()==4) {
					flow.setFour(actionId);
				}

				if(actions.getDtmf_key()==5) {
					flow.setFive(actionId);
				}

				if(actions.getDtmf_key()==6) {
					flow.setSix(actionId);
				}

				if(actions.getDtmf_key()==7) {
					flow.setSeven(actionId);
				}

				if(actions.getDtmf_key()==8) {
					flow.setEight(actionId);
				}

				if(actions.getDtmf_key()==9) {
					flow.setNine(actionId);
					// c
				}


			}

		}
		return flow;
	}

	public int randomId() {
		SecureRandom random = new SecureRandom();
		int num = random.nextInt(100000);
		return num;
	}

	@Override
	public BaseResponse createLoanConfig(LoanConfigRequestRes requestData) {
		BaseResponse response =new BaseResponse();
		errorMap = new HashMap<>();
		try {
			LoanConfiguration loan=new LoanConfiguration();
			loan.setOperator_id(requestData.getOperatorId());
			loan.setCheck_eligiblity_url(requestData.getCheck_eligiblity());
			loan.setGetOption(requestData.getGetOption());
			loan.setLoan_lend_url(requestData.getLoan_request());
			loan.setLoan_type(requestData.getLoan_type());
			loan.setName(requestData.getName());
			boolean loanExist=loanConfigRepository.existsByName(requestData.getName());
			logger.info("Camapign exist:"+loanExist);
			//LoanConfiguration loanExist=loanConfigRepository.findByName(requestData.getName());
			if(loanExist) {
				response.setStatus(ResponseStatus.FAILED);
				errorMap.put(ResponseErrorKey.ERROR,
						"Loan configration with this name already exist.");
				response.setErrorMessageMap(errorMap);
				//logger.debug(""");
				return response;

			}
			loanConfigRepository.save(loan);
			LoanConfiguration loanConfig=loanConfigRepository.findByName(requestData.getName());
			int loanId=loanConfig.getId();
			//List<LoanOptions> loan_options=new ArrayList<>();
			requestData.getLoanOption().forEach(loanOption->{
				LoanOptions option=new LoanOptions();
				LoanActions action=new LoanActions();
				action.setPath(loanOption.getAudio_file());
				action.setActionType(ActionType.PLAY.name());
				action.setWaitTime(loanOption.getWaittime());
				String actionId=loanId+"*"+loanOption.getLoan_amount();
				action.setActionId(actionId);
				action.setBargein(true);
				//action.setActionId(actionId);
				option.setFlow(gson.toJson(action));
				option.setLoan_amount(loanOption.getLoan_amount());
				option.setLoan_id(loanId);
				loan_optionsgRepository.saveAndFlush(option);
			});
			logger.debug("Loan flow going to save");
			response.setStatus(ResponseStatus.SUCCESS);
			return response;
			//logger.error("Error occurred while configuring sms");
		}catch(Exception e){
			response.setStatus(ResponseStatus.FAILED);
			logger.debug("Error occurred while "+e.getMessage());
			return response;
		}


	}

	@Override
	public IvrCampCreateReq getIvrCamp(CampaignGetReq requestData) {
		List<Flow> flowList=flowRepository.findAllByFlowIdOrderById(4);
		IvrCampCreateReq responce =new IvrCampCreateReq();
		int level=1;

		IvrFlow ivrFlow=getFlow(flowList,level);
		responce.setFlow(ivrFlow);

		System.out.println("Flow data:"+gson.toJson(flowList));
		return responce;
	}

	IvrFlow getFlow( List<Flow> flowList,int level) {
		Flow flow=flowList.get(0);
		IvrFlow ivrFlow =new IvrFlow();
		HashMap<String,String> audio_file=new HashMap<>();
		audio_file.put("en", flow.getAudio());
		ActionType actionType =ActionType.valueOf(flow.getActionType());
		ivrFlow.setType(actionType);
		ivrFlow.setMain_audio_file(audio_file);
		List<Actions> actionList=new ArrayList<>();
		if(flow.getZero()!=null && !flow.getZero().isEmpty()) {
			List<Actions> actionList0=getSubFlow(flowList,flow.getZero(), level,0);
			actionList.add(actionList0.get(0));
			//actionList
		}
		if(flow.getOne()!=null && !flow.getOne().isEmpty()) {
			List<Actions> actionList1=getSubFlow(flowList,flow.getOne(), level,1);
			actionList.add(actionList1.get(0));
		}
		if(flow.getTwo()!=null && !flow.getTwo().isEmpty()) {
			List<Actions> actionList2=getSubFlow(flowList,flow.getTwo(), level,2);
			actionList.add(actionList2.get(0));
		}
		ivrFlow.setActions(actionList);
		return ivrFlow;
	}

	List<Actions> getSubFlow( List<Flow> flowList,String actionId,int level,int dtmf) {
		System.out.println("Inside Sub fLOW iD:"+actionId);
		Optional<Flow> flowOpt=flowList.stream().filter(flowData->flowData.getActionId().equals(actionId)).findFirst();
		Flow flow=flowOpt.get();
		Actions actions =new Actions();
		HashMap<String,String> audio_file=new HashMap<>();
		audio_file.put("en", flow.getAudio());
		ActionType actionType =ActionType.valueOf(flow.getActionType());
		actions.setType(actionType);
		actions.setAudio_file(audio_file);
		actions.setLevel(level);
		actions.setDtmf_key(dtmf);
		if(flow.getZero()!=null && !flow.getZero().isEmpty()) {
			List<Actions> actionList0=getSubFlow(flowList,flow.getZero(), level+1,0);
			
		}
		if(flow.getOne()!=null && !flow.getOne().isEmpty()) {
			List<Actions> actionList1=getSubFlow(flowList,flow.getOne(), level+1,1);
		}
		if(flow.getTwo()!=null && !flow.getTwo().isEmpty()) {
			List<Actions> actionList2=getSubFlow(flowList,flow.getTwo(), level+1,2);
		}
		if(flow.getThree()!=null && !flow.getThree().isEmpty()) {
			List<Actions> actionList3=getSubFlow(flowList,flow.getThree(), level+1,2);
		}
		if(flow.getFour()!=null && !flow.getFour().isEmpty()) {
			List<Actions> actionList4=getSubFlow(flowList,flow.getFour(), level+1,2);
		}
		if(flow.getFive()!=null && !flow.getFive().isEmpty()) {
			List<Actions> actionList5=getSubFlow(flowList,flow.getFive(), level+1,2);
		}
		if(flow.getSix()!=null && !flow.getSix().isEmpty()) {
			List<Actions> actionList6=getSubFlow(flowList,flow.getSix(), level+1,2);
		}
		if(flow.getSeven()!=null && !flow.getSeven().isEmpty()) {
			List<Actions> actionList7=getSubFlow(flowList,flow.getSeven(), level+1,2);
		}
		if(flow.getEight()!=null && !flow.getEight().isEmpty()) {
			List<Actions> actionList8=getSubFlow(flowList,flow.getEight(), level+1,2);
		}
		if(flow.getThree()!=null && !flow.getNine().isEmpty()) {
			List<Actions> actionList9=getSubFlow(flowList,flow.getThree(), level+1,2);
		}
		
		List<Actions> actionsList=new ArrayList<>();
		actionsList.add(actions);
		return actionsList;
	}

}
