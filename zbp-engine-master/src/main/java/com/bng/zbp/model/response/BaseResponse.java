package com.bng.zbp.model.response;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Mansi Rajora
 */
@Getter
@Setter
public class BaseResponse {
    private String error;
    private ResponseStatus status = ResponseStatus.SUCCESS;

    @JsonProperty("auth_token")
    private String authToken;
    @JsonProperty("crdt")
    private Date crdt;
    @JsonProperty("error_map")
    private Map<ResponseErrorKey,String> errorMessageMap;
	public void setStatus(ResponseStatus success) {
		// TODO Auto-generated method stub
		
	}

}
