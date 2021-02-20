package com.bng.zbp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Mansi Rajora
 */
@Entity
@Table(name = "tags", catalog = "zbp")
@Getter
@Setter
public class Tags extends BaseEntity {
    @Column(name = "name")
    private String name;


	public Tags(String name) {
		super();
		this.name = name;
	}
	public Tags() {
		super();
		//this.name = name;
	}
    
    
}
    

