package com.bng.zbp.service;

import com.bng.zbp.model.request.CampaignRequest;
import com.bng.zbp.model.response.BaseResponse;
import com.bng.zbp.model.response.CampaignResponse;
import com.bng.zbp.model.response.CampaignResponseBO;
import com.bng.zbp.model.response.CampaignResponseList;
import com.bng.zbp.model.response.ServiceListResponse;
import com.bng.zbp.model.response.TagResponse;
import com.bng.zbp.request.CampCreateReqData;

import java.util.List;

/**
 * @author Mansi Rajora
 */
public interface CampaignService {

     CampaignResponseBO getCampaignById(Long id);
     CampaignResponseBO getCampaignByName(String name);
     CampaignResponseList getCampaignList (CampaignRequest request);
	BaseResponse createCamp(CampCreateReqData requestData);
	TagResponse tagList(String user_id);
	ServiceListResponse serviceList(String user_id);
	BaseResponse editCampStatus(String camp_id, String status, String editcampstatusurl);
	BaseResponse editCamp(CampCreateReqData requestData);

}