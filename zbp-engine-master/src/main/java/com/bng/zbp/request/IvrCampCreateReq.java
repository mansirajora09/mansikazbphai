package com.bng.zbp.request;

import java.util.HashMap;
import java.util.Map;

import com.bng.zbp.model.request.IvrFlow;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class IvrCampCreateReq {
		private Map<String, String> service_Data = new HashMap<>();
		private Map<String, String> timezone = new HashMap<>();
		private Map<String, int[]> blackoutdatetime = new HashMap<>();
		private IvrFlow flow;
		private int flow_id;
		private String[] publisher;
		private String device;
		private String country;
}
