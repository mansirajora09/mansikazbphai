package com.bng.zbp.model.response;

import java.util.List;

import com.bng.zbp.model.entity.Service;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Mansi Rajora
 */

@Data
public class ServiceListResponse extends BaseResponse{


    @JsonProperty("serviceList")
    private List<Service> serviceList;



    
}
