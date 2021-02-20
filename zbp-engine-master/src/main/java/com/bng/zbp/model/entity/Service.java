package com.bng.zbp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Mansi Rajora
 */
@Entity
@Table(name = "vas_service", catalog = "zbp")
@Getter
@Setter
public class Service  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;

	public Service(String name) {
		super();
		this.name = name;
	}

	public Service() {
		super();
		// this.name = name;
	}

}
