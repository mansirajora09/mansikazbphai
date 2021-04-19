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
@Table(name = "publisher", catalog = "zbp")
@Getter
@Setter
public class Publisher extends BaseEntity {
    @Column(name = "name")
    private String name;

	public Publisher(String name) {
		super();
		this.name = name;
	}
    
    
}
