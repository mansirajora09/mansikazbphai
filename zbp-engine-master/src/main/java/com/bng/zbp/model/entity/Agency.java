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
@Table(name = "agency", catalog = "zbp")
@Getter
@Setter
public class Agency extends BaseEntity {

    @Column(name = "name")
    private String name;

	public Agency(String name) {
		super();
		this.name = name;
	}

	public Agency() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}

