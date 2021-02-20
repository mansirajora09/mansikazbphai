package com.bng.zbp.model.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Mansi Rajora
 */
@Entity
@Table(name = "operators",catalog = "zbp")
public class Operator {

    private Long id;
    private Date crdt;
    private Long createdBy;
    private Date lastModifiedOn;
    private Long lastModifiedBy;
    private Boolean isActive;
    private String name;
    private String description;
    private String logoImageUrl;
    private String bannerUrl;
    private String country;
    public Operator() {
    }

    public Operator(Date crdt, Long createdBy, Date lastModifiedOn, Long lastModifiedBy, Boolean isActive, String name, String description, String logoImageUrl, String bannerUrl, String country) {
        this.crdt = crdt;
        this.createdBy = createdBy;
        this.lastModifiedOn = lastModifiedOn;
        this.lastModifiedBy = lastModifiedBy;
        this.isActive = isActive;
        this.name = name;
        this.description = description;
        this.logoImageUrl = logoImageUrl;
        this.bannerUrl = bannerUrl;
        this.country = country;

    }
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "crdt", nullable = false)
    public Date getCrdt() {
        return crdt;
    }

    public void setCrdt(Date crdt) {
        this.crdt = crdt;
    }

    @Column(name = "created_by", nullable = false)
    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "last_modified_on")
    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    @Column(name = "last_modified_by")
    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Column(name = "is_active")
    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name = "logo_image_url")
    public String getLogoImageUrl() {
        return logoImageUrl;
    }

    public void setLogoImageUrl(String logoImageUrl) {
        this.logoImageUrl = logoImageUrl;
    }

    @Column(name = "banner_url")
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

	public Operator(Long id, Date crdt, String name, String description, String logoImageUrl, String bannerUrl, String country) {
		super();
		this.id = id;
		this.crdt = crdt;
		this.name = name;
		this.description = description;
		this.logoImageUrl = logoImageUrl;
		this.bannerUrl = bannerUrl;
		this.country = country;
	}
	


    
}
