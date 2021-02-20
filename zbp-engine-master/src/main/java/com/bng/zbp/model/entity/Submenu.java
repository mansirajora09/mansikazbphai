package com.bng.zbp.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "submenu",catalog = "zbp")
public class Submenu implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	private int submenu_id;	

	private String submenu_name;
	private String submenu_displayname;
	private String display;
	@OneToMany

	@JoinColumn(name ="submenu_id", insertable=false, updatable=false,referencedColumnName="id",nullable=false)

	//private <Submenu> submenu;
    private List<SubSubmenuItem> subSubmenu = new ArrayList<>();

	
	public Submenu() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSubmenu_name() {
		return submenu_name;
	}
	public void setSubmenu_name(String submenu_name) {
		this.submenu_name = submenu_name;
	}
	public String getSubmenu_displayname() {
		return submenu_displayname;
	}
	public void setSubmenu_displayname(String submenu_displayname) {
		this.submenu_displayname = submenu_displayname;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public List<SubSubmenuItem> getSubSubmenu() {
		return subSubmenu;
	}
	public void setSubSubmenu(List<SubSubmenuItem> subSubmenu) {
		this.subSubmenu = subSubmenu;
	}
	
	
	
}
