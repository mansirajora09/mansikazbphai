package com.bng.zbp.model.response;

import java.util.List;

import com.bng.zbp.model.entity.Tags;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Mansi Rajora
 */

@Data
public class TagResponse extends BaseResponse{


    @JsonProperty("optionList")
    private List<Tags> tagList;



    
}
