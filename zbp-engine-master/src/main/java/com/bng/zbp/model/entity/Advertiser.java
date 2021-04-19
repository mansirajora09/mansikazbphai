package com.bng.zbp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Mansi Rajora
 */
@Entity
@Table(name = "advertiser", catalog = "zbp")
@Getter
@Setter
public class Advertiser extends BaseEntity {
    @Column(name = "name")
    private String name;

	public Advertiser(String name) {
		super();
		this.name = name;
	}
    
    
}
