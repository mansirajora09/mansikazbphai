package com.bng.zbp.model.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "menu")
public class UserMysqlPerDAO implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String menu_name;
	private String menu_id;
	private String menu_displayname;
	private String display;
    private String submenu_id;
	//@OneToMany
	@OneToMany

	@JoinColumn(name ="submenu_id", insertable=false, updatable=false,referencedColumnName="id",nullable=false)

	//private <Submenu> submenu;
    private List<Submenu> submenu = new ArrayList<>();

	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_displayname() {
		return menu_displayname;
	}
	public void setMenu_displayname(String menu_displayname) {
		this.menu_displayname = menu_displayname;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubmenu_id() {
		return submenu_id;
	}
	public void setSubmenu_id(String submenu_id) {
		this.submenu_id = submenu_id;
	}
	public List<Submenu> getSubmenu() {
		return submenu;
	}
	public void setSubmenu(List<Submenu> submenu) {
		this.submenu = submenu;
	}
	
	
    
    
    
    
    
}