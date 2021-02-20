package com.bng.zbp.model.response;


import java.util.Date;

import com.bng.zbp.model.entity.Advertiser;
import com.bng.zbp.model.entity.Agency;
import com.bng.zbp.model.entity.Operator;
import com.bng.zbp.model.entity.Publisher;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author Mansi Rajora
 */

public class OperatorModel extends BaseObjectModel {

    @JsonProperty("logoImageUrl")
    private String logoImageUrl;
    @JsonProperty("bannerUrl")
    private String bannerUrl;
	private String country;

    public OperatorModel() {
        super();
    }


    public OperatorModel(Long id, Date crdt, String name, String description, String logoImageUrl, String bannerUrl,String country) {
        this.setId(id);
        this.setCrdt(crdt);
        this.setName(name);
        this.setDescription(description);
        this.logoImageUrl = logoImageUrl;
        this.bannerUrl = bannerUrl;
        this.country=country;
        
    }

    /**
     * Return OperatorResponse using the operator Entity object
     *
     * @param operator
     */
    public OperatorModel(Operator operator) {

        this(operator.getId(), operator.getCrdt(), operator.getName(), operator.getDescription(), operator.getLogoImageUrl(), operator.getBannerUrl(),operator.getCountry());
    }

    public OperatorModel(Agency agency)
    {
    	this(agency.getId(),agency.getCrdt(),agency.getName());
    }
    
    public OperatorModel(Publisher publisher)
    {
    	this(publisher.getId(),publisher.getCrdt(),publisher.getName());
    }
    
    public OperatorModel(Advertiser advertiser)
    {
    	this(advertiser.getId(),advertiser.getCrdt(),advertiser.getName());
    }
    

    public OperatorModel(Long id, Date crdt, String name) {
	
    	// TODO Auto-generated constructor stub
    	   this.setId(id);
           this.setCrdt(crdt);
           this.setName(name);
        
    }


	public String getLogoImageUrl() {
        return logoImageUrl;
    }

    public void setLogoImageUrl(String logoImageUrl) {
        this.logoImageUrl = logoImageUrl;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}
    
}