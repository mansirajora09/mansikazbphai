package com.bng.zbp.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "sub_submenu",catalog = "zbp")

public class SubSubmenuItem implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String displayname;
	private Boolean display;
	private Boolean iseditable;

    private int submenu_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public Boolean getDisplay() {
		return display;
	}

	public void setDisplay(Boolean display) {
		this.display = display;
	}

	public Boolean getIseditable() {
		return iseditable;
	}

	public void setIseditable(Boolean iseditable) {
		this.iseditable = iseditable;
	}

	public int getSubmenu_id() {
		return submenu_id;
	}

	public void setSubmenu_id(int submenu_id) {
		this.submenu_id = submenu_id;
	}
	
    
    

	
}

