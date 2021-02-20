package com.bng.zbp.business;
import com.bng.zbp.model.response.BaseResponse;
import com.bng.zbp.request.CampCreateReqData;
import com.bng.zbp.request.ServiceCampBO;
public interface CampBusinessLayer {
	ServiceCampBO getSeriveInfo(CampCreateReqData requestData);

	BaseResponse fileConverter(String sub_url, Object object);
}
