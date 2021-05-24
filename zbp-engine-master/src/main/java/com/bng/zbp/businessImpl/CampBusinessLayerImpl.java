package com.bng.zbp.businessImpl;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bng.zbp.business.CampBusinessLayer;
import com.bng.zbp.controller.ZbpCampaignController;
import com.bng.zbp.model.entity.Campaign;
import com.bng.zbp.model.response.BaseResponse;
import com.bng.zbp.request.CampCreateReqData;
import com.bng.zbp.request.ServiceCampBO;
import com.bng.zbp.util.Utility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class CampBusinessLayerImpl implements CampBusinessLayer {
	private final static Logger logger = LoggerFactory.getLogger(ZbpCampaignController.class);
	private static final Gson gson = new GsonBuilder().serializeNulls().create();
	public ServiceCampBO getSeriveInfo(CampCreateReqData requestData) {
		String servicereqData=gson.toJson(requestData);
		logger.info("Business Data requestdate: "+servicereqData);

		
		
		//fgf
		String serviceData=gson.toJson(requestData.getService_Data());
		logger.info("Business Data : "+serviceData);
		ServiceCampBO serviceCampBO = Utility.mapCampDAOToCampBO(serviceData);
		return serviceCampBO;
	}
	
	public  Map<String, String> getSeriveinfofromCamapign(Campaign campaign) {
		String campaignData=gson.toJson(campaign);
		logger.info("Business Data requestdate: "+campaignData);
		 Map<String, String> service_Data = Utility.mapCampDAOToService(campaignData);
		return service_Data; 
	}
	
	public String fileConverter(String url) {
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			int responseCode = con.getResponseCode();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			logger.info("Responce"+response.toString());
			in.close();
			return response.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	@Override
	public BaseResponse fileConverter(String url, Object object) {
		// TODO Auto-generated method stub

			try {
				URL obj = new URL(url);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("User-Agent", "Mozilla/5.0");
				// logger.info("Fileconverter con "+gson.toJson(con));

				int responseCode = con.getResponseCode();
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				logger.info("======Response of hitting the URL ====={} and the Url which we  hit is", response, url);


				in.close();

				return gson.fromJson(response.toString(), BaseResponse.class);

			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Excepion caught while hitting the Url" + e.getMessage());
				return null;
			
		}	}
	
}