package com.bng.zbp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bng.zbp.model.entity.FlowMapping;
import com.bng.zbp.model.request.CampaignGetReq;
import com.bng.zbp.model.request.CampaignRequest;
import com.bng.zbp.model.request.CreateFlowReq;
import com.bng.zbp.model.request.IvrCampCreateReq;
import com.bng.zbp.model.request.LoanConfigRequestRes;
import com.bng.zbp.model.response.BaseResponse;
import com.bng.zbp.model.response.CampaignResponseBO;
import com.bng.zbp.model.response.CampaignResponseList;
import com.bng.zbp.model.response.ServiceListResponse;
import com.bng.zbp.model.response.TagResponse;
import com.bng.zbp.request.CampCreateReqData;
import com.bng.zbp.service.CampaignService;
import com.bng.zbp.util.URIConstants;

/**
 * @author Mansi Rajora
 */

@RestController
@RequestMapping(value = "/bng/zbp")
@CrossOrigin(origins = "*", maxAge = 3600)

public class ZbpCampaignController {

	@Autowired
	CampaignService campaignService;

	@RequestMapping(value =URIConstants.GETCAMP, method = RequestMethod.GET)
	public CampaignResponseBO getCampaingByIdAndName(@RequestParam(name = "id", required = false) Long id,
			@RequestParam(name = "name", required = false) String name)
	{
		if (id != null)
		{
			return campaignService.getCampaignById(id);
		} else if (name != null) 
		{
			return campaignService.getCampaignByName(name);
		}
		return null;
	}

	@RequestMapping(value = URIConstants.CREATECAMP, method = RequestMethod.POST)
	public BaseResponse createCamp(@RequestBody CampCreateReqData requestData) {
		BaseResponse response=campaignService.createCamp(requestData);
		
		return response;

	}
	
	@RequestMapping(value = URIConstants.CREATEIVRCAMP, method = RequestMethod.POST)
	public BaseResponse createIvrCamp(@RequestBody IvrCampCreateReq requestData) {
		BaseResponse response=campaignService.createIvrCamp(requestData);
		return response;

	}
	@RequestMapping(value = URIConstants.CREATEFLOW, method = RequestMethod.POST)
	public BaseResponse createFlow(@RequestBody CreateFlowReq request) {
		BaseResponse response=campaignService.createFlow(request);
		return response;

	}
	
	@RequestMapping(value = URIConstants.GETFLOW, method = RequestMethod.POST)
	public List<FlowMapping> getFlowList(@RequestBody CreateFlowReq request) {
		List<FlowMapping> response=campaignService.getFlowList(request);
		return response;

	}
	
	@RequestMapping(value = URIConstants.GETIVRCAMP, method = RequestMethod.POST)
	public IvrCampCreateReq getIvrCamp(@RequestBody CampaignGetReq requestData) {
		IvrCampCreateReq response=campaignService.getIvrCamp(requestData);
		return response;

	}
	
	@RequestMapping(value = URIConstants.CREATELOANCONFIG, method = RequestMethod.POST)
	public BaseResponse createLoanConfig(@RequestBody LoanConfigRequestRes requestData) {
		BaseResponse response=campaignService.createLoanConfig(requestData);
		return response;

	}
	
	@RequestMapping(value = URIConstants.EDITCAMP, method = RequestMethod.POST)
	public BaseResponse editCamp(@RequestBody CampCreateReqData requestData) {

		return campaignService.editCamp(requestData);

	}
	@GetMapping("/api/foos")
	@ResponseBody
	public BaseResponse getFlowById(@RequestParam long flowId) {
		System.out.println("flowid:"+flowId);
		return campaignService.getFlow(flowId);

	}
	
	

	@RequestMapping(value = URIConstants.TAGLIST, method = RequestMethod.GET)
	public TagResponse tagList(@RequestParam(name = "user_id", required = false) String user_id) {

		return campaignService.tagList(user_id);

	}
	
	@RequestMapping(value = URIConstants.SERVICELIST, method = RequestMethod.GET)
	public ServiceListResponse serviceList(@RequestParam(name = "user_id", required = false) String user_id) {

		return campaignService.serviceList(user_id);

	}
	@RequestMapping(value = URIConstants.EDITCAMPSTATUS, method = RequestMethod.GET)
	public BaseResponse editStatus(@RequestParam(name = "status", required = false) String status,
			@RequestParam(name = "camp_id", required = false) String camp_id)
 {

		return campaignService.editCampStatus(camp_id,status,URIConstants.EDITCAMPSTATUSURL);

	}

	@RequestMapping(value = URIConstants.CAMPAIGNLIST, method = RequestMethod.GET)
	public CampaignResponseList getCampaignList(@RequestParam(name = "camptype", required = false) String camptype){
		CampaignRequest request = new CampaignRequest();
		request.setCamptype(camptype);
		return campaignService.getCampaignList(request);
	}

}
